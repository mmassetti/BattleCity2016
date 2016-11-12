package juego;

import TDALista.*;
import audio.ReproductorSonido;
import controladores.Controlador;
import controladores.ControladorCreadorEnemigos;
import controladores.ControladorDisparoEnemigo;
import controladores.ControladorDisparoJugador;
import controladores.ControladorGrafico;
import controladores.ControladorMovimientoEnemigo;
import controladores.ControladorPoderes;
import enemigos.*;
import fabricas.EnemigosDificil1;
import fabricas.EnemigosDificil2;
import fabricas.EnemigosDificil3;
import fabricas.EnemigosFacil1;
import fabricas.EnemigosFacil2;
import fabricas.EnemigosFacil3;
import fabricas.EnemigosMedio1;
import fabricas.EnemigosMedio2;
import fabricas.EnemigosMedio3;
import fabricas.FabricaEnemigos;
import grafica.*;
import powerups.PowerUp;
import puntajes.AdministradorPuntajesAltos;
import obstaculos.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.JPanel;

public class Juego implements Manager {

	protected PositionList<Enemigo> misEnemigos;
	protected PositionList<Obstaculo> misObstaculos;
	protected PositionList<PowerUp> misPoderes;
	protected PositionList<Controlador> misControladores;
	protected ControladorMovimientoEnemigo miControladorEnemigo;
	protected ControladorPoderes miControladorPoderes;
	protected ControladorCreadorEnemigos miControladorCreador;
	protected ControladorGrafico miControladorGrafico;
	protected Jugador miJugador;
	protected Base miBase;
	protected int cantEnemigos;
	protected int posX, posY;
	protected final int anchoPixel = 64;
	protected final int altoPixel = 64;
	protected PanelJuego gui;
	protected FabricaEnemigos factory;
	protected PanelInfo panelInfo;
	protected volatile boolean juegoPausado;
	protected final Rectangle rectanguloPanel = new Rectangle(0, 0, anchoPixel * 20, altoPixel * 11);
	protected TerminadorJuego miTerminador;
	protected ReproductorSonido miReproductorSonido;
	protected int numeroNivel;
	protected int numeroMapa;
	protected Ventana ventana;
	protected AdministradorPuntajesAltos miAdministradorPuntajes;
	protected int cantEnemigosMuertos;
	protected String nombreJugador;

	// Constructor
	public Juego(Ventana ventana, JPanel gui, PanelInfo panelInfo, int nroMapa, int nroNivel) {
		this.panelInfo = panelInfo;
		miTerminador = new TerminadorJuego(this);
		miReproductorSonido = new ReproductorSonido();
		miAdministradorPuntajes = new AdministradorPuntajesAltos();
		setGui(gui);
		crearListas();
		numeroNivel = nroNivel;
		numeroMapa = nroMapa;
		crearMapa(numeroMapa);
		crearJugador();
		crearFabrica();
		crearHilos();
		juegoPausado = false;
		pausarJuegoInicioPrimerNivel();
		this.ventana = ventana;
		cantEnemigosMuertos = 0;

	}

	public Juego(Ventana ventana, JPanel gui, PanelInfo panelInfo, int nroMapa, int nroNivel, Jugador j) {
		this.panelInfo = panelInfo;
		miTerminador = new TerminadorJuego(this);
		miReproductorSonido = new ReproductorSonido();
		miAdministradorPuntajes = new AdministradorPuntajesAltos();
		setGui(gui);
		crearListas();
		numeroNivel = nroNivel;
		numeroMapa = nroMapa;
		crearMapa(numeroMapa);
		agregarJugador(j);
		crearFabrica();
		crearHilos();
		juegoPausado = false;
		pausarJuegoInicioNivelAvanzado();
		this.ventana = ventana;
		cantEnemigosMuertos = 0;
	}

	public PositionList<Enemigo> getMisEnemigos() {
		return misEnemigos;
	}

	public PositionList<Obstaculo> getMisObstaculos() {
		return misObstaculos;
	}

	public PositionList<PowerUp> getMisPoderes() {
		return misPoderes;
	}

	public Jugador getMiJugador() {
		return miJugador;
	}

	public JPanel getGui() {
		return gui;
	}

	private void setGui(JPanel gui) {
		this.gui = (PanelJuego) gui;
	}

	public TerminadorJuego getTerminador() {
		return miTerminador;
	}

	public int getAnchoPixel() {
		return anchoPixel;
	}

	public int getAltoPixel() {
		return altoPixel;
	}

	public FabricaEnemigos getFabrica() {
		return factory;
	}

	public void setBase(Base b) {
		miBase = b;
	}

	// Creacion de atributos
	private void crearListas() {
		misObstaculos = new ListaDoblementeEnlazada<Obstaculo>();
		misEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		misPoderes = new ListaDoblementeEnlazada<PowerUp>();
		misControladores = new ListaDoblementeEnlazada<Controlador>();
	}

	private void crearMapa(int nroMapa) {
		posX = 0;
		posY = 0;
		ManejadorArchivo archivo = new ManejadorArchivo();
		archivo.cargarMapa(this, posX, posY, nroMapa);
	}

	private void crearJugador() {
		miJugador = new Jugador(435, 635, miTerminador, this);
		this.gui = (PanelJuego) gui;
		gui.add(miJugador.getLabel());
	}

	private void agregarJugador(Jugador j) {
		miJugador = new Jugador(435, 635, miTerminador, this);
		miJugador.setVidas(j.getVidas());
		miJugador.setNivel(j.getNivel());
		miJugador.setPuntos(j.getCantPuntos());
		this.gui = (PanelJuego) gui;
		gui.add(miJugador.getLabel());
		panelInfo.getlabelNivelJugador().setText("" + miJugador.getNumeroNivel());
		panelInfo.getlabelPuntosJugador().setText("" + miJugador.getCantPuntos());
		panelInfo.getlabelVidasJugador().setText("" + miJugador.getVidas());
	}

	private void crearHilos() {
		miControladorEnemigo = new ControladorMovimientoEnemigo(misEnemigos, misObstaculos, miJugador);
		miControladorPoderes = new ControladorPoderes(miControladorEnemigo, misPoderes, misEnemigos, misObstaculos,
				misControladores, miJugador, miBase, gui);
		miControladorCreador = new ControladorCreadorEnemigos(this);
		miControladorGrafico = new ControladorGrafico(miJugador, panelInfo, gui);
		miControladorEnemigo.start();
		miControladorPoderes.start();
		miControladorCreador.start();
		miControladorGrafico.start();
		misControladores.addLast(miControladorEnemigo);
		misControladores.addLast(miControladorPoderes);
		misControladores.addLast(miControladorCreador);
		misControladores.addLast(miControladorGrafico);
	}

	public void generarDisparo() {
		if (!juegoPausado)
			miJugador.disparar();
	}

	public void generarDisparo(DisparoEnemigo disparo, Enemigo e) {
		gui.add(disparo.getLabel());
		ControladorDisparoEnemigo controladorDisparoEnemigo = new ControladorDisparoEnemigo(disparo, misObstaculos,
				miJugador, misControladores, e.getDisparosActuales(), gui);
		disparo.setControlador(controladorDisparoEnemigo);
		controladorDisparoEnemigo.start();
		misControladores.addLast(controladorDisparoEnemigo);
	}

	public void generarDisparo(DisparoJugador disparo) {
		gui.add(disparo.getLabel());
		ControladorDisparoJugador controladorDisparoJugador = new ControladorDisparoJugador(disparo, miJugador,
				misObstaculos, misEnemigos, misControladores, gui);
		disparo.setControlador(controladorDisparoJugador);
		controladorDisparoJugador.start();
		misControladores.addLast(controladorDisparoJugador);

	}

	public void pausarJuegoBoton() {
		if (!juegoPausado)
			gui.cambiarFondoAPausa();
		else
			gui.cambiarFondoAOriginal();
		pausa();
		for (Controlador c : misControladores)
			c.controlarHilo();
	}

	public void pausarJuegoInicioPrimerNivel() { 
		if (!juegoPausado) {
			gui.cambiarFondoAEspera();
			pausa();
			for (Controlador c : misControladores)
				c.controlarHilo();
			nombreJugador= gui.pedirNombreJugador();
		} else {
			gui.cambiarFondoAOriginal();
			pausa();
			for (Controlador c : misControladores)
				c.controlarHilo();
		}
	}
	
	public void pausarJuegoInicioNivelAvanzado() {
		if (!juegoPausado) {
			gui.cambiarFondoAEspera();
			pausa();
			for (Controlador c : misControladores)
				c.controlarHilo();
		} else {
			gui.cambiarFondoAOriginal();
			pausa();
			for (Controlador c : misControladores)
				c.controlarHilo();
		}
	}

	private void pausa() {
		if (!juegoPausado)
			juegoPausado = true;
		else
			juegoPausado = false;
	}

	public void moverJugador(int dir) {
		if (!juegoPausado) {
			int direccion;
			boolean puedoMover = false;
			switch (dir) {
			case KeyEvent.VK_UP: { // Arriba
				direccion = 0;
				miJugador.setDireccionActual(direccion);
				puedoMover = puedoMoverTanque();
				break;
			}
			case KeyEvent.VK_DOWN: { // Abajo
				direccion = 1;
				miJugador.setDireccionActual(direccion);
				puedoMover = puedoMoverTanque();
				break;
			}
			case KeyEvent.VK_LEFT: { // Izquierda
				direccion = 2;
				miJugador.setDireccionActual(direccion);
				puedoMover = puedoMoverTanque();
				break;
			}
			case KeyEvent.VK_RIGHT: { // Derecha
				direccion = 3;
				miJugador.setDireccionActual(direccion);
				puedoMover = puedoMoverTanque();
				break;
			}
			default:
				direccion = -1;
			}
			((JugadorGrafico) miJugador.getMiGrafico()).cambiarGrafico(miJugador.getDireccionActual(),
					miJugador.getTieneCasco());
			if (direccion >= 0 && puedoMover)
				miJugador.mover();
		}
	}

	private boolean puedoMoverTanque() {
		PositionList<ObjetoJuego> listaObjetos = new ListaDoblementeEnlazada<ObjetoJuego>();
		Iterator<Enemigo> it = misEnemigos.iterator();
		Iterator<Obstaculo> it2 = misObstaculos.iterator();
		Iterator<PowerUp> it3 = misPoderes.iterator();
		Rectangle rectanguloJugador = miJugador.posicionAMover();
		boolean puedoMover = true;
		if (rectanguloPanel.contains(rectanguloJugador)) {
			while (it.hasNext()) {
				ObjetoJuego elem = it.next();
				if (rectanguloJugador.intersects(elem.getBounds())) //
					listaObjetos.addLast(elem);
			}
			while (it2.hasNext()) {
				ObjetoJuego elem = it2.next();
				if (rectanguloJugador.intersects(elem.getBounds()))
					listaObjetos.addLast(elem);
			}
			while (it3.hasNext()) {
				ObjetoJuego elem = it3.next();
				if (rectanguloJugador.intersects(elem.getBounds())) {
					listaObjetos.addLast(elem);
					miReproductorSonido.reproducir("powerup");
				}
			}
			while (!listaObjetos.isEmpty() && puedoMover) {
				try {
					puedoMover = listaObjetos.last().element().accept(miJugador.getVisitador());
					listaObjetos.remove(listaObjetos.last());
				} catch (EmptyListException | InvalidPositionException e) {
					e.printStackTrace();
				}
			}
		} else
			puedoMover = false;
		return puedoMover;
	}

	public void finJuegoLogica() {
		miReproductorSonido.reproducir("gameover");
		gui.cambiarFondoAGameOver();
		procesarPuntaje();
		pausa();
		for (Controlador c : misControladores)
			c.terminarHilo();
	}

	private void procesarPuntaje() {
		miAdministradorPuntajes.agregarPuntaje(nombreJugador, miJugador.getCantPuntos());
	}

	public void finJuegoAlternativa() {
		pausa();
		for (Controlador c : misControladores)
			c.terminarHilo();
	}

	private void crearFabrica() {
		switch (numeroNivel) {
		case 1:
			factory = new EnemigosFacil1(this);
			break;
		case 2:
			factory = new EnemigosFacil2(this);
			break;
		case 3:
			factory = new EnemigosFacil3(this);
			break;
		case 4:
			factory = new EnemigosMedio1(this);
			break;
		case 5:
			factory = new EnemigosMedio2(this);
			break;
		case 6:
			factory = new EnemigosMedio3(this, miJugador);
			break;
		case 7:
			factory = new EnemigosDificil1(this, miJugador);
			break;
		case 8:
			factory = new EnemigosDificil2(this, miJugador);
			break;
		case 9:
			factory = new EnemigosDificil3(this, miJugador);
			break;
		}
	}

	public void ganarNivel() {
		finJuegoAlternativa();
		if (numeroNivel < 9)
			numeroNivel++;
		numeroMapa++;
		if (numeroMapa == 6)
			numeroMapa = 1;
		miReproductorSonido.reproducir("levelup");
		panelInfo.getReproductor().detener();
		ventana.cambiarNivel(numeroNivel, numeroMapa, miJugador,nombreJugador);
	}

	public void aumentarCantMuertos() {
		cantEnemigosMuertos++;
		if (cantEnemigosMuertos == 15)
			ganarNivel();
	}

	public AdministradorPuntajesAltos getMiAdministradorPuntajes() {
		return miAdministradorPuntajes;
	}
	
	public void setNombreJugador (String nombre) {
		nombreJugador = nombre;
	}
	
	public String getNombreJugador() { 
		return nombreJugador;
	}
	
}

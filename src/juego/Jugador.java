package juego;

import grafica.JugadorGrafico;
import niveles.*;
import visitadores.VisitadorConcretoJugador;
import visitadores.Visitor;
import java.awt.Rectangle;
import TDALista.ListaDoblementeEnlazada;
import audio.ReproductorSonido;

public class Jugador extends Tanque {

	// Atributos
	protected int vidas;
	protected final int maxVidas = 5;
	protected int cantPuntos;
	protected Nivel nivel;
	protected int numeroNivel;
	protected TerminadorJuego miTerminador;
	protected VisitadorConcretoJugador miVisitador;
	protected boolean tieneCasco;
	protected Manager managerDisparo;
	protected ReproductorSonido miReproductorSonido;
	protected int contadorPuntos;

	// Constructor
	public Jugador(int x, int y, TerminadorJuego terminador, Manager manager) {
		tieneCasco = false;
		nivel = new Nivel1();
		numeroNivel = 1;
		vidas = 1;
		cantPuntos = 0;
		direccionActual = 0;
		miTerminador = terminador;
		actualizarAtributos();
		miGrafico = new JugadorGrafico(x, y);
		miVisitador = new VisitadorConcretoJugador(this);
		miRectangulo = new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 55, 55);
		miReproductorSonido = new ReproductorSonido();
		managerDisparo = manager;
		disparosActuales = new ListaDoblementeEnlazada<Disparo>();
		contadorPuntos = 1;
	}

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public int getVidas() {
		return vidas;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public int getNumeroNivel() {
		return numeroNivel;
	}

	public int getCantPuntos() {
		return cantPuntos;
	}

	public VisitadorConcretoJugador getVisitador() {
		return miVisitador;
	}

	public boolean getTieneCasco() {
		return tieneCasco;
	}

	public int getResistenciaGolpes() {
		return resistenciaGolpes;
	}

	public void setResistenciaGolpes(int n) {
		resistenciaGolpes = n;
	}

	public void setTieneCasco(boolean tieneCasco) {
		this.tieneCasco = tieneCasco;
	}

	public void setPuntos(int n) {
		cantPuntos = n;
	}

	public void setVidas(int n) {
		vidas = n;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
		actualizarAtributos();
	}

	public void actualizarEnemigosMuertos() {
		managerDisparo.aumentarCantMuertos();
	}

	public void aumentarVida() {
		if (vidas < maxVidas)
			this.vidas++;
	}

	public void aumentarPuntos(int n) {
		this.cantPuntos += n;
		int puntosParaSubirDeNivel = 20000 * contadorPuntos;
		if (cantPuntos > puntosParaSubirDeNivel) {
			aumentarVida();
			contadorPuntos++;
		}
	}

	public void subirNivel() {
		if (numeroNivel != 4) {
			numeroNivel++;
			switch (numeroNivel) {
			case 2:
				setNivel(new Nivel2());
				break;
			case 3:
				setNivel(new Nivel3());
				break;
			case 4:
				setNivel(new Nivel4());
				break;
			}
			actualizarAtributos();
		}
	}

	public void recibirDisparo() {
		resistenciaGolpes--;
		if (resistenciaGolpes == 0) {
			vidas--;
			this.getLabel().setLocation(435, 635);
			miGrafico.getPos().setLocation(435, 635);
			this.setRectangulo(new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 55, 55));
			if (vidas == 0)
				morir();
			else {
				setNivel(new Nivel1());
				actualizarAtributos();
			}
		}
	}

	private void actualizarAtributos() {
		resistenciaGolpes = nivel.getGolpesResistencia();
		velocidadMovimiento = nivel.getVelocidadMovimiento();
		velocidadDisparo = nivel.getVelocidadDisparo();
		disparoSimultaneo = nivel.getDisparoSimultaneo();
		numeroNivel = nivel.getNumeroNivel();
	}

	public void disparar() {
		if (disparosActuales.size() < disparoSimultaneo) {
			miReproductorSonido.reproducir("laser");
			DisparoJugador d = new DisparoJugador(miGrafico.getPos().x, miGrafico.getPos().y, direccionActual,
					velocidadDisparo);
			disparosActuales.addLast(d);
			d.cambiarDireccion(direccionActual);
			managerDisparo.generarDisparo(d);
		}
	}

	public void morir() {
		miTerminador.terminarJuego();
	}

}
package juego;

import TDALista.*;
import enemigos.Basico;
import enemigos.Blindado;
import enemigos.DePoder;
import enemigos.Enemigo;
import enemigos.Rapido;
import powerups.*;

//import java.awt.Dimension;
import java.awt.Rectangle;
//import java.awt.Toolkit;
import java.awt.event.KeyEvent;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

//import java.util.Random;
import grafica.*;
import obstaculos.*;
import powerups.PowerUp;

public class Juego {
	// Atributos
	protected PositionList<Enemigo> misEnemigos;
	protected PositionList<Obstaculo> misObstaculos;
	protected PositionList<PowerUp> misPoderes;
	protected PositionList<Disparo> misDisparos;
	protected ControladorDisparoJugador miControladorDisparo;
	protected ControladorEnemigo miControladorEnemigo;
	protected ControladorPoderes miControladorPoderes;
	protected Jugador miJugador;
	protected int cantEnemigos;
	protected int posX, posY;
	protected final int anchoPixel = 64;
	protected final int altoPixel = 64;
	protected Ventana gui;
	protected VisitadorConcretoJugador visitadorJugador;

	// Constructor
	public Juego(Ventana gui) {
		crearListas();
		crearMapa(gui);
		crearJugador(gui);
		crearEnemigos();
		//crearPoderes();
		crearHilos();
	}

	// Metodos
	
	//Getters y setters
	public PositionList<Enemigo> getMisEnemigos() {
		return misEnemigos;
	}

	public PositionList<Obstaculo> getMisObstaculos() {
		return misObstaculos;
	}

	public PositionList<PowerUp> getMisPoderes() {
		return misPoderes;
	}

	public PositionList<Disparo> getMiDisparo() {
		return misDisparos;
	}
	
	public Jugador getMiJugador() {
		return miJugador;
	}
	
	//Creacion de atributos
	private void crearListas(){
		misObstaculos = new ListaDoblementeEnlazada<Obstaculo>();
		misEnemigos = new  ListaDoblementeEnlazada<Enemigo>();
		misPoderes = new ListaDoblementeEnlazada<PowerUp>();
		misDisparos = new ListaDoblementeEnlazada<Disparo>();
	}
	
	private void crearMapa(Ventana gui){
		posX = 0;
		posY = 0;
		ManejadorArchivo archivo = new ManejadorArchivo();
		archivo.cargarMapa(misObstaculos,gui,posX,posY,anchoPixel,altoPixel);
	}
	
	private void crearJugador(Ventana gui) {
		TerminadorJuego miTerminador = new TerminadorJuego(this);
		miJugador = new Jugador(350, 300, miTerminador);
		visitadorJugador = new VisitadorConcretoJugador(miJugador);
		this.gui = gui;
		gui.add(miJugador.getLabel());
	}
	
	private void crearEnemigos() {
		Enemigo enemigo1 = new DePoder(300, 500);
		gui.add(enemigo1.getLabel());
		misEnemigos.addLast(enemigo1);
		
		Enemigo enemigo2 = new Basico(500, 500);
		gui.add(enemigo2.getLabel());
		misEnemigos.addLast(enemigo2);
		
		Enemigo enemigo3 = new Rapido(700, 500);
		gui.add(enemigo3.getLabel());
		misEnemigos.addLast(enemigo3);
		
		Enemigo enemigo4 = new Blindado(900, 500);
		gui.add(enemigo4.getLabel());
		misEnemigos.addLast(enemigo4);
	}
	
	public void crearPoderes(){
		Random r = new Random();			
		int dir = r.nextInt(6);
		PowerUp poder;
		switch (dir){
			case 0 : {
				poder = new Casco();
				
				break;
			}
			case 1 : {
				poder = new Estrella();
				break;
			}
			case 2 : {
				poder = new Granada();
				break;
			}
			case 3 : {
				poder = new Pala();
				break;
			}
			case 4 : {
				poder = new Timer();
				break;
			}
			case 5 : {
				poder = new VidaExtra();
				break;
			}
		}
	}
	
	private void crearHilos() {
		miControladorEnemigo= new ControladorEnemigo(misEnemigos,misObstaculos,miJugador,misDisparos,gui);
		miControladorEnemigo.start();	
	}
	
	//Manejador de eventos
	public void generarDisparo(int key){
		switch(key){
			case KeyEvent.VK_K:{
				Disparo disparo = miJugador.disparar();
				misDisparos.addLast(disparo);		
				gui.add(disparo.getLabel());
				disparo.getMiGrafico().cambiarGrafico(miJugador.getDireccionActual());
				miControladorDisparo= new ControladorDisparoJugador(disparo,misDisparos,misObstaculos,misEnemigos,gui);
				miControladorDisparo.start();
			}
		}
	}
	
	public void moverJugador(int dir) {
		int direccion;
		boolean puedoMover=false;
		switch (dir) {
		case KeyEvent.VK_UP:{ // Arriba
			direccion = 0;
			miJugador.setDireccionActual(direccion);
			puedoMover= puedoMoverTanque();
			break;
		}
		case KeyEvent.VK_DOWN:{ // Abajo
			direccion = 1;
			miJugador.setDireccionActual(direccion);
			puedoMover= puedoMoverTanque();
			break;
		}
		case KeyEvent.VK_LEFT:{ // Izquierda
			direccion = 2;
			miJugador.setDireccionActual(direccion);
			puedoMover= puedoMoverTanque();
			break;
		}
		case KeyEvent.VK_RIGHT:{ // Derecha
			direccion = 3;
			miJugador.setDireccionActual(direccion);
			puedoMover= puedoMoverTanque();
			break;
		}
		default: direccion=-1;
		}

		miJugador.getMiGrafico().cambiarGrafico(miJugador.getDireccionActual());
		if (direccion>=0 && puedoMover)
			miJugador.mover();
	}
	
	//Auxiliares
	private boolean puedoMoverTanque(){
		PositionList<ObjetoJuego> listaObjetos= new ListaDoblementeEnlazada<ObjetoJuego>();
		Iterator<Enemigo> it= misEnemigos.iterator();
		Iterator<Obstaculo> it2= misObstaculos.iterator();
		Iterator<PowerUp> it3 =misPoderes.iterator();
		boolean puedoMover=true;
		while(it.hasNext()){
			ObjetoJuego elem=it.next();
			if(elem.accept(visitadorJugador))
				listaObjetos.addLast(elem);
		}
		while(it2.hasNext()){
			ObjetoJuego elem=it2.next();
			if(elem.accept(visitadorJugador))
				listaObjetos.addLast(elem);
		}
		while(it3.hasNext()){
			ObjetoJuego elem=it3.next();
			if(elem.accept(visitadorJugador))
				listaObjetos.addLast(elem);
		}
		while(!listaObjetos.isEmpty() && puedoMover){
			try {
				if(!listaObjetos.last().element().getAtraviesaTanque())
					puedoMover=false;
				listaObjetos.remove(listaObjetos.last());
			} catch (EmptyListException | InvalidPositionException e) { e.printStackTrace(); }
		}
		return puedoMover;
	}	

	public void finJuego() {
		
	}
}

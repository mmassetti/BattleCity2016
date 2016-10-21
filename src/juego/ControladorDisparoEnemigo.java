package juego;

import java.util.Iterator;

import TDALista.*;
import enemigos.Enemigo;
import obstaculos.Obstaculo;
import grafica.Ventana;

public class ControladorDisparoEnemigo implements Runnable {
	protected Ventana gui;
	protected Disparo disparo;
	protected PositionList<Disparo> listaDisparos;
	protected PositionList<Obstaculo> listaObstaculos;
	protected Jugador miJugador;
	protected VisitadorConcretoDisparoEnemigo visitadorDisparo;
	Thread hilo;
	boolean estaVivo = true;

	public ControladorDisparoEnemigo(Disparo disparo,PositionList<Disparo> disparos,PositionList<Obstaculo> obstaculos,Jugador jugador,Ventana v) {
		gui=v;
		this.disparo=disparo;
		miJugador = jugador;
		listaDisparos=disparos;
		listaObstaculos = obstaculos;
		hilo = new Thread(this);
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		try {
			while (disparo.getExiste()) {
					disparo.mover();
					controlarObstaculos();
					controlarJugador();
					gui.repintar(); //El repaint en un momento random tira una exepcion por un tema del Swing y del Event Dispatch Thread, corregir.
					Thread.sleep(50);
			}
		}
		catch (InterruptedException e) {
		}
	}
	
	public void controlarObstaculos(){
		visitadorDisparo = new VisitadorConcretoDisparoEnemigo(disparo);
		Iterator<Obstaculo> it= listaObstaculos.iterator();
		boolean encontre=false;
		Obstaculo obs=null;
		while(it.hasNext() && !encontre){
			obs = it.next();
			encontre=obs.accept(visitadorDisparo);
		}
		if(encontre){
			if(obs.getEsDestructible()){
				gui.remove(obs.getLabel());
				listaObstaculos.removeElement(obs);
			}
			disparo.destruir();			
			listaDisparos.removeElement(disparo);
			gui.remove(disparo.getLabel());
		}	
	}
	
	public void controlarJugador(){
		visitadorDisparo = new VisitadorConcretoDisparoEnemigo(disparo);
		boolean encontre = miJugador.accept(visitadorDisparo);
		if(encontre){
			disparo.destruir();
			if(!miJugador.getEstaVivo())
				gui.remove(miJugador.getLabel());
			listaDisparos.removeElement(disparo);
			gui.remove(disparo.getLabel());
		}	
	}
	
}

	
package juego;

import java.util.Iterator;

import TDALista.*;
import enemigos.Enemigo;
import obstaculos.Obstaculo;
import grafica.Ventana;

public class ControladorDisparoJugador implements Runnable {
	protected Ventana gui;
	protected Disparo disparo;
	protected PositionList<Disparo> listaDisparos;
	protected PositionList<Obstaculo> listaObstaculos;
	protected PositionList<Enemigo> listaEnemigos;
	protected VisitadorConcretoDisparoJugador visitadorDisparo;
	Thread hilo;
	boolean estaVivo = true;

	public ControladorDisparoJugador(Disparo disparo,PositionList<Disparo> disparos,PositionList<Obstaculo> obstaculos,PositionList<Enemigo> enemigos,Ventana v) {
		gui=v;
		this.disparo=disparo;
		listaEnemigos=enemigos;
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
					controlarEnemigos();
					gui.repintar(); //El repaint en un momento random tira una exepcion por un tema del Swing y del Event Dispatch Thread, corregir.
					Thread.sleep(50);
			}
		}
		catch (InterruptedException e) {
		}
	}
	
	public void controlarObstaculos(){
		visitadorDisparo = new VisitadorConcretoDisparoJugador(disparo);
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
			//gui.repaint();
		}	
	}
	
	public void controlarEnemigos(){
		visitadorDisparo = new VisitadorConcretoDisparoJugador(disparo);
		Iterator<Enemigo> it= listaEnemigos.iterator();
		boolean encontre=false;
		Enemigo e=null;
		while(it.hasNext() && !encontre){
			e = it.next();
			encontre=e.accept(visitadorDisparo);
		}
		if(encontre){
			disparo.destruir();
			if(!e.getEstaVivo()){
				gui.remove(e.getLabel());
				listaEnemigos.removeElement(e);
			}
			listaDisparos.removeElement(disparo);
			gui.remove(disparo.getLabel());
			//gui.repaint();
		}	
	}
	
}

	
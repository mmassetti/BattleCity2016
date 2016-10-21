package juego;

import enemigos.*;
import grafica.ObjetoGrafico;
import grafica.Ventana;
import obstaculos.Obstaculo;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

import TDALista.*;

public class ControladorEnemigo implements Runnable {
	Thread hilo;
	protected Ventana gui;
	protected PositionList<Enemigo> listaEnemigos;
	protected PositionList<Obstaculo> listaObstaculos;
	protected PositionList<Disparo> listaDisparos;
	protected ControladorDisparoEnemigo controlador;
	protected Jugador jugador;
	protected boolean hayJuego = true;
	protected int cantMovimientos;

	public ControladorEnemigo(PositionList<Enemigo> enemigos, PositionList<Obstaculo> obstaculos, Jugador jugador, PositionList<Disparo> disparos, Ventana gui) {
		listaDisparos=disparos;
		listaEnemigos = enemigos;
		listaObstaculos = obstaculos;
		this.gui=gui;
		this.jugador = jugador;
		hilo = new Thread(this);

		cantMovimientos=0;
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		try {
			while (hayJuego) {
				for (Enemigo e : listaEnemigos) {
					if (puedoMoverTanque(e)){
						e.mover();						
					}
					if(cantMovimientos%23==2)
						generarDisparo(e);
					//e.getMiGrafico().getGrafico().repaint();
					gui.repintar(); //El repaint en un momento random tira una exepcion por un tema del Swing y del Event Dispatch Thread, corregir.
					cantMovimientos++;
				}
				Thread.sleep(300);
			}
		} catch (InterruptedException e) {
		}
	}

	private boolean puedoMoverTanque(Enemigo e) {
		e.setDireccion(e.getInteligencia().cambiarDireccion());
		e.getMiGrafico().cambiarGrafico(e.getDireccionActual());
		PositionList<ObjetoJuego> listaObjetos = new ListaDoblementeEnlazada<ObjetoJuego>();
		Iterator<Enemigo> it = listaEnemigos.iterator();
		Iterator<Obstaculo> it2 = listaObstaculos.iterator();
		boolean puedoMover = true;
		while (it.hasNext()) {
			ObjetoJuego elem = it.next();
			if (elem.accept(e.getVisitador()) && elem != e)
				listaObjetos.addLast(elem);
		}
		while (it2.hasNext()) {
			ObjetoJuego elem = it2.next();
			if (elem.accept(e.getVisitador()))
				listaObjetos.addLast(elem);
		}
		if (jugador.accept(e.getVisitador())) {
			listaObjetos.addLast(jugador);
		}
		while (!listaObjetos.isEmpty() && puedoMover) {
			try {
				if (!listaObjetos.last().element().getAtraviesaTanque())
					puedoMover = false;
				listaObjetos.remove(listaObjetos.last());
			} catch (EmptyListException | InvalidPositionException ex) {
				ex.printStackTrace();
			}
		}
		return puedoMover;
	}
	
	private void generarDisparo(Enemigo e){
		Disparo disparo = e.disparar();
		listaDisparos.addLast(disparo);		
		gui.add(disparo.getLabel());
		disparo.cambiarDireccion(e.getDireccionActual());
		controlador= new ControladorDisparoEnemigo(disparo,listaDisparos,listaObstaculos,jugador,gui);
		controlador.start();
	}
}

	
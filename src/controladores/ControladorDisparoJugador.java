package controladores;

import java.util.Iterator;

import javax.swing.JPanel;

import TDALista.*;
import enemigos.Enemigo;
import grafica.PanelJuego;
import juego.Disparo;
import juego.Jugador;
import juego.Tanque;
import obstaculos.Obstaculo;

public class ControladorDisparoJugador extends Controlador {
	private PanelJuego gui;
	private Disparo disparo;
	private PositionList<Obstaculo> listaObstaculos;
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Controlador> listaControladores;
	private Jugador miJugador;
	Thread hilo;

	public ControladorDisparoJugador(Disparo disparo, Jugador miJugador, PositionList<Obstaculo> obstaculos,
			PositionList<Enemigo> enemigos, PositionList<Controlador> controladores, JPanel v) {
		gui = (PanelJuego) v;
		this.disparo = disparo;
		listaEnemigos = enemigos;
		listaObstaculos = obstaculos;
		listaControladores = controladores;
		this.miJugador = miJugador;
		hilo = new Thread(this);
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		while (disparo.getExiste() && hayJuego) {
			if (!juegoEnPausa) {
				disparo.mover();
				controlarObstaculos();
				controlarEnemigos();
				controlarRango();
				controlarDisparos();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void controlarObstaculos() {
		Iterator<Obstaculo> it = listaObstaculos.iterator();
		boolean encontre = false;
		Obstaculo obs = null;
		while (it.hasNext() && !encontre) {
			obs = it.next();
			encontre = obs.accept(disparo.getVisitor());
		}
		if (encontre) {
			if (obs.recibirDisparo() == 0) {
				gui.remove(obs.getLabel());
				listaObstaculos.removeElement(obs);
			}
			destruirDisparo(miJugador, disparo);
		}
	}

	public void controlarEnemigos() {
		Iterator<Enemigo> it = listaEnemigos.iterator();
		boolean encontre = false;
		Enemigo e = null;
		while (it.hasNext() && !encontre) {
			e = it.next();
			encontre = e.accept(disparo.getVisitor());
		}
		if (encontre) {
			destruirDisparo(miJugador, disparo);
			if (!e.getEstaVivo()) {
				miJugador.aumentarPuntos(e.getPuntos());
				listaEnemigos.removeElement(e);
				miJugador.actualizarEnemigosMuertos();
			}
		}
	}

	private void controlarRango() {
		if (!rectanguloPanel.contains(disparo.crearRectangulo()))
			destruirDisparo(miJugador, disparo);
	}

	private void controlarDisparos() {
		Iterator<Enemigo> itEnemigos = listaEnemigos.iterator();
		boolean encontre = false;
		Enemigo e = null;
		Disparo d = null;
		while (itEnemigos.hasNext() && !encontre) {
			e = itEnemigos.next();
			PositionList<Disparo> disparosActuales = e.getDisparosActuales();
			Iterator<Disparo> itDisparos = disparosActuales.iterator();
			while (itDisparos.hasNext() && !encontre) {
				d = itDisparos.next();
				encontre = d.accept(disparo.getVisitor());
			}
		}
		if (encontre) {
			destruirDisparo(miJugador, disparo);
			destruirDisparo(e, d);
		}
	}

	private void destruirDisparo(Tanque t, Disparo d) {
		d.destruir();
		t.getDisparosActuales().removeElement(d);
		gui.remove(d.getLabel());
		listaControladores.removeElement(d.getControlador());
	}
}

package controladores;

import enemigos.*;
import juego.Jugador;
import juego.ObjetoJuego;
import obstaculos.Obstaculo;
import java.awt.Rectangle;
import java.util.Iterator;
import TDALista.*;

public class ControladorMovimientoEnemigo extends Controlador {
	Thread hilo;
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Obstaculo> listaObstaculos;
	private Jugador jugador;
	private final Rectangle rectanguloPanel = new Rectangle(0, 0, 64 * 20, 64 * 11);
	private volatile int estoyParado = 0;

	public ControladorMovimientoEnemigo(PositionList<Enemigo> enemigos, PositionList<Obstaculo> obstaculos,
			Jugador jugador) {
		listaEnemigos = enemigos;
		listaObstaculos = obstaculos;
		this.jugador = jugador;
		hilo = new Thread(this);
	}

	public void start() {
		this.hilo.start();
	}

	public Thread getHilo() {
		return hilo;
	}

	public void run() {
		while (hayJuego) {
			if (!juegoEnPausa) {
				if (estoyParado == 0 && !listaEnemigos.isEmpty()) {
					for (Enemigo e : listaEnemigos) {
						if (puedoMoverTanque(e))
							e.mover();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						Thread.sleep(this.estoyParado);
						this.estoyParado = 0;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private boolean puedoMoverTanque(Enemigo e) {
		e.setDireccionActual(e.getInteligencia().cambiarDireccion());
		e.getMiGrafico().cambiarGrafico(e.getDireccionActual());
		PositionList<ObjetoJuego> listaObjetos = new ListaDoblementeEnlazada<ObjetoJuego>();
		Iterator<Enemigo> it = listaEnemigos.iterator();
		Iterator<Obstaculo> it2 = listaObstaculos.iterator();
		Rectangle rectanguloEnemigo = e.posicionAMover();
		boolean puedoMover = true;
		if (rectanguloPanel.contains(rectanguloEnemigo)) {
			while (it.hasNext()) {
				ObjetoJuego elem = it.next();
				if (rectanguloEnemigo.intersects(elem.getMiRectangulo()) && elem != e)
					listaObjetos.addLast(elem);
			}
			while (it2.hasNext()) {
				ObjetoJuego elem = it2.next();
				if (rectanguloEnemigo.intersects(elem.getBounds()))
					listaObjetos.addLast(elem);
			}
			if (rectanguloEnemigo.intersects(jugador.getMiRectangulo())) {
				listaObjetos.addLast(jugador);
			}
			while (!listaObjetos.isEmpty() && puedoMover) {
				try {
					puedoMover = listaObjetos.last().element().accept(e.getVisitador());
					listaObjetos.remove(listaObjetos.last());
				} catch (EmptyListException | InvalidPositionException ex) {
					ex.printStackTrace();
				}
			}
		} else
			puedoMover = false;
		return puedoMover;
	}

	public void pararHilo(int tiempo) {
		this.estoyParado = tiempo;
	}
}

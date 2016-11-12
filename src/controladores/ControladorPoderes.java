package controladores;

import java.util.Random;

import javax.swing.JPanel;

import powerups.*;
import TDALista.PositionList;
import enemigos.Enemigo;
import grafica.PanelJuego;
import juego.Jugador;
import obstaculos.Base;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class ControladorPoderes extends Controlador {

	private PanelJuego gui;
	private PositionList<PowerUp> misPoderes;
	private PositionList<Enemigo> misEnemigos;
	private PositionList<Obstaculo> misObstaculos;
	private Base base;
	Thread hilo;
	private ControladorMovimientoEnemigo controladorEnemigos;
	private PositionList<Controlador> misControladores;
	private Jugador jugador;

	public ControladorPoderes(ControladorMovimientoEnemigo controladorEnemigos, PositionList<PowerUp> poderes,
			PositionList<Enemigo> misEnemigos, PositionList<Obstaculo> misObstaculos,
			PositionList<Controlador> misControladores, Jugador j, Base b, JPanel v) {
		hilo = new Thread(this);
		gui = (PanelJuego) v;
		misPoderes = poderes;
		base = b;
		this.misEnemigos = misEnemigos;
		this.misObstaculos = misObstaculos;
		this.controladorEnemigos = controladorEnemigos;
		this.misControladores = misControladores;
		jugador = j;
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		while (hayJuego) {
			if (!juegoEnPausa) {
				try {
					Thread.sleep(25000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				PowerUp poder = crearPoder();
				misPoderes.addLast(poder);
				gui.add(poder.getLabel());

			}
		}
	}

	private PowerUp crearPoder() {
		Random r = new Random();
		int dir = r.nextInt(6);
		switch (dir) {
		case 0:
			return new Casco(misPoderes, misControladores, gui);

		case 1:
			return new Granada(misEnemigos, misPoderes, jugador, gui);

		case 2:
			return new Estrella(misPoderes, gui);

		case 3:
			return new Timer(controladorEnemigos, misPoderes, gui);

		case 4:
			return new VidaExtra(misPoderes, gui);

		default:
			return new Pala(base, misPoderes, misObstaculos, gui);

		}
	}
}

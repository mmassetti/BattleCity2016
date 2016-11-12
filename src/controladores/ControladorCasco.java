package controladores;

import TDALista.PositionList;
import grafica.JugadorGrafico;
import juego.Jugador;

public class ControladorCasco extends Controlador {

	Thread hilo;
	private int contador = 0;
	private Jugador miJugador;
	private PositionList<Controlador> misControladores;

	public ControladorCasco(Jugador jugador, PositionList<Controlador> controladores) {
		hilo = new Thread(this);
		miJugador = jugador;
		misControladores = controladores;
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		int resistencia = miJugador.getResistenciaGolpes();
		inicioHilo();
		while (contador < 10 && hayJuego) {
			if (!juegoEnPausa) {
				contador++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		finHilo(resistencia);
	}

	private void inicioHilo() {
		miJugador.setResistenciaGolpes(99999);
		miJugador.setTieneCasco(true);
		((JugadorGrafico) miJugador.getMiGrafico()).cambiarGraficoCasco(miJugador.getDireccionActual());
	}

	private void finHilo(int resistencia) {
		miJugador.setTieneCasco(false);
		miJugador.setResistenciaGolpes(resistencia);
		((JugadorGrafico) miJugador.getMiGrafico()).cambiarGraficoNormal(miJugador.getDireccionActual());
		misControladores.removeElement(this);
	}
}

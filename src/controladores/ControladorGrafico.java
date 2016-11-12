package controladores;

import javax.swing.JPanel;

import grafica.PanelInfo;
import juego.Jugador;

public class ControladorGrafico extends Controlador {

	Thread hilo;
	private Jugador miJugador;
	private PanelInfo panelInfo;
	private JPanel gui;
	private volatile boolean juegoEnPausa = false;

	public ControladorGrafico(Jugador miJugador, PanelInfo miPanel, JPanel gui) {
		hilo = new Thread(this);
		this.miJugador = miJugador;
		panelInfo = miPanel;
		this.gui = gui;
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {

		while (hayJuego) {
			if (!juegoEnPausa) {
				try {
					gui.repaint();
				} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
				}
				panelInfo.getlabelNivelJugador().setText("" + miJugador.getNumeroNivel());
				panelInfo.getlabelPuntosJugador().setText("" + miJugador.getCantPuntos());
				panelInfo.getlabelVidasJugador().setText("" + miJugador.getVidas());
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}

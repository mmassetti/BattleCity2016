package visitadores;

import javax.swing.JPanel;
import TDALista.PositionList;
import controladores.ControladorMovimientoEnemigo;
import grafica.PanelJuego;
import juego.Jugador;
import powerups.*;

public class VisitadorConcretoTimer extends VisitorPoderes {

	private Timer miTimer;
	private ControladorMovimientoEnemigo controladorEnemigos;
	private PositionList<PowerUp> misPoderes;
	private PanelJuego gui;

	public VisitadorConcretoTimer(Timer t, ControladorMovimientoEnemigo controladorEnemigos,
			PositionList<PowerUp> misPoderes, JPanel gui) {
		miTimer = t;
		this.controladorEnemigos = controladorEnemigos;
		this.misPoderes = misPoderes;
		this.gui = (PanelJuego) gui;
	}

	public void afectarJugador(Jugador j) {
		gui.remove(miTimer.getLabel());
		j.aumentarPuntos(500);
		misPoderes.removeElement(miTimer);
		controladorEnemigos.pararHilo(5000);

	}
}
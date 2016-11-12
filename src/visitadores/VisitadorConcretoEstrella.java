package visitadores;

import javax.swing.JPanel;
import TDALista.PositionList;
import grafica.PanelJuego;
import juego.Jugador;
import powerups.Estrella;
import powerups.PowerUp;

public class VisitadorConcretoEstrella extends VisitorPoderes {

	private Estrella miEstrella;
	private PositionList<PowerUp> misPoderes;
	private PanelJuego gui;

	public VisitadorConcretoEstrella(Estrella e, PositionList<PowerUp> misPoderes, JPanel gui) {
		miEstrella = e;
		this.misPoderes = misPoderes;
		this.gui = (PanelJuego) gui;
	}

	public void afectarJugador(Jugador j) {
		j.subirNivel();
		j.aumentarPuntos(500);
		gui.remove(miEstrella.getLabel());
		misPoderes.removeElement(miEstrella);
	}
}
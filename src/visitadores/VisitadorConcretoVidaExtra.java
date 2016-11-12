package visitadores;

import javax.swing.JPanel;
import TDALista.PositionList;
import juego.Jugador;
import powerups.*;

public class VisitadorConcretoVidaExtra extends VisitorPoderes {

	private VidaExtra miVida;
	private PositionList<PowerUp> misPoderes;
	private JPanel gui;

	public VisitadorConcretoVidaExtra(VidaExtra vida, PositionList<PowerUp> misPoderes, JPanel gui) {
		miVida = vida;
		this.misPoderes = misPoderes;
		this.gui = gui;
	}

	public void afectarJugador(Jugador j) {
		j.aumentarVida();
		j.aumentarPuntos(500);
		gui.remove(miVida.getLabel());
		misPoderes.removeElement(miVida);
	}
}
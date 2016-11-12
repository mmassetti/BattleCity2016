package visitadores;

import javax.swing.JPanel;
import TDALista.PositionList;
import controladores.Controlador;
import controladores.ControladorCasco;
import grafica.PanelJuego;
import juego.Jugador;
import powerups.Casco;
import powerups.PowerUp;

public class VisitadorConcretoCasco extends VisitorPoderes {

	private Casco miCasco;
	private PanelJuego gui;
	private PositionList<PowerUp> misPoderes;
	private PositionList<Controlador> misControladores;

	public VisitadorConcretoCasco(Casco c, PositionList<PowerUp> misPoderes, PositionList<Controlador> misControladores,
			JPanel gui) {
		miCasco = c;
		this.gui = (PanelJuego) gui;
		this.misPoderes = misPoderes;
		this.misControladores = misControladores;
	}

	public void afectarJugador(Jugador j) {
		gui.remove(miCasco.getLabel());
		misPoderes.removeElement(miCasco);
		j.aumentarPuntos(500);
		ControladorCasco contadorTiempo = new ControladorCasco(j, misControladores);
		contadorTiempo.start();
		misControladores.addLast(contadorTiempo);
	}
}
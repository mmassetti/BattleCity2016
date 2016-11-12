package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import grafica.EstrellaGrafica;
import visitadores.VisitadorConcretoEstrella;
import visitadores.VisitorPoderes;

public class Estrella extends PowerUp {

	protected VisitadorConcretoEstrella miVisitador;

	public Estrella(PositionList<PowerUp> misPoderes, JPanel gui) {
		super();
		miVisitador = new VisitadorConcretoEstrella(this, misPoderes, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new EstrellaGrafica(x, y);
	}

	public VisitorPoderes getVisitor() {
		return miVisitador;
	}
}

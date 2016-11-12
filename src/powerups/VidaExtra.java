package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import grafica.VidaExtraGrafica;
import visitadores.VisitadorConcretoVidaExtra;
import visitadores.VisitorPoderes;

public class VidaExtra extends PowerUp {

	protected VisitadorConcretoVidaExtra miVisitador;

	public VidaExtra(PositionList<PowerUp> misPoderes, JPanel gui) {
		miVisitador = new VisitadorConcretoVidaExtra(this, misPoderes, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new VidaExtraGrafica(x, y);
	}

	public VisitorPoderes getVisitor(){
		return miVisitador;
	}
}

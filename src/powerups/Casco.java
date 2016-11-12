package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import controladores.Controlador;
import grafica.CascoGrafico;
import visitadores.VisitadorConcretoCasco;
import visitadores.VisitorPoderes;

public class Casco extends PowerUp {

	protected VisitadorConcretoCasco miVisitador;

	public Casco(PositionList<PowerUp> misPoderes, PositionList<Controlador> misControladores, JPanel gui) {
		super();
		miVisitador = new VisitadorConcretoCasco(this, misPoderes, misControladores, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new CascoGrafico(x, y);
	}

	public VisitorPoderes getVisitor() {
		return miVisitador;
	}
}

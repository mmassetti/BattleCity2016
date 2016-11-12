package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import grafica.PalaGrafica;
import obstaculos.Base;
import obstaculos.Obstaculo;
import visitadores.VisitadorConcretoPala;
import visitadores.VisitorPoderes;

public class Pala extends PowerUp {

	protected VisitadorConcretoPala miVisitador;

	public Pala(Base base, PositionList<PowerUp> misPoderes, PositionList<Obstaculo> misObstaculos, JPanel gui) {
		super();
		miVisitador = new VisitadorConcretoPala(this, base, misPoderes, misObstaculos, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new PalaGrafica(x, y);
	}

	public VisitorPoderes getVisitor() {
		return miVisitador;
	}
}

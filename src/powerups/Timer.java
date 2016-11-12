package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import controladores.ControladorMovimientoEnemigo;
import grafica.TimerGrafico;
import visitadores.VisitadorConcretoTimer;
import visitadores.VisitorPoderes;

public class Timer extends PowerUp {

	protected VisitadorConcretoTimer miVisitador;

	public Timer(ControladorMovimientoEnemigo controladorEnemigos, PositionList<PowerUp> misPoderes, JPanel gui) {
		super();
		miVisitador = new VisitadorConcretoTimer(this, controladorEnemigos, misPoderes, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new TimerGrafico(x, y);
	}

	public VisitorPoderes getVisitor() {
		return miVisitador;
	}
}

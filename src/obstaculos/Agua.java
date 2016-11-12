package obstaculos;

import grafica.AguaGrafico;
import visitadores.VisitadorConcretoAgua;
import visitadores.VisitorObstaculos;

public class Agua extends Obstaculo {

	protected VisitadorConcretoAgua miVisitador;

	public Agua(int x, int y) {
		miVisitador = new VisitadorConcretoAgua();
		atraviesaBala = true;
		resistencia = -1;
		miGrafico = new AguaGrafico(x, y);
	}

	public VisitorObstaculos getVisitor() {
		return miVisitador;
	}

	public int recibirDisparo() {
		return resistencia;
	}
}

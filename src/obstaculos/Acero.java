package obstaculos;

import grafica.AceroGrafico;
import visitadores.VisitadorConcretoAcero;
import visitadores.VisitorObstaculos;

public class Acero extends Obstaculo {

	protected VisitadorConcretoAcero miVisitador;

	public Acero(int x, int y) {
		miVisitador = new VisitadorConcretoAcero();
		atraviesaBala = false;
		resistencia = -1;
		miGrafico = new AceroGrafico(x, y);
	}

	public VisitorObstaculos getVisitor() {
		return miVisitador;
	}

	public int recibirDisparo() {
		return resistencia;
	}
}

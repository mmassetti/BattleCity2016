package obstaculos;

import grafica.LadrilloGrafico;
import visitadores.VisitadorConcretoLadrillo;
import visitadores.VisitorObstaculos;


public class Ladrillo extends Obstaculo {

	protected VisitadorConcretoLadrillo miVisitador;

	public Ladrillo(int x, int y) {
		miVisitador = new VisitadorConcretoLadrillo();
		atraviesaBala = false;
		miGrafico = new LadrilloGrafico(x, y);
		resistencia = 4;
	}

	public VisitorObstaculos getVisitor() {
		return miVisitador;
	}

	public int recibirDisparo() {
		resistencia--;
		if (resistencia != 0)
			((LadrilloGrafico) miGrafico).actualizarLadrillo();
		return resistencia;
	}
}

package obstaculos;

import grafica.ArbolGrafico;
import visitadores.VisitadorConcretoArbol;
import visitadores.VisitorObstaculos;

public class Arbol extends Obstaculo {

	protected VisitadorConcretoArbol miVisitador;

	public Arbol(int x, int y) {
		miVisitador = new VisitadorConcretoArbol();
		atraviesaBala = true;
		resistencia = -1;
		miGrafico = new ArbolGrafico(x, y);
	}

	public VisitorObstaculos getVisitor() {
		return miVisitador;
	}

	public int recibirDisparo() {
		return resistencia;
	}

}

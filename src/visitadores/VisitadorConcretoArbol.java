package visitadores;

import juego.Disparo;
import juego.Tanque;

public class VisitadorConcretoArbol extends VisitorObstaculos {

	public VisitadorConcretoArbol() {
	}

	public boolean puedePasar(Tanque t) {
		return true;
	}

	public boolean puedePasar(Disparo d) {
		return false;
	}
}

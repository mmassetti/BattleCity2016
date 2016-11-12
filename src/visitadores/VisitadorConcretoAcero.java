package visitadores;

import juego.Disparo;
import juego.Tanque;

public class VisitadorConcretoAcero extends VisitorObstaculos {

	public VisitadorConcretoAcero() {
	}

	public boolean puedePasar(Tanque t) {
		return false;
	}

	public boolean puedePasar(Disparo d) {
		return true;
	}
}

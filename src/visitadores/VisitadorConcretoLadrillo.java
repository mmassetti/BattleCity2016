package visitadores;

import juego.Disparo;
import juego.Tanque;

public class VisitadorConcretoLadrillo extends VisitorObstaculos {

	public VisitadorConcretoLadrillo() {
	}

	public boolean puedePasar(Tanque t) {
		return false;
	}

	public boolean puedePasar(Disparo d) {
		return true;
	}
}

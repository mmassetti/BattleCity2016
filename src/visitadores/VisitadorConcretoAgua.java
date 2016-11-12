package visitadores;

import juego.Disparo;
import juego.Tanque;

public class VisitadorConcretoAgua extends VisitorObstaculos {

	public VisitadorConcretoAgua() {
	}

	public boolean puedePasar(Tanque t) {
		return false;
	}

	public boolean puedePasar(Disparo d) {
		return false;
	}
}

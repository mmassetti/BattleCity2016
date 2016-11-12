package visitadores;

import juego.Disparo;
import juego.Tanque;

public abstract class VisitorObstaculos {
	public abstract boolean puedePasar(Tanque t);
	public abstract boolean puedePasar(Disparo d);
}

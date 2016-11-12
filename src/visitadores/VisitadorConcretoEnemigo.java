package visitadores;

import enemigos.Enemigo;
import juego.Disparo;
import juego.Jugador;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoEnemigo implements Visitor {
	private Enemigo miEnemigo;

	public VisitadorConcretoEnemigo(Enemigo e) {
		miEnemigo = e;
	}

	public boolean visit(Obstaculo obs) {
		return obs.getVisitor().puedePasar(miEnemigo);
	}

	public boolean visit(PowerUp power) {
		return true;
	}

	public boolean visit(Disparo dis) {
		return true;
	}

	public boolean visit(Enemigo tanque) {
		return true;
	}

	public boolean visit(Jugador tanque) {
		return false;
	}
}

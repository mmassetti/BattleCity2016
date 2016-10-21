package juego;

import enemigos.Enemigo;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoEnemigo implements Visitor {
	protected Enemigo miEnemigo;

	public VisitadorConcretoEnemigo(Enemigo e) {
		miEnemigo=e;
	}
		
	public boolean visit(Obstaculo obs) {
		return (miEnemigo.posicionAMover().intersects(obs.getBounds()));
	}

	public boolean visit(PowerUp power) {
		return false;
	}

	public boolean visit(Disparo dis) {
		return true;
	}
	
	public boolean visit(Enemigo tanque) {
		return (miEnemigo.posicionAMover().intersects(tanque.getBounds()));
	}

	public boolean visit(Jugador tanque) {
		return (miEnemigo.posicionAMover().intersects(tanque.getBounds()));
	}
}

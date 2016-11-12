package visitadores;

import enemigos.Enemigo;
import juego.Disparo;
import juego.Jugador;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoDisparoEnemigo implements Visitor {
	private Disparo disparo;

	public VisitadorConcretoDisparoEnemigo(Disparo disparo) {
		this.disparo = disparo;

	}

	public boolean visit(Obstaculo obs) {
		boolean toReturn = false;
		if (disparo.crearRectangulo().intersects(obs.getBounds()))
			toReturn = obs.getVisitor().puedePasar(disparo);
		return toReturn;
	}

	public boolean visit(PowerUp power) {
		return true;
	}

	public boolean visit(Disparo dis) {
		return true;
	}

	public boolean visit(Enemigo tanque) {
		if (disparo.crearRectangulo().intersects(tanque.getMiRectangulo()))
			return true;
		return false;
	}

	public boolean visit(Jugador tanque) {
		if (disparo.crearRectangulo().intersects(tanque.getMiRectangulo())) {
			tanque.recibirDisparo();
			return true;
		}
		return false;
	}
}

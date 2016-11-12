package visitadores;

import enemigos.Enemigo;
import juego.Disparo;
import juego.Jugador;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoJugador implements Visitor {
	private Jugador miJugador;

	public VisitadorConcretoJugador(Jugador jugador) {
		miJugador = jugador;
	}

	public boolean visit(Obstaculo obs) {
		return obs.getVisitor().puedePasar(miJugador);
	}

	public boolean visit(PowerUp power) {
		power.getVisitor().afectarJugador(miJugador);
		return true;
	}

	public boolean visit(Disparo dis) {
		return true;
	}

	public boolean visit(Enemigo tanque) {
		return false;
	}

	public boolean visit(Jugador tanque) {
		return false;
	}

}

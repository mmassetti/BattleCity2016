package juego;

import enemigos.Enemigo;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoJugador implements Visitor {
	protected Jugador miJugador;
	
	public VisitadorConcretoJugador(Jugador jugador) {
		miJugador = jugador;
	}
	
	public boolean visit(Obstaculo obs) {
		return (miJugador.posicionAMover().intersects(obs.getBounds()));
	}

	public boolean visit(PowerUp power) {
		if(miJugador.posicionAMover().intersects(power.getBounds())){
			power.afectarJugador();
			return true;
		}
		return false;
	}

	public boolean visit(Disparo dis) {
		return true;
	}

	public boolean visit(Enemigo tanque) {
		return (miJugador.posicionAMover().intersects(tanque.getBounds()));
	}

	public boolean visit(Jugador tanque) {
		return true;
	}
	
	
}

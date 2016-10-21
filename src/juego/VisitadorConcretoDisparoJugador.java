package juego;

import java.awt.Rectangle;

import enemigos.Enemigo;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public class VisitadorConcretoDisparoJugador implements Visitor{
	Disparo disparo;
	
	public VisitadorConcretoDisparoJugador(Disparo disparo){
		this.disparo = disparo;
				
	}
	
	public boolean visit(Obstaculo obs) {		
			if (disparo.crearRectangulo().intersects(obs.getBounds())){ //(disparo.colision(obs)
				if(!obs.getAtraviesaBala())
					return true;
			}
		return false;
	}

	public boolean visit(PowerUp power) {
		return true;
	}

	public boolean visit(Disparo dis) {
		return true;
	}

	public boolean visit(Enemigo tanque) {
		if (disparo.colision(tanque)){
			tanque.recibirDisparo();
			return true;
		}
		return false;
	}

	public boolean visit(Jugador tanque) {
		return true;
	}
}

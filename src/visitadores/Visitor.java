package visitadores;

import enemigos.Enemigo;
import juego.Disparo;
import juego.Jugador;
import obstaculos.Obstaculo;
import powerups.PowerUp;

public interface Visitor {
	public boolean visit(Obstaculo obstaculo);
	public boolean visit(Enemigo enemigo);
	public boolean visit(Jugador juegador);
	public boolean visit(PowerUp powerup);
	public boolean visit(Disparo disparo);
}

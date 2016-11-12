package juego;

import enemigos.Enemigo;

public interface Manager {
	public abstract void generarDisparo(DisparoEnemigo d, Enemigo e);

	public abstract void generarDisparo(DisparoJugador d);

	public abstract void ganarNivel();

	public abstract void aumentarCantMuertos();
}

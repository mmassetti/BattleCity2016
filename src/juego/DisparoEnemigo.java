package juego;

import grafica.DisparoEnemigoGrafico;

public class DisparoEnemigo extends Disparo {
	public DisparoEnemigo(int x, int y, int dir){
		super(10);
		miGrafico = new DisparoEnemigoGrafico(x,y);
		direccionDisparo = dir;
	}
}

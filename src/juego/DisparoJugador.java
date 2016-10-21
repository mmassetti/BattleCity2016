package juego;

import grafica.DisparoJugadorGrafico;

public class DisparoJugador extends Disparo {
	public DisparoJugador(int x,int y,int dir){
		super(10);
		miGrafico = new DisparoJugadorGrafico(x,y);
		direccionDisparo = dir;
	}
}

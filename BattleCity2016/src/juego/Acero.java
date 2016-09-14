package juego;

import grafica.AceroGrafico;

public class Acero extends Obstaculo {

	public Acero(int x, int y) {
		atraviesaTanque=false;
		atraviesaBala=false;
		esDestructible=false;
		miGrafico = new AceroGrafico(x,y);
	}

}

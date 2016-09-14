package juego;

import grafica.ArbolGrafico;

public class Arbol extends Obstaculo {

	public Arbol(int x, int y) {
		atraviesaTanque=true;
		atraviesaBala=true;
		esDestructible=false;
		miGrafico = new ArbolGrafico(x,y);
	}

}

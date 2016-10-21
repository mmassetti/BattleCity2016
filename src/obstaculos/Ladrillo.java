package obstaculos;

import grafica.LadrilloGrafico;

public class Ladrillo extends Obstaculo{

	public Ladrillo(int x, int y) {
		atraviesaTanque=false;
		atraviesaBala=false;
		esDestructible=true;
		miGrafico = new LadrilloGrafico(x,y);
	}

}

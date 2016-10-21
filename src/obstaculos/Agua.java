package obstaculos;

import grafica.AguaGrafico;

public class Agua extends Obstaculo{

	public Agua(int x, int y) {
		atraviesaTanque=false;
		atraviesaBala=true;
		esDestructible=false;
		miGrafico = new AguaGrafico(x,y);
	}

}

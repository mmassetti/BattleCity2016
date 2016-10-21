package obstaculos;

import grafica.BaseGrafica;
import grafica.LadrilloGrafico;
import juego.Visitor;

public class Base extends Obstaculo {

	public Base(int x, int y) {
		atraviesaTanque=false;
		atraviesaBala=false;
		esDestructible=true;
		miGrafico = new BaseGrafica(x,y);
	}

	@Override
	public boolean accept(Visitor visitor) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

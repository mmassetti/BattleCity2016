package powerups;

import grafica.PalaGrafica;

public class Pala extends PowerUp{

	public Pala(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new PalaGrafica(x,y);
	}
	public void afectarJugador() {
		// TODO Auto-generated method stub
		
	}

}

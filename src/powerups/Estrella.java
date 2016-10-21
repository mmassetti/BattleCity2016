package powerups;

import grafica.EstrellaGrafica;

public class Estrella extends PowerUp {

	public Estrella(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new EstrellaGrafica(x,y);
	}
	public void afectarJugador() {
		// TODO Auto-generated method stub
		
	}

}

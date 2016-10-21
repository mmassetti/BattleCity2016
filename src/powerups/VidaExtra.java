package powerups;

import grafica.VidaExtraGrafica;

public class VidaExtra extends PowerUp {

	public VidaExtra(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new VidaExtraGrafica(x,y);
	}
	public void afectarJugador() {
		// TODO Auto-generated method stub
		
	}

}

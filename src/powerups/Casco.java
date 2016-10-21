package powerups;

import grafica.CascoGrafico;

public class Casco extends PowerUp {

	public Casco(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new CascoGrafico(x,y);
	}
	public void afectarJugador() {
		
	}

}

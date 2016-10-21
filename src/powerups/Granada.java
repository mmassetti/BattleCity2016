package powerups;

import grafica.GranadaGrafica;

public class Granada extends PowerUp{

	public Granada(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new GranadaGrafica(x,y);
	}
	public void afectarJugador() {
		
	}

}

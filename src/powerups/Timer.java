package powerups;

import grafica.TimerGrafico;

public class Timer extends PowerUp {

	public Timer(){
		super();
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new TimerGrafico(x,y);
	}
	public void afectarJugador() {
		// TODO Auto-generated method stub
		
	}

}

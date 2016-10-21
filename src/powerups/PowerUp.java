package powerups;
import java.util.Random;

import grafica.ObjetoGrafico;
import juego.*;
public abstract class PowerUp extends ObjetoJuego {
	protected boolean existe;
	public final int punto1 = 300;
	public final int punto2 = 700;
	public final int punto3 = 200;
	public final int punto4 = 500;
	
	public PowerUp(){
		atraviesaTanque = true;
		atraviesaBala = true;
		esDestructible = false;
		existe = true;
	}
	
	public boolean getExiste(){
		return existe;
	}
	
	public int generarCoordenada(){
		Random r = new Random();
		int dir = r.nextInt(4);
		switch (dir){
			case 0 : 
				return punto1;
			case 1 : 
				return punto2;
			case 2 : 
				return punto3;
			default : 
				return punto4;
		}
	}
	
	public boolean accept(Visitor visitor){
		return visitor.visit(this);
	}
	
	public void destruir(){
		existe = false;
	}
	
	//Metodos
	public abstract void afectarJugador();
}

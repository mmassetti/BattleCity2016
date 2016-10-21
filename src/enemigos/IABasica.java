package enemigos;

import java.util.Random;

public class IABasica extends IA {
	
	public IABasica(){
		contador=0;
		direccion=0;
	}
	
	public int cambiarDireccion(){	
			if(contador<5)
				contador++;			
			else{
				Random r = new Random();			
				direccion = r.nextInt(4);
				contador=0;
			}			
			return direccion;
	}	
}

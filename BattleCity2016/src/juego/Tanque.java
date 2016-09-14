package juego;

public abstract class Tanque extends ObjetoJuego{
	
	//Atributos
	
	protected int resistenciaGolpes;
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	//protected int disparoSimultaneo;
	
	//Constructor
	public Tanque(int res, int vM, int vD, int dS){
		resistenciaGolpes=res;
		velocidadMovimiento=vM;
		//velocidadDisparo=vD;
		//disparoSimultaneo=dS;
	}
		
	//Getters
	
	public int getResistenciaGolpes(){
		return resistenciaGolpes;
	}
	
	public int getVelocidadMovimiento(){
		return velocidadMovimiento;
	}
	
	public int getVelocidadDisparo(){
		return velocidadDisparo;
	}
	
/*	public int getDisparoSimultaneo(){
		return disparoSimultaneo;
	} */
	
	//Setters
	
	/* Controlar que el n pasado por parametro en los setters sea un valor valido*/
	
	public void setResistenciaGolpes(int n){
		resistenciaGolpes=n;
	}
	
	public void setVelocidadMovimiento(int n){
		velocidadMovimiento=n;
	}
	
	public void setVelocidadDisparo(int n){
		velocidadDisparo=n;
	}
	
	/*public void setDisparoSimultaneo(int n){
		disparoSimultaneo=n;
	}*/
	
	//Metodos
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y - velocidadMovimiento);
				break;
			case 1 : //Abajo
				miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y + velocidadMovimiento);
				break;
			case 2 : //Izquierda
				miGrafico.getPos().setLocation(miGrafico.getPos().x - velocidadMovimiento, miGrafico.getPos().y);
				break;
			case 3 : //Derecha
				miGrafico.getPos().setLocation(miGrafico.getPos().x + velocidadMovimiento, miGrafico.getPos().y);
				break;
		}
		miGrafico.cambiarGrafico(dir);
	}
	/*Crear objeto de tipo disparo y manejarlo a traves de la clase*/
	public void disparar(){		
	}
		
	/* Jugadpr y Enemigo redefinen el metodo porque no tiene el mismo efecto*/
	public abstract void morir();
}

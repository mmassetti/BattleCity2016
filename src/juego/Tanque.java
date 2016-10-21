package juego;

import java.awt.Rectangle;

public abstract class Tanque extends ObjetoJuego{
	
	//Atributos
	
	protected int resistenciaGolpes;
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	protected boolean estaVivo;
	protected int disparoSimultaneo;
	protected int direccionActual;
	protected Rectangle miRectangulo;
	
	//Constructor
	public Tanque(int res, int vM, int vD, int dS){
		resistenciaGolpes=res;
		velocidadMovimiento=vM;
		velocidadDisparo=vD;
		disparoSimultaneo=dS;
		estaVivo=true;
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
	
	public boolean getEstaVivo(){
		return estaVivo;
	}
	
	public int getDireccionActual() {
		return direccionActual;
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
	
	public void recibirDisparo(){
		resistenciaGolpes--;
		if(resistenciaGolpes==0){
			morir();
		}
	}
	
	// Metodos
		public void mover() {
			switch (direccionActual) {
			case 0:// Arriba
				miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y - velocidadMovimiento);
				break;
			case 1: // Abajo
				miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y + velocidadMovimiento);
				break;
			case 2: // Izquierda
				miGrafico.getPos().setLocation(miGrafico.getPos().x - velocidadMovimiento, miGrafico.getPos().y);
				break;
			case 3: // Derecha
				miGrafico.getPos().setLocation(miGrafico.getPos().x + velocidadMovimiento, miGrafico.getPos().y);
				break;
			}
		}
		
		
		public abstract Disparo disparar();
		/*public Disparo disparar() {
			Disparo d = null;
			switch (direccionActual) {
			case 0:// Arriba
				d = new Disparo(miGrafico.getPos().x, miGrafico.getPos().y, 10, direccionActual);
			case 1: // Abajo
				d = new Disparo(miGrafico.getPos().x, miGrafico.getPos().y, 10, direccionActual);
			case 2: // Izquierda
				d = new Disparo(miGrafico.getPos().x, miGrafico.getPos().y, 10, direccionActual);
			case 3: // Derecha
				d = new Disparo(miGrafico.getPos().x, miGrafico.getPos().y, 10, direccionActual);
			}
			return d;
		}*/

		public Rectangle posicionAMover() {

			int posX = 0, posY = 0;
			switch (direccionActual) {
			case 0: { // Arriba
				posX = miGrafico.getPos().x;
				posY = miGrafico.getPos().y - velocidadMovimiento;
				break;
			}
			case 1: { // Abajo
				posX = miGrafico.getPos().x;
				posY = miGrafico.getPos().y + velocidadMovimiento;
				break;
			}
			case 2: { // Izquierda
				posX = miGrafico.getPos().x - velocidadMovimiento;
				posY = miGrafico.getPos().y;
				break;
			}
			case 3: { // Derecha
				posX = miGrafico.getPos().x + velocidadMovimiento;
				posY = miGrafico.getPos().y;
				break;
			}
			}
			miRectangulo.setBounds(posX, posY, 55, 55);
			return miRectangulo;
		}
		
	/* Jugadpr y Enemigo redefinen el metodo porque no tiene el mismo efecto*/
	public abstract void morir();
}

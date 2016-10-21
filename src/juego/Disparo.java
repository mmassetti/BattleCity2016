package juego;

import java.awt.Rectangle;



public abstract class Disparo extends ObjetoJuego {
	//Atributos	
	protected boolean existe;
	protected int velocidadMovimiento;
	protected int direccionDisparo;
	

	public Disparo(int velMov) {
		existe=true;
		velocidadMovimiento = velMov;
	}
	
	public Rectangle crearRectangulo(){
		switch(direccionDisparo){
		case 0:
			return new Rectangle(miGrafico.getPos().x+20,miGrafico.getPos().y-20,15,55);
		case 1:
			return new Rectangle(miGrafico.getPos().x+20,miGrafico.getPos().y+20,15,55);
		case 2:
			return new Rectangle(miGrafico.getPos().x-20,miGrafico.getPos().y+20,55,15);
		default:
			return new Rectangle(miGrafico.getPos().x+20,miGrafico.getPos().y+20,55,15);
		}
	}
	
	public void cambiarDireccion(int direccion){
		miGrafico.cambiarGrafico(direccion);
	}
	
	public int getDireccionDisparo() {
		return direccionDisparo;
	}
	
	public boolean getExiste(){
		return existe;
	}
	
	public void destruir(){
		existe=false;
	}
	
	public boolean accept(Visitor visitor){
		return visitor.visit(this);
	}
	
	public void mover(){
		switch (direccionDisparo) {
		case 0 ://Arriba		
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
		miGrafico.cambiarGrafico(direccionDisparo);
	}
}
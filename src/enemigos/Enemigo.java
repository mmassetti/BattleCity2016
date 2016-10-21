package enemigos;

import java.awt.Rectangle;

import juego.Disparo;
import juego.DisparoEnemigo;
import juego.Tanque;
import juego.VisitadorConcretoEnemigo;
import juego.Visitor;

public class Enemigo extends Tanque {
	protected IA miInteligencia;
	protected VisitadorConcretoEnemigo miVisitador;
	protected int contadorMovimientos;


	public Enemigo(int res, int vM, int vD, int dS) {
		super(res, vM, vD, dS);
		direccionActual=0;
		contadorMovimientos=0;
		miVisitador= new VisitadorConcretoEnemigo(this);
	}
	
	public VisitadorConcretoEnemigo getVisitador(){
		return miVisitador;
	}
	
	public void setDireccion(int d){
		direccionActual=d;
	}	
	
	public void morir() {
		estaVivo = false;
	}
	
	public Disparo disparar(){
		return new DisparoEnemigo(miGrafico.getPos().x, miGrafico.getPos().y, direccionActual);
	}
	
	public boolean accept(Visitor visitor){
		return visitor.visit(this);
	}
	
	public IA getInteligencia(){
		return miInteligencia;
	}
}

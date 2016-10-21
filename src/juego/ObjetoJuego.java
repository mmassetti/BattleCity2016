package juego;

import javax.swing.JLabel;
import java.awt.Rectangle;
import grafica.ObjetoGrafico;

public abstract class ObjetoJuego {
	// Atributos
	protected ObjetoGrafico miGrafico;
	protected boolean atraviesaTanque;
	protected boolean atraviesaBala;
	protected boolean esDestructible;


	/*public ObjetoJuego(int x, int y) {
		miGrafico = new ObjetoGrafico(x, y);
	}*/

	public abstract boolean accept(Visitor visitor);
	
	public JLabel getLabel() {
		return miGrafico.getGrafico();
	}
	
	public ObjetoGrafico getMiGrafico(){
		return miGrafico;
	}
	
	public boolean getAtraviesaTanque() {
		return atraviesaTanque;
	}

	public boolean getAtraviesaBala() {
		return atraviesaBala;
	}

	public boolean getEsDestructible() {
		return esDestructible;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,miGrafico.getAnchoPixel(),miGrafico.getAltoPixel()); 
	}
	
	public boolean colision(ObjetoJuego obj){
		return this.getBounds().intersects(obj.getBounds());
	}
	
}

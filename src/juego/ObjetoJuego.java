package juego;

import javax.swing.JLabel;
import java.awt.Rectangle;
import grafica.ObjetoGrafico;
import visitadores.Visitor;

public abstract class ObjetoJuego {
	// Atributos
	protected ObjetoGrafico miGrafico;
	protected boolean atraviesaBala;
	protected Rectangle miRectangulo;

	public abstract boolean accept(Visitor visitor);

	public JLabel getLabel() {
		return miGrafico.getGrafico();
	}

	public Rectangle getMiRectangulo() {
		return miRectangulo;
	}

	public ObjetoGrafico getMiGrafico() {
		return miGrafico;
	}

	public boolean getAtraviesaBala() {
		return atraviesaBala;
	}

	public Rectangle getBounds() {
		return new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, miGrafico.getAnchoPixel(), miGrafico.getAltoPixel());
	}

	public void setRectangulo(Rectangle r) {
		miRectangulo = r;
	}
}

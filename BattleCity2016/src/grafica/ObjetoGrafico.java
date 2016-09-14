package grafica;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class ObjetoGrafico {
	protected JLabel grafico;
	protected Icon image[];
	protected final int ancho = 32;
	protected final int alto = 32;
	protected Point pos;
	
	public ObjetoGrafico(int x, int y) {
		this.pos = new Point(x, y);
	}

	public Point getPos() {
		return pos;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}
		return this.grafico;
	}	
	
	public void cambiarGrafico(int dir){
	}
	
	public void destruir() {
	}
	
	public void posicion() {
	}
	
	public void grafico(){
	}
	
	public boolean colision(){
		return false;
	}
}

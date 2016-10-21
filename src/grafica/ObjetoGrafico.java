package grafica;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class ObjetoGrafico {
	protected JLabel grafico;
	protected Icon image[];
	/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double anchoPantalla = screenSize.getWidth(); 
	double altoPantalla = screenSize.getHeight(); 
	protected final int anchoPixel = (int) (anchoPantalla/30);
	protected final int altoPixel = (int) (altoPantalla/30);*/
	protected final int anchoPixel = 64;
	protected final int altoPixel = 64;
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
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel); //this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
		return this.grafico;
	}	
	
	public int getAnchoPixel(){
		return anchoPixel;
	}
	
	public int getAltoPixel(){
		return altoPixel;
	}
	
	public void cambiarGrafico(int dir){
	}
	
	public void destruir() {
	}
	
	public void posicion() {
	}
	
	public void grafico(){
	}
	
	
}

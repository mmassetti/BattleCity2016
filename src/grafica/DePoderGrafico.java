package grafica;

import javax.swing.ImageIcon;

public class DePoderGrafico extends EnemigoGrafico{

	public DePoderGrafico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/DePoder/up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Fuentes1/DePoder/down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Fuentes1/DePoder/left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Fuentes1/DePoder/right.png"));
	}
	
	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
		
}

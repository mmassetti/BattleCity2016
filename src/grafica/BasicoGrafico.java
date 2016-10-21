package grafica;

import javax.swing.ImageIcon;

public class BasicoGrafico extends EnemigoGrafico{

	public BasicoGrafico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/Basico/up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Fuentes1/Basico/down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Fuentes1/Basico/left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Fuentes1/Basico/right.png"));
	}
	
	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
}

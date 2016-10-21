package grafica;

import javax.swing.ImageIcon;

public class RapidoGrafico extends EnemigoGrafico{

	public RapidoGrafico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/Rapido/up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Fuentes1/Rapido/down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Fuentes1/Rapido/left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Fuentes1/Rapido/right.png"));
	}
	
	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
}

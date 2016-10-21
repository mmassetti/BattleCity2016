package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DisparoGrafico extends ObjetoGrafico {

	public DisparoGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[4];
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/Disparo/vertical.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Fuentes1/Disparo/vertical.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Fuentes1/Disparo/horizontal.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Fuentes1/Disparo/horizontal.png"));
	}
	
	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x , this.pos.y, anchoPixel, altoPixel);
		}
	}
}
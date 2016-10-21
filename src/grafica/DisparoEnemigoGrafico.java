package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DisparoEnemigoGrafico extends ObjetoGrafico{
	
	public DisparoEnemigoGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[4];
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/DisparoEnemigo/vertical.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Fuentes1/DisparoEnemigo/vertical.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Fuentes1/DisparoEnemigo/horizontal.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Fuentes1/DisparoEnemigo/horizontal.png"));
	}
	
	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			switch (dir){
				case 0:
					this.grafico.setBounds(this.pos.x, this.pos.y-35, anchoPixel, altoPixel);
					break;
				case 1:
					this.grafico.setBounds(this.pos.x, this.pos.y+35, anchoPixel, altoPixel);
					break;
				case 2:
					this.grafico.setBounds(this.pos.x-35, this.pos.y, anchoPixel, altoPixel);
					break;
				case 3:
					this.grafico.setBounds(this.pos.x+35, this.pos.y, anchoPixel, altoPixel);
					break;
			}
		}
	}
}

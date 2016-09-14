package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class JugadorGrafico extends ObjetoGrafico {

	public JugadorGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[4];
		this.image[0] = new ImageIcon(this.getClass().getResource("/fuentes/up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/fuentes/down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/fuentes/left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/fuentes/right.png"));
	}

	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}
	}

}

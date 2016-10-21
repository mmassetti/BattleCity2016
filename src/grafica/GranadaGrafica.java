package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GranadaGrafica extends ObjetoGrafico {
	public GranadaGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		this.image[0] = new ImageIcon(this.getClass().getResource("/fuentes/Obstaculos/agua.png"));
	}
}

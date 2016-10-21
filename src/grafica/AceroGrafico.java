package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AceroGrafico extends ObjetoGrafico {

	public AceroGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/Obstaculos/acero.png"));
	}

}

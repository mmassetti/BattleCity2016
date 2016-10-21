package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BaseGrafica extends ObjetoGrafico {
	
	public BaseGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		this.image[0] = new ImageIcon(this.getClass().getResource("/Fuentes1/Base/base.png"));
	}

}

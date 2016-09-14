package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ArbolGrafico extends ObjetoGrafico {

	public ArbolGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		this.image[0] = new ImageIcon(this.getClass().getResource("/fuentes/arbol.png"));
	}

}

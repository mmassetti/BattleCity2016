package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BaseGrafica extends ObjetoGrafico {

	public BaseGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = BaseGrafica.class.getResource("/fuentes/Base/base.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] =icono;
	}

}

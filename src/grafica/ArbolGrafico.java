package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ArbolGrafico extends ObjetoGrafico {

	public ArbolGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = ArbolGrafico.class.getResource("/fuentes/Obstaculos/arbol.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AguaGrafico extends ObjetoGrafico {

	public AguaGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = AguaGrafico.class.getResource("/fuentes/Obstaculos/agua.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}

}

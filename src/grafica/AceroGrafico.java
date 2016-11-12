package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AceroGrafico extends ObjetoGrafico {

	public AceroGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = AceroGrafico.class.getResource("/fuentes/Obstaculos/acero.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}

}

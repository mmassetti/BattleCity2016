package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GranadaGrafica extends ObjetoGrafico {
	public GranadaGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = GranadaGrafica.class.getResource("/fuentes/PowerUps/bomba.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

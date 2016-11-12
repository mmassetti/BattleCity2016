package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VidaExtraGrafica extends ObjetoGrafico {
	public VidaExtraGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = RapidoGrafico.class.getResource("/fuentes/PowerUps/vidaextra.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

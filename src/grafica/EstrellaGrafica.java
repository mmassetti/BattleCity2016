package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class EstrellaGrafica extends ObjetoGrafico {
	public EstrellaGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = EstrellaGrafica.class.getResource("/fuentes/PowerUps/estrella.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

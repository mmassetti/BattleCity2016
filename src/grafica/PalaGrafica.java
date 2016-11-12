package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PalaGrafica extends ObjetoGrafico {
	public PalaGrafica(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		
		URL url = PalaGrafica.class.getResource("/fuentes/PowerUps/pala.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

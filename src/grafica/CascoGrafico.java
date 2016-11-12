package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CascoGrafico extends ObjetoGrafico {
	public CascoGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = CascoGrafico.class.getResource("/fuentes/PowerUps/casco.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

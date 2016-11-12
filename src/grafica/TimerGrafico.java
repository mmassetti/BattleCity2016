package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TimerGrafico extends ObjetoGrafico {
	public TimerGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[1];
		URL url = TimerGrafico.class.getResource("/fuentes/PowerUps/timer.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	}
}

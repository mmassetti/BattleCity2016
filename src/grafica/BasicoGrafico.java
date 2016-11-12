package grafica;

import java.net.URL;

import javax.swing.ImageIcon;

public class BasicoGrafico extends EnemigoGrafico {

	public BasicoGrafico(int x, int y) {
		super(x, y);
		URL url = BasicoGrafico.class.getResource("/fuentes/Basico/up.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = BasicoGrafico.class.getResource("/fuentes/Basico/down.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = BasicoGrafico.class.getResource("/fuentes/Basico/left.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = BasicoGrafico.class.getResource("/fuentes/Basico/right.png");
		icono = new ImageIcon(url);
		this.image[3] = icono;
	}

	public void cambiarGrafico(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
}

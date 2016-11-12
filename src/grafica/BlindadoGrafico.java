package grafica;

import java.net.URL;

import javax.swing.ImageIcon;

public class BlindadoGrafico extends EnemigoGrafico {

	public BlindadoGrafico(int x, int y) {
		super(x, y);
		URL url = BlindadoGrafico.class.getResource("/fuentes/Blindado/up.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = BlindadoGrafico.class.getResource("/fuentes/Blindado/down.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = BlindadoGrafico.class.getResource("/fuentes/Blindado/left.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = BlindadoGrafico.class.getResource("/fuentes/Blindado/right.png");
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
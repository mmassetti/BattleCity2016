package grafica;

import java.net.URL;

import javax.swing.ImageIcon;

public class DePoderGrafico extends EnemigoGrafico {

	public DePoderGrafico(int x, int y) {
		super(x, y);
		URL url = DePoderGrafico.class.getResource("/fuentes/DePoder/up.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = DePoderGrafico.class.getResource("/fuentes/DePoder/down.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = DePoderGrafico.class.getResource("/fuentes/DePoder/left.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = DePoderGrafico.class.getResource("/fuentes/DePoder/right.png");
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

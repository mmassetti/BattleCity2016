package grafica;

import java.net.URL;

import javax.swing.ImageIcon;

public class RapidoGrafico extends EnemigoGrafico {

	public RapidoGrafico(int x, int y) {
		super(x, y);
		URL url = RapidoGrafico.class.getResource("/fuentes/Rapido/up.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = RapidoGrafico.class.getResource("/fuentes/Rapido/down.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = RapidoGrafico.class.getResource("/fuentes/Rapido/left.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = RapidoGrafico.class.getResource("/fuentes/Rapido/right.png");
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

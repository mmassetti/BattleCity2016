package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LadrilloGrafico extends ObjetoGrafico {
	protected int indice;

	public LadrilloGrafico(int x, int y) {
		super(x, y);
		indice = 0;
		this.image = new Icon[4];
		
		URL url = LadrilloGrafico.class.getResource("/fuentes/Obstaculos/ladrillo1.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = LadrilloGrafico.class.getResource("/fuentes/Obstaculos/ladrillo2.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = LadrilloGrafico.class.getResource("/fuentes/Obstaculos/ladrillo3.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = LadrilloGrafico.class.getResource("/fuentes/Obstaculos/ladrillo4.png");
		icono = new ImageIcon(url);
		this.image[3] = icono;
		
	}

	public void actualizarLadrillo() {
		indice++;
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[indice]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
}

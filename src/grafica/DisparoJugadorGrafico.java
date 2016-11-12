package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class DisparoJugadorGrafico extends ObjetoGrafico {

	public DisparoJugadorGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[4];
		URL url = DisparoJugadorGrafico.class.getResource("/fuentes/DisparoJugador/vertical.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
	
		url = DisparoJugadorGrafico.class.getResource("/fuentes/DisparoJugador/vertical.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = DisparoJugadorGrafico.class.getResource("/fuentes/DisparoJugador/horizontal.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = DisparoJugadorGrafico.class.getResource("/fuentes/DisparoJugador/horizontal.png");
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

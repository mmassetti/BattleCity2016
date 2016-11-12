package grafica;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class JugadorGrafico extends ObjetoGrafico {
	protected Icon imagePowerUp[];

	public JugadorGrafico(int x, int y) {
		super(x, y);
		this.image = new Icon[4];
		this.imagePowerUp = new Icon[4];
		
		URL url = JugadorGrafico.class.getResource("/fuentes/Jugador/up.png");
		ImageIcon icono = new ImageIcon(url);
		this.image[0] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/down.png");
		icono = new ImageIcon(url);
		this.image[1] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/left.png");
		icono = new ImageIcon(url);
		this.image[2] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/right.png");
		icono = new ImageIcon(url);
		this.image[3] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/up2.png");
		icono = new ImageIcon(url);
		this.imagePowerUp[0] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/down2.png");
		icono = new ImageIcon(url);
		this.imagePowerUp[1] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/left2.png");
		icono = new ImageIcon(url);
		this.imagePowerUp[2] = icono;
		
		url = JugadorGrafico.class.getResource("/fuentes/Jugador/right2.png");
		icono = new ImageIcon(url);
		this.imagePowerUp[3] = icono;

	}

	public void cambiarGrafico(int dir, boolean tienePU) {
		if (tienePU == false)
			cambiarGraficoNormal(dir);
		else
			cambiarGraficoCasco(dir);
	}

	public void cambiarGraficoNormal(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}

	public void cambiarGraficoCasco(int dir) {
		if (this.grafico != null) {
			this.grafico.setIcon(this.imagePowerUp[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
	}
}

package enemigos;

import java.awt.Rectangle;

import grafica.RapidoGrafico;
import juego.Manager;

public class Rapido extends Enemigo {

	public Rapido(int x, int y, Manager m) {
		super(1, 7, 10, m);
		puntos = 200;
		miGrafico = new RapidoGrafico(x, y);
		miRectangulo = new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 60, 60);
	}
}

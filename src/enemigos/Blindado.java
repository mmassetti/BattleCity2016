package enemigos;

import java.awt.Rectangle;

import grafica.BlindadoGrafico;
import juego.Manager;

public class Blindado extends Enemigo {

	public Blindado(int x, int y, Manager m) {
		super(4, 3, 10, m);
		puntos = 400;
		miGrafico = new BlindadoGrafico(x, y);
		miRectangulo = new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 60, 60);
	}

}

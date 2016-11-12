package enemigos;

import java.awt.Rectangle;

import grafica.BasicoGrafico;
import juego.Manager;

public class Basico extends Enemigo {

	public Basico(int x, int y, Manager m) {
		super(1, 3, 5, m);
		puntos = 100;
		miGrafico = new BasicoGrafico(x, y);
		miRectangulo = new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 60, 60);
	}

}

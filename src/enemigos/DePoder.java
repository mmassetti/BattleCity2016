package enemigos;

import java.awt.Rectangle;
import grafica.DePoderGrafico;
import juego.Manager;

public class DePoder extends Enemigo {

	public DePoder(int x, int y, Manager m) {
		super(1, 5, 15, m);
		puntos = 300;
		miGrafico = new DePoderGrafico(x, y);
		miRectangulo = new Rectangle(miGrafico.getPos().x, miGrafico.getPos().y, 60, 60);
	}
}

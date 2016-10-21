package enemigos;

import java.awt.Rectangle;

import grafica.BlindadoGrafico;

public class Blindado extends Enemigo {

	public Blindado(int x, int y) {
		super(4,5,10,10);
		miGrafico= new BlindadoGrafico(x,y);
		miInteligencia= new IABasica();
		miRectangulo= new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,55,55);
	}

}

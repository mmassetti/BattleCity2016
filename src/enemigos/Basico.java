package enemigos;

import java.awt.Rectangle;

import grafica.BasicoGrafico;

public class Basico extends Enemigo {

	public Basico(int x, int y) {
		super(1,10,10,10);
		miGrafico= new BasicoGrafico(x,y);
		miInteligencia= new IABasica();
		miRectangulo= new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,55,55);
	}

}

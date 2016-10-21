package enemigos;

import java.awt.Rectangle;

import grafica.DePoderGrafico;

public class DePoder extends Enemigo {

	public DePoder(int x,int y) {
		super(1,15,10,10);
		miGrafico= new DePoderGrafico(x,y);
		miInteligencia= new IABasica();
		miRectangulo= new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,55,55);
	}

}

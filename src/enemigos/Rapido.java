package enemigos;

import java.awt.Rectangle;

import grafica.RapidoGrafico;

public class Rapido extends Enemigo {

	public Rapido(int x, int y) {
		super(1,20,10,10);
		miGrafico= new RapidoGrafico(x,y);
		miInteligencia= new IABasica();
		miRectangulo= new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,55,55);
	}
}

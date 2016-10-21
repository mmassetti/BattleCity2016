package obstaculos;

import juego.ObjetoJuego;
import juego.Visitor;

public abstract class Obstaculo extends ObjetoJuego {
	public boolean accept(Visitor visitor){
		return visitor.visit(this);
	}
}


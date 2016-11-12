package obstaculos;

import juego.ObjetoJuego;
import visitadores.Visitor;
import visitadores.VisitorObstaculos;

public abstract class Obstaculo extends ObjetoJuego {
	protected int resistencia;

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public abstract VisitorObstaculos getVisitor();

	public abstract int recibirDisparo();
}

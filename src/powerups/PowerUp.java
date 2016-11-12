package powerups;

import java.util.Random;
import juego.*;
import visitadores.Visitor;
import visitadores.VisitorPoderes;

public abstract class PowerUp extends ObjetoJuego {

	protected boolean existe;
	protected final int punto1 = 210;
	protected final int punto2 = 315;
	protected final int punto3 = 520;

	public PowerUp() {
		atraviesaBala = true;
		existe = true;
	}

	public boolean getExiste() {
		return existe;
	}

	public abstract VisitorPoderes getVisitor();

	public int generarCoordenada() {
		Random r = new Random();
		int dir = r.nextInt(3);
		switch (dir) {
		case 0:
			return punto1;
		case 1:
			return punto2;
		default:
			return punto3;
		}
	}

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public void destruir() {
		existe = false;
	}
}

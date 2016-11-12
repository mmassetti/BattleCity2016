package fabricas;

import enemigos.*;
import juego.Manager;

public class EnemigosFacil2 extends FabricaEnemigos {

	public EnemigosFacil2(Manager m) {
		super(m);
	}

	public Enemigo crearEnemigo(int x) {
		Enemigo e = null;
		switch (contador) {
		case 0: {
			e = new Basico(x, 0, managerDisparo);
			e.setInteligencia(new IAMedia(e));
			break;
		}
		case 1: {
			e = new DePoder(x, 0, managerDisparo);
			e.setInteligencia(new IABasica(e));
			break;
		}
		default: {
			e = new Blindado(x, 0, managerDisparo);
			e.setInteligencia(new IABasica(e));
			break;

		}
		}
		contador++;
		if (contador == 3)
			contador = 0;
		return e;
	}
}

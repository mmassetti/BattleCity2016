package fabricas;

import enemigos.*;
import juego.Manager;

public class EnemigosFacil3 extends FabricaEnemigos {

	public EnemigosFacil3(Manager m) {
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
			e.setInteligencia(new IAMedia(e));
			break;
		}
		case 2: {
			e = new Blindado(x, 0, managerDisparo);
			e.setInteligencia(new IABasica(e));
			break;
		}
		default: {
			e = new Rapido(x, 0, managerDisparo);
			e.setInteligencia(new IABasica(e));
			break;
		}
		}
		contador++;
		if (contador == 4)
			contador = 0;
		return e;
	}
}

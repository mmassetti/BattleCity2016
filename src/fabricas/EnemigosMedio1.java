package fabricas;

import enemigos.Basico;
import enemigos.Blindado;
import enemigos.DePoder;
import enemigos.Enemigo;
import enemigos.IABasica;
import enemigos.IAMedia;
import enemigos.Rapido;
import juego.Manager;

public class EnemigosMedio1 extends FabricaEnemigos {

	public EnemigosMedio1(Manager m) {
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
			e.setInteligencia(new IAMedia(e));
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

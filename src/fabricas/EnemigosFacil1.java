package fabricas;

import enemigos.*;
import juego.Manager;

public class EnemigosFacil1 extends FabricaEnemigos {

	public EnemigosFacil1(Manager m) {
		super(m);
	}

	public Enemigo crearEnemigo(int x) {
		Enemigo e = null;
		switch (contador) {
		case 0:
			e = new Basico(x, 0, managerDisparo);
			break;
		default:
			e = new DePoder(x, 0, managerDisparo);
			break;
		}
		contador++;
		if (contador == 2)
			contador = 0;
		e.setInteligencia(new IABasica(e));
		return e;
	}
}

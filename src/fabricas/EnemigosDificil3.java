package fabricas;

import enemigos.*;
import juego.Jugador;
import juego.Manager;

public class EnemigosDificil3 extends FabricaEnemigos {
	private Jugador jugador;

	public EnemigosDificil3(Manager m, Jugador j) {
		super(m);
		jugador = j;
	}

	public Enemigo crearEnemigo(int x) {
		Enemigo e = null;
		switch (contador) {
		case 0:
			e = new Basico(x, 0, managerDisparo);
			break;
		case 1:
			e = new DePoder(x, 0, managerDisparo);
			break;
		case 2:
			e = new Blindado(x, 0, managerDisparo);
			break;
		default:
			e = new Rapido(x, 0, managerDisparo);
			break;
		}
		e.setInteligencia(new IAAvanzada(e, jugador));
		contador++;
		if (contador == 4)
			contador = 0;
		return e;
	}
}

package fabricas;

import enemigos.Enemigo;
import juego.Manager;

public abstract class FabricaEnemigos {
	protected int contador;
	protected Manager managerDisparo;

	public FabricaEnemigos(Manager manager) {
		contador = 0;
		managerDisparo = manager;
	}

	public abstract Enemigo crearEnemigo(int n);
}

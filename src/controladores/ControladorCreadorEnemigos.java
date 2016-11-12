package controladores;

import enemigos.Enemigo;
import juego.Juego;

public class ControladorCreadorEnemigos extends Controlador {

	Thread hilo;
	private int contadorRespawn;
	private final int respawn1 = 0;
	private final int respawn2 = 200;
	private final int respawn3 = 400;
	private final int respawn4 = 600;
	private final int respawn5 = 800;
	private final int respawn6 = 1000;
	private final int respawn7 = 1200;
	private Juego juego;
	private int cantEnemigos;
	private volatile boolean juegoEnPausa = false;

	public ControladorCreadorEnemigos(Juego j) {
		hilo = new Thread(this);
		juego = j;
		contadorRespawn = 0;
		cantEnemigos = juego.getMisEnemigos().size();
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {

		while (hayJuego) {
			if (!juegoEnPausa) {
				cantEnemigos = juego.getMisEnemigos().size();
				if (cantEnemigos < 6) {
					Enemigo e = juego.getFabrica().crearEnemigo(generarRespawn());
					cantEnemigos++;
					juego.getGui().add(e.getLabel());
					juego.getMisEnemigos().addLast(e);
					contadorRespawn++;
					if (contadorRespawn == 7)
						contadorRespawn = 0;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private int generarRespawn() {
		switch (contadorRespawn) {
		case 0:
			return respawn4;
		case 1:
			return respawn3;
		case 2:
			return respawn7;
		case 3:
			return respawn1;
		case 4:
			return respawn5;
		case 5:
			return respawn2;
		default:
			return respawn6;
		}
	}
}

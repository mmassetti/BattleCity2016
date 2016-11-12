package controladores;

import java.awt.Rectangle;

public abstract class Controlador implements Runnable {
	protected volatile boolean juegoEnPausa = false;
	protected final Rectangle rectanguloPanel = new Rectangle(0, 0, 64 * 20, 64 * 11);
	protected volatile boolean hayJuego = true;

	public abstract void run();

	public void pausarHilo() {
		juegoEnPausa = true;
	}

	public synchronized void reanudarHilo() {
		juegoEnPausa = false;
		notifyAll();
	}

	public void controlarHilo() {
		if (juegoEnPausa == true)
			reanudarHilo();
		else
			pausarHilo();
	}

	public void terminarHilo() {
		hayJuego = false;
	}
}

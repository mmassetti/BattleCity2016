package juego;

public class TerminadorJuego {

	protected Juego miJuego;

	public TerminadorJuego(Juego juego) {
		miJuego = juego;
	}

	public void terminarJuego() {
		miJuego.finJuegoLogica();
	}
}

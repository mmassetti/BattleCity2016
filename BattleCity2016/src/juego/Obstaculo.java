package juego;

public abstract class Obstaculo extends ObjetoJuego {
	// Atributos

	protected boolean atraviesaTanque;
	protected boolean atraviesaBala;
	protected boolean esDestructible;

	public boolean getAtraviesaTanque() {
		return atraviesaTanque;
	}

	public boolean getAtraviesaBala() {
		return atraviesaBala;
	}

	public boolean getEsDestructible() {
		return esDestructible;
	}
}

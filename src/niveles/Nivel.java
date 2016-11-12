package niveles;

public abstract class Nivel {

	protected int golpesResistencia;
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	protected int disparoSimultaneo;
	protected int numeroNivel;

	public int getNumeroNivel() {
		return numeroNivel;
	}

	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}

	public int getDisparoSimultaneo() {
		return disparoSimultaneo;
	}

	public int getGolpesResistencia() {
		return golpesResistencia;
	}
}

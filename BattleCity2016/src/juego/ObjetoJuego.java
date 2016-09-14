package juego;

import javax.swing.JLabel;

import grafica.ObjetoGrafico;

public abstract class ObjetoJuego {
	// Atributos
	protected ObjetoGrafico miGrafico;

	/*public ObjetoJuego(int x, int y) {
		miGrafico = new ObjetoGrafico(x, y);
	}*/

	public JLabel getLabel() {
		return miGrafico.getGrafico();
	}

	
}

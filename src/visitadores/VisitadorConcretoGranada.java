package visitadores;

import javax.swing.JPanel;
import TDALista.EmptyListException;
import TDALista.PositionList;
import enemigos.Enemigo;
import grafica.PanelJuego;
import juego.Jugador;
import powerups.Granada;
import powerups.PowerUp;

public class VisitadorConcretoGranada extends VisitorPoderes {

	private Granada miGranada;
	private PositionList<Enemigo> misEnemigos;
	private PositionList<PowerUp> misPoderes;
	private PanelJuego gui;
	private Jugador jugador;

	public VisitadorConcretoGranada(Granada g, PositionList<Enemigo> misEnemigos, PositionList<PowerUp> misPoderes,
			Jugador j, JPanel gui) {
		miGranada = g;
		this.misEnemigos = misEnemigos;
		this.misPoderes = misPoderes;
		this.gui = (PanelJuego) gui;
		jugador = j;
	}

	public void afectarJugador(Jugador j) {
		while (!misEnemigos.isEmpty()) {
			try {
				Enemigo ultimoEnemigo = misEnemigos.last().element();
				ultimoEnemigo.morir();
				jugador.aumentarPuntos(ultimoEnemigo.getPuntos());
				// gui.remove(ultimoEnemigo.getLabel());
				misEnemigos.removeElement(ultimoEnemigo);
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
		}
		j.aumentarPuntos(500);
		gui.remove(miGranada.getLabel());
		misPoderes.removeElement(miGranada);
	}
}
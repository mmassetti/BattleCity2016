package powerups;

import javax.swing.JPanel;
import TDALista.PositionList;
import enemigos.Enemigo;
import grafica.GranadaGrafica;
import juego.Jugador;
import visitadores.VisitadorConcretoGranada;
import visitadores.VisitorPoderes;

public class Granada extends PowerUp {

	protected VisitadorConcretoGranada miVisitador;

	public Granada(PositionList<Enemigo> misEnemigos, PositionList<PowerUp> misPoderes, Jugador j, JPanel gui) {
		super();
		miVisitador = new VisitadorConcretoGranada(this, misEnemigos, misPoderes, j, gui);
		int x = generarCoordenada();
		int y = generarCoordenada();
		miGrafico = new GranadaGrafica(x, y);
	}

	public VisitorPoderes getVisitor() {
		return miVisitador;
	}
}

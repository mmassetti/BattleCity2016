package juego;

import controladores.Controlador;
import grafica.DisparoJugadorGrafico;
import visitadores.VisitadorConcretoDisparoJugador;
import visitadores.Visitor;

public class DisparoJugador extends Disparo {

	protected VisitadorConcretoDisparoJugador miVisitador;

	public DisparoJugador(int x, int y, int dir, int vD) {
		super(vD);
		miVisitador = new VisitadorConcretoDisparoJugador(this);
		miGrafico = new DisparoJugadorGrafico(x, y);
		direccionDisparo = dir;
	}

	public Visitor getVisitor() {
		return miVisitador;
	}

	public void setControlador(Controlador c) {
		miControlador = c;
	}
}

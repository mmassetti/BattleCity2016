package juego;

import controladores.Controlador;
import grafica.DisparoEnemigoGrafico;
import visitadores.VisitadorConcretoDisparoEnemigo;
import visitadores.Visitor;

public class DisparoEnemigo extends Disparo {

	protected VisitadorConcretoDisparoEnemigo miVisitador;

	public DisparoEnemigo(int x, int y, int dir) {
		super(10);
		miVisitador = new VisitadorConcretoDisparoEnemigo(this);
		miGrafico = new DisparoEnemigoGrafico(x, y);
		direccionDisparo = dir;
	}

	public Visitor getVisitor() {
		return miVisitador;
	}

	public void setControlador(Controlador c) {
		miControlador = c;
	}
}

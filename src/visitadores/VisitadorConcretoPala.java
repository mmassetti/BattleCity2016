package visitadores;

import java.util.Iterator;
import javax.swing.JPanel;
import TDALista.*;
import controladores.ControladorPala;
import grafica.PanelJuego;
import juego.Jugador;
import obstaculos.*;
import powerups.Pala;
import powerups.PowerUp;

public class VisitadorConcretoPala extends VisitorPoderes {

	private Pala miPala;
	private Base miBase;
	private PositionList<PowerUp> misPoderes;
	private PositionList<Obstaculo> misObstaculos;
	private PanelJuego gui;

	public VisitadorConcretoPala(Pala p, Base base, PositionList<PowerUp> misPoderes,
			PositionList<Obstaculo> misObstaculos, JPanel gui) {
		miPala = p;
		miBase = base;
		this.misPoderes = misPoderes;
		this.misObstaculos = misObstaculos;
		this.gui = (PanelJuego) gui;
	}

	public void afectarJugador(Jugador j) {
		j.aumentarPuntos(500);
		gui.remove(miPala.getLabel());
		misPoderes.removeElement(miPala);

		int posXbase = miBase.getMiGrafico().getPos().x;
		int posYbase = miBase.getMiGrafico().getPos().y;
		PositionList<Obstaculo> misAceros = new ListaDoblementeEnlazada<Obstaculo>();
		PositionList<Obstaculo> misLadrillos = new ListaDoblementeEnlazada<Obstaculo>();

		int posX1 = posXbase - 64;
		int posY1 = posYbase;
		Obstaculo a1 = new Acero(posX1, posY1);
		Obstaculo l1 = new Ladrillo(posX1, posY1);
		misAceros.addLast(a1);
		misLadrillos.addLast(l1);
		int posX2 = posXbase - 64;
		int posY2 = posYbase - 64;
		Obstaculo a2 = new Acero(posX2, posY2);
		Obstaculo l2 = new Ladrillo(posX2, posY2);
		misAceros.addLast(a2);
		misLadrillos.addLast(l2);
		int posX3 = posXbase;
		int posY3 = posYbase - 64;
		Obstaculo a3 = new Acero(posX3, posY3);
		Obstaculo l3 = new Ladrillo(posX3, posY3);
		misAceros.addLast(a3);
		misLadrillos.addLast(l3);
		int posX4 = posXbase + 64;
		int posY4 = posYbase - 64;
		Obstaculo a4 = new Acero(posX4, posY4);
		Obstaculo l4 = new Ladrillo(posX4, posY4);
		misAceros.addLast(a4);
		misLadrillos.addLast(l4);
		int posX5 = posXbase + 64;
		int posY5 = posYbase;
		Obstaculo a5 = new Acero(posX5, posY5);
		Obstaculo l5 = new Ladrillo(posX5, posY5);
		misAceros.addLast(a5);
		misLadrillos.addLast(l5);

		Iterator<Obstaculo> it = misObstaculos.iterator();
		while (it.hasNext()) {
			Obstaculo o = it.next();
			if (o.getMiGrafico().getPos().x == posX1 && o.getMiGrafico().getPos().y == posY1
					|| o.getMiGrafico().getPos().x == posX2 && o.getMiGrafico().getPos().y == posY2
					|| o.getMiGrafico().getPos().x == posX3 && o.getMiGrafico().getPos().y == posY3
					|| o.getMiGrafico().getPos().x == posX4 && o.getMiGrafico().getPos().y == posY4
					|| o.getMiGrafico().getPos().x == posX5 && o.getMiGrafico().getPos().y == posY5) {
				gui.remove(o.getLabel());
				misObstaculos.removeElement(o);
			}
		}
		ControladorPala controladorTiempo = new ControladorPala(misObstaculos, misAceros, misLadrillos, gui);
		controladorTiempo.start();
	}
}
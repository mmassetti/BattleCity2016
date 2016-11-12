package controladores;

import javax.swing.JPanel;

import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.PositionList;
import grafica.PanelJuego;
import obstaculos.Obstaculo;

public class ControladorPala extends Controlador {

	Thread hilo;
	private PositionList<Obstaculo> misAceros;
	private PositionList<Obstaculo> misLadrillos;
	private PositionList<Obstaculo> misObstaculos;
	private PanelJuego gui;
	private int contador = 0;

	public ControladorPala(PositionList<Obstaculo> misObstaculos, PositionList<Obstaculo> misAceros,
			PositionList<Obstaculo> misLadrillos, JPanel gui) {
		hilo = new Thread(this);
		this.misAceros = misAceros;
		this.misLadrillos = misLadrillos;
		this.misObstaculos = misObstaculos;
		this.gui = (PanelJuego) gui;
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		while (hayJuego) {
			while (!misAceros.isEmpty()) {
				try {
					gui.add(misAceros.last().element().getLabel());
					misObstaculos.addLast(misAceros.remove(misAceros.last()));
				} catch (EmptyListException | InvalidPositionException e) {
					e.printStackTrace();
				}
			}
			while (contador < 10) {
				contador++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			for (int i = 0; i < 5; i++)
				try {
					gui.remove(misObstaculos.last().element().getLabel());
					misObstaculos.remove(misObstaculos.last());
				} catch (InvalidPositionException | EmptyListException e) {
					e.printStackTrace();
				}

			while (!misLadrillos.isEmpty()) {
				try {
					gui.add(misLadrillos.last().element().getLabel());
					misObstaculos.addLast(misLadrillos.remove(misLadrillos.last()));
				} catch (EmptyListException | InvalidPositionException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package juego;

import TDALista.PositionList;
import grafica.Ventana;
import powerups.PowerUp;

public class ControladorPoderes implements Runnable {
	protected Ventana gui;
	protected PowerUp poder;
	protected PositionList<PowerUp> misPoderes;
	protected VisitadorConcretoJugador visitadorJugador;
	protected Jugador miJugador;
	Thread hilo;
	
	public ControladorPoderes(PowerUp poder,Jugador jugador,PositionList<PowerUp> poderes, Ventana  v){
		hilo = new Thread(this);
		gui=v;
		misPoderes = poderes;
		miJugador = jugador;
		this.poder=poder;
	}
	
	public void start(){
		this.hilo.start();
	}
	public void run() {
			while(poder.getExiste()){
				
				visitadorJugador = new VisitadorConcretoJugador(miJugador);
				controlarPowerUp();
			}
	}
	
	public void controlarPowerUp(){
		boolean encontre = false;
		encontre = poder.accept(visitadorJugador);
		if(encontre){
			poder.afectarJugador();
			poder.destruir();
			misPoderes.removeElement(poder);
			gui.remove(poder.getLabel());
			gui.repintar();
		}
	}

}

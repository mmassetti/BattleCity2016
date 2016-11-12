package enemigos;

import java.awt.Point;
import java.util.Random;

import juego.Jugador;

public class IAAvanzada extends IA {
	protected Jugador jugador;

	public IAAvanzada(Enemigo e, Jugador j) {
		miEnemigo = e;
		contador = 0;
		direccion = 0;
		jugador = j;
		ultimaUbicacion = null;
	}

	public int cambiarDireccion() {
		miEnemigo.disparar();
		Point ubicacionEnemigo = miEnemigo.getMiGrafico().getPos().getLocation();
		if (!ubicacionEnemigo.equals(ultimaUbicacion)) {
			Point ubicacionJugador = jugador.getMiGrafico().getPos().getLocation();
			ultimaUbicacion = ubicacionEnemigo;
			int diferencia = Math.abs(ubicacionJugador.y - ubicacionEnemigo.y);
			if (diferencia >= 5) {
				if (ubicacionJugador.y > ubicacionEnemigo.y)
					direccion = 1;
				else if (ubicacionJugador.y < ubicacionEnemigo.y)
					direccion = 0;
			} else {
				if (ubicacionJugador.x < ubicacionEnemigo.x)
					direccion = 2;
				else if (ubicacionJugador.x > ubicacionEnemigo.x)
					direccion = 3;
			}
		} else {
			Random r = new Random();
			direccion = r.nextInt(2) + 2;
		}
		return direccion;
	}

}

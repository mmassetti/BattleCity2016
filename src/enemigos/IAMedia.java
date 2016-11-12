package enemigos;

import java.awt.Point;
import java.util.Random;

public class IAMedia extends IA {

	public IAMedia(Enemigo e) {
		miEnemigo = e;
		contador = 0;
		direccion = 0;
	}

	public int cambiarDireccion() {
		miEnemigo.disparar();
		Point ubicacionEnemigo = miEnemigo.getMiGrafico().getPos().getLocation();
		if (!ubicacionEnemigo.equals(ultimaUbicacion) && contador < 60) {
			ultimaUbicacion = ubicacionEnemigo;
			contador++;
		} else {
			Random r = new Random();
			direccion = r.nextInt(3) + 1;
			contador = 0;
		}

		return direccion;
	}

}

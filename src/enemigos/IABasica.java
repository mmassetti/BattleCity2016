package enemigos;

import java.awt.Point;
import java.util.Random;

public class IABasica extends IA {

	public IABasica(Enemigo e) {
		contador = 0;
		direccion = 0;
		miEnemigo = e;
		ultimaUbicacion = null;
	}

	public int cambiarDireccion() {
		Point ubicacionEnemigo = miEnemigo.getMiGrafico().getPos().getLocation();
		if (!ubicacionEnemigo.equals(ultimaUbicacion) && contador < 100) {
			ultimaUbicacion = ubicacionEnemigo;
			contador++;
		} else {
			miEnemigo.disparar();
			Random r = new Random();
			direccion = r.nextInt(4);
			contador = 0;
		}

		return direccion;
	}
}

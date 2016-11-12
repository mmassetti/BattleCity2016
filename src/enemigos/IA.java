package enemigos;

import java.awt.Point;

public abstract class IA {
	protected Enemigo miEnemigo;
	protected int contador;
	protected int direccion;
	protected Point ultimaUbicacion;

	public abstract int cambiarDireccion();

}

package enemigos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import TDALista.ListaDoblementeEnlazada;
import audio.ReproductorSonido;
import juego.Disparo;
import juego.DisparoEnemigo;
import juego.Jugador;
import juego.Manager;
import juego.Tanque;
import visitadores.VisitadorConcretoEnemigo;
import visitadores.Visitor;

public abstract class Enemigo extends Tanque {
	protected IA miInteligencia;
	protected int contadorMovimientos;
	protected boolean estaVivo;
	protected int puntos;
	protected VisitadorConcretoEnemigo miVisitador;
	protected Manager managerDisparo;
	protected Jugador jugador;
	protected ReproductorSonido miReproductorSonido;
	protected Timer timer;

	public Enemigo(int res, int vM, int vD, Manager m) {
		resistenciaGolpes = res;
		velocidadMovimiento = vM;
		velocidadDisparo = vD;
		estaVivo = true;
		direccionActual = 0;
		contadorMovimientos = 0;
		miVisitador = new VisitadorConcretoEnemigo(this);
		disparosActuales = new ListaDoblementeEnlazada<Disparo>();
		disparoSimultaneo = 1;
		managerDisparo = m;
		miReproductorSonido = new ReproductorSonido();
		crearTimer();
	}

	public int getResistenciaGolpes() {
		return resistenciaGolpes;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}

	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}

	public VisitadorConcretoEnemigo getVisitador() {
		return miVisitador;
	}

	public IA getInteligencia() {
		return miInteligencia;
	}

	public void setInteligencia(IA i) {
		miInteligencia = i;
	}

	public boolean getEstaVivo() {
		return estaVivo;
	}

	public void disparar() {
		if (disparosActuales.size() < disparoSimultaneo) {
			DisparoEnemigo d = new DisparoEnemigo(miGrafico.getPos().x, miGrafico.getPos().y, direccionActual);
			d.cambiarDireccion(direccionActual);
			disparosActuales.addLast(d);
			managerDisparo.generarDisparo(d, this);
		}
	}

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public void recibirDisparo() {
		resistenciaGolpes--;
		if (resistenciaGolpes == 0) {
			morir();
		}
	}

	public void morir() {
		cambiarLabel();
		miReproductorSonido.reproducir("explosion");
		estaVivo = false;
	}

	private void crearTimer() {
		timer = new Timer(300, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sacarGif();
			}
		});
		timer.setRepeats(false);
	}

	private void cambiarLabel() {
		ImageIcon animacion = new ImageIcon(getClass().getResource("/fuentes/Background/explosion.gif"));
		this.getMiGrafico().getGrafico().setIcon(animacion);
		timer.restart();
	}

	private void sacarGif() {
		this.getMiGrafico().getGrafico().setIcon(null);
	}
}

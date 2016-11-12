package visitadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import audio.ReproductorSonido;
import juego.Disparo;
import juego.Tanque;
import juego.TerminadorJuego;
import obstaculos.*;

public class VisitadorConcretoBase extends VisitorObstaculos {

	private Base miBase;
	private TerminadorJuego miTerminador;
	private ReproductorSonido miReproductorSonido;
	private Timer timer;

	public VisitadorConcretoBase(Base b, TerminadorJuego t) {
		miBase = b;
		miTerminador = t;
		miReproductorSonido = new ReproductorSonido();
		crearTimer();
	}

	public boolean puedePasar(Tanque t) {
		return true;
	}

	public boolean puedePasar(Disparo d) {
		cambiarLabel();
		miReproductorSonido.reproducir("explosion");
		miTerminador.terminarJuego();
		return false;
	}

	private void crearTimer() {
		timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miBase.getMiGrafico().getGrafico().setIcon(null);
			}
		});
		timer.setRepeats(false);
	}

	private void cambiarLabel() {
		ImageIcon animacion = new ImageIcon(getClass().getResource("/fuentes/Base/explosion.gif"));
		miBase.getMiGrafico().getGrafico().setIcon(animacion);
		timer.restart();
	}
}

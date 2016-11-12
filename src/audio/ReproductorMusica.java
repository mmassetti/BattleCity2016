package audio;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import controladores.Controlador;




public class ReproductorMusica extends Controlador  {
	
	Thread hilo;
	private volatile int hayMusica = 0;
	Clip clip;
	
	public ReproductorMusica () {
		hilo= new Thread(this);
	}
	
	public void start() {
		this.hilo.start();
	}

	public void run() {
		while (hayJuego) {
			if (hayMusica == 0) {
				try {
					InputStream in = ReproductorMusica.class.getResourceAsStream("/fuentes/Audio/fondo.wav");
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(in));
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					Thread.sleep(clip.getMicrosecondLength());
		
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				try {
					Thread.sleep(this.hayMusica);
					this.hayMusica = 0;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void pararHilo(int tiempo) {
		this.hayMusica = tiempo;
	}
	
	public void detener () {
		clip.stop();
	}
	
	public void reanudar() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public boolean hayMusica() {
		return clip.isActive();
	}
	
}


package audio;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReproductorSonido {
	
	private String fuente;
	private Clip clip;
	
	public ReproductorSonido() {

	}

	public void reproducir(String nombre) {
		
		try {
			fuente = "/fuentes/Audio/"+nombre+".wav";
			InputStream in = ReproductorSonido.class.getResourceAsStream(fuente);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(in));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}

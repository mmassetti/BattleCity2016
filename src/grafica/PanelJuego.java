package grafica;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import juego.Juego;

public class PanelJuego extends JPanel implements KeyListener {

	//Atributos
	private Juego map;
	private BufferedImage img;
	private static final long serialVersionUID = 1L;
	private volatile boolean estaEnPausa = false;
	private Ventana ventana;
	private PanelInfo panelInfo;
	private boolean juegoInicio;
	private String nombreJugador;
	private boolean pediNombreJugador;

	//Constructor
	public PanelJuego(Ventana ventana) {
		this.ventana = ventana;
		cambiarFondoAOriginal();
		setearPanel();
		juegoInicio = false;
		pediNombreJugador=false;
	}

	//Establecen propiedades del panel
	private void setearPanel() {
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 1284, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 702, Short.MAX_VALUE));
		this.setLayout(gl_panel);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, 1280, 704, this);
	}
	
	//Listeners del teclado
		public void keyPressed(KeyEvent arg0) {
			moverJugador(arg0);
		}

		public void keyReleased(KeyEvent arg0) {
			disparo(arg0);
			pausarJuego(arg0);
			cambiarMapaRandom(arg0);
			mostrarPuntajesAltos(arg0);
		}

		public void keyTyped(KeyEvent arg0) {

		}
	
	//Metodos auxiliares
	public void setJuego(Juego j) {
		map = j;
	}

	protected void moverJugador(KeyEvent key) {
		map.moverJugador(key.getKeyCode());
	}

	protected void disparo(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_K)
			map.generarDisparo();
	}

	protected void pausarJuego(KeyEvent key) {
		if (KeyEvent.VK_SPACE == key.getKeyCode() && juegoInicio)
			map.pausarJuegoBoton();
		else {
			if (KeyEvent.VK_ENTER == key.getKeyCode() && !juegoInicio) {
				if (map.getNombreJugador() != null)
					map.pausarJuegoInicioNivelAvanzado();
				else
					map.pausarJuegoInicioPrimerNivel();
				juegoInicio = true;
			}
		}
	}

	protected void cambiarMapaRandom(KeyEvent key) {
		if (KeyEvent.VK_C == key.getKeyCode()) {
			panelInfo.getReproductor().detener();
			map.finJuegoAlternativa();
			Random rnd = new Random();
			int nroMapa = rnd.nextInt(5) + 1;
			ventana.reiniciar(nroMapa);
		}
	}

	protected void mostrarPuntajesAltos(KeyEvent key) {
		if (KeyEvent.VK_R == key.getKeyCode()) {
			URL url = PanelJuego.class.getResource("/fuentes/PanelInfo/puntaje.png");
			ImageIcon icono = new ImageIcon(url);
			String puntajes = map.getMiAdministradorPuntajes().getPuntajesAltos();
			if (this.getEstaEnPausa()) {
				JOptionPane.showMessageDialog(this, "\n" + puntajes, "RANKING", JOptionPane.INFORMATION_MESSAGE, icono);
			} else {
				this.getJuego().pausarJuegoBoton();
				JOptionPane.showMessageDialog(this, "\n" + puntajes, "RANKING", JOptionPane.INFORMATION_MESSAGE, icono);
				this.getJuego().pausarJuegoBoton();
			}
			this.requestFocus();
		}
	}

	public boolean getEstaEnPausa() {
		return estaEnPausa;
	}

	public void cambiarFondoAOriginal() {
		try {
			URL url = PanelJuego.class.getResource("/fuentes/Background/fondo.png");
			img= ImageIO.read(url); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		estaEnPausa = false;
	}

	public void cambiarFondoAEspera() {
		try {
			URL url = PanelJuego.class.getResource("/fuentes/Background/esperainicio.png");
			img= ImageIO.read(url); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		estaEnPausa = true;
	}

	public void cambiarFondoAPausa() {
		try {
			URL url = PanelJuego.class.getResource("/fuentes/Background/pausa.png");
			img= ImageIO.read(url); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		estaEnPausa = true;
	}

	public void cambiarFondoAGameOver() {
		try {
			URL url = PanelJuego.class.getResource("/fuentes/Background/gameover.png");
			img= ImageIO.read(url); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.repaint();

	}

	public Juego getJuego() {
		return map;
	}

	public void setPanelInfo(PanelInfo panel) {
		panelInfo = panel;
	}

	public String pedirNombreJugador() {
		if (pediNombreJugador==false) {
			int control = -1;
			while (control < 0) {
				nombreJugador = JOptionPane.showInputDialog("Por favor ingrese su nombre: ");
				if (nombreJugador==null) {
					System.exit(0);
				}
				if (nombreJugador.length() > 0) {
					control++;
				} else
					JOptionPane.showMessageDialog(this, "Ingrese su nombre: ");
			}	
		}
		return nombreJugador;
		
	}
	
	public void setPediNombreJugador(boolean pedi) {
		pediNombreJugador= true;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}
}

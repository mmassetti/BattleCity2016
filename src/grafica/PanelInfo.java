package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import audio.ReproductorMusica;

public class PanelInfo extends JPanel {

	// Atributos
	private static final long serialVersionUID = 1L;

	// JFrame
	Ventana ventana;

	// Panel juego
	PanelJuego panelJuego;

	// Imagen
	private BufferedImage img;

	// Botones
	protected JButton botonSalir;
	protected JButton botonReiniciar;
	protected JButton botonAyuda;
	protected JButton botonMusica;

	// Etiquetas
	protected JLabel labelPuntos;
	protected JLabel labelPuntosJugador;
	protected JLabel labelVidas;
	protected JLabel labelVidasJugador;
	protected JLabel labelNivel;
	protected JLabel labelNivelJugador;

	// Reproductor
	protected ReproductorMusica reproductor;

	// Numero de mapa actual
	protected int numeroMapa;

	// Constructor
	public PanelInfo(JPanel panelJuego, Ventana ventana, int nroMapa) {
		numeroMapa = nroMapa;
		crearAudio();
		crearImagen();
		crearBotones();
		crearEtiquetas();
		setearPanel();
		this.ventana = ventana;
		this.panelJuego = (PanelJuego) panelJuego;

	}

	// Crea la imagen de fondo del panel
	private void crearImagen() {
		try {
			 URL url = PanelInfo.class.getResource("/fuentes/Background/fondo.png");
			 img= ImageIO.read(url); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Crea los botones del panel
	private void crearBotones() {

		// Se crea el boton para salir del juego y se asocia al listener
		botonSalir = new JButton("");
		URL url = PanelInfo.class.getResource("/fuentes/PanelInfo/salir.png");
		ImageIcon icono = new ImageIcon(url);
		botonSalir.setIcon((icono));
		botonSalir.setMargin(new Insets(0, 0, 0, 0));
		botonSalir.setBackground(null);
		botonSalir.setBorder(null);
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Se crea el boton para reiniciar el jugo (se reinicia la ventana)
		botonReiniciar = new JButton("");
		botonReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproductor.detener();
				panelJuego.getJuego().finJuegoAlternativa();
				ventana.reiniciar(numeroMapa);
			}
		});
		url = PanelInfo.class.getResource("/fuentes/PanelInfo/reiniciar.png");
		icono = new ImageIcon(url);
		botonReiniciar.setIcon(icono);
		botonReiniciar.setMargin(new Insets(0, 0, 0, 0));
		botonReiniciar.setBackground(null);
		botonReiniciar.setBorder(null);

		// Se crea el boton para mostrar una ayuda al usuario
		botonAyuda = new JButton("");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				URL url = PanelInfo.class.getResource("/fuentes/PanelInfo/mensajeayuda.png");
				ImageIcon iconoayuda = new ImageIcon(url);
				if (panelJuego.getEstaEnPausa()) {
					JOptionPane.showMessageDialog(null, "", "Ayuda", JOptionPane.INFORMATION_MESSAGE, iconoayuda);
				} else {
					panelJuego.getJuego().pausarJuegoBoton(); // Pauso el juego
					JOptionPane.showMessageDialog(null, "", "Ayuda", JOptionPane.INFORMATION_MESSAGE, iconoayuda);
					panelJuego.getJuego().pausarJuegoBoton(); // Cuando apreta aceptar se reanuda el juego
				}
				panelJuego.requestFocus();
			}
		});
		url = PanelInfo.class.getResource("/fuentes/PanelInfo/ayuda.png");
		icono = new ImageIcon(url);
		botonAyuda.setIcon(icono);
		botonAyuda.setMargin(new Insets(0, 0, 0, 0));
		botonAyuda.setBorder(null);
		botonAyuda.setBackground(null);

		// Se crea el boton para pausar o reproducir la musica y se asocia al
		// listener
		botonMusica = new JButton("");
		url = PanelInfo.class.getResource("/fuentes/PanelInfo/musicaON.png");
		icono = new ImageIcon(url);
		botonMusica.setIcon(icono);
		botonMusica.setMargin(new Insets(0, 0, 0, 0));
		botonMusica.setBorder(null);
		botonMusica.setBackground(null);

		botonMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reproductor.hayMusica()) {
					reproductor.detener();
					panelJuego.requestFocus();
					URL url = PanelInfo.class.getResource("/fuentes/PanelInfo/musicaOFF.png");
					ImageIcon icono = new ImageIcon(url);
					botonMusica.setIcon(icono);
				} else {
					reproductor.reanudar();
					panelJuego.requestFocus();
					URL url = PanelInfo.class.getResource("/fuentes/PanelInfo/musicaON.png");
					ImageIcon icono = new ImageIcon(url);
					botonMusica.setIcon(icono);
				}
			}
		});

	}

	// Crea las etiquetas del panel
	private void crearEtiquetas() {

		// labels para los puntos
		labelPuntos = new JLabel("PUNTOS");
		labelPuntos.setForeground(Color.WHITE);
		labelPuntos.setFont(new Font("Ebrima", Font.PLAIN, 16));

		labelPuntosJugador = new JLabel("0");
		labelPuntosJugador.setForeground(Color.YELLOW);
		labelPuntosJugador.setFont(new Font("Ebrima", Font.BOLD, 18));

		// labels para las vidas
		labelVidas = new JLabel("VIDAS");
		labelVidas.setForeground(Color.WHITE);
		labelVidas.setFont(new Font("Ebrima", Font.PLAIN, 16));

		labelVidasJugador = new JLabel("1");
		labelVidasJugador.setForeground(Color.YELLOW);
		labelVidasJugador.setFont(new Font("Ebrima", Font.BOLD, 18));

		// labels para el nivel del jugador
		labelNivel = new JLabel("NIVEL ");
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setFont(new Font("Ebrima", Font.PLAIN, 16));

		labelNivelJugador = new JLabel("1");
		labelNivelJugador.setForeground(Color.YELLOW);
		labelNivelJugador.setFont(new Font("Ebrima", Font.BOLD, 18));

	}

	// Establece propiedades del panel
	private void setearPanel() {
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(botonReiniciar, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(botonSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addContainerGap(20, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addComponent(labelPuntosJugador, 0, 0, Short.MAX_VALUE).addGap(46))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addComponent(labelVidas, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
												.addGap(46))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addComponent(labelVidasJugador, 0, 0, Short.MAX_VALUE).addGap(46))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(labelNivelJugador, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 61, Short.MAX_VALUE)
														.addComponent(labelNivel, GroupLayout.DEFAULT_SIZE, 61,
																Short.MAX_VALUE))
												.addGap(46))
								.addGroup(Alignment.TRAILING,
										gl_panel.createSequentialGroup()
												.addComponent(labelPuntos, GroupLayout.DEFAULT_SIZE, 97,
														Short.MAX_VALUE)
												.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(botonMusica, 0, 0, Short.MAX_VALUE).addGap(66))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(botonAyuda, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
										.addGap(66)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(botonSalir)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(botonReiniciar).addGap(65)
						.addComponent(labelPuntos).addGap(18).addComponent(labelPuntosJugador).addGap(32)
						.addComponent(labelVidas).addGap(18).addComponent(labelVidasJugador).addGap(41)
						.addComponent(labelNivel).addGap(18).addComponent(labelNivelJugador).addGap(95)
						.addComponent(botonAyuda).addGap(18).addComponent(botonMusica)
						.addContainerGap(26, Short.MAX_VALUE)));
		this.setLayout(gl_panel);

	}

	// Crea el reproductor e inicia la musica de fondo
	private void crearAudio() {
		reproductor = new ReproductorMusica();
		reproductor.start();
	}

	// Metodos auxiliares
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, 1280, 704, this);
	}

	public JLabel getlabelPuntosJugador() {
		return labelPuntosJugador;
	}

	public JLabel getlabelVidasJugador() {
		return labelVidasJugador;
	}

	public JLabel getlabelNivelJugador() {
		return labelNivelJugador;
	}

	public int getNumeroMapa() {
		return numeroMapa;
	}

	public ReproductorMusica getReproductor() {
		return reproductor;
	}

}

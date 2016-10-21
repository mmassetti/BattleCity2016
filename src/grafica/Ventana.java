package grafica;

import juego.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	//private Container contentPane = getContentPane();
	private PanelJuego panelJuego;
	//private JPanel panelMenu;
	private BufferedImage img;
	private Juego map;
	private final int width= 64*20; 
	private final int height= 64*11;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ventana();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private class PanelJuego extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, width, height, this);
		}
	}

	public Ventana() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				moverJugador(arg0);
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				disparo(arg0);
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()== KeyEvent.VK_ESCAPE) { //Para salir del juego (por ahora)
					System.exit(0);
				}
					
			}
		});
		
		try {
			img = ImageIO.read(new File(getClass().getResource("/Fuentes1/Background/fondo.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace(); 
		}
		
		
		setTitle("Battle City 2016");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setBounds(50,50,width,height);
		

		panelJuego = new PanelJuego();
		panelJuego.setBorder(new EmptyBorder(1,1,1,1));		
		panelJuego.setLayout(null);
		setContentPane(panelJuego);
		setResizable(false);
		setVisible(true);
		
		/*contentPane.setLayout(new GridLayout(1,2));
		panelMenu = new JPanel();
		panelMenu.setBorder(new EmptyBorder(1,1,1,1));		
		panelMenu.setLayout(null);			
		contentPane.add(panelJuego);
		contentPane.add(panelMenu);*/
		
		map = new Juego(this);
	}

	protected void moverJugador(KeyEvent key) {
		map.moverJugador(key.getKeyCode());
	}
	
	protected void disparo(KeyEvent key) {
		map.generarDisparo(key.getKeyCode());
	}
	
	public synchronized void repintar(){
		this.repaint();
	}
}

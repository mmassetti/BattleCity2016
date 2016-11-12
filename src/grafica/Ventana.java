package grafica;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import juego.Juego;
import juego.Jugador;

public class Ventana extends JFrame {

	//Atributos
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelJuego panelJuego;
	protected PanelInfo panelInfo;
	private Juego map;
	private static volatile int nroNivel = 1;
	private static volatile int nroMapa = 1;

	//Main
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana(nroMapa,nroNivel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructores
	public Ventana(int nMapa,int nNivel) {
		setearPropiedades();
		crearPaneles(nMapa);
		setearVentana();
		crearJuego(nMapa, nNivel);
	}
	
	public Ventana(int nNivel,int nMapa, Jugador j,String nombreJugador){
		setearPropiedades();
		crearPaneles(nMapa);
		setearVentana();
		crearJuego(nMapa, nNivel,j,nombreJugador);
	}

	//Seteo de las propiedades del frame
	private void setearPropiedades() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1373, 704);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setUndecorated(true);
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
	}

	//Creacion de los paneles
	private void crearPaneles(int nMapa) {
		panelJuego = new PanelJuego(this);
		panelJuego.addKeyListener(panelJuego);
		panelJuego.setFocusable(true);
		panelJuego.setBackground(Color.BLACK);
		panelInfo = new PanelInfo(panelJuego, this, nMapa);
		panelInfo.setFocusable(true);
	}

	//Ajustes del frame
	private void setearVentana() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panelJuego, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 1181, Short.MAX_VALUE)
						.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
				.addComponent(panelJuego, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE));

		contentPane.setLayout(gl_contentPane);
	}
	
	//Se crea el juego
	private void crearJuego(int nMapa, int nNivel) {
		map = new Juego(this, panelJuego, panelInfo, nMapa, nNivel);
		panelJuego.setJuego(map);
		panelJuego.setPanelInfo(panelInfo);
	}
	
	private void crearJuego(int nMapa, int nNivel, Jugador j,String nombreJugador) {
		panelJuego.setPediNombreJugador(true);
		map = new Juego(this, panelJuego, panelInfo, nMapa, nNivel,j);
		map.setNombreJugador(nombreJugador);
		panelJuego.setJuego(map);
		panelJuego.setPanelInfo(panelInfo);
		
	}

	
	//Metodos auxiliares

	//Reinicia el juego
	public void reiniciar(int nMapa) {
		this.dispose();
		Ventana frame = new Ventana(nMapa,nroNivel);
		frame.setVisible(true);
	}

	//Cambia de nivel
	public void cambiarNivel(int nNivel, int nMapa, Jugador j,String nombreJugador) {
		this.dispose();
		Ventana frame = new Ventana(nNivel, nMapa,j,nombreJugador);
		frame.setVisible(true);
	}
}

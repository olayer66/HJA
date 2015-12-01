package HJA.GUI;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

import HJA.constante;
import HJA.controlador.controlador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Toolkit;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

public class GUIPlayers {

	
	private JFrame frmPokermaster;
	private controlador control;
	
	private JPanel jpApar1;
	private JTextField[] TfRango;
	private JTextField[] tfEquity;
	private JButton[] btnJugadores;
	private JButton[] btnRandom;
	private misAccciones accion;
	private JTextField tfMesa;
	private JTextField tfDescartes;
	
	
	
	
	public GUIPlayers(controlador miCont)
	{
		control=miCont;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokermaster = new JFrame();
		frmPokermaster.setTitle("PokerMaster");
		frmPokermaster.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIPlayers.class.getResource("/HJA/GUI/icon.png")));
		frmPokermaster.setBounds(100, 100, 625, 708);
		frmPokermaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokermaster.getContentPane().setLayout(null);
		
		
		//Actionlisteners
		accion= new misAccciones(this);
		
		
		jpApar1 = new JPanel();
		jpApar1.setBounds(0, 0, 375, 360);
		frmPokermaster.getContentPane().add(jpApar1);
		jpApar1.setLayout(null);
		
		JPanel jpControles = new JPanel();
		jpControles.setBounds(385, 0, 214, 360);
		frmPokermaster.getContentPane().add(jpControles);
		jpControles.setLayout(null);
		
		//incializadores
		creaTfRango();
		creaTfEquity();
		creaBtnJugadores();
		creaBtnRandom();
			
		
		JLabel lblRangoDeJuego = new JLabel("Rango de Juego");
		lblRangoDeJuego.setBounds(130, 0, 182, 14);
		jpApar1.add(lblRangoDeJuego);
		
		JLabel lblEquity = new JLabel("Equity");
		lblEquity.setBounds(322, 0, 39, 14);
		jpApar1.add(lblEquity);
		
		JLabel lblMesa = new JLabel("Mesa:");
		lblMesa.setBounds(10, 11, 68, 14);
		jpControles.add(lblMesa);
		
		tfMesa = new JTextField();
		tfMesa.setBounds(10, 24, 68, 20);
		jpControles.add(tfMesa);
		tfMesa.setColumns(10);
		
		JLabel lblDescartes = new JLabel("Descartes:");
		lblDescartes.setBounds(10, 55, 68, 14);
		jpControles.add(lblDescartes);
		
		tfDescartes = new JTextField();
		tfDescartes.setBounds(10, 72, 68, 20);
		jpControles.add(tfDescartes);
		tfDescartes.setColumns(10);
		
		JButton btnSeleccionarMesa = new JButton("Seleccionar");
		btnSeleccionarMesa.setBounds(88, 23, 116, 23);
		jpControles.add(btnSeleccionarMesa);
		
		JButton btnSeleccionarDescartes = new JButton("Seleccionar");
		btnSeleccionarDescartes.setBounds(88, 71, 116, 23);
		jpControles.add(btnSeleccionarDescartes);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(54, 120, 89, 69);
		jpControles.add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(54, 200, 89, 23);
		jpControles.add(btnLimpiar);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(54, 234, 89, 23);
		jpControles.add(btnAyuda);
		
	}
	//Crea los botones
	private void creaBtnJugadores()
	{
		int y=-10;
		btnJugadores= new JButton[10];
		for(int i=0;i<btnJugadores.length;i++)
		{
			btnJugadores[i]=new JButton();
			btnJugadores[i].setText("Jugador "+Integer.toString(i+1));
			y+=34;
			btnJugadores[i].setBounds(10, y, 98, 23);	
			btnJugadores[i].addActionListener(accion);
			btnJugadores[i].setActionCommand(Integer.toString(i+1));
			jpApar1.add(btnJugadores[i]);
		}
	}
	//Crea los botones de ramdom
	private void creaBtnRandom()
	{
		int y=-10;
		btnRandom= new JButton[10];
		for(int i=0;i<btnRandom.length;i++)
		{
			btnRandom[i]=new JButton();
			btnRandom[i].setText("Rnd");
			y+=34;
			btnRandom[i].setBounds(113, y, 41, 23);
			btnRandom[i].setMargin(new Insets(2,0,0,2));
			btnRandom[i].addActionListener(accion);
			btnRandom[i].setActionCommand(Integer.toString(i+22));
			jpApar1.add(btnRandom[i]);
		}
	}
	//crea los textfield de rango
	private void creaTfRango()
	{	
		int y=-8;
		TfRango=new JTextField[10];
		for(int i=0;i<TfRango.length;i++)
		{
			TfRango[i]=new JTextField();
			TfRango[i].setColumns(10);
			y+=34;
			TfRango[i].setBounds(158, y, 160, 20);
			jpApar1.add(TfRango[i]);
		}
			
	}
	//Crea los textfield de equity
	private void creaTfEquity()
	{
		int y=-8;
		tfEquity=new JTextField[10];
		for(int i=0;i<tfEquity.length;i++)
		{
			tfEquity[i]=new JTextField();
			tfEquity[i].setColumns(10);
			y+=34;
			tfEquity[i].setBounds(322, y, 39, 20);
			tfEquity[i].setEditable(false);
			tfEquity[i].setBackground(Color.WHITE);
			jpApar1.add(tfEquity[i]);
		}
	}
	//Inserta el nuevo rango extraido de la GUIRango
	public void insertaRango(String rango,int jugador)
	{
		TfRango[jugador].setText(rango);
	}
	
	//Inserta un rango random en el jugador pasado
	public void insertaRamdom(int jug)
	{
		TfRango[jug].setText("Aleatorio");
		TfRango[jug].setEditable(false);
	}
	
	//devuelve el texto de un textfile dado el numero de juagdor
	public String miRango(int jugador)
	{
		return TfRango[jugador].getText();
	}
	//Getters y setters
	public JFrame getFrame() {
		return frmPokermaster;
	}

	public JTextField[] getTfRango() {
		return TfRango;
	}

	public void setTfRango(JTextField[] tfRango) {
		TfRango = tfRango;
	}

	public controlador getControl() {
		return control;
	}

	public misAccciones getAccion() {
		return accion;
	}
}

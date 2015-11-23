package HJA.GUI;

import java.awt.EventQueue;
import java.awt.TextField;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;

import HJA.constante;
import HJA.constante.datosMano;
import HJA.controlador.controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class GUIPlayers {

	private JFrame frmPokermaster;
	private controlador control;
	private JTextField[] TfRango;
	private JButton[] btnJugadores;
	private misAccciones accion;
	private JPanel jpAp2;
	private JRadioButton rdbtnOr;
	private JRadioButton rdbtnFold;
	private ButtonGroup botones;
	
	private JTextField tfEquity1;
	private JTextField textField_1;	
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_17;
	private JTextField tfMano;
	private JPanel jpApar1;
	
	
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
		frmPokermaster.setBounds(100, 100, 391, 441);
		frmPokermaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokermaster.getContentPane().setLayout(null);
		
		jpApar1 = new JPanel();
		jpApar1.setBounds(0, 32, 375, 375);
		frmPokermaster.getContentPane().add(jpApar1);
		jpApar1.setLayout(null);
		
		jpAp2 = new JPanel();
		jpAp2.setBounds(0, 32, 375, 310);
		frmPokermaster.getContentPane().add(jpAp2);
		jpAp2.setLayout(null);
		jpAp2.setVisible(false);
		//Actionlisteners
		accion= new misAccciones(this);
		
		//incializadores
		creaTfRango();
		creaBtnJugadores();
			
		JLabel lblApartado = new JLabel("Apartado:");
		lblApartado.setBounds(10, 11, 54, 14);
		frmPokermaster.getContentPane().add(lblApartado);
		
		JComboBox<Integer> cbApartado = new JComboBox<Integer>();
		cbApartado.setBounds(64, 8, 40, 20);
		cbApartado.addItem(1);
		cbApartado.addItem(2);
		cbApartado.setSelectedIndex(0);
		cbApartado.addActionListener(accion);
		cbApartado.setActionCommand("17");
		frmPokermaster.getContentPane().add(cbApartado);
		
		botones= new ButtonGroup();
		
		
		
		
		
		JLabel lblMano = new JLabel("Mano:");
		lblMano.setBounds(6, 63, 46, 14);
		jpAp2.add(lblMano);
		
		tfMano = new JTextField();
		tfMano.setBounds(42, 60, 86, 20);
		jpAp2.add(tfMano);
		tfMano.setColumns(10);
		
		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setBounds(6, 88, 46, 14);
		jpAp2.add(lblPosicion);
		
		JComboBox<String> cbPosicion = new JComboBox<String>();
		cbPosicion.setBounds(52, 85, 76, 20);
		jpAp2.add(cbPosicion);
		
		JButton btnSelecionar = new JButton("Seleccionar");
		btnSelecionar.setBounds(138, 59, 103, 23);
		jpAp2.add(btnSelecionar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(259, 59, 89, 43);
		jpAp2.add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbPosicion.addItem("SB");
		cbPosicion.addItem("BB");
		cbPosicion.addItem("UTG");
		cbPosicion.addItem("UTG+1");
		cbPosicion.addItem("MP");
		cbPosicion.addItem("CO");
		cbPosicion.addItem("BTN");
		cbPosicion.addActionListener(accion);
		cbPosicion.setActionCommand("18");
		
		rdbtnOr = new JRadioButton("OR");
		rdbtnOr.setBounds(134, 84, 46, 23);
		jpAp2.add(rdbtnOr);
		
		rdbtnFold = new JRadioButton("Fold");
		rdbtnFold.setBounds(182, 84, 59, 23);
		jpAp2.add(rdbtnFold);
		botones.add(rdbtnFold);
		botones.add(rdbtnOr);
		
		JCheckBox chckbxMa = new JCheckBox("MA");
		chckbxMa.setBounds(6, 7, 97, 23);
		jpAp2.add(chckbxMa);
		
		JCheckBox chckbxJanda = new JCheckBox("Janda");
		chckbxJanda.setBounds(6, 33, 97, 23);
		jpAp2.add(chckbxJanda);
		
		
		
		JLabel lblRangoDeJuego = new JLabel("Rango de Juego");
		lblRangoDeJuego.setBounds(130, 0, 182, 14);
		jpApar1.add(lblRangoDeJuego);
		
		JLabel lblEquity = new JLabel("Equity");
		lblEquity.setBounds(322, 0, 39, 14);
		jpApar1.add(lblEquity);
		
		
		tfEquity1 = new JTextField();
		tfEquity1.setBounds(322, 25, 39, 20);
		jpApar1.add(tfEquity1);
		tfEquity1.setEditable(false);
		tfEquity1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(322, 59, 39, 20);
		jpApar1.add(textField_1);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(322, 93, 39, 20);
		jpApar1.add(textField_3);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		
		textField_5 = new JTextField();
		textField_5.setBounds(322, 127, 39, 20);
		jpApar1.add(textField_5);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		
		textField_7 = new JTextField();
		textField_7.setBounds(322, 161, 39, 20);
		jpApar1.add(textField_7);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		
		textField_9 = new JTextField();
		textField_9.setBounds(322, 195, 39, 20);
		jpApar1.add(textField_9);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		
		
		textField_11 = new JTextField();
		textField_11.setBounds(322, 229, 39, 20);
		jpApar1.add(textField_11);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		
		
		textField_13 = new JTextField();
		textField_13.setBounds(322, 263, 39, 20);
		jpApar1.add(textField_13);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(322, 297, 39, 20);
		jpApar1.add(textField_15);
		textField_15.setEditable(false);
		textField_15.setColumns(10);
			
		textField_17 = new JTextField();
		textField_17.setBounds(322, 331, 39, 20);
		jpApar1.add(textField_17);
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		
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
			TfRango[i].setBounds(121, y, 182, 20);
			jpApar1.add(TfRango[i]);
		}
			
	}
	//Inserta el nuevo rango extraido de la GUIRango
	public void insertaRango(String rango,int jugador)
	{
		TfRango[jugador].setText(rango);
	}
	
	//cambia la ventana segun el apartado selecionado
	public void cambiaVentana(int apartado)
	{
		if(apartado==1)
		{
			jpAp2.setVisible(false);
			jpApar1.setVisible(true);
		}
		else
		{
			jpAp2.setVisible(true);
			jpApar1.setVisible(false);
		}
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

package HJA.GUI;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import HJA.controlador.controlador;

import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
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
	private JTextPane tpSalida;
	private Color mejorEquity= Color.GREEN;
	private Color Equity= Color.YELLOW;
	private Color peorEquity= Color.RED;
	private HelpBroker hb;
	private HelpSet hs;
	
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
		jpApar1.setBorder(null);
		jpApar1.setBounds(10, 11, 365, 362);
		frmPokermaster.getContentPane().add(jpApar1);
		jpApar1.setLayout(null);
		
		JPanel jpControles = new JPanel();
		jpControles.setBorder(null);
		jpControles.setBounds(385, 11, 214, 362);
		frmPokermaster.getContentPane().add(jpControles);
		jpControles.setLayout(null);
		
		//incializadores
		cargarAyuda();
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
		lblMesa.setBounds(10, 25, 68, 14);
		jpControles.add(lblMesa);
		
		tfMesa = new JTextField();
		tfMesa.setBounds(10, 38, 68, 20);
		jpControles.add(tfMesa);
		tfMesa.setColumns(10);
		
		JLabel lblDescartes = new JLabel("Descartes:");
		lblDescartes.setBounds(10, 69, 68, 14);
		jpControles.add(lblDescartes);
		
		tfDescartes = new JTextField();
		tfDescartes.setBounds(10, 86, 68, 20);
		jpControles.add(tfDescartes);
		tfDescartes.setColumns(10);
		
		JButton btnSeleccionarMesa = new JButton("Seleccionar");
		btnSeleccionarMesa.setBounds(88, 37, 116, 23);
		btnSeleccionarMesa.addActionListener(accion);
		btnSeleccionarMesa.setActionCommand("32");
		jpControles.add(btnSeleccionarMesa);
		
		JButton btnSeleccionarDescartes = new JButton("Seleccionar");
		btnSeleccionarDescartes.setBounds(88, 85, 116, 23);
		btnSeleccionarDescartes.addActionListener(accion);
		btnSeleccionarDescartes.setActionCommand("33");
		jpControles.add(btnSeleccionarDescartes);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(54, 134, 89, 69);
		btnCalcular.addActionListener(accion);
		btnCalcular.setActionCommand("34");
		jpControles.add(btnCalcular);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(54, 214, 89, 23);
		btnLimpiar.addActionListener(accion);
		btnLimpiar.setActionCommand("35");
		jpControles.add(btnLimpiar);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(54, 248, 89, 23);
		btnAyuda.addActionListener(new CSH.DisplayHelpFromSource( hb ));
		jpControles.add(btnAyuda);
		hb.enableHelpOnButton(btnAyuda, "manual", hs);
		
		JPanel jpSalida = new JPanel();
		jpSalida.setBounds(10, 384, 589, 275);
		frmPokermaster.getContentPane().add(jpSalida);
		jpSalida.setLayout(null);
		
		tpSalida = new JTextPane();
		tpSalida.setEditable(false);
		tpSalida.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tpSalida.setBounds(10, 28, 569, 247);
		jpSalida.add(tpSalida);
		
		JLabel lblDatosDeSalida = new JLabel("Datos de salida:");
		lblDatosDeSalida.setBounds(10, 11, 134, 14);
		jpSalida.add(lblDatosDeSalida);
		
	}
	
	/*---------------------------------------------------------------------------------------------------------------------------*/
	
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
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	//Inserta el nuevo rango extraido de la GUIRango
	public void insertaRango(String rango,int jugador)
	{
		TfRango[jugador].setEditable(true);
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
		if(TfRango[jugador].isEditable())
			return TfRango[jugador].getText();
		else
			return "";
	}
	//INserta el equity en los jugadores
	public void insertaEquity(int[] equity)
	{
		int mayor=0;
		int menor=50;
		for(int i=0;i<equity.length;i++)
		{
			tfEquity[i].setText(Integer.toString(equity[i]));
			if(equity[i]!=0)
				tfEquity[i].setBackground(Equity);	
			if(equity[i]>= mayor)
				mayor=i;
			else if(equity[i]<=menor)
				menor=i;		
		}
		tfEquity[mayor].setBackground(mejorEquity);	
		tfEquity[menor].setBackground(peorEquity);	
	}
	//Inserta el resultado de la salida
	public void miSalida(String salida)
	{
		tpSalida.setText(salida);
	}
	//Limpia todos los campos de la ventana
	public void limpiarVentana()
	{
		for(int i=0;i<10;i++)
		{
			TfRango[i].setText("");
			if(!TfRango[i].isEditable())
				TfRango[i].setEditable(true);
			tfEquity[i].setText("");
			tfEquity[i].setBackground(Color.WHITE);
		}
		tfMesa.setText("");
		tfDescartes.setText("");
		tpSalida.setText("");
	}
	
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/
	
	private void cargarAyuda()
	{
		String helpHS =System.getProperty("user.dir")+ "/src/HJA/help/help.hs";
		try {
			// falla aqui la url esta mal no apunta bien a help.hs
			File fichero = new File(helpHS);
			URL hsURL = fichero.toURI().toURL();
		    hs = new HelpSet(null, hsURL);
		} catch (Exception ee) {
		    System.out.println( "HelpSet " + ee.getMessage());
		    System.out.println("HelpSet "+ helpHS +" not found");
		    return;
		}
		hb = hs.createHelpBroker();
		hb.enableHelpKey(frmPokermaster.getContentPane(), "manual", hs);
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/
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

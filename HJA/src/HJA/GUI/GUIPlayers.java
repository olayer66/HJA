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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class GUIPlayers {

	
	private JFrame frmPokermaster;
	private controlador control;
	
	//Apartado 1
	private JPanel jpApar1;
	private JTextField[] TfRango;
	private JButton[] btnJugadores;
	private misAccciones accion;
	
	//Apartado 2
	private JPanel jpAp2;
	private JRadioButton rdbtnOr;
	private JRadioButton rdbtnFold;
	private ButtonGroup botones;
	private JCheckBox chckbxMa;
	private JCheckBox chckbxJanda;
	private JComboBox<String> cbPosicion;
	private JButton btnSelecionar;
	private JButton btnCalcular;
	private JTextField tfMano;
	
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
	
	private JPanel jpMA;
	private JPanel jpJanda;
	private JLabel lblRangoMa;
	private JLabel lblRangoJanda;
	private JLabel lblMAResultado ;
	private JLabel lblJandaResultado ;
	private JLabel lblPosicion_1;
	private JTextField tfMAPos;
	private JTextField tfMAMano;
	private JTextField tfMAAccion;
	private JTextField tfJandaAccion;
	private JTextField tfJandaMano;
	private JTextField tfJandaPosicion;
	
	
	
	
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
		
		jpAp2 = new JPanel();
		jpAp2.setBounds(0, 32, 375, 310);
		frmPokermaster.getContentPane().add(jpAp2);
		jpAp2.setLayout(null);
		jpAp2.setVisible(false);
		
		
		//Actionlisteners
		accion= new misAccciones(this);
			
		
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
		
		btnSelecionar = new JButton("Seleccionar");
		btnSelecionar.setBounds(138, 59, 103, 23);
		jpAp2.add(btnSelecionar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(259, 59, 89, 43);
		btnCalcular.addActionListener(accion);
		btnCalcular.setActionCommand("18");
		jpAp2.add(btnCalcular);
	
		cbPosicion = new JComboBox<String>();
		cbPosicion.setBounds(52, 85, 76, 20);
		jpAp2.add(cbPosicion);
		cbPosicion.addItem("SB");
		cbPosicion.addItem("BB");
		cbPosicion.addItem("UTG");
		cbPosicion.addItem("UTG+1");
		cbPosicion.addItem("MP");
		cbPosicion.addItem("CO");
		cbPosicion.addItem("BTN");
		
		
		rdbtnOr = new JRadioButton("OR");
		rdbtnOr.setBounds(134, 84, 46, 23);
		jpAp2.add(rdbtnOr);
		
		rdbtnFold = new JRadioButton("Fold");
		rdbtnFold.setBounds(182, 84, 59, 23);
		jpAp2.add(rdbtnFold);
		
		
		chckbxMa = new JCheckBox("MA");
		chckbxMa.setBounds(6, 7, 97, 23);
		jpAp2.add(chckbxMa);
		
		chckbxJanda = new JCheckBox("Janda");
		chckbxJanda.setBounds(6, 33, 97, 23);
		jpAp2.add(chckbxJanda);
		
		
		
		jpMA = new JPanel();
		jpMA.setBounds(6, 113, 170, 138);
		jpAp2.add(jpMA);
		jpMA.setLayout(null);
		jpMA.setVisible(false);
		
		lblRangoMa = new JLabel("Rango MA");
		lblRangoMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRangoMa.setBounds(10, 0, 150, 14);
		jpMA.add(lblRangoMa);
		
		lblPosicion_1 = new JLabel("Posicion:");
		lblPosicion_1.setBounds(10, 21, 46, 14);
		jpMA.add(lblPosicion_1);
		
		tfMAPos = new JTextField();
		tfMAPos.setBackground(Color.WHITE);
		tfMAPos.setEditable(false);
		tfMAPos.setBounds(66, 18, 86, 20);
		jpMA.add(tfMAPos);
		tfMAPos.setColumns(10);
		
		JLabel lblMano_1 = new JLabel("Mano:");
		lblMano_1.setBounds(10, 46, 46, 14);
		jpMA.add(lblMano_1);
		
		tfMAMano = new JTextField();
		tfMAMano.setEditable(false);
		tfMAMano.setColumns(10);
		tfMAMano.setBackground(Color.WHITE);
		tfMAMano.setBounds(66, 43, 86, 20);
		jpMA.add(tfMAMano);
		
		JLabel lblNewLabel = new JLabel("Accion:");
		lblNewLabel.setBounds(10, 71, 46, 14);
		jpMA.add(lblNewLabel);
		
		tfMAAccion = new JTextField();
		tfMAAccion.setEditable(false);
		tfMAAccion.setColumns(10);
		tfMAAccion.setBackground(Color.WHITE);
		tfMAAccion.setBounds(66, 68, 86, 20);
		jpMA.add(tfMAAccion);
		
		lblMAResultado = new JLabel("Error");
		lblMAResultado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMAResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblMAResultado.setBounds(10, 96, 150, 37);
		jpMA.add(lblMAResultado);
		
		jpJanda = new JPanel();
		jpJanda.setBounds(182, 113, 183, 138);
		jpAp2.add(jpJanda);
		jpJanda.setLayout(null);
		jpJanda.setVisible(false);
		
		lblRangoJanda = new JLabel("Rango Janda");
		lblRangoJanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblRangoJanda.setBounds(10, 0, 163, 14);
		jpJanda.add(lblRangoJanda);
		
		lblJandaResultado = new JLabel("Error");
		lblJandaResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblJandaResultado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblJandaResultado.setBounds(10, 96, 150, 37);
		jpJanda.add(lblJandaResultado);
		
		tfJandaAccion = new JTextField();
		tfJandaAccion.setEditable(false);
		tfJandaAccion.setColumns(10);
		tfJandaAccion.setBackground(Color.WHITE);
		tfJandaAccion.setBounds(66, 68, 86, 20);
		jpJanda.add(tfJandaAccion);
		
		tfJandaMano = new JTextField();
		tfJandaMano.setEditable(false);
		tfJandaMano.setColumns(10);
		tfJandaMano.setBackground(Color.WHITE);
		tfJandaMano.setBounds(66, 43, 86, 20);
		jpJanda.add(tfJandaMano);
		
		tfJandaPosicion = new JTextField();
		tfJandaPosicion.setEditable(false);
		tfJandaPosicion.setColumns(10);
		tfJandaPosicion.setBackground(Color.WHITE);
		tfJandaPosicion.setBounds(66, 18, 86, 20);
		jpJanda.add(tfJandaPosicion);
		
		JLabel label_1 = new JLabel("Posicion:");
		label_1.setBounds(10, 21, 46, 14);
		jpJanda.add(label_1);
		
		JLabel label_2 = new JLabel("Mano:");
		label_2.setBounds(10, 46, 46, 14);
		jpJanda.add(label_2);
		
		JLabel label_3 = new JLabel("Accion:");
		label_3.setBounds(10, 71, 46, 14);
		jpJanda.add(label_3);
		
		
		jpApar1 = new JPanel();
		jpApar1.setBounds(0, 32, 375, 375);
		frmPokermaster.getContentPane().add(jpApar1);
		jpApar1.setLayout(null);
		
		
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
			
		
		JLabel lblRangoDeJuego = new JLabel("Rango de Juego");
		lblRangoDeJuego.setBounds(130, 0, 182, 14);
		jpApar1.add(lblRangoDeJuego);
		
		JLabel lblEquity = new JLabel("Equity");
		lblEquity.setBounds(322, 0, 39, 14);
		jpApar1.add(lblEquity);
		
		//Grupos de botones
		botones= new ButtonGroup();
		botones.add(rdbtnFold);
		botones.add(rdbtnOr);
		botones.setSelected(rdbtnOr.getModel(), true);
		
		//--------------------------------------------------------------------------------------------------------------
		
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
	//Comprueba el estado para el calculo
	private boolean comprobarEstadoCalculo()
	{
		boolean correcto=true;
		if(!rdbtnFold.isSelected() && !rdbtnOr.isSelected())
			correcto=false;
		else if(tfMano.getText().equals(""))
			correcto=false;
		return correcto;
	}
	//Recoje los datos para la ejecucion del calculo
	public void EjecutarCalculo()
	{
		jpJanda.setVisible(false);
		jpMA.setVisible(false);
		String[] datos;
		if(comprobarEstadoCalculo())
		{
			datos=new String[4];
			datos[1]=tfMano.getText();
			datos[2]=Integer.toString(cbPosicion.getSelectedIndex());
			if(rdbtnOr.isSelected())
				datos[3]="0";
			else
				datos[3]="1";
			if(chckbxMa.isSelected())
			{
				datos[0]="0";
				mostrarMA(control.evaluarJugada(datos));
			}
			if(chckbxJanda.isSelected())
			{
				datos[0]="1";
				mostrarJanda(control.evaluarJugada(datos));
			}
		}
		else
			datos=null;
	}
	//resultado de janda
	private void mostrarJanda(boolean resultado)
	{
		jpJanda.setVisible(true);
		tfJandaMano.setText(tfMano.getText());
		tfJandaPosicion.setText(cbPosicion.getItemAt(cbPosicion.getSelectedIndex()));
		if(rdbtnOr.isSelected())
			tfJandaAccion.setText("Open Range");
		else
			tfJandaAccion.setText("Fold");
		if(resultado)
		{
			lblJandaResultado.setForeground(Color.GREEN);
			lblJandaResultado.setText("Correcto");
		}
		else
		{
			lblJandaResultado.setForeground(Color.RED);
			lblJandaResultado.setText("Erroneo");
		}
		
	}
	//resultado de MA
	private void mostrarMA(boolean resultado)
	{
		jpMA.setVisible(true);
		tfMAMano.setText(tfMano.getText());
		tfMAPos.setText(cbPosicion.getItemAt(cbPosicion.getSelectedIndex()));
		if(rdbtnOr.isSelected())
			tfMAAccion.setText("Open Range");
		else
			tfMAAccion.setText("Fold");
		if(resultado)
		{
			lblMAResultado.setForeground(Color.GREEN);
			lblMAResultado.setText("Correcto");
		}
		else
		{
			lblMAResultado.setForeground(Color.RED);
			lblMAResultado.setText("Erroneo");
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

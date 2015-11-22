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
import javax.swing.JButton;
import javax.swing.JTextField;

public class GUIPlayers {

	private JFrame frame;
	private controlador control;
	private JTextField[] TfRango;
	private misAccciones accion;
	
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
	
	
	public GUIPlayers(controlador miCont)
	{
		control=miCont;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//incializadores
		creaTfRango();
		
		JButton btnPlayer1 = new JButton("jugador 1");
		btnPlayer1.setBounds(10, 45, 94, 23);
		frame.getContentPane().add(btnPlayer1);
		
		
		tfEquity1 = new JTextField();
		tfEquity1.setBounds(313, 46, 39, 20);
		frame.getContentPane().add(tfEquity1);
		tfEquity1.setColumns(10);
		
		JButton btnPlayer2 = new JButton("jugador 2");
		btnPlayer2.setBounds(10, 79, 94, 23);
		frame.getContentPane().add(btnPlayer2);
			
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 80, 39, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnPlayer3 = new JButton("jugador 3");
		btnPlayer3.setBounds(10, 113, 94, 23);
		frame.getContentPane().add(btnPlayer3);
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(313, 114, 39, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnPlayer4 = new JButton("jugador 4");
		btnPlayer4.setBounds(10, 147, 94, 23);
		frame.getContentPane().add(btnPlayer4);
		
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(313, 148, 39, 20);
		frame.getContentPane().add(textField_5);
		
		JButton btnPlayer5 = new JButton("jugador 5");
		btnPlayer5.setBounds(10, 181, 94, 23);
		frame.getContentPane().add(btnPlayer5);
		
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(313, 182, 39, 20);
		frame.getContentPane().add(textField_7);
		
		JButton btnPlayer6 = new JButton("jugador 6");
		btnPlayer6.setBounds(10, 215, 94, 23);
		frame.getContentPane().add(btnPlayer6);
		
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(313, 216, 39, 20);
		frame.getContentPane().add(textField_9);
		
		JButton btnPlayer7 = new JButton("jugador 7");
		btnPlayer7.setBounds(10, 249, 94, 23);
		frame.getContentPane().add(btnPlayer7);
		
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(313, 250, 39, 20);
		frame.getContentPane().add(textField_11);
		
		JButton btnPlayer8 = new JButton("jugador 8");
		btnPlayer8.setBounds(10, 283, 94, 23);
		frame.getContentPane().add(btnPlayer8);
		
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(313, 284, 39, 20);
		frame.getContentPane().add(textField_13);
		
		JButton btnPlayer9 = new JButton("jugador 9");
		btnPlayer9.setBounds(10, 317, 94, 23);
		frame.getContentPane().add(btnPlayer9);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(313, 318, 39, 20);
		frame.getContentPane().add(textField_15);
		
		JButton btnPlayer10 = new JButton("jugador 10");
		btnPlayer10.setBounds(10, 351, 94, 23);
		frame.getContentPane().add(btnPlayer10);
	
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(313, 352, 39, 20);
		frame.getContentPane().add(textField_17);
		
		JLabel lblRangoDeJuego = new JLabel("Rango de Juego");
		lblRangoDeJuego.setBounds(121, 21, 182, 14);
		frame.getContentPane().add(lblRangoDeJuego);
		
		JLabel lblEquity = new JLabel("Equity");
		lblEquity.setBounds(313, 21, 39, 14);
		frame.getContentPane().add(lblEquity);
		
		//Actionlisteners
		accion= new misAccciones(this);
		btnPlayer1.addActionListener(accion);
		btnPlayer1.setActionCommand("1");
		btnPlayer2.addActionListener(accion);
		btnPlayer2.setActionCommand("2");
		btnPlayer3.addActionListener(accion);
		btnPlayer3.setActionCommand("3");
		btnPlayer4.addActionListener(accion);
		btnPlayer4.setActionCommand("4");
		btnPlayer5.addActionListener(accion);
		btnPlayer5.setActionCommand("5");
		btnPlayer6.addActionListener(accion);
		btnPlayer6.setActionCommand("6");
		btnPlayer7.addActionListener(accion);
		btnPlayer7.setActionCommand("7");
		btnPlayer8.addActionListener(accion);
		btnPlayer8.setActionCommand("8");
		btnPlayer9.addActionListener(accion);
		btnPlayer9.setActionCommand("9");
		btnPlayer10.addActionListener(accion);
		btnPlayer10.setActionCommand("10");
		
	}
	
	//crea los textfield de rango
	private void creaTfRango()
	{
		TfRango=new JTextField[10];
		int y=13;
		for(int i=0;i<TfRango.length;i++)
		{
			TfRango[i]=new JTextField();
			TfRango[i].setColumns(10);
			y+=34;
			TfRango[i].setBounds(121, y, 182, 20);
			frame.getContentPane().add(TfRango[i]);
		}
			
	}
	//Inserta el nuevo rango extraido de la GUIRango
	public void insertaRango(Object[] rng,int jugador)
	{
		StringBuilder rango=new StringBuilder();
		for (int i=0;i<rng.length;i++)
		{
			rango.append(rng[i]);
			if(i!=rng.length-1)
				rango.append(",");
		}
		TfRango[jugador].setText(rango.toString());
	}
	//devuelve el texto de un textfile dado el numero de juagdor
	public String miRango(int jugador)
	{
		return TfRango[jugador].getText();
	}
	//Getters y setters
	public JFrame getFrame() {
		return frame;
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

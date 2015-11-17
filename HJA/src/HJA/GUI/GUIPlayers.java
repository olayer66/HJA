package HJA.GUI;

import java.awt.EventQueue;
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
	private JTextField TfRango1;
	private JTextField tfEquity1;
	private JTextField TfRango2;
	private JTextField textField_1;
	private JTextField TfRango3;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
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
		
		JButton btnPlayer1 = new JButton("jugador 1");
		btnPlayer1.setBounds(10, 45, 94, 23);
		frame.getContentPane().add(btnPlayer1);
		
		TfRango1 = new JTextField();
		TfRango1.setBounds(121, 46, 182, 20);
		frame.getContentPane().add(TfRango1);
		TfRango1.setColumns(10);
		
		tfEquity1 = new JTextField();
		tfEquity1.setBounds(313, 46, 39, 20);
		frame.getContentPane().add(tfEquity1);
		tfEquity1.setColumns(10);
		
		JButton btnPlayer2 = new JButton("jugador 2");
		btnPlayer2.setBounds(10, 79, 94, 23);
		frame.getContentPane().add(btnPlayer2);
		
		TfRango2 = new JTextField();
		TfRango2.setColumns(10);
		TfRango2.setBounds(121, 80, 182, 20);
		frame.getContentPane().add(TfRango2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(313, 80, 39, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnPlayer3 = new JButton("jugador 3");
		btnPlayer3.setBounds(10, 113, 94, 23);
		frame.getContentPane().add(btnPlayer3);
		
		TfRango3 = new JTextField();
		TfRango3.setColumns(10);
		TfRango3.setBounds(121, 114, 182, 20);
		frame.getContentPane().add(TfRango3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(313, 114, 39, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnPlayer4 = new JButton("jugador 4");
		btnPlayer4.setBounds(10, 147, 94, 23);
		frame.getContentPane().add(btnPlayer4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 148, 182, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(313, 148, 39, 20);
		frame.getContentPane().add(textField_5);
		
		JButton btnPlayer5 = new JButton("jugador 5");
		btnPlayer5.setBounds(10, 181, 94, 23);
		frame.getContentPane().add(btnPlayer5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(121, 182, 182, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(313, 182, 39, 20);
		frame.getContentPane().add(textField_7);
		
		JButton btnPlayer6 = new JButton("jugador 6");
		btnPlayer6.setBounds(10, 215, 94, 23);
		frame.getContentPane().add(btnPlayer6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(121, 216, 182, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(313, 216, 39, 20);
		frame.getContentPane().add(textField_9);
		
		JButton btnPlayer7 = new JButton("jugador 7");
		btnPlayer7.setBounds(10, 249, 94, 23);
		frame.getContentPane().add(btnPlayer7);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(121, 250, 182, 20);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(313, 250, 39, 20);
		frame.getContentPane().add(textField_11);
		
		JButton btnPlayer8 = new JButton("jugador 8");
		btnPlayer8.setBounds(10, 283, 94, 23);
		frame.getContentPane().add(btnPlayer8);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(121, 284, 182, 20);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(313, 284, 39, 20);
		frame.getContentPane().add(textField_13);
		
		JButton btnPlayer9 = new JButton("jugador 9");
		btnPlayer9.setBounds(10, 317, 94, 23);
		frame.getContentPane().add(btnPlayer9);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(121, 318, 182, 20);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(313, 318, 39, 20);
		frame.getContentPane().add(textField_15);
		
		JButton btnPlayer10 = new JButton("jugador 10");
		btnPlayer10.setBounds(10, 351, 94, 23);
		frame.getContentPane().add(btnPlayer10);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(121, 352, 182, 20);
		frame.getContentPane().add(textField_16);
		
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
		
		
	}
	
	
	//Getters y setters
	public JFrame getFrame() {
		return frame;
	}
}

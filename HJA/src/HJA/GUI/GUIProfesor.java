package HJA.GUI;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

import HJA.controlador.controlador;

import java.awt.Toolkit;

public class GUIProfesor {

	private controlador control;
	private accionesProfesor acciones;
	private JFrame frmPokermaster;
	private JPanel panelProfesor;
	private JTextField tfBoard;
	private JButton btnEjecutar;
	private JButton[] btnSeleccionar;
	private ImagePanel[] ipCartas;
	private ImagePanel[] ipMesa;
	private JButton[] btnRandom;
	private JTextField[] Equitys;
	private JRadioButton rbFold;
	private JRadioButton rbCall;
	private JTextField tfEquity;
	private JComboBox<String> cbAleatoriasMesa;
	private ButtonGroup botones;
	public GUIProfesor(controlador miCont) {
		control= miCont;
		acciones= new accionesProfesor(this);
		botones= new ButtonGroup();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokermaster = new JFrame();
		frmPokermaster.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIProfesor.class.getResource("/HJA/GUI/icon.png")));
		frmPokermaster.setTitle("PokerMaster");
		frmPokermaster.setBounds(100, 100, 490, 533);
		frmPokermaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokermaster.getContentPane().setLayout(null);
		
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador.setBounds(54, 11, 125, 27);
		frmPokermaster.getContentPane().add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Rival");
		lblJugador_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJugador_1.setBounds(291, 11, 125, 27);
		frmPokermaster.getContentPane().add(lblJugador_1);
		
		
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesa.setBounds(176, 229, 125, 27);
		frmPokermaster.getContentPane().add(lblMesa);
		
		JButton sm = new JButton("Seleccionar Mesa");
		sm.setBounds(79, 398, 149, 23);
		frmPokermaster.getContentPane().add(sm);
		
		panelProfesor = new JPanel();
		panelProfesor.setBorder(null);
		panelProfesor.setBounds(10, 425, 454, 59);
		frmPokermaster.getContentPane().add(panelProfesor);
		panelProfesor.setLayout(null);
		
		JRadioButton rdbtnCall = new JRadioButton("Call");
		rdbtnCall.setBounds(72, 7, 46, 23);
		panelProfesor.add(rdbtnCall);
		
		JRadioButton rdbtnFold = new JRadioButton("Fold");
		rdbtnFold.setBounds(72, 33, 71, 23);
		panelProfesor.add(rdbtnFold);
		
		JLabel lblEquity = new JLabel("Equity: ");
		lblEquity.setBounds(138, 10, 46, 15);
		panelProfesor.add(lblEquity);
		
		tfEquity = new JTextField();
		tfEquity.setBounds(178, 7, 86, 20);
		panelProfesor.add(tfEquity);
		tfEquity.setColumns(10);
					
		cbAleatoriasMesa = new JComboBox<String>();
		cbAleatoriasMesa.setBounds(238, 399, 41, 20);
		frmPokermaster.getContentPane().add(cbAleatoriasMesa);
		cbAleatoriasMesa.addItem("0");
		cbAleatoriasMesa.addItem("3");
		cbAleatoriasMesa.addItem("4");
		cbAleatoriasMesa.addItem("5");
		
		//ButtonGroup
		botones.add(rdbtnFold);
		botones.add(rdbtnCall);
		//Inicializadores
		creaCartas();
		creaBotones();
	}
	//Crea Las cartas
	private void creaCartas()
	{
		ipCartas= new ImagePanel[4];
		ipMesa= new ImagePanel[5];
		int witdh=83;
		int heigth=120;
		int x=35;
		int y=43;
		for(int i=0; i< ipCartas.length;i++)
		{
			ipCartas[i] = new ImagePanel("back.jpg");
			ipCartas[i].setName("bc");
			ipCartas[i].setBounds(x, y, witdh, heigth);
			frmPokermaster.getContentPane().add(ipCartas[i]);
			if(i==1)
				x+=139;
			else
				x+=93;
		}
		x=10;
		y=267;
		for(int i=0;i<ipMesa.length;i++)
		{
			ipMesa[i] = new ImagePanel("back.jpg");
			ipMesa[i].setName("bc");
			ipMesa[i].setBounds(x, y, witdh, heigth);
			frmPokermaster.getContentPane().add(ipMesa[i]);
			x+=93;
		}
	}
	//Crea los Botones
	private void creaBotones()
	{
		JButton btnsc1 = new JButton("Seleccionar cartas");
		btnsc1.setBounds(35, 174, 176, 23);
		frmPokermaster.getContentPane().add(btnsc1);
		btnsc1.addActionListener(acciones);
		btnsc1.setActionCommand("1");
		
		JButton btnsc2 = new JButton("Seleccionar cartas");
		btnsc2.setBounds(267, 174, 176, 23);
		frmPokermaster.getContentPane().add(btnsc2);
		btnsc2.addActionListener(acciones);
		btnsc2.setActionCommand("2");
		
		JButton btnsm = new JButton("Seleccionar Mesa");
		btnsm.setBounds(79, 398, 149, 23);
		frmPokermaster.getContentPane().add(btnsm);
		btnsm.addActionListener(acciones);
		btnsm.setActionCommand("3");
		
		JButton btnal1 = new JButton("Aleatorias");
		btnal1.setBounds(68, 202, 100, 23);
		frmPokermaster.getContentPane().add(btnal1);
		btnal1.addActionListener(acciones);
		btnal1.setActionCommand("4");
		
		JButton btnal2 = new JButton("Aleatorias");
		btnal2.setBounds(303, 202, 108, 23);
		frmPokermaster.getContentPane().add(btnal2);
		btnal2.addActionListener(acciones);
		btnal2.setActionCommand("5");
		
		JButton btnAleatoriasMesa = new JButton("Aleatorias");
		btnAleatoriasMesa.setBounds(279, 398, 100, 23);
		frmPokermaster.getContentPane().add( btnAleatoriasMesa);
		btnAleatoriasMesa.addActionListener(acciones);
		btnAleatoriasMesa.setActionCommand("6");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(284, 7, 92, 41);
		panelProfesor.add(btnCalcular);
		btnCalcular.addActionListener(acciones);
		btnCalcular.setActionCommand("7");
	}
	//devuelve las cartas que han de ser bloqueadas
	public ArrayList<String> getBloqueadas(int posicion)
	{
		ArrayList<String> bloqueadas= new ArrayList<String>();
		switch (posicion) 
		{
			case 1:
				for(int i=0;i<ipMesa.length;i++)
				{
					if(ipMesa[i]!=null)
						bloqueadas.add(ipMesa[i].getName());
				}
				for(int i=2; i<ipCartas.length;i++)
				{
					if(ipCartas[i]!=null)
						bloqueadas.add(ipCartas[i].getName());
				}
				break;
			case 2:
				for(int i=0;i<ipMesa.length;i++)
				{
					if(ipMesa[i]!=null)
						bloqueadas.add(ipMesa[i].getName());
				}
				for(int i=0; i<1;i++)
				{
					if(ipCartas[i]!=null)
						bloqueadas.add(ipCartas[i].getName());
				}
				break;
			case 3:
				for(int i=0; i<ipCartas.length;i++)
				{
					if(ipCartas[i]!=null)
						bloqueadas.add(ipCartas[i].getName());
				}
				break;
		}
		return bloqueadas;
	}
	//Carga las nuevas cartas recibidas
	public void cargaCartas (ArrayList<String> cartas, int jug) throws IOException
	{
		switch (jug) {
		case 1:
			for(int i=0;i<2;i++)
			{
				if(i==1 && cartas.size()==1)
				{
					ipCartas[i].repintar("back.jpg");
					ipCartas[i].setName("bc");
				}
				else
				{
					ipCartas[i].repintar(cartas.get(i)+".png");
					ipCartas[i].setName(cartas.get(i));
				}
				ipCartas[i].repaint();
			}
			break;
		case 2:
				if(cartas.size()==1)
				{
					ipCartas[3].repintar("back.jpg");
					ipCartas[3].setName("bc");
				}
				else
				{
					ipCartas[2].repintar(cartas.get(0)+".png");
					ipCartas[2].setName(cartas.get(0));
					ipCartas[3].repintar(cartas.get(1)+".png");
					ipCartas[3].setName(cartas.get(1));
				}
				ipCartas[2].repaint();
				ipCartas[3].repaint();
			break;
		case 3:
			
			break;
		}
	}
	/*-------------------------------------- Getters y setters-------------------------------------------------*/
	public JFrame getFrmPokermaster() {
		return frmPokermaster;
	}
	public accionesProfesor getAcciones() {
		return acciones;
	}
}

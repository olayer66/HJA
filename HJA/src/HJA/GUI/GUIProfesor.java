package HJA.GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPanel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;

import HJA.controlador.controlador;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GUIProfesor {

	private controlador control;
	private accionesProfesor acciones;
	private JFrame frmPokermaster;
	private JPanel panelProfesor;
	private JPanel jpRango;
	private ImagePanel[] ipCartas;
	private ImagePanel[] ipMesa;
	private JButton btnCalcular;
	private JButton[] btnSeleccionar;
	private JButton[] btnRandom;
	private JButton btnSiguienteFase;
	private JButton btnMostrarRival;
	private JButton btnLimpiar;
	private JLabel lblDecision;
	private JLabel lblMano ;
	private JRadioButton rbFold;
	private JRadioButton rbCall;
	private JComboBox<String> cbAleatoriasMesa;
	private JComboBox<String> cbRango; 
	private JComboBox<String> cbPosicion;
	private ButtonGroup botones;
	private Color colorGanador= Color.GREEN;
	private Color colorPerdedor= Color.RED;
	private Color colorEmpate= Color.ORANGE;
	
	private int numCartasMesa;
	private String[] nombreCartas={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
	public GUIProfesor(controlador miCont) {
		control= miCont;
		acciones= new accionesProfesor(this);
		botones= new ButtonGroup();
		numCartasMesa=0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokermaster = new JFrame();
		frmPokermaster.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIProfesor.class.getResource("/HJA/GUI/icon.png")));
		frmPokermaster.setTitle("PokerMaster");
		frmPokermaster.setBounds(100, 100, 490, 602);
		frmPokermaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokermaster.getContentPane().setLayout(null);
		
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJugador.setHorizontalAlignment(SwingConstants.LEFT);
		lblJugador.setBounds(35, 11, 94, 27);
		frmPokermaster.getContentPane().add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Rival:");
		lblJugador_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblJugador_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblJugador_1.setBounds(267, 11, 63, 27);
		frmPokermaster.getContentPane().add(lblJugador_1);
		
		
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesa.setBounds(176, 229, 125, 27);
		frmPokermaster.getContentPane().add(lblMesa);
			
		panelProfesor = new JPanel();
		panelProfesor.setBorder(null);
		panelProfesor.setBounds(0, 425, 474, 138);
		frmPokermaster.getContentPane().add(panelProfesor);
		panelProfesor.setLayout(null);
		
		jpRango = new JPanel();
		jpRango.setBounds(10, 425, 162, 62);
		frmPokermaster.getContentPane().add(jpRango);
		
		lblMano = new JLabel("poker");
		lblMano.setHorizontalAlignment(SwingConstants.CENTER);
		lblMano.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMano.setBounds(36, 78, 152, 37);
		panelProfesor.add(lblMano);


		lblDecision = new JLabel("correcto");
		lblDecision.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDecision.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecision.setBounds(271, 75, 127, 42);
		panelProfesor.add(lblDecision);
		
		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setBounds(10, 40, 46, 14);
		panelProfesor.add(lblPosicion);
		
		JLabel lblRango = new JLabel("Rango:");
		lblRango.setBounds(10, 14, 46, 14);
		panelProfesor.add(lblRango);
		
		rbCall = new JRadioButton("Call");
		rbCall.setSelected(true);
		rbCall.setBounds(186, 10, 46, 23);
		panelProfesor.add(rbCall);
		
		rbFold = new JRadioButton("Fold");
		rbFold.setBounds(186, 36, 51, 23);
		panelProfesor.add(rbFold);
		
		cbAleatoriasMesa = new JComboBox<String>();
		cbAleatoriasMesa.setBounds(169, 399, 41, 20);
		frmPokermaster.getContentPane().add(cbAleatoriasMesa);
		cbAleatoriasMesa.addItem("0");
		cbAleatoriasMesa.addItem("3");
		cbAleatoriasMesa.addItem("4");
		cbAleatoriasMesa.addItem("5");
		
		cbRango = new JComboBox<String>();
		cbRango.setBounds(55, 11, 92, 20);
		panelProfesor.add(cbRango);
		cbRango.addItem("Janda");
		cbRango.addItem("MA");
		
		cbPosicion = new JComboBox<String>();
		cbPosicion.setBounds(65, 37, 82, 20);
		panelProfesor.add(cbPosicion);
		cbPosicion.addItem("SB");
		cbPosicion.addItem("BB");
		cbPosicion.addItem("UTG");
		cbPosicion.addItem("UTG+1");
		cbPosicion.addItem("MP");
		cbPosicion.addItem("CO");
		cbPosicion.addItem("BTN");
		
		//ButtonGroup
		botones.add(rbFold);
		botones.add(rbCall);
		
		
		
		//Inicializadores
		creaCartas();
		creaBotones();
		//creaEquitys();
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
			ipCartas[i] = new ImagePanel("bc.png");
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
			ipMesa[i] = new ImagePanel("bc.png");
			ipMesa[i].setName("bc");
			ipMesa[i].setBounds(x, y, witdh, heigth);
			frmPokermaster.getContentPane().add(ipMesa[i]);
			x+=93;
		}
	}
	//Crea los Botones
	private void creaBotones()
	{
		btnRandom= new JButton[3];
		btnSeleccionar=new JButton[3];
		int y=35;
		for(int i=0; i<2;i++)
		{
			btnSeleccionar[i]= new JButton("Seleccionar cartas");
			btnSeleccionar[i].setBounds(y, 174, 176, 23);
			y=267;
			frmPokermaster.getContentPane().add(btnSeleccionar[i]);
			btnSeleccionar[i].addActionListener(acciones);
			btnSeleccionar[i].setActionCommand(Integer.toString(i+1));
		}
		
		btnSeleccionar[2]= new JButton("Seleccionar Mesa");
		btnSeleccionar[2].setBounds(10, 398, 149, 23);
		frmPokermaster.getContentPane().add(btnSeleccionar[2]);
		btnSeleccionar[2].addActionListener(acciones);
		btnSeleccionar[2].setActionCommand("3");
		
		y=68;
		for(int i=0;i<2;i++)
		{
			btnRandom[i] = new JButton("Aleatorias");
			btnRandom[i].setBounds(y, 202, 100, 23);
			y=293;
			frmPokermaster.getContentPane().add(btnRandom[i]);
			btnRandom[i].addActionListener(acciones);
			btnRandom[i].setActionCommand(Integer.toString(i+4));
		}	
		btnRandom[2]= new JButton("Aleatorias");
		btnRandom[2].setBounds(214, 398, 100, 23);
		frmPokermaster.getContentPane().add(btnRandom[2]);
		btnRandom[2].addActionListener(acciones);
		btnRandom[2].setActionCommand("6");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(238, 8, 117, 46);
		btnCalcular.setEnabled(false);
		panelProfesor.add(btnCalcular);
		btnCalcular.addActionListener(acciones);
		btnCalcular.setActionCommand("7");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setEnabled(false);
		btnLimpiar.setBounds(375, 8, 89, 46);
		btnLimpiar.addActionListener(acciones);
		btnLimpiar.setActionCommand("10");
		panelProfesor.add(btnLimpiar);
		
		btnSiguienteFase = new JButton("Siguiente fase");
		btnSiguienteFase.setBounds(316, 398, 148, 23);
		btnSiguienteFase.setEnabled(false);
		btnSiguienteFase.addActionListener(acciones);
		btnSiguienteFase.setActionCommand("8");
		frmPokermaster.getContentPane().add(btnSiguienteFase);
		
		btnMostrarRival = new JButton("");
		btnMostrarRival.setEnabled(false);
		btnMostrarRival.setIcon(new ImageIcon(GUIProfesor.class.getResource("/HJA/GUI/eye.png")));
		btnMostrarRival.addActionListener(acciones);
		btnMostrarRival.setActionCommand("9");
		btnMostrarRival.setBounds(403, 202, 35, 23);
		frmPokermaster.getContentPane().add(btnMostrarRival);
	}
	//Añade una carta al board
	public void nuevaCartaBoard()
	{
		String imagen=nombreCartas[(int)generaCartaAleatoria()];
		ipMesa[numCartasMesa].repintar(imagen+".png");
		ipMesa[numCartasMesa].setName(imagen);
		ipMesa[numCartasMesa].repaint();
		numCartasMesa++;
		if(numCartasMesa==5)
			btnSiguienteFase.setEnabled(false);
	}
	/*--------------------------Metodos de uso-------------------------------------------------*/
	//devuelve las cartas que han de ser bloqueadas
	public ArrayList<String> getBloqueadas(int posicion)
	{
		ArrayList<String> bloqueadas= new ArrayList<String>();
		switch (posicion) 
		{
			case 1:
				for(int i=0;i<ipMesa.length;i++)
				{
					if(ipMesa[i].getName()!="bc")
						bloqueadas.add(ipMesa[i].getName());
				}
				for(int i=2; i<ipCartas.length;i++)
				{
					if(ipCartas[i].getName()!="bc")
						bloqueadas.add(ipCartas[i].getName());
				}
				break;
			case 2:
				for(int i=0;i<ipMesa.length;i++)
				{
					if(ipMesa[i].getName()!="bc")
						bloqueadas.add(ipMesa[i].getName());
				}
				for(int i=0; i<2;i++)
				{
					if(ipCartas[i].getName()!="bc")
						bloqueadas.add(ipCartas[i].getName());
				}
				break;
			case 3:
				for(int i=0; i<ipCartas.length;i++)
				{
					if(ipCartas[i].getName()!="bc")
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
					ipCartas[i].repintar("bc.jpg");
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
					ipCartas[3].repintar("bc.jpg");
					ipCartas[3].setName("bc");
				}
				else
				{
					ipCartas[2].repintar(cartas.get(0)+".png");
					ipCartas[2].setName(cartas.get(0));
					ipCartas[3].repintar(cartas.get(1)+".png");
					ipCartas[3].setName(cartas.get(1));
				}
				btnMostrarRival.setEnabled(true);
			break;
		case 3:
			for(int i=0; i<cartas.size();i++)
			{
				ipMesa[i].repintar(cartas.get(i)+".png");
				ipMesa[i].setName(cartas.get(i));
				ipMesa[i].repaint();
			}
			if(cartas.size()<5)
			{
				for(int i=cartas.size(); i<5;i++)
				{
					ipMesa[i].repintar("bc.jpg");
					ipMesa[i].setName("bc");
					ipMesa[i].repaint();
				}
			}
			numCartasMesa=cartas.size();
			if(numCartasMesa==5)
				btnSiguienteFase.setEnabled(false);
			else
				btnSiguienteFase.setEnabled(true);
			break;
		}
		activaCalcular();
	}
	//Genera cartas aleatorias
	public void cartasAleatorias(int jug)
	{
		ArrayList<String> bloqueadas= getBloqueadas(jug);
		ArrayList<String> cartas=new ArrayList<String>();
		int carta=0;
		switch (jug) {
		case 1:
			for(int i=0 ;i<2;i++)
			{
				do
				{
					
					carta=(int)generaCartaAleatoria();
				}
				while(bloqueadas.contains(nombreCartas[carta]));
				bloqueadas.add(nombreCartas[carta]);
				cartas.add(nombreCartas[carta]);			
			}
			break;
		case 2:
			for(int i=0 ;i<2;i++)
			{
				do
				{
					carta=(int)generaCartaAleatoria();
				}
				while(bloqueadas.contains(nombreCartas[carta]));
				bloqueadas.add(nombreCartas[carta]);
				cartas.add(nombreCartas[carta]);	
			}
			break;	
		case 3:
			if(cbAleatoriasMesa.getSelectedItem().toString()!="0")
			{
				for(int i=0 ;i<Integer.parseInt(cbAleatoriasMesa.getSelectedItem().toString());i++)
				{
					do
					{
						carta=(int)generaCartaAleatoria();
					}
					while(bloqueadas.contains(nombreCartas[carta]));
					bloqueadas.add(nombreCartas[carta]);
					cartas.add(nombreCartas[carta]);			
				}
			}
			break;
		}
		try {
			cargaCartas(cartas, jug);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	//Devuelve si todos los parametros estan correctos para calcular
	public boolean calcularActivo()
	{
		boolean correcto=true;
		for(int i=0; i< ipCartas.length;i++)
		{
			if(ipCartas[i].getName()=="bc")
			{
				correcto=false;
			}
		}
		return correcto;
	}
	//Introduce los valores obtenidos del calculo
	public void introduceResultado(String[] ganador)
	{
		switch (ganador[0]) 
		{
		case "1":
			if(rbCall.isSelected())
			{
				lblDecision.setText("Correcto");
				lblDecision.setForeground(colorGanador);
				lblMano.setText(ganador[1]);
			}
			else
			{
				lblDecision.setText("Error");
				lblDecision.setForeground(colorPerdedor);
				lblMano.setText("");
			}
			break;
		case "2":
			if(rbFold.isSelected())
			{
				lblDecision.setText("Correcto");
				lblDecision.setForeground(colorGanador);
				lblMano.setText("");
				
			}
			else
			{
				lblDecision.setText("Error");
				lblDecision.setForeground(colorPerdedor);
				lblMano.setText("");
			}
			break;
			
		default:
			lblDecision.setText("Empate");
			lblDecision.setForeground(colorEmpate);
			break;
		}
		btnLimpiar.setEnabled(true);
	}
	//Devuleve si se permite calcular
	private void activaCalcular()
	{
		if(ipCartas[0].getName()!="bc")
			btnCalcular.setEnabled(true);
		else
			btnCalcular.setEnabled(false);
	}
	//Muestra las cartas del rival
	public void muestraRival()
	{
		ipCartas[2].repaint();
		ipCartas[3].repaint();
		btnMostrarRival.setEnabled(false);
		btnRandom[1].setEnabled(false);
	}
	//Limpia la ventana
	public void LimpiarVentana() 
	{
		try {
			cargaCartas(CreaArrayBack(2), 1);
			cargaCartas(CreaArrayBack(2), 2);
			cargaCartas(CreaArrayBack(5), 3);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		muestraRival();
		btnCalcular.setEnabled(false);
		btnMostrarRival.setEnabled(false);
		btnRandom[1].setEnabled(true);
		btnSiguienteFase.setEnabled(false);
		btnLimpiar.setEnabled(false);
	}
	//Crea arrayList de cartas
	private ArrayList<String> CreaArrayBack(int num)
	{
		ArrayList<String> cartas= new ArrayList<>();
		for(int i=0;i<num ;i++)
		{
			cartas.add("bc");
		}
		return cartas;
	}
	//redondea los float
	public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
	//Genera una carta aleatoria
	private double generaCartaAleatoria()
	{
		Random rnd = new Random();
		double num=rnd.nextDouble() * 51 + 0;
		return  num;
	}
	/*-------------------------------------- Getters y setters-------------------------------------------------*/
	public JFrame getFrmPokermaster() {
		return frmPokermaster;
	}
	public accionesProfesor getAcciones() {
		return acciones;
	}

	public controlador getControl() {
		return control;
	}
	public ArrayList <String> getJugadores()
	{
		ArrayList<String> cartas= new ArrayList<String>();
		for(int i=0; i< ipCartas.length;i++)
		{
			cartas.add(ipCartas[i].getName());
		}
		return cartas;
	}
	public ArrayList <String> getMesa()
	{
		ArrayList<String> cartas= new ArrayList<String>();
		for(int i=0; i< ipMesa.length;i++)
		{
			if(ipMesa[i].getName()!="bc")
				cartas.add(ipMesa[i].getName());
		}
		return cartas;
	}
}

package HJA.GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.ArrayUtils;

import java.awt.Font;

import javax.swing.JPanel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JComboBox;

import HJA.controlador.controlador;
import HJA.modelo.procesarJugada;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GUIProfesor {

	private controlador control;
	private accionesProfesor acciones;
	private JFrame frmPokermaster;
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
	private int contFase;
	private String[] nombreCartas={"Ah","Ad","Ac","As","Kh","Kd","Kc","Ks","Qh","Qd","Qc","Qs","Jh","Jd","Jc","Js","Th","Td","Tc","Ts","9h","9d","9c","9s","8h","8d","8c","8s","7h","7d","7c","7s","6h","6d","6c","6s","5h","5d","5c","5s","4h","4d","4c","4s","3h","3d","3c","3s","2h","2d","2c","2s"};
	private JPanel jpControl;
	private JPanel jpResultado;
	public GUIProfesor(controlador miCont) {
		control= miCont;
		acciones= new accionesProfesor(this);
		botones= new ButtonGroup();
		numCartasMesa=0;
		contFase=0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokermaster = new JFrame();
		frmPokermaster.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIProfesor.class.getResource("/HJA/GUI/icon.png")));
		frmPokermaster.setTitle("PokerMaster");
		frmPokermaster.setBounds(100, 100, 490, 582);
		frmPokermaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokermaster.setResizable(false);
		frmPokermaster.getContentPane().setLayout(null);
		
		jpRango = new JPanel();
		jpRango.setBounds(10, 425, 153, 62);
		jpRango.setVisible(true);
		frmPokermaster.getContentPane().add(jpRango);
		jpRango.setLayout(null);
		
		jpResultado = new JPanel();
		jpResultado.setBounds(10, 486, 454, 56);
		frmPokermaster.getContentPane().add(jpResultado);
		jpResultado.setLayout(null);
		
		jpControl = new JPanel();
		jpControl.setBounds(163, 425, 301, 62);
		frmPokermaster.getContentPane().add(jpControl);
		jpControl.setLayout(null);
		
		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setBounds(10, 40, 68, 14);
		jpRango.add(lblPosicion);
		
		JLabel lblRango = new JLabel("Rango:");
		lblRango.setBounds(10, 14, 46, 14);
		jpRango.add(lblRango);
		
		cbPosicion = new JComboBox<String>();
		cbPosicion.setBounds(78, 36, 63, 20);
		jpRango.add(cbPosicion);
		
		cbRango = new JComboBox<String>();
		cbRango.setBounds(58, 5, 83, 20);
		jpRango.add(cbRango);
		cbRango.addItem("MA");
		cbRango.addItem("Janda");	
		cbPosicion.addItem("SB");
		cbPosicion.addItem("BB");
		cbPosicion.addItem("UTG");
		cbPosicion.addItem("UTG+1");
		cbPosicion.addItem("MP");
		cbPosicion.addItem("CO");
		cbPosicion.addItem("BTN");
		
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
		
		cbAleatoriasMesa = new JComboBox<String>();
		cbAleatoriasMesa.setBounds(169, 399, 41, 20);
		frmPokermaster.getContentPane().add(cbAleatoriasMesa);
		cbAleatoriasMesa.addItem("3");
		cbAleatoriasMesa.addItem("4");
		cbAleatoriasMesa.addItem("5");
		
		rbFold = new JRadioButton("Fold");
		rbFold.setBounds(6, 32, 78, 23);
		jpControl.add(rbFold);
		
		rbCall = new JRadioButton("OR");
		rbCall.setBounds(6, 5, 78, 23);
		jpControl.add(rbCall);
		rbCall.setSelected(true);
		
		//ButtonGroup
		botones.add(rbFold);
		botones.add(rbCall);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(0, 0, 90, 14);
		jpResultado.add(lblResultado);
		
		lblDecision = new JLabel("");
		lblDecision.setBounds(56, 6, 127, 42);
		jpResultado.add(lblDecision);
		lblDecision.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDecision.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblMano = new JLabel("");
		lblMano.setBounds(262, 11, 152, 37);
		jpResultado.add(lblMano);
		lblMano.setHorizontalAlignment(SwingConstants.CENTER);
		lblMano.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
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
		btnSeleccionar[1].setEnabled(false);
		btnSeleccionar[2]= new JButton("Seleccionar cartas");
		btnSeleccionar[2].setBounds(10, 398, 149, 23);
		frmPokermaster.getContentPane().add(btnSeleccionar[2]);
		btnSeleccionar[2].addActionListener(acciones);
		btnSeleccionar[2].setActionCommand("3");
		btnSeleccionar[2].setEnabled(false);
		
		y=73;
		for(int i=0;i<2;i++)
		{
			btnRandom[i] = new JButton("Aleatorias");
			btnRandom[i].setBounds(y, 202, 100, 23);
			y=300;
			frmPokermaster.getContentPane().add(btnRandom[i]);
			btnRandom[i].addActionListener(acciones);
			btnRandom[i].setActionCommand(Integer.toString(i+4));
		}
		
		btnRandom[1].setEnabled(false);
		btnRandom[2]= new JButton("Aleatorias");
		btnRandom[2].setBounds(214, 398, 100, 23);
		frmPokermaster.getContentPane().add(btnRandom[2]);
		btnRandom[2].addActionListener(acciones);
		btnRandom[2].setActionCommand("6");
		btnRandom[2].setEnabled(false);
		
		btnSiguienteFase = new JButton("Añadir carta");
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
		btnMostrarRival.setBounds(408, 202, 35, 23);
		frmPokermaster.getContentPane().add(btnMostrarRival);
			
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(90, 5, 99, 46);
		jpControl.add(btnCalcular);
		btnCalcular.setEnabled(false);
		btnCalcular.addActionListener(acciones);
		btnCalcular.setActionCommand("7");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(199, 5, 92, 46);
		jpControl.add(btnLimpiar);
		btnLimpiar.setEnabled(false);
		btnLimpiar.addActionListener(acciones);
		btnLimpiar.setActionCommand("10");
	}

	/*--------------------------Metodos de uso-------------------------------------------------*/
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
		btnCalcular.setEnabled(true);
	}
	//Carga las nuevas cartas recibidas
	public void cargaCartas (ArrayList<String> cartas, int jug, boolean selecionar) throws IOException
	{
		ArrayList<String> lasCartas= new ArrayList<>(Arrays.asList(nombreCartas));
		switch (jug) {
		case 1:
			if(lasCartas.indexOf(cartas.get(0))>lasCartas.indexOf(cartas.get(1)))
			{
				ipCartas[0].repintar(cartas.get(1)+".png");
				ipCartas[0].setName(cartas.get(1));
				ipCartas[0].repaint();
				ipCartas[1].repintar(cartas.get(0)+".png");
				ipCartas[1].setName(cartas.get(0));
				ipCartas[1].repaint();
			}
			else
			{
				ipCartas[0].repintar(cartas.get(0)+".png");
				ipCartas[0].setName(cartas.get(0));
				ipCartas[0].repaint();
				ipCartas[1].repintar(cartas.get(1)+".png");
				ipCartas[1].setName(cartas.get(1));
				ipCartas[1].repaint();
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
					ipCartas[2].setName(cartas.get(0));
					ipCartas[3].setName(cartas.get(1));
				if(selecionar==true)
				{
					ipCartas[2].repintar(cartas.get(0)+".png");
					ipCartas[3].repintar(cartas.get(1)+".png");
					ipCartas[2].repaint();
					ipCartas[3].repaint();
					muestraRival();
					btnSeleccionar[1].setEnabled(true);
					btnRandom[1].setEnabled(true);
				}
				else
				{
					ipCartas[2].repintar("bc.png");
					ipCartas[3].repintar("bc.png");
					ipCartas[2].repaint();
					ipCartas[3].repaint();
					btnMostrarRival.setEnabled(true);
					btnSeleccionar[1].setEnabled(false);
					btnRandom[1].setEnabled(false);
				}
				}
				
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
					ipMesa[i].repintar("bc.png");
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
				btnCalcular.setEnabled(true);
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
				btnCalcular.setEnabled(true);
			}
			break;
		}
		try {
			cargaCartas(cartas, jug, false);
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
	//Ejecuta la opcion de calculo elegida
	public void calcular()
	{
		String[] datos= new String[4];
		StringBuilder mano= new StringBuilder();
		switch (faseDeJuego()) 
		{
			case 1://Preflop
				datos[0]= Integer.toString(cbRango.getSelectedIndex());
				datos[1]=mano.append(ipCartas[0].getName()).append(ipCartas[1].getName()).toString();
				datos[2]= Integer.toString(cbPosicion.getSelectedIndex());
				if(rbCall.isSelected())
					datos[3]="0";
				else
					datos[3]="1";
				if(control.evaluarJugada(datos))
				{
					lblDecision.setText("Correcto");
					lblDecision.setForeground(colorGanador);
					btnCalcular.setText("Continuar");
					btnRandom[0].setEnabled(false);
					btnSeleccionar[0].setEnabled(false);
					btnRandom[2].setEnabled(true);
					btnSeleccionar[2].setEnabled(true);
					btnCalcular.setEnabled(false);
					rbCall.setText("Call");
				}
				else
				{
					lblDecision.setText("Error");
					lblDecision.setForeground(colorPerdedor);
					btnCalcular.setEnabled(false);
					btnLimpiar.setEnabled(true);
				}
				jpRango.setEnabled(false);
				contFase++;
				break;
			case 2://flop
				if(rbCall.isSelected())
				{
					lblDecision.setText("");
					mano= new StringBuilder();
					mano.append(ipCartas[0].getName()).append(ipCartas[1].getName()).append(String.join("",getMesa() ));
					lblMano.setText(control.valorMano(mano.toString()));
					btnCalcular.setEnabled(false);
					contFase++;
				}
				else
				{
					btnCalcular.setEnabled(false);
					generaRestoJugada(2);
				}
				break;
			case 3://turn
				if(rbCall.isSelected())
				{
					lblDecision.setText("");
					mano= new StringBuilder();
					mano.append(ipCartas[0].getName()).append(ipCartas[1].getName()).append(String.join("",getMesa() ));
					lblMano.setText(control.valorMano(mano.toString()));
					contFase++;
					btnRandom[1].setEnabled(true);
					btnSeleccionar[1].setEnabled(true);
					btnCalcular.setEnabled(false);
				}
				else	
					generaRestoJugada(1);
				break;
			case 4://river	
					generaRestoJugada(0);
				break;
			default:
				JOptionPane.showMessageDialog(getFrmPokermaster(), "Faltan datos");
				break;
		}
	}
	//seleciona la fase de juego
	private int faseDeJuego()
	{	
		if(ipCartas[0].getName()!="bc" && ipCartas[2].getName()!="bc" && ipMesa[4].getName()!="bc" && contFase==3)
			return 4;//river
		else if(ipCartas[0].getName()!="bc" && ipMesa[3].getName()!="bc" && contFase==2)
			return 3;//turn
		else if(ipCartas[0].getName()!="bc" && ipMesa[2].getName()!="bc" && contFase==1)
			return 2;//flop
		else if(ipCartas[0].getName()!="bc" &&ipCartas[2].getName()=="bc" && contFase==0)
			return 1;//Preflop
		else
			return 0;
	}
	//Genera el resto de la jugada en caso de hacer fold
	private void generaRestoJugada(int numCartas)
	{
		for(int i=0;i<numCartas;i++)
		{
			nuevaCartaBoard();
		}
		ArrayList<String> mesa= getMesa();
		if(ipCartas[2].getName()=="bc")
			cartasAleatorias(2);
		btnCalcular.setEnabled(false);
		introduceResultado(control.caculoProfesor(getJugadores(),mesa));
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
		ipCartas[2].repintar(ipCartas[2].getName()+".png");
		ipCartas[3].repintar(ipCartas[3].getName()+".png");
		ipCartas[2].repaint();
		ipCartas[3].repaint();
		btnMostrarRival.setEnabled(false);
		btnRandom[1].setEnabled(false);
	}
	//Limpia la ventana
	public void LimpiarVentana() 
	{
		try {
			cargaCartas(CreaArrayBack(2), 1, false);
			cargaCartas(CreaArrayBack(2), 2, false);
			cargaCartas(CreaArrayBack(5), 3, false);
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		muestraRival();
		btnCalcular.setEnabled(false);
		btnMostrarRival.setEnabled(false);
		btnRandom[0].setEnabled(true);
		btnSeleccionar[0].setEnabled(true);
		btnRandom[1].setEnabled(false);
		btnSeleccionar[1].setEnabled(false);
		btnSiguienteFase.setEnabled(false);
		btnLimpiar.setEnabled(false);
		jpRango.setEnabled(true);
		btnCalcular.setText("Calcular");
		lblDecision.setText("");
		lblMano.setText("");
		rbCall.setText("OR");
		contFase=0;
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
	/*------------------------ Metodos de cambios en GUI segun la fase de juego--------------------------------*/
	//Prelop
	
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

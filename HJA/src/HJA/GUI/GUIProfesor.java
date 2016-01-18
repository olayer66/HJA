package HJA.GUI;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;

import HJA.controlador.controlador;

import java.awt.Toolkit;
import java.awt.Color;

public class GUIProfesor {

	private controlador control;
	private accionesProfesor acciones;
	private JFrame frmPokermaster;
	private JPanel panelProfesor;
	private JButton btnCalcular;
	private JButton[] btnSeleccionar;
	private ImagePanel[] ipCartas;
	private ImagePanel[] ipMesa;
	private JButton[] btnRandom;
	private JTextField[] equitys;
	private JLabel lblDecision;
	private JLabel lblResultadoEquity;
	private JRadioButton rbFold;
	private JRadioButton rbCall;
	private JTextField tfEquity;
	private JComboBox<String> cbAleatoriasMesa;
	private ButtonGroup botones;
	private Color colorGanador= Color.GREEN;
	private Color colorPerdedor= Color.RED;
	private Color colorEmpate= Color.YELLOW;
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
		panelProfesor.setBounds(10, 425, 454, 59);
		frmPokermaster.getContentPane().add(panelProfesor);
		panelProfesor.setLayout(null);
		
		rbCall = new JRadioButton("Call");
		rbCall.setSelected(true);
		rbCall.setBounds(6, 6, 46, 23);
		panelProfesor.add(rbCall);
		
		rbFold = new JRadioButton("Fold");
		rbFold.setBounds(6, 32, 71, 23);
		panelProfesor.add(rbFold);
		
		JLabel lblEquity = new JLabel("Equity: ");
		lblEquity.setBounds(79, 10, 46, 15);
		panelProfesor.add(lblEquity);
		
		tfEquity = new JTextField();
		tfEquity.setForeground(Color.BLACK);
		tfEquity.setBounds(118, 7, 63, 20);
		panelProfesor.add(tfEquity);
		tfEquity.setColumns(10);
		tfEquity.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE) || (c==','))) 
		        {
		          e.consume();
		        }
		      }
		    });				
		cbAleatoriasMesa = new JComboBox<String>();
		cbAleatoriasMesa.setBounds(238, 399, 41, 20);
		frmPokermaster.getContentPane().add(cbAleatoriasMesa);
		cbAleatoriasMesa.addItem("0");
		cbAleatoriasMesa.addItem("3");
		cbAleatoriasMesa.addItem("4");
		cbAleatoriasMesa.addItem("5");
		
		//ButtonGroup
		botones.add(rbFold);
		botones.add(rbCall);
		//Inicializadores
		creaCartas();
		creaBotones();
		creaEquitys();
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
		btnSeleccionar[2].setBounds(79, 398, 149, 23);
		frmPokermaster.getContentPane().add(btnSeleccionar[2]);
		btnSeleccionar[2].addActionListener(acciones);
		btnSeleccionar[2].setActionCommand("3");
		
		y=68;
		for(int i=0;i<2;i++)
		{
			btnRandom[i] = new JButton("Aleatorias");
			btnRandom[i].setBounds(y, 202, 100, 23);
			y=303;
			frmPokermaster.getContentPane().add(btnRandom[i]);
			btnRandom[i].addActionListener(acciones);
			btnRandom[i].setActionCommand(Integer.toString(i+4));
		}	
		btnRandom[2]= new JButton("Aleatorias");
		btnRandom[2].setBounds(283, 398, 100, 23);
		frmPokermaster.getContentPane().add(btnRandom[2]);
		btnRandom[2].addActionListener(acciones);
		btnRandom[2].setActionCommand("6");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(191, 6, 92, 42);
		panelProfesor.add(btnCalcular);
		btnCalcular.addActionListener(acciones);
		btnCalcular.setActionCommand("7");
		
		lblDecision = new JLabel("Correcto");
		lblDecision.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDecision.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecision.setBounds(293, 10, 151, 38);
		panelProfesor.add(lblDecision);
		
		lblResultadoEquity = new JLabel("Acertaste");
		lblResultadoEquity.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoEquity.setBounds(83, 32, 98, 16);
		panelProfesor.add(lblResultadoEquity);
	}
	//Crea los campos de texto
	private void creaEquitys()
	{
		equitys= new JTextField[2];
		int y=125;
		for(int i=0; i<equitys.length;i++)
		{
			equitys[i] = new JTextField();
			equitys[i].setFont(new Font("Tahoma", Font.PLAIN, 22));
			equitys[i].setHorizontalAlignment(SwingConstants.RIGHT);
			equitys[i].setEnabled(true);
			equitys[i].setEditable(false);
			equitys[i].setForeground(Color.BLACK);
			equitys[i].setBounds(y, 11, 60, 27);
			y=329;
			frmPokermaster.getContentPane().add(equitys[i]);
			equitys[i].setColumns(10);
			equitys[i].setText("0%");
		}
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
					ipMesa[i].repintar("back.jpg");
					ipMesa[i].setName("bc");
					ipMesa[i].repaint();
				}
			}
			break;
		}
	}
	//Genera cartas aleatorias
	public void cartasAleatorias(int jug)
	{
		ArrayList<String> bloqueadas= getBloqueadas(jug);
		ArrayList<String> cartas=new ArrayList<String>();
		String[] aux={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
		Random rnd = new Random();
		double num=0;
		int carta=0;
		switch (jug) {
		case 1:
			for(int i=0 ;i<2;i++)
			{
				do
				{
					num=rnd.nextDouble() * 51 + 0;
					carta=(int)num;
				}
				while(bloqueadas.contains(aux[carta]));
				bloqueadas.add(aux[carta]);
				cartas.add(aux[carta]);			
			}
			break;
		case 2:
			for(int i=0 ;i<2;i++)
			{
				do
				{
					num=rnd.nextDouble() * 51 + 0;
					carta=(int)num;
				}
				while(bloqueadas.contains(aux[carta]));
				bloqueadas.add(aux[carta]);
				cartas.add(aux[carta]);			
			}
			break;	
		case 3:
			if(cbAleatoriasMesa.getSelectedItem().toString()!="0")
			{
				for(int i=0 ;i<Integer.parseInt(cbAleatoriasMesa.getSelectedItem().toString());i++)
				{
					do
					{
						num=rnd.nextDouble() * 51 + 0;
						carta=(int)num;
					}
					while(bloqueadas.contains(aux[carta]));
					bloqueadas.add(aux[carta]);
					cartas.add(aux[carta]);			
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
		if(tfEquity.getText().toString()=="")
		{
			correcto=false;
		}
		else
		{
			for(int i=0; i< ipCartas.length;i++)
			{
				if(ipCartas[i].getName()=="bc")
				{
					correcto=false;
				}
			}
		}
		return correcto;
	}
	//Introduce los valores obtenidos del calculo
	public void introduceResultado(ArrayList<String> equity)
	{
		float jug1= round(Float.parseFloat(equity.get(0)), 2);
		float jug2= round(Float.parseFloat(equity.get(1)), 2);
		float decision= Float.parseFloat( tfEquity.getText());
		equitys[0].setText(Float.toString(jug1));
		equitys[1].setText(Float.toString(jug2));
		if(jug1>jug2)
		{
			equitys[0].setBackground(colorGanador);
			equitys[1].setBackground(colorPerdedor);
			if(rbCall.isSelected())
			{
				lblDecision.setText("Correcto");
				lblDecision.setForeground(colorGanador);
				
			}
			else
			{
				lblDecision.setText("Error");
				lblDecision.setForeground(colorPerdedor);
			}
		}
		else if(jug1<jug2)
		{
			equitys[1].setBackground(colorGanador);
			equitys[0].setBackground(colorPerdedor);
			if(rbFold.isSelected())
			{
				lblDecision.setText("Correcto");
				lblDecision.setForeground(colorGanador);
				
			}
			else
			{
				lblDecision.setText("Error");
				lblDecision.setForeground(colorPerdedor);
			}
		}
		else
		{
			equitys[0].setBackground(colorEmpate);
			equitys[1].setBackground(colorEmpate);
			lblDecision.setText("Empate");
			lblDecision.setForeground(colorEmpate);
		}
		if(jug1>decision)
		{
			lblResultadoEquity.setText("Te pasaste");
			lblDecision.setForeground(colorPerdedor);
		}
		else if(jug1<decision)
		{
			lblResultadoEquity.setText("Te quedaste corto");
			lblDecision.setForeground(colorPerdedor);
		}
		else
		{
			lblResultadoEquity.setText("Acertaste");
			lblDecision.setForeground(colorGanador);
		}
	}
	//redondea los float
	public float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
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
			cartas.add(ipMesa[i].getName());
		}
		return cartas;
	}
}

package HJA.GUI;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Color;

public class GUISeleccionCartas {

	private JFrame frmSeleccionarCartas;
	private ActionListener accion;
	private ArrayList<String> cartasBloqueadas;
	private ArrayList<String> cartasSeleccionadas;
	private int numCartas=0;
	private Color colorSelec= Color.GREEN;
	private Color colorBloq= Color.YELLOW;
	private ImagePanel[] cuadroImagenes;
	private String[] cartas={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
	private detectaClickCarta detector;
	private int cMax;
	
	public GUISeleccionCartas(ActionListener acc,int cartas, String sC,ArrayList<String> bloq,ArrayList<String> cartasSel) throws IOException
	{
		accion=acc;
		cMax=cartas;
		//cartas que no se pueden tocar
		cartasBloqueadas=bloq;
		cartasSeleccionadas= new ArrayList<String>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmSeleccionarCartas = new JFrame();
		frmSeleccionarCartas.setTitle("Seleccionar  cartas");
		frmSeleccionarCartas.setIconImage(Toolkit.getDefaultToolkit().getImage(GUISeleccionCartas.class.getResource("/HJA/GUI/icon.png")));
		frmSeleccionarCartas.setBounds(100, 100, 1113, 586);
		frmSeleccionarCartas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSeleccionarCartas.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(998, 514, 89, 23);
		btnCancelar.addActionListener(accion);
		btnCancelar.setActionCommand("21");
		frmSeleccionarCartas.getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(899, 514, 89, 23);
		btnAceptar.addActionListener(accion);
		btnAceptar.setActionCommand("20");
		frmSeleccionarCartas.getContentPane().add(btnAceptar);
		detector=new detectaClickCarta(this);
		//inicialiazdores
		crearCartas();
		escogerCarta();
	}
	private void crearCartas() throws IOException
	{
		int c=0;
		int x=10;
		int y=11;
		int width=83;
		int height=120;
		cuadroImagenes=new ImagePanel[52];
		//palo
		for(int i=1;i<=4;i++)
		{
			//carta
			for(int z=0;z<13;z++)
			{
				cuadroImagenes[c]= new ImagePanel(cartas[c]+".png");	
				cuadroImagenes[c].setName(cartas[c]);
				cuadroImagenes[c].setBounds(y, x, width, height);
				y+=width;
				cuadroImagenes[c].setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				cuadroImagenes[c].addMouseListener(detector);
				frmSeleccionarCartas.getContentPane().add(cuadroImagenes[c]);
				cuadroImagenes[c].repaint();
				c++;
			}
			x+=height;
			y=11;
		}
	}
	//Selecciona las cartas pasadas dese la GUIProfesor
	private void escogerCarta()
	{	
		for(int i = 0; i< cartasBloqueadas.size(); i++)
		{	
			for(int x=0 ;x< cuadroImagenes.length;x++)
			{
				if(cuadroImagenes[x].getName()==cartasBloqueadas.get(i))
				{
					cuadroImagenes[x].repintar("bc.png");
					cuadroImagenes[x].repaint();
				}
			}
		}
	}
	//Seleccion de cartas
	public void seleccionarCarta(ImagePanel carta)
	{

		if(!cartasSeleccionadas.contains(carta.getName()) && numCartas<cMax && !cartasBloqueadas.contains(carta.getName()))
		{
			cartasSeleccionadas.add(carta.getName());
			carta.setBorder(new BevelBorder(BevelBorder.LOWERED, colorSelec, colorSelec, colorSelec, colorSelec));
			numCartas++;
		}
		else if(numCartas>0 && cartasSeleccionadas.contains(carta.getName()))
		{
			carta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			cartasSeleccionadas.remove(carta.getName());
			numCartas--;
		}
	}
	//devuleve las cartas selecionadas
	public String leerMano ()
	{
		StringBuilder miString= new StringBuilder();
		for(String carta:cartasSeleccionadas)
		{
			miString.append(carta);
		}
		return miString.toString();
	}
	public JFrame getFrmSeleccionarCartas() {
		return frmSeleccionarCartas;
	}

	public ArrayList<String> getCartasSeleccionadas() {
		return cartasSeleccionadas;
	}
	//control de la mesa
	public boolean esMesaValida(int jug)
	{
		if(jug==3)
		{
			if(cartasSeleccionadas.size()==1 ||cartasSeleccionadas.size()==2)
			{
				return false;
			}
			else
				return true;
		}
		else
		{
			if(cartasSeleccionadas.size()!=2)
			{
				return false;
			}
			else
				return true;
		}
	}
}

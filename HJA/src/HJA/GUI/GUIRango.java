package HJA.GUI;

import java.awt.EventQueue;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import HJA.constante;
import HJA.constante.datosMano;
import HJA.controlador.controlador;

public class GUIRango {

	private JFrame frame;
	private controlador control;
	
	//Objetos
	private JTable JtRango;
	private String[] rango;
	private GUIPlayers vtnPlayers;
	private int jugador;
	//Constructor
	public GUIRango(GUIPlayers miGUI, controlador miCont,String[] rng,int player)
	{
		control=miCont;
		rango=rng;
		vtnPlayers=miGUI;
		jugador=player;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//inicializadores de los objetos
				creaTablaRangos();
				
				JtRango.setBounds(10, 11, 250, 208);
				frame.getContentPane().add(JtRango);
	}

	//Crea la tabala de rangos.
		private void creaTablaRangos()
		{
			Object[][] data;
			data= new JLabel[13][13];
			java.util.Iterator<Entry<String, datosMano>> it = constante.getInstance().getManos().entrySet().iterator();
			for(int i=0;i<13;i++)
			{
				for (int x=0;x<13;x++)
				{
					data[i][x]=new JLabel(it.next().getKey());
				}
			}
			JtRango= new JTable(data, null);
		}
	
	//Getters y setters
	public JFrame getFrame() {
		return frame;
	}

}

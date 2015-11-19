package HJA.GUI;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import HJA.constante;
import HJA.constante.datosMano;
import HJA.controlador.controlador;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import javax.swing.SwingConstants;

public class GUIRango {

	private JFrame frmSeleccionDeRango;
	private controlador control;
	
	//Objetos
	private String[] rango;
	private GUIPlayers vtnPlayers;
	private int jugador;
	private JLabel[][] TablaRangos;
	private JTextField tfRango;
	private MouseListener miMouse;
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
		frmSeleccionDeRango = new JFrame();
		frmSeleccionDeRango.setTitle("Seleccion de rango");
		frmSeleccionDeRango.setBounds(100, 100, 424, 448);
		frmSeleccionDeRango.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSeleccionDeRango.getContentPane().setLayout(null);
		
		//inicializadores de los objetos
				creaTablaRangos();			
				
				JLabel lblRangoSeleccionado = new JLabel("Rango seleccionado:");
				lblRangoSeleccionado.setBounds(10, 289, 127, 14);
				frmSeleccionDeRango.getContentPane().add(lblRangoSeleccionado);
				
				tfRango = new JTextField();
				tfRango.setBackground(new Color(255, 255, 255));
				tfRango.setEnabled(false);
				tfRango.setEditable(false);
				tfRango.setBounds(133, 286, 265, 20);
				frmSeleccionDeRango.getContentPane().add(tfRango);
				tfRango.setColumns(10);
				
	}

	//Crea la tabala de rangos.
		private void creaTablaRangos()
		{
			miMouse= new detectaClick();
			TablaRangos=new JLabel[13][13];
			int x=10;
			int y=11;
			int heigth=20;
			int width=30;
			Border border = LineBorder.createBlackLineBorder();
			Iterator<String> it = constante.getInstance().getManos().keySet().iterator();
			for(int z=0;z<13;z++)
			{
				for(int i=0;i<13;i++)
				{
					if(it.hasNext())
					{
						String e=it.next();
						TablaRangos[z][i]=new JLabel(e);
						TablaRangos[z][i].setBounds(y, x, width, heigth);
						y+=width;
						TablaRangos[z][i].setHorizontalAlignment(SwingConstants.CENTER);
						TablaRangos[z][i].setOpaque(true);
						TablaRangos[z][i].setBackground(new Color(238, 232, 170));
						TablaRangos[z][i].setBorder(border);
						TablaRangos[z][i].addMouseListener(miMouse);
						frmSeleccionDeRango.getContentPane().add(TablaRangos[z][i]);
					}
					
				}
				x+=heigth;
				y=11;
			}
					
		}
	
	//Getters y setters
	public JFrame getFrame() 
	{
		return frmSeleccionDeRango;
	}
}

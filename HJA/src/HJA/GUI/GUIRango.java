package HJA.GUI;

import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JSlider;
import javax.swing.JButton;

public class GUIRango {

	private JFrame frmSeleccionDeRango;
	private controlador control;
	
	//Objetos
	private ArrayList<String> rangoSelec;
	private GUIPlayers vtnPlayers;
	private int jugador;
	private JLabel[][] TablaRangos;
	private JTextField tfRango;
	private MouseListener miMouse;
	private Color colorSelec;
	private Color colorNoSelec;
	//Constructor
	public GUIRango(GUIPlayers miGUI, controlador miCont,String[] rng,int player)
	{
		control=miCont;
		if(rng!=null)
			rangoSelec= new ArrayList<String>(Arrays.asList(rng));
		else
			rangoSelec= new ArrayList<String>();
		vtnPlayers=miGUI;
		jugador=player;
		colorSelec=Color.MAGENTA;
		colorNoSelec=new Color(238, 232, 170);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionDeRango = new JFrame();
		frmSeleccionDeRango.setTitle("Seleccion de rango");
		frmSeleccionDeRango.setBounds(100, 100, 424, 421);
		frmSeleccionDeRango.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSeleccionDeRango.getContentPane().setLayout(null);
		
		//inicializadores de los objetos
				creaTablaRangos();			
				
				JLabel lblRangoSeleccionado = new JLabel("Rango selec:");
				lblRangoSeleccionado.setBounds(10, 320, 127, 14);
				frmSeleccionDeRango.getContentPane().add(lblRangoSeleccionado);
				
				tfRango = new JTextField();
				tfRango.setBackground(new Color(255, 255, 255));
				tfRango.setEditable(false);
				tfRango.setBounds(86, 317, 312, 20);
				frmSeleccionDeRango.getContentPane().add(tfRango);
				tfRango.setColumns(10);
				
				JSlider SlRango = new JSlider();
				SlRango.setPaintTicks(true);
				SlRango.setBounds(10, 286, 388, 26);
				SlRango.addChangeListener(null);
				frmSeleccionDeRango.getContentPane().add(SlRango);
				
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(309, 348, 89, 26);
				frmSeleccionDeRango.getContentPane().add(btnAceptar);
				
	}

	//Crea la tabala de rangos.
		private void creaTablaRangos()
		{
			miMouse= new detectaClick(this);
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
						TablaRangos[z][i].setBackground(colorNoSelec);
						TablaRangos[z][i].setBorder(border);
						TablaRangos[z][i].addMouseListener(miMouse);
						frmSeleccionDeRango.getContentPane().add(TablaRangos[z][i]);
					}
					
				}
				x+=heigth;
				y=11;
			}
					
		}
		//Cambia el color de una celda ademas de las acciones asociadas
		public void cambiarColor(JLabel pareja)
		{
			if(pareja.getBackground().equals(colorNoSelec))
			{
				pareja.setBackground(colorSelec);
				rangoSelec.add(pareja.getText());
			}
			else
			{
				pareja.setBackground(colorNoSelec);
				rangoSelec.remove(rangoSelec.indexOf(pareja.getText()));
			}
			actualizaSeleccionadas();
		}
		//Actualiza el texto de las cartas seleccionadas
		private void actualizaSeleccionadas()
		{
			StringBuilder mostrar = new StringBuilder();
			for(String pareja: rangoSelec)
			{
				mostrar.append(pareja);
				mostrar.append(",");
			}
			tfRango.setText(mostrar.toString());
		}
	//Getters y setters
	public JFrame getFrame() 
	{
		return frmSeleccionDeRango;
	}
}

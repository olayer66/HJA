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
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class GUIRango {

	private JFrame frmSeleccionDeRango;
	private controlador control;
	
	//Objetos
	private ArrayList<String> rangoSelec;
	private GUIPlayers vtnPlayers;
	private int jugador;
	private int rango;
	private boolean slide=true;
	private JLabel[][] TablaRangos;
	private JTextField tfRango;
	private JSlider SlRango;
	private MouseListener miMouse;
	private Color colorSelec;
	private Color colorNoSelec;
	private JButton btnCancelar;
	private JTextField tfPorcentaje;
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
		frmSeleccionDeRango.setIconImage(Toolkit.getDefaultToolkit().getImage(GUIRango.class.getResource("/HJA/GUI/icon.png")));
		frmSeleccionDeRango.setTitle("Seleccion de rango");
		frmSeleccionDeRango.setBounds(100, 100, 424, 487);
		frmSeleccionDeRango.setResizable(false);
		frmSeleccionDeRango.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSeleccionDeRango.getContentPane().setLayout(null);
		
		//inicializadores de los objetos
				creaTablaRangos();			
				
				JLabel lblRangoSeleccionado = new JLabel("Rango selec:");
				lblRangoSeleccionado.setBounds(10, 393, 127, 14);
				frmSeleccionDeRango.getContentPane().add(lblRangoSeleccionado);
				
				tfRango = new JTextField();
				tfRango.setBackground(new Color(255, 255, 255));
				tfRango.setEditable(false);
				tfRango.setBounds(86, 390, 312, 20);
				frmSeleccionDeRango.getContentPane().add(tfRango);
				tfRango.setColumns(10);
				
				SlRango = new JSlider(0,100,0);
				SlRango.setMajorTickSpacing(10);
				SlRango.setMinorTickSpacing(1);
				SlRango.setPaintTicks(true);
				SlRango.setPaintLabels(true);
				SlRango.setBounds(10, 283, 352, 56);
				SlRango.addChangeListener(new cambioSlide(this));
				frmSeleccionDeRango.getContentPane().add(SlRango);
				
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(310, 421, 89, 26);
				btnAceptar.addActionListener(vtnPlayers.getAccion());
				btnAceptar.setActionCommand("11");
				frmSeleccionDeRango.getContentPane().add(btnAceptar);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBounds(211, 421, 89, 26);
				btnCancelar.addActionListener(vtnPlayers.getAccion());
				btnCancelar.setActionCommand("12");
				frmSeleccionDeRango.getContentPane().add(btnCancelar);
				
				JButton btnTodas = new JButton("Todas");
				btnTodas.setBounds(10, 359, 77, 23);
				btnTodas.addActionListener(vtnPlayers.getAccion());
				btnTodas.setActionCommand("13");
				frmSeleccionDeRango.getContentPane().add(btnTodas);
				
				JButton btnParejas = new JButton("Parejas");
				btnParejas.setBounds(97, 359, 83, 23);
				btnParejas.addActionListener(vtnPlayers.getAccion());
				btnParejas.setActionCommand("14");
				frmSeleccionDeRango.getContentPane().add(btnParejas);
				
				JButton btnLimpiar = new JButton("Limpiar");
				btnLimpiar.setBounds(190, 359, 77, 23);
				btnLimpiar.addActionListener(vtnPlayers.getAccion());
				btnLimpiar.setActionCommand("15");
				frmSeleccionDeRango.getContentPane().add(btnLimpiar);
				
				JLabel lblSeleccionRapida = new JLabel("Seleccion rapida:");
				lblSeleccionRapida.setBounds(10, 338, 110, 14);
				frmSeleccionDeRango.getContentPane().add(lblSeleccionRapida);
				
				JComboBox<String> cbRango = new JComboBox<String>();
				cbRango.setBounds(277, 360, 121, 20);
				cbRango.addItem("Sklansky-Chubukov");
				cbRango.addItem("Sklansky-Malmuth");
				cbRango.setSelectedIndex(0);
				cbRango.addActionListener(vtnPlayers.getAccion());
				cbRango.setActionCommand("16");
				frmSeleccionDeRango.getContentPane().add(cbRango);
				
				JLabel lblRangoUsado = new JLabel("Rango usado:");
				lblRangoUsado.setBounds(277, 338, 121, 14);
				frmSeleccionDeRango.getContentPane().add(lblRangoUsado);
				
				tfPorcentaje = new JTextField();
				tfPorcentaje.setText("0");
				tfPorcentaje.setBounds(363, 283, 23, 20);
				frmSeleccionDeRango.getContentPane().add(tfPorcentaje);
				tfPorcentaje.setColumns(10);
				tfPorcentaje.addKeyListener(new KeyAdapter() {
				    public void keyTyped(KeyEvent e) {
				        char c = e.getKeyChar();
				        if (!((c >= '0') && (c <= '9') ||
				           (c == KeyEvent.VK_BACK_SPACE) ||
				           (c == KeyEvent.VK_DELETE))) {
				          e.consume();
				        }
				      }
				    });
				tfPorcentaje.addFocusListener(new FocusListener() {
				      public void focusGained(FocusEvent e) {
				      };
				      public void focusLost(FocusEvent e) 
				      {
				        cambiarRango();
				      }
				    });
				tfPorcentaje.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				       cambiarRango();
				    }
				});
				JLabel label = new JLabel("%");
				label.setBounds(387, 283, 21, 20);
				frmSeleccionDeRango.getContentPane().add(label);
				
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
		int s;
		int r;
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
		if(!rangoSelec.isEmpty())
		{
			
			for(String pareja:rangoSelec)
			{
				s=constante.getInstance().getManos().get(pareja).getX();
				r=constante.getInstance().getManos().get(pareja).getY();
				TablaRangos[s][r].setBackground(colorSelec);
			}
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
	//Limpia la tabla
	private void limpiartabla()
	{
		int x;
		int y;
		for(String pareja:rangoSelec)
		{
			x=constante.getInstance().getManos().get(pareja).getX();
			y=constante.getInstance().getManos().get(pareja).getY();
			TablaRangos[x][y].setBackground(colorNoSelec);
		}
		rangoSelec.clear();
		actualizaSeleccionadas();	
	}
	//Actualiza el texto de las cartas seleccionadas
	private void actualizaSeleccionadas()
	{	
		StringBuilder mostrar = new StringBuilder();
		if(!rangoSelec.isEmpty())
		{
			for(String pareja: rangoSelec)
			{
				mostrar.append(pareja);
				mostrar.append(",");
			}
		}
		tfRango.setText(mostrar.toString());
		cambiarPorcentaje();
	}
	//Carga un rango seleccionado desde el slide
	public void modificarDesdeSlide(String[] nuevoRango)
	{
		int x;
		int y;
		if(!rangoSelec.isEmpty())
			limpiartabla();
		for(int s=0;s<nuevoRango.length;s++)
		{
			x=constante.getInstance().getManos().get(nuevoRango[s]).getX();
			y=constante.getInstance().getManos().get(nuevoRango[s]).getY();
			TablaRangos[x][y].setBackground(colorSelec);
			rangoSelec.add(nuevoRango[s]);
		}
		tfPorcentaje.setText(Integer.toString(SlRango.getValue()));
		actualizaSeleccionadas();
	}
	
	//Funciones de seleccion automatica
	//Seleccion de pares
	public void seleccionaPares()
	{
		limpiartabla();
		String[] pares={"AA","KK","QQ","JJ","TT","99","88","77","66","55","44","33","22"};
		int x;
		int y;
		for(int i=0;i<pares.length;i++)
		{
			x=constante.getInstance().getManos().get(pares[i]).getX();
			y=constante.getInstance().getManos().get(pares[i]).getY();
			TablaRangos[x][y].setBackground(colorSelec);
			rangoSelec.add(pares[i]);
		}
		actualizaSeleccionadas();
	}
	//Seleccion de todas
	public void seleccionaTodas()
	{
		limpiartabla();
		for(int i=0;i<13;i++)
		{
			for(int x=0;x<13;x++)
			{
				TablaRangos[x][i].setBackground(colorSelec);
				rangoSelec.add(TablaRangos[x][i].getText());
			}
		}
		actualizaSeleccionadas();
	}
	//Limpiar todas
	public void limpiarSeleccion()
	{
		limpiartabla();
		actualizaSeleccionadas();
	}
	
	//dado un rango cambia el porcentaje
	private void cambiarPorcentaje()
	{
		int nuevoValor=control.rangoToPorcentaje(rangoSelec.toArray(new String[rangoSelec.size()]));
		slide=false;
		SlRango.setValue(nuevoValor);
		slide=true;
		tfPorcentaje.setText(Integer.toString(nuevoValor));
	}
	//Dado un porcentaje cambia el rango
	public void cambiarRango()
	{	
		String[] miRango=control.porcentajeToRango(Integer.parseInt(tfPorcentaje.getText()), rango);
		modificarDesdeSlide(miRango);
	}
	//Getters y setters
	public JFrame getFrame() 
	{
		return frmSeleccionDeRango;
	}

	public JTextField getTfRango() {
		return tfRango;
	}

	public int getJugador() {
		return jugador;
	}
	
	public controlador getControl() {
		return control;
	}

	public ArrayList<String> getRangoSelec() {
		return rangoSelec;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public boolean isSlide() {
		return slide;
	}
}

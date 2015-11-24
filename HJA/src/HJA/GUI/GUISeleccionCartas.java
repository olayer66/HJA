package HJA.GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HJA.controlador.controlador;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.Color;

public class GUISeleccionCartas {

	private JFrame frmSeleccionarCartas;
	private controlador control;
	private ActionListener accion;
	private ArrayList<String> cartasSeleccionadas;
	private int numCartas;
	private Color colorSelec= Color.GREEN;
	private ImagePanel[][] cuadroImagenes;
	private String[] cartas={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
	private detectaClickCarta detector;
	
	public GUISeleccionCartas(controlador ctn,ActionListener acc) {
		control=ctn;
		accion=acc;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		/*ImagePanel panel= new ImagePanel("2c.png");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.YELLOW, null, null, null));
		panel.setBounds(10, 11, 83, 120);
		panel.addMouseListener(detector);	
		frmSeleccionarCartas.getContentPane().add(panel);
		panel.repaint();
		*/
		//inicialiazdores
		crearCartas();
	}
	private void crearCartas()
	{
		int c=0;
		int x=10;
		int y=11;
		int width=83;
		int height=120;
		cuadroImagenes=new ImagePanel[4][13];
		cartasSeleccionadas= new ArrayList<String>();
		//palo
		for(int i=0;i<4;i++)
		{
			//carta
			for(int z=0;z<13;z++)
			{
				cuadroImagenes[i][z]= new ImagePanel("C:\\hlocal\\git\\HJA\\HJA\\src\\HJA\\GUI\\"+cartas[c]+".png");	
				cuadroImagenes[i][z].setName(cartas[c]);
				cuadroImagenes[i][z].setBounds(y, x, width, height);
				y+=width;
				cuadroImagenes[i][z].setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				cuadroImagenes[i][z].addMouseListener(detector);
				frmSeleccionarCartas.getContentPane().add(cuadroImagenes[i][z]);
				cuadroImagenes[i][z].repaint();
				c++;
			}
			x+=height;
			y=11;
		}
	}
	//Seleccion de cartas
	public void seleccionarCarta(ImagePanel carta)
	{
		if(!cartasSeleccionadas.contains(carta.getName()) && numCartas<2)
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
}

package HJA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import HJA.controlador.controlador;

import java.awt.Toolkit;

public class GUISeleccionCartas {

	private JFrame frmSeleccionarCartas;
	private controlador control;
	private ImagePanel[][] cuadroImagenes;
	private String[] cartas={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
	private detectaClickCarta detector;
	
	public GUISeleccionCartas(controlador ctn) {
		control=ctn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccionarCartas = new JFrame();
		frmSeleccionarCartas.setTitle("Seleccionar  cartas");
		frmSeleccionarCartas.setIconImage(Toolkit.getDefaultToolkit().getImage(GUISeleccionCartas.class.getResource("/HJA/GUI/icon.png")));
		frmSeleccionarCartas.setBounds(100, 100, 1097, 512);
		frmSeleccionarCartas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSeleccionarCartas.getContentPane().setLayout(null);
		
		detector=new detectaClickCarta(this);
		ImagePanel panel= new ImagePanel("Ah");
		panel.setBounds(10, 11, 83, 120);
		panel.addMouseListener(detector);
		frmSeleccionarCartas.getContentPane().add(panel);
		//inicialiazdores
		//crearCartas();
	}
	private void crearCartas()
	{
		int c=0;
		int x=10;
		int y=11;
		int width=83;
		int height=120;
		cuadroImagenes=new ImagePanel[4][13];
		//palo
		for(int i=0;i<4;i++)
		{
			//carta
			for(int z=0;z<13;z++)
			{
				cuadroImagenes[i][z]= new ImagePanel(cartas[c]);
				y+=width;
				cuadroImagenes[i][z].setBounds(x, y, width, height);
				cuadroImagenes[i][z].addMouseListener(detector);
				frmSeleccionarCartas.getContentPane().add(cuadroImagenes[i][z]);
				c++;
			}
			x+=height;
			y=11;
		}
	}

	public JFrame getFrmSeleccionarCartas() {
		return frmSeleccionarCartas;
	}
	
}

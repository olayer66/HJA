package HJA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import HJA.controlador.controlador;

public class GUIRango {

	private JFrame frame;
	private controlador control;
	
	/*public GUIRango(controlador miCont)
	{
		control=miCont;
		initialize();
	}*/
	/**
	 * Create the application.
	 */
	public GUIRango() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

}

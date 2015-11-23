package HJA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUISeleccionCartas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISeleccionCartas window = new GUISeleccionCartas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUISeleccionCartas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

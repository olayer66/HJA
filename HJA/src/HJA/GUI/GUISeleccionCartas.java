package HJA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUISeleccionCartas {

	private JFrame frame;
	private ImagePanel[][] cuadroImagenes;
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	}
	private void crearCartas()
	{
		int x=10;
		int y=11;
		int width=83;
		int height=120;
		cuadroImagenes=new ImagePanel[4][13];
		//palo
		for(int i=0;i<4;i++)
		{
			//carta
			for(int z=0;z<14;z++)
			{
				
			}
		}
	}
}

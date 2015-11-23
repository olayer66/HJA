package HJA.GUI;

import javax.swing.*;  
import java.awt.*;

class ImagePanel extends JPanel
{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImagePanel() {
		this.setSize(83, 120); //se selecciona el tama�o del panel
		}
		 
		//Se crea un m�todo cuyo par�metro debe ser un objeto Graphics
		 
		public void paint(Graphics grafico) {
		Dimension height = getSize();
		 
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
		 
		ImageIcon Img = new ImageIcon(getClass().getResource("\\66.png")); 
		 
		//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
		 
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		 
		setOpaque(false);
		super.paintComponent(grafico);
		}
}

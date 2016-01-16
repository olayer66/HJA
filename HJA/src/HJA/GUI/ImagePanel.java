package HJA.GUI;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;

    public ImagePanel(String imagen)
    {
    	repintar(imagen);
    }
    public void repintar(String imagen)
    {
    	if(imagen!=null)
			try {
				image = ImageIO.read(getClass().getResourceAsStream(imagen));
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

}
package HJA.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class detectaClick implements MouseListener {

	private GUIRango vtnRango;
	public detectaClick(GUIRango vtn) {
		vtnRango=vtn;
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		vtnRango.cambiarColor((JLabel) e.getSource());		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

}

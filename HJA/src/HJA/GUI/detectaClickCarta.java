package HJA.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class detectaClickCarta implements MouseListener {

	private GUISeleccionCartas vtnCartas;
	public detectaClickCarta(GUISeleccionCartas vtn) {
		vtnCartas=vtn;
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		ImagePanel imagen= (ImagePanel) e.getSource();
		vtnCartas.seleccionarCarta(imagen);
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
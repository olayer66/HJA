package HJA.GUI;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import HJA.controlador.controlador;

public class cambioSlide implements ChangeListener {

	private GUIRango vtnRango;
	private String[] prueba;
	public cambioSlide(GUIRango vtn) 
	{
		vtnRango=vtn;
	}
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		JSlider slide=(JSlider)e.getSource();
		if (!slide.getValueIsAdjusting())
		{		
			prueba=vtnRango.getControl().porcentajeToRango(slide.getValue(), 0);
			vtnRango.modificarDesdeSlide(prueba);
		}
	}
}

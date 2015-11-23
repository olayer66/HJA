package HJA.GUI;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import HJA.controlador.controlador;

public class cambioSlide implements ChangeListener {

	private GUIRango vtnRango;
	private String[] rango;
	private int rangoUsado;
	public cambioSlide(GUIRango vtn, int rng) 
	{
		vtnRango=vtn;
		rangoUsado=rng;
	}
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		JSlider slide=(JSlider)e.getSource();
		if (!slide.getValueIsAdjusting() && vtnRango.isSlide())
		{		
			rango=vtnRango.getControl().porcentajeToRango(slide.getValue(), rangoUsado);
			vtnRango.modificarDesdeSlide(rango);
		}
	}
}

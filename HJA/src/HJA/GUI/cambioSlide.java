package HJA.GUI;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import HJA.controlador.controlador;

public class cambioSlide implements ChangeListener {

	private controlador miCont;
	private int prueba;
	public cambioSlide(controlador miC) 
	{
		miCont=miC;
	}
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		JSlider slide=(JSlider)e.getSource();
		if (slide.getValueIsAdjusting())
		{
			prueba=slide.getValue();
			miCont.porcentajeToRango(slide.getValue(), 0);
		}
	}
}

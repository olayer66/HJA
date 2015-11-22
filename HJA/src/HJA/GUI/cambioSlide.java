package HJA.GUI;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cambioSlide implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		JSlider slide=(JSlider)e.getSource();
		 //if (slide.getValueIsAdjusting()) 
			 //llamar al controlador
	}

}

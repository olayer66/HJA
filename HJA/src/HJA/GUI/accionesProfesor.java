package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accionesProfesor implements ActionListener 
{
	private GUIProfesor vtnProfesor;
	public accionesProfesor(GUIProfesor vtnProf) 
	{
		vtnProfesor=vtnProf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) 
		{
			case "1"://seleccion cartas jug1
				
				break;
			case "2"://seleccion cartas jug2
						
				break;
			case "3"://seleccion mesa
				
				break;
			case "4":// aleatorio jug1
				
				break;
			case "5":// aleatorio jug2
				
				break;
			case "6":// aleatorio mesa
				
				break;
			case "7":// boton calcular
				
				break;
		}
		
	}

}

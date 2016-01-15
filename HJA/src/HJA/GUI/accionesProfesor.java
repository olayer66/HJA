package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accionesProfesor implements ActionListener 
{
	private GUIProfesor vtnProfesor;
	private GUISeleccionCartas vtnCartas;
	public accionesProfesor(GUIProfesor vtnProf) 
	{
		vtnProfesor=vtnProf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) 
		{
			case "1"://seleccion cartas jug1
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),1, null,vtnProfesor.getBloqueadas(1), vtnProfesor.getCartas(), null);
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);
				break;
			case "2"://seleccion cartas jug2
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),2, null,vtnProfesor.getBloqueadas(2), vtnProfesor.getCartas(), null);
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);	
				break;
			case "3"://seleccion mesa
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),3, null,vtnProfesor.getBloqueadas(3), vtnProfesor.getMesa(), null);
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);
				break;
			case "4":// aleatorio jug1
				
				break;
			case "5":// aleatorio jug2
				
				break;
			case "6":// aleatorio mesa
				
				break;
			case "7":// boton calcular
				
				break;
			case "20":
				//accion a profesor
				vtnCartas.getFrmSeleccionarCartas().setVisible(false);
				vtnCartas.getFrmSeleccionarCartas().dispose();
				vtnCartas=null;
				break;
			case "21":
				vtnCartas.getFrmSeleccionarCartas().setVisible(false);
				vtnCartas.getFrmSeleccionarCartas().dispose();
				vtnCartas=null;
				break;
		}
		
	}

}

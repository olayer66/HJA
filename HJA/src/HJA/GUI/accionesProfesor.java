package HJA.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class accionesProfesor implements ActionListener 
{
	private GUIProfesor vtnProfesor;
	private GUISeleccionCartas vtnCartas;
	private int jug;
	private boolean seleccion=false;
	public accionesProfesor(GUIProfesor vtnProf) 
	{
		vtnProfesor=vtnProf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) 
		{
			case "1"://seleccion cartas jug1
			try {
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),2, null,vtnProfesor.getBloqueadas(1),  null);
			} catch (IOException e4) {
				// TODO Bloque catch generado automáticamente
				e4.printStackTrace();
			}
				jug=1;
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);
				break;
			case "2"://seleccion cartas jug2
			try {
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),2, null,vtnProfesor.getBloqueadas(2),  null);
				seleccion=true;
			} catch (IOException e3) {
				// TODO Bloque catch generado automáticamente
				e3.printStackTrace();
			}
				jug=2;
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);	
				break;
			case "3"://seleccion mesa
			try {
				vtnCartas= new GUISeleccionCartas(vtnProfesor.getAcciones(),5, null,vtnProfesor.getBloqueadas(3),  null);
			} catch (IOException e2) {
				// TODO Bloque catch generado automáticamente
				e2.printStackTrace();
			}
				jug=3;
				vtnCartas.getFrmSeleccionarCartas().setVisible(true);
				break;
			case "4":// aleatorio jug1
				vtnProfesor.cartasAleatorias(1);
				break;
			case "5":// aleatorio jug2
				vtnProfesor.cartasAleatorias(2);
				break;
			case "6":// aleatorio mesa
				vtnProfesor.cartasAleatorias(3);
				break;
			case "7":// boton calcular
					vtnProfesor.calcular();			
				break;
			case "8"://nueva carta en el board
				vtnProfesor.nuevaCartaBoard();
				break;
			case "9"://mostrar cartas del rival
				vtnProfesor.muestraRival();
				break;
			case "10":
				vtnProfesor.LimpiarVentana();
				break;
			case "20":
				if(vtnCartas.esMesaValida(jug))
				{
					boolean seleccionar=false;
					try 
					{
						if(seleccion)	
							seleccionar=true;
						seleccion=false;
						vtnProfesor.cargaCartas(vtnCartas.getCartasSeleccionadas(),jug, seleccionar);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					vtnCartas.getFrmSeleccionarCartas().setVisible(false);
					vtnCartas.getFrmSeleccionarCartas().dispose();
					vtnCartas=null;
				}
				
				break;
			case "21":
				vtnCartas.getFrmSeleccionarCartas().setVisible(false);
				vtnCartas.getFrmSeleccionarCartas().dispose();
				vtnCartas=null;
				break;
		}
		
	}

}

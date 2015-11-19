package HJA.controlador;

import HJA.modelo.transformarString;
import HJA.modelo.transformarRango;

public class controlador 
{
	public String[] transformarString(String rango)
	{
		/*transformarString  trans = new transformarString(rango);
		return trans.procesarString();*/
		return null;
	}
	
	public String transformarRango(String[] cartas){

		transformarRango trans = new transformarRango(cartas);
		return trans.crearRango();
	}
}

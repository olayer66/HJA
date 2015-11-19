package HJA.controlador;

import HJA.modelo.transformarString;

public class controlador 
{
	public String[] transformarString(String rango)
	{
		transformarString  trans = new transformarString(rango);
		return trans.procesarString();
	}
	
	public String transformarRango(String[] cartas){
		return null;
	}
}

package HJA.controlador;

import HJA.modelo.transformarString;
import HJA.modelo.procesarRankings;
import HJA.modelo.transformarRango;

public class controlador 
{
	public String[] transformarString(String rango)
	{
		if(!rango.isEmpty())
		{
		transformarString  trans = new transformarString(rango);
		return trans.procesarString();
		}
		else
			return null;
	}
	
	public String transformarRango(String[] cartas){

		transformarRango trans = new transformarRango(cartas);
		return trans.crearRango();
	}
	
	//Rango: 0 -> Chubukov
	public String[] porcentajeToRango(int porcentaje, int rango){
		
		procesarRankings proc = new procesarRankings();
		return proc.porcentajeToRango(porcentaje, rango);
	}
	
	public int rangoToPorcentaje(String[] cartas){
		
		procesarRankings proc = new procesarRankings();
		return proc.rangoToPorcentaje(cartas);
	}
}

package HJA.controlador;

import HJA.modelo.transformarString;

import java.util.ArrayList;

import HJA.modelo.calculoEquity;
import HJA.modelo.procesarJugada;
import HJA.modelo.procesarRankings;
import HJA.modelo.profesor;
import HJA.modelo.transformarRango;

public class controlador 
{
	String salida;
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
		if(cartas.length!=0){
		transformarRango trans = new transformarRango(cartas);
		return trans.crearRango();
		}else return null;
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
	
	public boolean evaluarJugada(String[] datos){
		procesarJugada proc = new procesarJugada(datos); 
		return proc.evaluarJugada();
	}
	public float[] calcularEquity(String mesa, String desc, String[] rangos)
	{
		calculoEquity calculo= new calculoEquity();
		float[] eq=calculo.calcular(mesa, desc, rangos);
		salida=calculo.getMiSalida();
		return eq;
	}
	public String[] caculoProfesor(ArrayList<String> jugadores, ArrayList<String> mesa)
	{
		String[] resultado= new String[2];
		profesor prof = new profesor();
		resultado[0]=Integer.toString(prof.calculaEquity(jugadores, mesa));
		resultado[1]=prof.getMano();
		return resultado;
	}
	public String valorMano(String mano)
	{
		profesor prof = new profesor();
		return prof.calculaValorMano(mano);
	}
	public String getSalida() {
		return salida;
	}
	
}

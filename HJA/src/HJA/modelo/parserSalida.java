package HJA.modelo;

import java.util.ArrayList;

public class parserSalida {


	
	public parserSalida() {
	}
	
	public String parserString(String mesa, String desc, String[] rangos, ArrayList <String[]> jugadores,  ArrayList<String> descartes,  ArrayList<String> board, float[] equity, float numVueltas){
		StringBuilder sb= new StringBuilder();
		sb.append("Variables puras:");
		sb.append(System.lineSeparator());
		sb.append("Mesa: ");
		sb.append(mesa);
		sb.append("Descartes: ");
		sb.append(desc);
		for(int i=0;i<rangos.length;i++)
		{
			sb.append("jugador ");
			sb.append(i+1);
			sb.append(": ");
			sb.append(rangos[i]);
			sb.append(System.lineSeparator());
		}
		sb.append("Variables transformadas:");
		sb.append(System.lineSeparator());
		int n=0;
		for(String [] jug :jugadores)
		{
			sb.append("jugador ");
			sb.append(n);
			sb.append(": ");
			for(int i=0;i<jug.length;i++)
			{
				sb.append(jug[i]);
				sb.append(" ");
			}
			sb.append(System.lineSeparator());
			n++;
		}
		if(descartes!=null)
		{
			sb.append("Descartes:  ");
			for(String carta: descartes)
			{
				sb.append(carta); 
				sb.append(" ");
			}
		}
		if(board!=null)
		{
			sb.append(System.lineSeparator());
			sb.append("Mesa: ");
			for(String carta: board)
			{
				sb.append(carta); 
				sb.append(" ");
			}
		}
		sb.append(System.lineSeparator());
		sb.append("Equitys: ");
		for(int i=0;i<equity.length;i++)
		{
			System.out.println("jugador "+i+": "+ equity[i]+"%");
			sb.append("jugador ");
			sb.append(i);
			sb.append(": ");
			sb.append(equity[i]);
			sb.append("%");
			sb.append(System.lineSeparator());
			
		}
		sb.append("Vueltas totales:");
		sb.append(numVueltas);
		sb.append(System.lineSeparator());
		return sb.toString();
		
	}
	
	
	
}

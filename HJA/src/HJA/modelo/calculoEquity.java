package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class calculoEquity 
{
	private String[] board;
	private String[] descartes;
	private ArrayList <String[]> jugadores;
	private float[] equity;
	private int[] puntos;
	//Constructor de la clase
	public calculoEquity()
	{
		jugadores= new ArrayList<String[]>();
	}
	//funcion principal
	public float[] calcular (String mesa, String desc, String[] rangos)
	{
		equity = new float[rangos.length];
		// Transformamos las diferentes entradas a valores que podamos usar
		transformar(mesa,desc,rangos);
		//iniciamos el calculo de las manos
		calculoManos();
		
		mostrarVariables(mesa, desc, rangos);
		return equity;
	}
	//funcion que calcula el ganador de una mano
	private void calculoManos()
	{
		//tenemos un board
		if(board!=null)
		{
			calculoBoard(board);
		}
		else//No hay board
		{
			if(!descartes.equals(null))
				
			calculoBoardVacio();
		}
	}
	//Realiza los calculos en caso de que el board este vacio
	private void calculoBoardVacio()
	{
		eliminaDescartes();
		ICombinatoricsVector<String> initialVector = Factory.createVector(board);
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 5);
	}
	//Calcula un board dado los jugadores y el board
	private void calculoBoard (String[] board)
	{
		
	}
	//Tranforma los rangos de cartas, el board y los descartes en cartas separadas
	private void transformar(String mesa, String desc, String[] rangos)
	{	
		int i=0;
		String[] cartas;
		ParseCartas parse = new ParseCartas();
		StringTokenizer strTok;
		if(mesa!=null)
		{
			
			strTok= new StringTokenizer(mesa, ",");
			board= new String[strTok.countTokens()];
			while (strTok.hasMoreTokens()) 
			{
		         board[i]=strTok.nextToken();
		         i++;
		    }
		}
		if(!desc.isEmpty())
		{
			i=0;
			strTok= new StringTokenizer(desc, ",");
			descartes= new String[strTok.countTokens()];
			while (strTok.hasMoreTokens()) 
			{
		         descartes[i]=strTok.nextToken();
		         i++;
		    }
		}
		for(int x=0 ; x<rangos.length; x++){
			transformarString trans = new transformarString(rangos[x]);
			cartas = parse.allCombinaciones(trans.procesarString());
			jugadores.add(cartas);
		}
	}
	//Elimina del board los descartes
	private void eliminaDescartes ()
	{
		String[] aux={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
		ArrayList<String> lista= new ArrayList<String>(Arrays.asList(aux));
		for(int i=0; i<descartes.length;i++)
		{
			lista.remove(descartes[i]);
		}
		board= (String[]) lista.toArray(new String[lista.size()]);
	}
	/*-----------------------------------Comprobacion de salidas---------------------------------------------------------*/
	// muestra las variables recibidas y su salida transformada
	private void mostrarVariables(String mesa, String desc, String[] rangos)
	{
		System.out.println("Variables puras:");
		System.out.println("Mesa: "+mesa);
		System.out.println("Descartes: "+desc);
		for(int i=0;i<rangos.length;i++)
		{
			System.out.println("jugador "+(i+1)+": "+rangos[i]);
		}
		System.out.println("\nVariables transformadas:");
		int n=1;
		for(String [] jug :jugadores)
		{
			System.out.print("jugador "+n+": ");
			for(int i=0;i<jug.length;i++)
			{
				System.out.print(jug[i] +" ");
			}
			System.out.print("\n");
			n++;
		}
		System.out.print("Descartes: ");
		for(int i=0;i<descartes.length;i++)
		{
			System.out.print(descartes[i] +" ");
		}
		System.out.print("\nMesa: ");
		for(int i=0;i<board.length;i++)
		{
			System.out.print(board[i] +" ");
		}
	}
}

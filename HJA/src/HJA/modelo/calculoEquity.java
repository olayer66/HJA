package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class calculoEquity 
{
	private ArrayList<String> board;
	private ArrayList<String> descartes;
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
			//calculoBoard(board);
		}
		else//No hay board
		{
			if(descartes!=null)
				
			calculoBoardVacio();
		}
	}
	//Realiza los calculos en caso de que el board este vacio
	private void calculoBoardVacio()
	{
		eliminaDescartes();
		ICombinatoricsVector<String> initialVector = Factory.createVector(board);
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 5);
		for (ICombinatoricsVector<String> combination : gen) 
		{
			
		}
	}
	
	/*------Metodos para el calculo del board---------*/
	//Calcula un board dado los jugadores y el board
	private void calculoBoard (ArrayList<String> board)
	{
		
	}
	
	
	//comprueba si se puede ejecutar el board pasado con las cartas pasadas
	private boolean calculoManoValido(String[] cartas,List<String> mesa,int valor, boolean estado)
	{
			if(valor<cartas.length)
			{
				if(!mesa.contains(cartas[valor]))
					return calculoManoValido(cartas, mesa, valor+1,true);
				else
					estado=false;
			}
			return estado;
	}
	//Tranforma los rangos de cartas, el board y los descartes en cartas separadas
	private void transformar(String mesa, String desc, String[] rangos)
	{	
		String[] cartas;
		ParseCartas parse = new ParseCartas();
		StringTokenizer strTok;
		if(mesa!=null)
		{
			
			strTok= new StringTokenizer(mesa, ",");
			board= new ArrayList<String>();
			while (strTok.hasMoreTokens()) 
			{
		         board.add(strTok.nextToken());
		    }
		}
		if(desc!=null)
		{
			strTok= new StringTokenizer(desc, ",");
			descartes= new ArrayList<String>();
			while (strTok.hasMoreTokens()) 
			{
		         descartes.add(strTok.nextToken());
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
		board= new ArrayList<String>(Arrays.asList(aux));
		for(String carta: descartes)
		{
			board.remove(carta);
		}
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
		if(descartes!=null)
		{
			System.out.print("Descartes: ");
			for(String carta: descartes)
			{
				System.out.print(carta +" ");
			}
		}
		if(board!=null)
		{
			System.out.print("\nMesa: ");
			for(String carta: board)
			{
				System.out.print(carta +" ");
			}
		}
	}
}

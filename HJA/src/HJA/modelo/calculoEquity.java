package HJA.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import HJA.constante;

public class calculoEquity 
{
	private ArrayList<String> board;
	private ArrayList<String> descartes;
	private ArrayList <String[]> jugadores;
	private ArrayList <int[]> manosUsadas;
	private float[] equity;
	private int[] puntos;
	//Constructor de la clase
	public calculoEquity()
	{
		jugadores= new ArrayList<String[]>();
		manosUsadas=new ArrayList<int[]>();
		
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
		//Eliminamos los descartes del mazo
		eliminaDescartes();
		//Generamos la combinatoria del mazo cojiendo cartas de 5 en 5 hasta cubrir todas las posibles variantes
		ICombinatoricsVector<String> initialVector = Factory.createVector(board);
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 5);
		String[] primeraMano;
		for (ICombinatoricsVector<String> combination : gen) 
		{
			
			//extraemos la primra mano a jugar
			sacaManos(combination.getVector(),0,0);
			//Comprobamos que tengamos una mano a jugar con el board
			break;
		}
	}
	
	/*------Metodos para el calculo del board---------*/
	//Calcula un board dado los jugadores y el board
	private void calculoBoard (List<String> board,String[] mano)
	{
		
	}
	//Extrae las manos jugables entre todos los jugadores eliminando manos no posibles(cartas en el board o en descartes)
	private void sacaManos(List<String> board,int jug, int mano)
	{
		String[] cartas={jugadores.get(jug)[mano].substring(0,2),jugadores.get(jug)[mano].substring(2,4)};
		if(calculoManoValido(cartas, board, 0, true))
		{
			manosUsadas.get(jug)[mano]=0;
		}
		else
		{
			manosUsadas.get(jug)[mano]=1;
		}
		if(jug!=jugadores.size()-1 && mano!=jugadores.get(jugadores.size()-1).length-1)
		{
			if(mano==jugadores.get(jug).length-1)
			{
				manosUsadas.add(new int[jugadores.get(jug+1).length]);
				sacaManos(board, jug+1, 0);
			}
			else
			{
				sacaManos(board, jug, mano+1);
			}
		}		
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
		ArrayList<String> pares = new ArrayList<String>(constante.getInstance().getManos().keySet());
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
		//Tranformamos los rangos de los jugadores a datos utiles
		for(int x=0 ; x<rangos.length; x++)
		{
			//Si el juagdor es random
			if(rangos[x]=="random")
			{
				transformarString trans = new transformarString(pares.get(generaManosRandom()));
				cartas = parse.allCombinaciones(trans.procesarString());
				jugadores.add(cartas);
				manosUsadas.add(new int[jugadores.get(x).length]);
			}
			else
			{
			transformarString trans = new transformarString(rangos[x]);
			cartas = parse.allCombinaciones(trans.procesarString());
			jugadores.add(cartas);
			manosUsadas.add(new int[jugadores.get(x).length]);
			}
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
	
	//Genera una mano aleatoria para los jugadores random
	private int generaManosRandom()
	{
		Random rnd= new Random();
		return (int)rnd.nextDouble() * 168 + 0;
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
		n=0;
		System.out.println("\nManos Usadas:");
		for(int[] jug :manosUsadas)
		{
			System.out.print("jugador "+n+": ");
			for(int i=0;i<jug.length;i++)
			{
				System.out.print(jug[i] +" ");
			}
			System.out.print("\n");
			n++;
		}
	}
}

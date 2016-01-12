package HJA.modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import HJA.constante;

public class calculoEquity 
{
	/*
	 * idea secundaria: 
	 * Quitar del board resultante todas las cartas de la mano 
	   asi no habria coincidencias eliminando el array de manos usadas y quitando un bucle de en medio 
	 *Cambiar el board a hashmap para mejorar de O(n) al buscar a O(1)
	*/
	private ArrayList<String> board;
	private ArrayList<String> descartes;
	private ArrayList <String[]> jugadores;
	private ArrayList <int[]> manosUsadas;
	private float[] equity;
	private Integer[] puntos;
	private long numVueltas;
	
	private ExecutorService threadPool;
	private Future<Integer[]> task;
	//Constructor de la clase
	public calculoEquity()
	{
		jugadores= new ArrayList<String[]>();
		manosUsadas=new ArrayList<int[]>();
		threadPool = Executors.newFixedThreadPool(40);
		
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
			calculoBoardNoVacio();
		}
		else//No hay board
		{
			calculoBoardVacio();
		}
		//calculamos los equitys
		calculaEquity();
		 // Eliminaos el threadPool de memoria
		threadPool.shutdown();
		 // Esperamos que todos los hilos terminen
		try 
		{
			threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	//Realiza los calculos en caso de que el board este vacio
	private void calculoBoardVacio()
	{
		eliminaDescartes();
		//Generamos la combinatoria del mazo cojiendo cartas de 5 en 5 hasta cubrir todas las posibles variantes
		ICombinatoricsVector<String> initialVector = Factory.createVector(board);
		Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 5);
		for (ICombinatoricsVector<String> combination : gen) 
		{		
			//Creamos la matriz de parejas jugables con el board actual
			sacaManos(combination.getVector(),0,0);

			//Calculamos el ganador para el board
			task= threadPool.submit(new calculoBoard(jugadores, manosUsadas,String.join("", combination.getVector())));
			try {
				
				SumarPuntos(task.get());
			} catch (InterruptedException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			/* Tenemos una "piscina" de hilos que limita la ejecucion en paralelo a n hilos para evitar la sobrecarga del procesador*/
		}	
	}
	//Realiza los calculos en caso de que el board no este vacio
	private void calculoBoardNoVacio()
	{
		eliminaDescartes();
		sacaManos(board, 0, 0);
		task= threadPool.submit(new calculoBoard(jugadores, manosUsadas,String.join("", board)));
		try {
			puntos=task.get();
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
	}
	
	/*------Metodos previos para el calculo del board---------*/
	//Extrae las manos jugables entre todos los jugadores eliminando manos no posibles(cartas en el board o en descartes)
	private void sacaManos(List<String> board,int jug, int mano)
	{
		String[] cartas= new String[2];
		if(jugadores.get(jug).length!=0)
		{
			cartas[0]=jugadores.get(jug)[mano].substring(0,2);
			cartas[1]=jugadores.get(jug)[mano].substring(2,4);
			if(calculoManoValido(cartas, board, 0, true))
			{
				manosUsadas.get(jug)[mano]=0;
			}
			else
			{
				manosUsadas.get(jug)[mano]=1;
			}
		}	
		if(jug!=jugadores.size()-1)
		{
			if(mano==jugadores.get(jug).length-1)
			{
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
				int num=generaManosRandom();
				transformarString trans = new transformarString(pares.get(num));
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
			puntos= new Integer[jugadores.size()];
		}
	}
	//Elimina del board los descartes
	private void eliminaDescartes ()
	{
		String[] aux={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
		
		if(descartes!=null)
		{	
			board= new ArrayList<String>(Arrays.asList(aux));
			for(String carta: descartes)
			{
				board.remove(carta);
			}
		}
		else
			board=new ArrayList<String>(Arrays.asList(aux));
	}
	//Suma los puntos al total
	public void SumarPuntos(Integer[] pnts)
	{
		for(int i=0; i<puntos.length;i++)
		{
			if(puntos[i]==null)
				puntos[i]=0;
			if(pnts[i]==null)
				pnts[i]=0;
			puntos[i]+=pnts[i];
		}
	}
	//Genera una mano aleatoria para los jugadores random
	private int generaManosRandom()
	{
		Random rnd= new Random();
		double num=rnd.nextDouble() * 168 + 0;
		int num2=(int)num;
		return num2;
	}
	//Calcula los equity
	private void calculaEquity()
	{
		numVueltas=2*(long)Math.pow(10, 6);
		for(String[] jug : jugadores)
		{
			numVueltas*=jug.length;
		}
		for(int i=0;i<puntos.length;i++)
		{
			equity[i]=(float)numVueltas/puntos[i];
			
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
		int n=0;
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
		System.out.println("Vueltas totales:" + numVueltas);
		System.out.println("\nPuntos:");
		for(int i=0;i<puntos.length;i++)
		{
			System.out.println("jugador "+i+": "+ puntos[i]);
			
		}
		System.out.println("\nEquitys:");
		for(int i=0;i<equity.length;i++)
		{
			System.out.println("jugador "+i+": "+ equity[i]+"%");
			
		}
	}
}

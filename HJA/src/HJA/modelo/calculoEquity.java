package HJA.modelo;

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
	private ArrayList<int[]> valorJugada;
	private ArrayList<int[]> valorMano;
	private ProcesarMano procesar;
	private float[] equity;
	private Float[] puntos;
	private float numVueltas;
	private String miSalida;
	private ExecutorService threadPool;
	private Future<Float[]> task;
	//Constructor de la clase
	public calculoEquity()
	{
		jugadores= new ArrayList<String[]>();
		procesar = new ProcesarMano();
		valorJugada= new ArrayList<int[]>();
		valorMano= new ArrayList<int[]>();
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
		miSalida=new parserSalida().parserString(mesa, desc, rangos, jugadores, descartes, board, equity, numVueltas);
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
			
			/* Tenemos una "piscina" de hilos que limita la ejecucion en paralelo a n hilos para evitar la sobrecarga del procesador*/
			//Calculamos el ganador para el board
			task= threadPool.submit(new calculoBoard(jugadores, valorJugada,valorMano));
			try 
			{	
				SumarPuntos(task.get());			
			} 
			catch (InterruptedException | ExecutionException e1) 
			{
				e1.printStackTrace();
			}
			//Muestra los valores de las manos conseguidos
			//muestraValorManos(String.join("", combination.getVector()));			
		}	
	}
	//Realiza los calculos en caso de que el board no este vacio
	private void calculoBoardNoVacio()
	{
		eliminaDescartes();
		sacaManos(board, 0, 0);
		task= threadPool.submit(new calculoBoard(jugadores, valorJugada,valorMano));
		try {
			puntos=task.get();
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
	}
	
	/*------Metodos previos para el calculo del board---------*/
	//Extrae las manos jugables entre todos los jugadores eliminando manos no posibles(cartas en el board o en descartes)
	private void sacaManos(List<String> brd,int jug, int mano)
	{
		String[] cartas= new String[2];
		if(jug<jugadores.size() && mano<jugadores.get(jugadores.size()-1).length)
		{
			cartas[0]=jugadores.get(jug)[mano].substring(0,2);
			cartas[1]=jugadores.get(jug)[mano].substring(2,4);
			if(calculoManoValido(cartas, brd, 0, true))
			{
				String jugada=concatena(jugadores.get(jug)[mano], String.join("", brd));
				if(valorJugada.get(jug).length<=jugadores.get(jug).length)
					valorJugada.get(jug)[mano]=procesar.procesarBestHand(jugada);
				else
					valorJugada.get(jug)[mano]= procesar.procesarBestHand(jugada);
				
				if(valorMano.get(jug).length<=jugadores.get(jug).length)
					valorMano.get(jug)[mano]=procesar.valorMano(jugada);
				else
					valorMano.get(jug)[mano]=procesar.valorMano(jugada);
			}
			else
			{
				if(valorJugada.get(jug).length<=jugadores.get(jug).length)
					valorJugada.get(jug)[mano]=0;
				else
					valorJugada.get(jug)[mano]=0;
				if(valorMano.get(jug).length<=jugadores.get(jug).length)
					valorMano.get(jug)[mano]=0;
				else
					valorMano.get(jug)[mano]=0;
			}
			if(mano==jugadores.get(jug).length-1)
			{
				sacaManos(brd, jug+1, 0);
			}
			else
			{
				sacaManos(brd, jug, mano+1);
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
			if(rangos[x].equals("random"))
			{
				int num=generaManosRandom();
				transformarString trans = new transformarString(pares.get(num));
				cartas = parse.allCombinaciones(trans.procesarString());
				jugadores.add(cartas);
				valorJugada.add(new int[jugadores.get(x).length]);
				valorMano.add(new int[jugadores.get(x).length]);
			}
			else
			{
				transformarString trans = new transformarString(rangos[x]);
				cartas = parse.allCombinaciones(trans.procesarString());
				jugadores.add(cartas);
				valorJugada.add(new int[jugadores.get(x).length]);
				valorMano.add(new int[jugadores.get(x).length]);
			}
			puntos= new Float[jugadores.size()];
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
	public void SumarPuntos(Float[] pnts)
	{
		for(int i=0; i<puntos.length;i++)
		{
			if(puntos[i]==null)
				puntos[i]=Float.valueOf("0");
			if(pnts[i]==null)
				pnts[i]=Float.valueOf("0");
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
		float calculo;
		numVueltas=2*(long)Math.pow(10, 6);
		for(String[] jug : jugadores)
		{
			numVueltas*=jug.length;
		}
		for(int i=0;i<puntos.length;i++)
		{
			calculo=puntos[i]*100;
			equity[i]=calculo/numVueltas;		
		}
	}
	//Concatena dos String cad1(mano) y cad2(board)
	private String concatena(String cad1,String cad2)
	{
		return new StringBuilder().append(cad1).append(cad2).toString();
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
		System.out.println("\nEquitys:");
		for(int i=0;i<equity.length;i++)
		{
			System.out.println("jugador "+i+": "+ equity[i]+"%");
			
		}
		System.out.println("Vueltas totales:" + numVueltas);
	}
	//Muestra los resultados de las manos
		private void muestraValorManos(String brd)
		{
			System.out.println("Board: " +brd);
			System.out.println("Valor Jugada:");
			for(int x=0; x<valorJugada.size();x++)
			{
				System.out.print("Jugador "+x+": ");
				for(int i=0; i<valorJugada.get(x).length;i++)
				{
					System.out.print(valorJugada.get(x)[i]+" ");
				}
				System.out.print("\n");
			}
			System.out.println("Valor Mano:");
			for(int x=0; x<valorMano.size();x++)
			{
				System.out.print("Jugador "+x+": ");
				for(int i=0; i<valorMano.get(x).length;i++)
				{
					System.out.print(valorMano.get(x)[i]+" ");
				}
				System.out.print("\n");
			}
			System.out.println("\nPuntos:");
			for(int i=0;i<puntos.length;i++)
			{
				System.out.println("jugador "+i+": "+ puntos[i]);
				
			}
		}
		public String getMiSalida() {
			return miSalida;
		}
		
}

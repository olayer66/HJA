package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.ArrayUtils;

public class calculoBoard implements Callable<Integer[]> 
{
	private Integer [] puntos;
	private ArrayList <String[]> jugador;
	private ArrayList <int[]> manosUsadas;
	private String board;
	private ArrayList<ArrayList<Integer>> valorJugada;
	private ArrayList<ArrayList<Integer>> valorMano;
	private ProcesarMano procesar;
	//Constructor
	public calculoBoard(ArrayList <String[]> jug,ArrayList <int[]> usadas,String brd) 
	{
		jugador=jug;
		manosUsadas=usadas;
		board=brd;
		puntos=new Integer[jugador.size()];
		Arrays.fill(puntos, 0);
		procesar = new ProcesarMano();
		valorJugada= new ArrayList<ArrayList<Integer>>();
		valorMano= new ArrayList<ArrayList<Integer>>();
	}
	public Integer[] call()
	{
		//calculamos los valores de las manos
		calculaManos(0,0);
		//muestraValorManos();
		//calcular(mano);
		return puntos;
	}
	private void calcular(int[] mano)
	{
		/*
		 * aqui hay que evitar enfrentar manos que contegan las mismas cartas 
		 * usaremos en indice de los resutados que estamos enfrentando llamando a una funcion que lo compruebe
		*/
	}
	
	
	/*-------------------------Metodos varios-------------------------------*/
	//Calcula los valores de las manos jugadas dejando a cero aquellas que no se pueden jugar
	private void calculaManos(int jug, int mano)
	{
		
		if(jug==jugador.size()-1 && mano==jugador.get(jugador.size()-1).length-1)
		{
		}
		else
		{
			if(valorJugada.size()-1<jug)
				valorJugada.add(new ArrayList<Integer>());
			if(valorMano.size()-1<jug)
				valorMano.add(new ArrayList<Integer>());
			if(manosUsadas.get(jug)[mano]==0 )
			{	
				String jugada=concatena(jugador.get(jug)[mano], board);
				valorJugada.get(jug).add(procesar.procesarBestHand(jugada));
				valorMano.get(jug).add(procesar.valorMano(jugada));
			}
			else
			{
				valorJugada.get(jug).add(0);
				valorMano.get(jug).add(0);
			}
			if(mano>=jugador.get(jug).length-1)
			{
				calculaManos(jug+1, 0);
			}
			else
			{
				calculaManos(jug, mano+1);
			}
		}		
	}
	//Concatena dos String cad1(mano) y cad2(board)
	private String concatena(String cad1,String cad2)
	{
		return new StringBuilder().append(cad1).append(cad2).toString();
	}
	
	/*-------------------------------Funciones de muestra de datos------------------------------*/
	//Muestra los resultados de las manos
	private void muestraValorManos()
	{
		System.out.println("Board: " +board);
		System.out.println("Valor Jugada:");
		for(int x=0; x<valorJugada.size();x++)
		{
			System.out.print("Jugador "+x+": ");
			for(int i=0; i<valorJugada.get(x).size();i++)
			{
				System.out.print(valorJugada.get(x).get(i)+" ");
			}
			System.out.print("\n");
		}
		System.out.println("Valor Mano:");
		for(int x=0; x<valorMano.size();x++)
		{
			System.out.print("Jugador "+x+": ");
			for(int i=0; i<valorMano.get(x).size();i++)
			{
				System.out.print(valorMano.get(x).get(i)+" ");
			}
			System.out.print("\n");
		}
	}
}

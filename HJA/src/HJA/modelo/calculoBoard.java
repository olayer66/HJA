package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.ArrayUtils;

public class calculoBoard implements Callable<Integer[]> 
{
	private Integer [] puntos;
	private ArrayList <String[]> jugadores;
	private ArrayList <int[]> manosUsadas;
	private String board;
	private ArrayList<ArrayList<Integer>> valorJugada;
	private ArrayList<ArrayList<Integer>> valorMano;
	private ProcesarMano procesar;
	//Constructor
	public calculoBoard(ArrayList <String[]> jug,ArrayList <int[]> usadas,String brd) 
	{
		jugadores=jug;
		manosUsadas=usadas;
		board=brd;
		puntos=new Integer[jugadores.size()];
		Arrays.fill(puntos, 0);
		procesar = new ProcesarMano();
		valorJugada= new ArrayList<ArrayList<Integer>>();
		valorMano= new ArrayList<ArrayList<Integer>>();
	}
	public Integer[] call()
	{
		int[] mano= new int[jugadores.size()];
		//eliminamos las manos no jugables
		eliminaManos(0,0);
		calculaResultados(0, 0);
		//calcular(mano);
		return puntos;
	}
	private void calcular(int[] mano)
	{
		// Calculamos los puntos
		//Llamadas recursivas cambiando de pareja	
		if(mano[0]!=jugadores.get(0).length)
		{
			
		}
	}
	
	
	/*-------------------------Metodos varios-------------------------------*/
	//Concatena dos String cad1(mano) y cad2(board)
	private String concatena(String cad1,String cad2)
	{
		return new StringBuilder().append(cad1).append(cad2).toString();
	}
	//Elimina las manos no jugables
	private void eliminaManos(int jug, int mano)
	{
		if(manosUsadas.get(jug).length>mano)
		{
			if(manosUsadas.get(jug)[mano]==1 )
			{
				jugadores.set(jug,ArrayUtils.remove(jugadores.get(jug), mano));
				manosUsadas.set(jug,ArrayUtils.remove(manosUsadas.get(jug), mano));
			}
		}
		if(jug!=jugadores.size()-1)
		{
			if(mano>=jugadores.get(jug).length-1)
			{
				eliminaManos(jug+1, 0);
			}
			else
			{
				eliminaManos(jug, mano+1);
			}
		}		
	}
	private void calculaResultados(int jug, int mano)
	{
		if(jugadores.get(jug).length!=0)
		{
			if(valorJugada.size()-1<jug)
				valorJugada.add(new ArrayList<Integer>());
			if(valorMano.size()-1<jug)
				valorMano.add(new ArrayList<Integer>());
			String jugada=concatena(jugadores.get(jug)[mano], board);
			valorJugada.get(jug).add(procesar.procesarBestHand(jugada));
			valorMano.get(jug).add(procesar.valorMano(jugada));
		}
		if(jug!=jugadores.size()-1)
		{
			if(mano>=jugadores.get(jug).length-1)
			{
				calculaResultados(jug+1, 0);
			}
			else
			{
				calculaResultados(jug, mano+1);
			}
		}		
	}
}

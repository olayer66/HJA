package HJA.modelo;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class calculoBoard implements Callable<Integer[]> 
{
	private Integer [] puntos;
	private ArrayList <String[]> jugadores;
	private ArrayList <int[]> manosUsadas;
	private String board;
	private int[] valorJugada;
	private int[] valorMano;
	
	//Constructor
	public calculoBoard(ArrayList <String[]> jug,ArrayList <int[]> usadas,String brd) 
	{
		jugadores=jug;
		manosUsadas=usadas;
		board=brd;
		puntos=new Integer[jugadores.size()];
	}
	public Integer[] call()
	{
		Integer[] aux={1,0};
		return aux;
	}
	private void calcular()
	{
		
	}
	/*-------------------------Metodos varios-------------------------------*/
	//Concatena dos String cad1(mano) y cad2(board)
	private String concatena(String cad1,String cad2)
	{
		return new StringBuilder().append(cad1).append(cad2).toString();
	}
}

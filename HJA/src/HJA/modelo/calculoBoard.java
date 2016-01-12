package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class calculoBoard implements Callable<Float[]> 
{
	private Float [] puntos;
	private ArrayList <String[]> jugador;
	private ArrayList<ArrayList<Integer>> valorJugada;
	private ArrayList<ArrayList<Integer>> valorMano;
	//Constructor
	public calculoBoard(ArrayList <String[]> jug,ArrayList<ArrayList<Integer>> vJugada,ArrayList<ArrayList<Integer>> vMano) 
	{
		jugador=jug;
		puntos=new Float[jugador.size()];
		Arrays.fill(puntos, Float.valueOf("0"));
		valorJugada= vJugada;
		valorMano= vMano;
	}
	public Float[] call()
	{
		switch (jugador.size()) {
		case 2:
			calcular(0,0);
			break;
		case 3:
			calcular(0,0,0);
			break;
		case 4:
			calcular(0,0,0,0);
			break;
		case 5:
			calcular(0,0,0,0,0);
			break;
		case 6:
			calcular(0,0,0,0,0,0);
			break;
		case 7:
			calcular(0,0,0,0,0,0,0);
			break;
		case 8:
			calcular(0,0,0,0,0,0,0,0);
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		default:
			break;
		}
		return puntos;
	}
	private void calcular(int jug1,int jug2)
	{
		if(jug1<jugador.get(0).length && jug2<jugador.get(1).length)
		{
			//comprobacion
			if(valorJugada.get(0).get(jug1)!=0 && valorJugada.get(1).get(jug2)!=0)
			{
				if(valorJugada.get(0).get(jug1) > valorJugada.get(1).get(jug2))
					puntos[0]++;
				else if(valorJugada.get(0).get(jug1) < valorJugada.get(1).get(jug2))
					puntos[1]++;
				else if (valorMano.get(0).get(jug1) > valorMano.get(1).get(jug2))
					puntos[0]++;
				else if (valorMano.get(0).get(jug1) < valorMano.get(1).get(jug2))
					puntos[1]++;
				else
				{
					puntos[0]++;
					puntos[1]++;
				}
			}
			//recursividad
			if(jug2==jugador.get(1).length-1)
			{
				calcular(jug1+1, 0);
			}
			else
			{
				calcular(jug1, jug2+1);
			}
		}
	}
	private void calcular(int jug1,int jug2,int jug3)
	{
		int valor1,valor2,valor3;
		int valorM1,valorM2,valorM3;
		if(jug1<jugador.get(0).length && jug2<jugador.get(1).length && jug3<jugador.get(2).length)
		{
			valor1=valorJugada.get(0).get(jug1);
			valor2=valorJugada.get(1).get(jug2);
			valor3=valorJugada.get(2).get(jug3);
			valorM1= valorMano.get(0).get(jug1);
			valorM2= valorMano.get(1).get(jug2);
			valorM3= valorMano.get(2).get(jug3);
			//comprobacion
			if(valor1!=0 && valor2!=0 && valor3!=0)
			{
				if(valor1 > valor2 && valor1 > valor3)
					puntos[0]++;
				else if(valor2 > valor1 && valor2 > valor3)
					puntos[1]++;
				else if (valor3 > valor1 && valor3 > valor2)
					puntos[2]++;
				else if (valor1 == valor2 && valor1 > valor3)
					calculoDos(valorM1, valorM2, 0, 1);
				else if (valor1 == valor3 && valor1 > valor2)
					calculoDos(valorM1, valorM3, 0, 2);
				else if (valor2 == valor3 && valor2 > valor1)
					calculoDos(valorM2, valorM3, 1, 2);
				else
				{
					calculoTres(valorM1, valorM2, valorM3, jug1, jug2, jug3);
				}
			}
			//recursividad
			if(jug3!=jugador.get(2).length-1)
			{
				calcular(jug1, jug2,jug3+1);
			}
			else if(jug2!=jugador.get(1).length-1 && jug3==jugador.get(2).length-1)
			{
				calcular(jug1, jug2+1,0);
			}
			else if(jug2==jugador.get(1).length-1 && jug3==jugador.get(2).length-1)
			{
				calcular(jug1+1,0,0);
			}
			
		}
	}
	private void calcular(int jug1,int jug2, int jug3, int jug4)
	{		
	}
	private void calcular(int jug1,int jug2, int jug3, int jug4, int jug5)
	{		
	}
	private void calcular(int jug1,int jug2, int jug3, int jug4,int jug5,int jug6)
	{		
	}
	private void calcular(int jug1,int jug2, int jug3, int jug4,int jug5,int jug6, int jug7)
	{	
	}
	private void calcular(int jug1,int jug2, int jug3, int jug4,int jug5,int jug6, int jug7, int jug8)
	{
	}
	//------------------------funciones de calculo -----------------//
	//Metodos que calculan el ganador dados los valores y a quien pertenecen
	private void calculoDos( int valor1, int valor2,int jug1, int jug2)
	{
		if(valor1>valor2)
			puntos[jug1]++;
		else if(valor1<valor2)
			puntos[jug2]++;
		else
		{
			puntos[jug1]++;
			puntos[jug2]++;
		}
	}
	private void calculoTres(int valor1, int valor2,int valor3,int jug1, int jug2, int jug3)
	{
		if(valor1 > valor2 && valor1 > valor3)
			puntos[0]++;
		else if(valor2 > valor1 && valor2 > valor3)
			puntos[1]++;
		else if (valor3 > valor1 && valor3 > valor2)
			puntos[2]++;
		else if (valor1 == valor2 && valor1 > valor3)
			calculoDos(valor1, valor2, jug1, jug2);
		else if (valor1 == valor3 && valor1 > valor2)
			calculoDos(valor1, valor3, jug1, jug3);
		else if (valor2 == valor3 && valor2 > valor1)
			calculoDos(valor2, valor3, jug2, jug3);
		else
		{
			puntos[0]++;
			puntos[1]++;
			puntos[2]++;
		}
	}
}

package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class calculoBoard implements Callable<Float[]> 
{
	private Float [] puntos;
	private ArrayList <String[]> jugador;
	private ArrayList<int[]> valorJugada;
	private ArrayList<int[]> valorMano;
	//Constructor
	public calculoBoard(ArrayList <String[]> jug,ArrayList<int[]> vJugada,ArrayList<int[]> vMano) 
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
			if(valorJugada.get(0)[jug1]!=0 && valorJugada.get(1)[jug2]!=0)
			{
				if(valorJugada.get(0)[jug1] > valorJugada.get(1)[jug2])
					puntos[0]++;
				else if(valorJugada.get(0)[jug1] < valorJugada.get(1)[jug2])
					puntos[1]++;
				else if (valorMano.get(0)[jug1] > valorMano.get(1)[jug2])
					puntos[0]++;
				else if (valorMano.get(0)[jug1] < valorMano.get(1)[jug2])
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
		int[] valor=new int[3];
		int[] valorM=new int[3];
		int[] jug=new int[3];
		if(jug1<jugador.get(0).length && jug2<jugador.get(1).length && jug3<jugador.get(2).length)
		{
			valor[0]=valorJugada.get(0)[jug1];
			valor[1]=valorJugada.get(1)[jug2];
			valor[2]=valorJugada.get(2)[jug3];
			valorM[0]= valorMano.get(0)[jug1];
			valorM[1]= valorMano.get(1)[jug2];
			valorM[2]= valorMano.get(2)[jug3];
			jug[0]=jug1;
			jug[1]=jug2;
			jug[2]=jug3;
			//comprobacion
			if(valor[0]!=0 && valor[1]!=0 && valor[2]!=0)
			{
				if(valor[0] > valor[1] && valor[0] > valor[2])
					puntos[0]++;
				else if(valor[1] > valor[0] && valor[1] > valor[2])
					puntos[1]++;
				else if (valor[2] > valor[0] && valor[2] > valor[1])
					puntos[2]++;
				else
				 calculoTres(valor, valorM, jug, false);
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
	private void calculoDos(int valor[],int valorMano[],int[]jug ,boolean mano)
	{
		if(valor[jug[0]]==valor[jug[1]] && mano==false)
		{
			calculoDos(valorMano, valor, jug, true);
		}
		else if(valor[jug[0]]==valor[jug[1]] && mano==true)
		{
			puntos[jug[0]]++;
			puntos[jug[1]]++;
		}
		else
		{
			if(valor[jug[0]]>valor[jug[1]])
				puntos[jug[0]]++;
			else
				puntos[jug[1]]++;
		}
	}
	private void calculoTres(int valor[],int valorMano[],int[] jug ,boolean mano)
	{
		int[] j= new int[2];
		if(valor[jug[0]]==valor[jug[1]] && valor[jug[1]]==valor[jug[2]] && mano==false)
		{
			calculoTres(valorMano, valor,jug, true);
		}
		else if(valor[jug[0]]==valor[jug[1]] && valor[jug[1]]==valor[jug[2]] && mano==true)
		{
			puntos[jug[0]]++;
			puntos[jug[1]]++;
			puntos[jug[2]]++;
		}
		else
		{
			j[0]=0;
			j[1]=1;
			calculoDos(valor, valorMano, j, false);
			j[0]=1;
			j[1]=2;
			calculoDos(valor, valorMano, j, false);
			j[0]=0;
			j[1]=2;
			calculoDos(valor, valorMano, j, false);
		}
	}
}

package HJA.modelo;

import java.util.ArrayList;

public class profesor 
{
	private ProcesarMano procesar;
	private String mano;
	public int calculaEquity(ArrayList<String> jugadores, ArrayList<String> mesa)
	{
		procesar = new ProcesarMano();
		StringBuilder manoJug1 = new StringBuilder();
		StringBuilder manoJug2 = new StringBuilder();
		int[] valorMano= new int[2];
		int[] valorJugada= new int[2];
		int ganador=0;
		manoJug1.append(jugadores.get(0)).append(jugadores.get(1));
		manoJug2.append(jugadores.get(2)).append(jugadores.get(3));
		valorMano[0]=procesar.valorMano(manoJug1.toString());
		valorMano[1]=procesar.valorMano(manoJug2.toString());
		manoJug1.append(String.join("", mesa));
		manoJug2.append(String.join("", mesa));
		valorJugada[0]=procesar.procesarBestHand(manoJug1.toString());
		valorJugada[1]=procesar.procesarBestHand(manoJug2.toString());
		//Preflow
		if(mesa.size()!=0)	
		{
			if(valorJugada[0]>valorJugada[1])
				ganador= 1;
			else if(valorJugada[0]<valorJugada[1])
				ganador= 2;
			else
			{
				if(valorMano[0]>valorMano[1])
					ganador=1;
				else if(valorMano[0]<valorMano[1])
					ganador=2;
				else
					ganador=0;
			}		
		}
		else
		{
			if(valorMano[0]>valorMano[1])
				ganador=1;
			else if(valorMano[0]<valorMano[1])
				ganador=2;
			else
				ganador=0;
		}
		mano= calculaMano(valorJugada[0]);
		return ganador;
	}
	private String calculaMano(int valorJugada)
	{
		ParseJugadas parser= new ParseJugadas();
		int num= valorJugada/100;
		return parser.intToHand(num);
	}
	public String getMano() {
		return mano;
	}
	//Devuelve la mano que se tiene para flop, turn y river
	public String calculaValorMano(String mano)
	{
		procesar = new ProcesarMano();
		return calculaMano(procesar.procesarBestHand(mano));
	}
	
}


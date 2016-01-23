package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class procesarJugada {

	private int rango; // 0->MA, 1->janda
	private String mano;
	private int posicion;
	private int accion; // 0->OR, 1->fold

	public procesarJugada(String[] datos){
		rango = Integer.valueOf(datos[0]);
		ParseCartas parse = new ParseCartas();
		mano = parse.manoToRango(datos[1]);
		posicion = Integer.valueOf(datos[2]);
		accion = Integer.valueOf(datos[3]);
	}
	public boolean evaluarJugada(){
		ArrayList<String> pares = new ArrayList<String>();
		//MA
		if(rango==0){
			if(posicion==1){//BB
				if(accion==0)return true;
				else return false;
			}else pares=evaluarMa();
		//JANDA
		}else if(rango==1){
			if(posicion==1){//BB
				if(accion==0)return true;
				else return false;
			}else pares=evaluarJanda();
		}	
		if(pares.contains(mano))
		{
			if(accion==0)
				return true;
			else 
				return false;
		}else
		{
			if(accion==0)
				return false;
			else 
				return true;
		}
	}
	
	//Devuelve array con los pares de cartas del rango Janda segun la posicion
	public ArrayList<String> evaluarJanda(){
		String rangoJanda="";
		if(posicion==0)//SB
			rangoJanda="22+,A2s+,K2s+,Q8s+,J9s+,A2o+,K4o+,Q9o+,JTo";
		else if (posicion==2)//UTG
			rangoJanda="44+,A4s+,KJs+,A8o+";	
		else if(posicion==3)//MP
			rangoJanda="33+,A2s+,KTs+,A7o+,A5o,KQo";
		else if(posicion==4)//CO
			rangoJanda="22+,A2s+,K8s+,QTs+,A2o+,KTo+";
		else{//BTN
			rangoJanda="22+,A2s+,K2s+,Q2s+,J4s+,T7s+,98s,A2o+,K2o+,Q4o+,J7o+,T9o";
		}
		transformarString trans = new transformarString(rangoJanda);
		return new ArrayList<String>(Arrays.asList(trans.procesarString()));
	}
	
	//Devuelve array con los pares de cartas del rango Ma segun la posicion
	public ArrayList<String> evaluarMa(){
		String rangoMa="";
		if(posicion==0)//SB
			rangoMa="22+,A2s+,K2s+,Q2s+,J2s+,T2s+,92s+,82s+,73s+,63s+,53s+,43s,A2o+,K2o+,Q2o+,J2o+,T2o+,92o+,84o+,74o+,65o";
		else if (posicion==2)//UTG
			rangoMa="88+,AJs+,KQs,AQo+";	
		else if(posicion==3)//MP
			rangoMa="77+,AJo+,KQo,ATs+,KQs";
		else if(posicion==4)//CO
			rangoMa="22+,A2s+,K4s+,Q9s+,JTs,A2o+,K7o+,QTo";
		else{//BTN
			rangoMa="22+,A2s+,K2s+,Q2s+,J3s+,T6s+,97s+,A2o+,K2o+,Q2o+,J7o+,T8o+";
		}
		transformarString trans = new transformarString(rangoMa);
		return new ArrayList<String>(Arrays.asList(trans.procesarString()));
	}
}

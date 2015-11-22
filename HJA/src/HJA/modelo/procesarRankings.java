package HJA.modelo;

import java.util.ArrayList;

public class procesarRankings {

	public procesarRankings(){
		
	}
	
	/*
	 1326 combinaciones
	 169 pares de cartas
	 Parejas = 6 combinaciones
	 Suited = 4 combinaciones
	 Offsuited = 12 combinaciones
	 Rango:
	 	-0 -> Chubukov
	 */
	public String[] porcentajeToRango(double porcentaje, int rango){
	double combinacionesT, comb=0;
	String[] ordenPares = null;
	int i=0;
	boolean salir =false;
	char[] aux;
	ArrayList<String> resultado = new ArrayList<String>();
	String par="";
	if(rango==0)
		ordenPares = rangoChubukov();
	//Crear otro rango
	
		combinacionesT = Math.ceil((porcentaje/100)*1326); //Redondeamos a lo alto

		while(i < 169 && !salir ){
			par=ordenPares[i];
			resultado.add(par);
			aux = par.toCharArray();
			if(aux.length==2){
				comb=comb+6;
			}else if(aux[2]=='s'){
				comb=comb+4;
			}else{
				comb=comb+12;
			}
			if(comb >= combinacionesT)salir=true;
			else i++;
		}
		return resultado.toArray(new String[resultado.size()]);
	}
	
	public String[] rangoChubukov(){
		String[] ordenPares = {"AA","KK","AKs","QQ","AKo","JJ","AQs","TT","AQo","99","AJs"
				  ,"88","ATs","AJo","77","66","ATo","A9s","55","A8s","KQs","44"
				  ,"A9o","A7s","KJs","A5s","A8o","A6s","A4s","33","KTs","A7o","A3s"
				  ,"KQo","A2s","A5o","A6o","A4o","KJo","QJs","A3o","22","K9s","A2o"
				  ,"KTo","QTs","K8s","K7s","JTs","K9o","K6s","QJo","Q9s","K5s","K8o"
				  ,"K4s","QTo","K7o","K3s","K2s","Q8s","K6o","J9s","K5o","Q9o","JTo","K4o"
				  ,"Q7s","T9s","Q6s","K3o","J8s","Q5s","K2o","Q8o","Q4s","J9o","Q3s"
				  ,"T8s","J7s","Q7o","Q2s","Q6o","98s","Q5o","J8o","T9o","J6s","T7s","J5s"
				  ,"Q4o","J4s","J7o","Q3o","97s","T8o","J3s","T6s","Q2o","J2s","87s"
				  ,"J6o","98o","T7o","96s","J5o","T5s","T4s","86s","J4o","T6o","97o"
				  ,"T3s","76s","95s","J3o","T2s","87o","85s","96o","T5o","J2o","75s"
				  ,"94s","T4o","65s","86o","93s","84s","95o","T3o","76o","92s","74s","54s","T2o"
				  ,"85o","64s","83s","94o","75o","82s","73s","93o","65o","53s","63s","84o","92o"
				  ,"43s","74o","72s","54o","64o","52s","62s","83o","42s","82o","73o","53o"
				  ,"63o","32s","43o","72o","52o","62o","42o","32o"};
		return ordenPares;
	}
	
}
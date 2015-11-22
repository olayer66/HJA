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
	 	-1 -> Malmuth
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
	else if(rango == 1)
		ordenPares = rangoMalmuth();
	
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
	
	public String[] rangoMalmuth(){
		String[] ordenPares = {"AA","KK","QQ","JJ","AKs","TT","AQs","AJs","KQs","AKo","99"
				  ,"ATs","KJs","QJs","JTs","AQo","88","KTs","QTs","J9s","T9s","98s"
				  ,"AJo","KQo","77","A9s","A8s","A7s","A6s","A5s","A4s","A3s","A2s"
				  ,"Q9s","T8s","97s","87s","76s","65s","KJo","QJo","JTo","66","55","K9s"
				  ,"J8s","86s","75s","54s","ATo","KTo","QTo","44","33","22","K8s"
				  ,"K7s","K6s","K5s","K4s","K3s","K2s","Q8s","T7s","64s","53s","43s"
				  ,"J9o","T9o","98o","J7s","96s","85s","74s","42s","32s","A9o","K9o"
				  ,"Q9o","J8o","T8o","87o","76o","65o","54o","A8o","A7o","A6o","A5o","A4o"
				  ,"A3o","A2o","K8o","K7o","K6o","K5o","K4o","Q7s","K3o","Q6s","K2o"
				  ,"Q5s","Q8o","Q4s","Q3s","Q7o","Q2s","Q6o","Q5o","J6s","J5s","Q4o"
				  ,"J4s","J7o","Q3o","J3s","Q2o","T6s","J2s","J6o","T7o","J5o","T5s"
				  ,"T4s","J4o","T6o","97o","95s","T3s","J3o","96o","T2s","T5o","J2o","T4o","94s"
				  ,"86o","93s","84s","95o","T3o","92s","94o","T2o","85o","83s","82s"
				  ,"75o","93o","73s","84o","63s","92o","74o","72s","64o","62s","52s","83o"
				  ,"82o","73o","53o","63o","72o","43o","52o","62o","42o","32o"};
		return ordenPares;
	}
	
}

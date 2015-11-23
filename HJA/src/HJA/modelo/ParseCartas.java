package HJA.modelo;

public class ParseCartas {
	
	public ParseCartas(){
	}
	
	/*Relaciona una figura con un entero*/
	public int figuraToInt(char figura){
	    if(figura=='A'){
			return 12;
		}else if(figura=='K'){
			return 11;
		}else if(figura=='Q'){
			return 10;
		}else if(figura=='J'){
			return 9;
		}else if(figura=='T'){
			return 8;
		}else return Integer.parseInt(String.valueOf(figura))-2; //Convierte el char a String y de ahi a int.
	}
	
	//78
	/*Devuelve la posición del array de rangos suited o offsuited en el que se situa la primera carta del par
	 * Ejemplo: 54o
	 * el 5 corresponde a la posición 3
	 * y según figuraToInt el 4 vale 2
	 * por lo que pondremos a true la posición 3+2=5
	 * Array de offsuited: [32][42][43][52][53][54][62]... */
	public int figuraRangoToInt(char figura){
		if(figura=='3'){
			return 0;
		}else if(figura=='4'){
			return 1;
		}else if(figura=='5'){
			return 3;
		}else if(figura=='6'){
			return 6;
		}else if(figura=='7'){
			return 10;
		}else if(figura=='8'){
			return 15;
		}else if(figura=='9'){
			return 21;
		}else if(figura=='T'){
			return 28;
		}else if(figura=='J'){
			return 36;
		}else if(figura=='Q'){
			return 45;
		}else if(figura=='K'){
			return 55;
		}else return 66;		
	}
	
	public String intTofiguraRango(int posicion){
		if(posicion==0) return "32";
		else if(posicion==1) return "42";
		else if(posicion==2) return "43";
		else if(posicion==3) return "52";
		else if(posicion==4) return "53";
		else if(posicion==5) return "54";
		else if(posicion==6) return "62";
		else if(posicion==7) return "63";
		else if(posicion==8) return "64";
		else if(posicion==9) return "65";
		else if(posicion==10) return "72";
		else if(posicion==11) return "73";
		else if(posicion==12) return "74";
		else if(posicion==13) return "75";
		else if(posicion==14) return "76";
		else if(posicion==15) return "82";
		else if(posicion==16) return "83";
		else if(posicion==17) return "84";
		else if(posicion==18) return "85";
		else if(posicion==19) return "86";
		else if(posicion==20) return "87";
		else if(posicion==21) return "92";
		else if(posicion==22) return "93";
		else if(posicion==23) return "94";
		else if(posicion==24) return "95";
		else if(posicion==25) return "96";
		else if(posicion==26) return "97";
		else if(posicion==27) return "98";
		else if(posicion==28) return "T2";
		else if(posicion==29) return "T3";
		else if(posicion==30) return "T4";
		else if(posicion==31) return "T5";
		else if(posicion==32) return "T6";
		else if(posicion==33) return "T7";
		else if(posicion==34) return "T8";
		else if(posicion==35) return "T9";
		else if(posicion==36) return "J2";
		else if(posicion==37) return "J3";
		else if(posicion==38) return "J4";
		else if(posicion==39) return "J5";
		else if(posicion==40) return "J6";
		else if(posicion==41) return "J7";
		else if(posicion==42) return "J8";
		else if(posicion==43) return "J9";
		else if(posicion==44) return "JT";
		else if(posicion==45) return "Q2";
		else if(posicion==46) return "Q3";
		else if(posicion==47) return "Q4";
		else if(posicion==48) return "Q5";
		else if(posicion==49) return "Q6";
		else if(posicion==50) return "Q7";
		else if(posicion==51) return "Q8";
		else if(posicion==52) return "Q9";
		else if(posicion==53) return "QT";
		else if(posicion==54) return "QJ";
		else if(posicion==55) return "K2";
		else if(posicion==56) return "K3";
		else if(posicion==57) return "K4";
		else if(posicion==58) return "K5";
		else if(posicion==59) return "K6";
		else if(posicion==60) return "K7";
		else if(posicion==61) return "K8";
		else if(posicion==62) return "K9";
		else if(posicion==63) return "KT";
		else if(posicion==64) return "KJ";
		else if(posicion==65) return "KQ";
		else if(posicion==66) return "A2";
		else if(posicion==67) return "A3";
		else if(posicion==68) return "A4";
		else if(posicion==69) return "A5";
		else if(posicion==71) return "A6";
		else if(posicion==72) return "A7";
		else if(posicion==73) return "A8";
		else if(posicion==74) return "A9";
		else if(posicion==75) return "AT";
		else if(posicion==76) return "AJ";
		else if(posicion==77) return "AQ";
		else return "AK";
	}
	
	/*Relaciona un entero con una figura*/
	public String intToFigura(int posicion){
		if(posicion == 12){
			return "A";
		}else if(posicion==11){
			return "K";
		}else if(posicion==10){
			return "Q";
		}else if(posicion==9){
			return "J";
		}else if(posicion == 8){
			return "T";
		}else return String.valueOf(posicion+2);
	}
	
	/*Dado una mano del estilo KhQc lo convierte a KQo*/
	public String manoToRango(String mano){
		char[] aux=mano.toCharArray();
		StringBuilder resultado = new StringBuilder();
		char figura1=aux[0], figura2=aux[2];
		//Pareja
		if(figura1==figura2){
			resultado.append(String.valueOf(figura1));
			resultado.append(String.valueOf(figura1));
		}else{
			//Suited
			if(aux[1]==aux[3]){
				resultado.append(String.valueOf(figura1));
				resultado.append(String.valueOf(figura2));
				resultado.append("s");
			//Offsuited
			}else{
				resultado.append(String.valueOf(figura1));
				resultado.append(String.valueOf(figura2));
				resultado.append("o");	
			}
		}
		return resultado.toString();
	}

}

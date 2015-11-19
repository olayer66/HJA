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

}

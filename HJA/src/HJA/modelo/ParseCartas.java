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

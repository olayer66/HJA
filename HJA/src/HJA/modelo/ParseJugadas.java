package HJA.modelo;

public class ParseJugadas {
	
	
	public ParseJugadas(){

	}
	
	/*Relaciona un entero con una jugada*/
	public String intToHand(int posicion){
		if(posicion==8){
			return "Straight Flush";
		}else if(posicion == 7){
			return "Four-of-a-kind";
		}else if(posicion == 6){
			return "Full house";
		}else if(posicion == 5){
			return "Flush";
		}else if(posicion == 4){
			return "Straight";
		}else if(posicion == 3){
			return "Three-of-a-kind";
		}else if(posicion == 2){
			return "Two-pair";
		}else if(posicion == 1){
			return "Pair";
		}else{
			return "High card";
		}
	}
	
	/*Relaciona una jugada con un entero*/
	public int handToInt(char hand){
		if(hand=='A'){
			return 8;
		}else if(hand=='B'){
			return 7;
		}else if(hand=='C'){
			return 6;
		}else if(hand=='D'){
			return 5;
		}else if(hand=='E'){
			return 4;
		}else if(hand=='F'){
			return 3;
		}else if(hand=='G'){
			return 2;
		}else if(hand=='H'){
			return 1;
		}else{
			return 0;
		}
	}
}

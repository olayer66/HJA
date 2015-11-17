package HJA.modelo;

import java.util.ArrayList;

public class transformarString {

	private String cadena;
	private char[] arrayCartas;
	private ArrayList<String> lista;
	private ParseCartas parse;
	
	public transformarString(String cadena){
		this.cadena=cadena;
		lista=new ArrayList<String>();
		parse = new ParseCartas();
		arrayCartas = new char[13];
		arrayCartas[0]='2';
		arrayCartas[1]='3';
		arrayCartas[2]='4';
		arrayCartas[3]='5';
		arrayCartas[4]='6';
		arrayCartas[5]='7';
		arrayCartas[6]='8';
		arrayCartas[7]='9';
		arrayCartas[8]='T';
		arrayCartas[9]='J';
		arrayCartas[10]='Q';
		arrayCartas[11]='K';
		arrayCartas[12]='A';
		
	}
	
	public String procesarString(){
		String resultado="";
		String[] aux = cadena.split(",");
		boolean encontradoPar=false;
		char[] cartas;
		char palo;
		int valMax, valMin, val1, val2;
		for(int i=0; i<aux.length; i++){
			cartas=aux[i].toCharArray();
			//Es una pareja
			if(cartas.length==2){
				lista.add(aux[i]);
			}else if(cartas.length ==3){
				//Es una pareja con +
				if(cartas[2]=='+'){
					for(int j=0; j< arrayCartas.length;j++){
						if(cartas[0]==arrayCartas[j]){
							encontradoPar=true;
						}
						if(encontradoPar){
							lista.add(String.valueOf(arrayCartas[j])+String.valueOf(arrayCartas[j]));
						}
					}
				//Dos cartas distintas 
				}else lista.add(aux[i]);
			//Dos cartas distintas con +	
			}else if(cartas.length ==4){
				val1=parse.figuraToInt(cartas[0]);
				val2=parse.figuraToInt(cartas[1]);
				palo=cartas[2];
			if(val1>val2){
				valMax=val1;
				valMin=val2;
			}else{
				valMax=val2;
				valMin=val1;
			}
			for(int j=valMin; j<valMax;j++){
				lista.add(String.valueOf(arrayCartas[valMin])+String.valueOf(arrayCartas[j])+String.valueOf(palo));
			}
			//Rango de cartas
			}else{
				
			}
		}
		return resultado;
	}
	
}

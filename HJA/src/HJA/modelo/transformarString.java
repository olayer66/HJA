package HJA.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class transformarString {

	private String cadena;
	private char[] arrayCartas;
	private ParseCartas parse;
	
	public transformarString(String cadena){
		this.cadena=cadena;
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
	
	public String[] procesarString(){
		String[] aux = cadena.split(",");
		String[] resultado;
		boolean encontradoPar=false;
		char[] cartas;
		char palo;
		int valMax, valMin;
		ArrayList<String> lista=new ArrayList<String>();
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
				valMax=parse.figuraToInt(cartas[0]);
				valMin=parse.figuraToInt(cartas[1]);
				palo=cartas[2];
			for(int j=valMin; j<valMax;j++){
				lista.add(String.valueOf(arrayCartas[valMax])+String.valueOf(arrayCartas[j])+String.valueOf(palo));
			}
			//Rango de cartas pares(JJ-33)
			}else if(cartas.length==5){
				valMax=parse.figuraToInt(cartas[0]);
				valMin=parse.figuraToInt(cartas[3]);
				for(int j=valMin; j<=valMax;j++){
					lista.add(String.valueOf(arrayCartas[j])+String.valueOf(arrayCartas[j]));
				}
			//Rango de cartas sueltas(A7o-A2o)
			}else{
				palo=cartas[2];
				valMax=parse.figuraToInt(cartas[1]);
				valMin=parse.figuraToInt(cartas[5]);
				for(int j=valMin; j<=valMax;j++){
					lista.add(String.valueOf(cartas[0])+String.valueOf(arrayCartas[j])+String.valueOf(palo));
				}		
			}
		}
		resultado=crearResultado(lista);
		return resultado;
	}
	
	public String[] crearResultado(ArrayList<String> lista){
		int i=0;
		//Quitamos los elementos repetidos del arrayList
		HashSet hash = new HashSet();
		hash.addAll(lista);
		Iterator iterator = hash.iterator(); //Lo usamos para recorrer el hashSet
		String[] resultado = new String[hash.size()];
		while(iterator.hasNext()){
			resultado[i]=String.valueOf(iterator.next());
			i++;
		}
		return resultado;
	}
	

	
}

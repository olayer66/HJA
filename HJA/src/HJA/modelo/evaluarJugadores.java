package HJA.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class evaluarJugadores {
	
	private String board;
	private String descartes;
	private String[] rangos;
	private float[] equitys;
	
	public evaluarJugadores(String board, String descartes, String[] rangos) {
		this.board = board;
		this.descartes = descartes;
		this.rangos = rangos;
		this.equitys = new float[this.rangos.length];
	}
	
	
	public void calcularEquitys(){
		String[] cartas={"Ah","Kh","Qh","Jh","Th","9h","8h","7h","6h","5h","4h","3h","2h","Ad","Kd","Qd","Jd","Td","9d","8d","7d","6d","5d","4d","3d","2d","Ac","Kc","Qc","Jc","Tc","9c","8c","7c","6c","5c","4c","3c","2c","As","Ks","Qs","Js","Ts","9s","8s","7s","6s","5s","4s","3s","2s"};
		ParseCartas parse = new ParseCartas();
		String[] cartasJugadores;
		String[] aux1, aux2;
		String sb1, sb2;
		StringBuilder sbAux1, sbAux2;
		StringBuilder sboard;
		int valorMano1,valorJugada1, valorMano2,valorJugada2, combinaciones=0;
		ProcesarMano proc;
		ArrayList<String> boardList = new ArrayList<String>(Arrays.asList(cartas));
		ArrayList<String[]> listaCartas = new ArrayList<String[]>();
		double[] puntos = new double[rangos.length];
		
		 long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		  TInicio = System.currentTimeMillis();
		  
		//Convertimos todos los rangos a cartas
		for(int i=0 ; i<rangos.length; i++){
			transformarString trans = new transformarString(rangos[i]);
			cartasJugadores = parse.allCombinaciones(trans.procesarString());
			listaCartas.add(cartasJugadores);
		}
		

		aux1 = listaCartas.get(0);
		for(int k=0; k<aux1.length ;k++){
		      sb1=aux1[k];
		      boardList.remove(sb1.substring(0, 2));
		      boardList.remove(sb1.substring(2, 4));
		      
		      for(int z=1; z<listaCartas.size();z++){
		    	 aux2 = listaCartas.get(z);
		    	 for(int w=0; w<aux2.length; w++){
		    		  sb2=aux2[w];
				      boardList.remove(sb2.substring(0, 2));
				      boardList.remove(sb2.substring(2, 4));

		    		 //Creamos todas las combinaciones de mesa posibles
		    		 ICombinatoricsVector<String> initialVector = Factory.createVector(boardList);
		    		 Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 5);
		    		 for (ICombinatoricsVector<String> combination : gen) {
		    			  sboard= new StringBuilder();
					      List<String> lista = combination.getVector(); //Board guardada en una lista
					      for (String s : lista)
					    	  sboard.append(s);
					      
					      sbAux1= new StringBuilder();
					      sbAux1.append(sb1);
					      sbAux1.append(sboard.toString());  
					      proc = new ProcesarMano();
					      valorJugada1=proc.procesarBestHand(sbAux1.toString());
					      valorMano1=proc.valorMano(sbAux1.toString());
						  				  
						  sbAux2= new StringBuilder();
						  sbAux2.append(sb2);
					      sbAux2.append(sboard); 
						  proc = new ProcesarMano();
					      valorJugada2=proc.procesarBestHand(sbAux2.toString());
					      valorMano2=proc.valorMano(sbAux2.toString());
						  combinaciones++;	

							 if(valorJugada1 > valorJugada2)
								 puntos[0]++;
							 else if(valorJugada1 < valorJugada2)
								 puntos[z]++;
							 else {
								 if (valorMano1>valorMano2)
									 puntos[0]++;
								 else puntos[z]++;
							 }
					   } 
		    		 boardList = new ArrayList<String>(Arrays.asList(cartas));
				    	boardList.remove(aux1[k]);
		    	 }
		    	
		      }
		      
		      boardList = new ArrayList<String>(Arrays.asList(cartas));
		}
		double a=(puntos[0]/(puntos[0]+puntos[1]))*100;
		double b=(puntos[1]/(puntos[0]+puntos[1]))*100;
		double c=puntos[0]+puntos[1];
		 System.out.println("Equity - Jugador 1 -> " + Math.round(a) +"%");
		 System.out.println("Equity - Jugador 2 -> " + Math.round(b) +"%");
		 System.out.println("Comprobaciones totales -> " + combinaciones);
		 
		 TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		  tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		  System.out.println("Tiempo de ejecución en segundos: " + tiempo/1000); //Mostramos en pantalla
	}
	
	

}

package HJA.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class ProcesarMano {
	

	public ProcesarMano(){}
	

/*Explicación de función procesarBestHand:
   -Recorre el array de la mano, 
	   1. Si en la posición del array hay un valor > 1000, significa que
	      hay 4 palos es decir que hay poker (4 cartas con la misma figura). Si hay poker guardaremos
	      en un String las cartas que lo forman para posteriormente en el caso de que no exista escalera de color
	      sea esta la jugada más alta.
	   2. Si el valor es > 100, significa que hay un trio, puede darse caso de que anteriormente haya salido poker ya que
	   	  el máximo de cartas que vamos a comparar es 7 (2 de la mano + 5 de la mesa) En este caso no hariámos nada ya que trio 
	   	  es una jugada inferior. Si no ha salido poker miramos si ha salido anteriormente una pareja si es así tendriamos full.
	   3. Si el valor es > 10, significa que hay una pareja. Si anteriormente ha salido poker o full no hacemos nada si no es el caso
	   	  miramos si ha salido trio si es así tendriamos full, si no ha salido trio miramos si ha salido una pareja si ha salido tendríamos
	   	  doble pareja, en caso de que tampoco haya salido tendriamos simplemente una pareja
	   4. Si el valor es != 0, significa que tenemos una carta suelta guardaremos su valor para que en caso de que no exista ninguna jugada
	   	  sea esta la carta alta.
	   5. En todas las jugadas menos en el poker iremos guardando los palos que salen para comprobar posteriormente si hay color.
	   	  Los guardamos en un array de enteros en el que cada posición se corresponde a un palo, si hay una posición que valga 5 o más
	   	  significaria que han salido cinco cartas de igual palo por lo que habría color.
	   6. Para gestionar la escalera guardamos cada palo que salga en un array en el que cada posición corresponde a una figura
	   	  La primera posición corresponde al as y la última al as también (Se pueden formar escaleras A,2,3,4,5...T,J,Q,K,A).
	   7. Una vez recorridas todas las cartas comprobamos si existe color, escalera y escalera de color. Una vez realizada todas las
	   	  comprobaciones nos quedaremos con la jugada más alta retornandola en un String con las cartas correspondientes que la forman.
	Explicación de variables relevantes:
	   -arrayColor: Cada posición corresponde a un palo, ayuda a ver si hay color. (0)h,(1)d,(2)c,(3)s.
	   -arrayEscalera: Cada posición corresponde a una figura nos ayuda a ver si hay escalera. A,2,3,4,5,6,7,8,9,T,J,Q,K,A
	   -palo: Lo usamos para guardar cada palo/os de la posición (figura) correspondiente.
	   -paloAux: En caso de color será esta variable la que contenga el palo que forma dicha jugada.
	   -Variables booleanas: Irán cambiando en función de si existe la jugada o hay otra jugada más alta que las supere.
 */
	public int procesarBestHand(String mano){
		
		int[] arrayColor=new int[4]; 
		int[] arrayEscalera= new int[14];
		String cartaAlta ="",esc="",escColor="";
		String[] arrayEsc;
		int palo, paloAux=0, valorJugada = 0, valorEsc = 0, valorColor = 0, posicion = 0, paloIni=0;
		boolean poker=false, full=false,trio=false,pareja=false,color=false,cAlta=true, escalera=false, escaleraColor=false, impar=false;
		ParseCartas parseCartas = new ParseCartas();
		char[] aux = mano.toCharArray();
		int[] arrayMano = transformarMano(mano);
		
		for(int i=0; i<arrayMano.length ;i++){
			palo=arrayMano[i];
			//Poker
			if(palo >1000){
			valorJugada=0;
			valorJugada = valorJugada +(i*4);
			valorJugada = valorJugada +(7*100); 
			poker=true;
			full=false;
			cAlta=false;
			//Trio
			}else if(palo >100){
				if(!poker&&!full){
					//Full
					if(pareja){
						valorJugada = valorJugada +(i*3);
						valorJugada = valorJugada +(6*100); 
						pareja = false;
						full=true;
					}else{
						valorJugada=0;
						valorJugada = valorJugada +(i*3);
						trio=true;
						arrayColor[palo%10-1]++;
						arrayColor[((palo/10)/10)-1]++;
						arrayColor[((palo/10)%10)-1]++;
						if(i==12){
						arrayEscalera[0]=palo;
						}
						arrayEscalera[i+1]=palo;
					cAlta=false;
					}
				}
			//Pareja
			}else if(palo>10){
				if(!poker&&!full){
					//Full
					if(trio){
						valorJugada = valorJugada +(i*2);
						valorJugada = valorJugada +(6*100); 
						trio = false;
						full=true;
					}
					//Doble Pareja
					else if(pareja){
						valorJugada = valorJugada +(i*2);
						valorJugada = valorJugada +(2*100); 
						pareja=false;
					}else{ 
						valorJugada=0;
						valorJugada = valorJugada +(i*2);
						pareja=true;
					}
				arrayColor[(palo/10)-1]++;
				arrayColor[(palo%10)-1]++;
				if(i==12){
					arrayEscalera[0]=palo;
					}
					arrayEscalera[i+1]=palo;
				cAlta=false;
				}
			}else if(palo != 0){
				if(i==12){
					arrayEscalera[0]=palo;
					}
					arrayEscalera[i+1]=palo;
				//Carta Alta
				if(cAlta) cartaAlta=parseCartas.convertToCard(i, palo);	
				arrayColor[palo-1]++;
			}	
		}
		
	  /*Comprobamos que al menos cinco cartas tengan el mismo palo, de ser así este será el palo que forme color (paloAux)*/
		for(int j=0; j< arrayColor.length; j++){
			if(arrayColor[j]>=5){color=true;
			paloAux=j+1;
			}
		}
		
		esc=procesarEscalera(arrayEscalera,paloAux, parseCartas);

		if(esc.length()!=0){
			escalera=true;
		    if(color){
		    	escColor=procesarEscaleraColor(esc, parseCartas);
		    	if(escColor.length() != 0)escaleraColor=true;
		    }
			if(!escaleraColor){
				arrayEsc=esc.split(",");
			}else arrayEsc=escColor.split(",");
				esc="";
				//Seleccionamos las cinco cartas más altas que forman la escalera de color o bién la escalera normal.
				for(int j=arrayEsc.length-5; j<arrayEsc.length; j++)
					valorEsc=valorEsc+parseCartas.figuraToInt(arrayEsc[j].charAt(0));
				
		}
		
	  /*Si existe escalera de color, no miramos las demás jugadas.*/
		if(escaleraColor){
			valorJugada=0;
			valorJugada = valorEsc;
			valorJugada = valorJugada +(8*100);
		}
      /*Si existe color pero no existe (escalera de color,poker,full)
		la jugada más alta será color.(Mostraremos todas las cartas que forman color).*/
		else if(color&&!poker&&!full){
			char[] colorArray;
			colorArray=mano.toCharArray();
			ArrayList<Integer> colorFinal = new ArrayList<Integer>();
			for(int s=0; s<colorArray.length-1;s++){
				s=s+1;
				if(paloAux==parseCartas.paloToInt(colorArray[s]))
					colorFinal.add(parseCartas.figuraToInt(colorArray[s-1]));
			}
			
			Collections.sort(colorFinal);
			
			for(int r=0; r<5; r++){
				valorColor=valorColor+colorFinal.get(r);
			}
			valorJugada=0;
			valorJugada = valorColor;
			valorJugada = valorJugada +(5*100);
      /*Si existe escalera pero no existe (escalera de color,poker,full,color) escalera será la mejor jugada.*/
		}else if(escalera&&!poker&&!full){
			valorJugada=0;
			valorJugada = valorEsc;
			valorJugada = valorJugada +(4*100);
	  /*Si existe trio pero no existe (escalera de color,poker,full,color,escalera) trio será la mejor jugada.*/
		}else if(trio&&!poker&&!full){
			valorJugada = valorJugada +(3*100); 
	  /*Si existe pareja pero no existe (escalera de color,poker,full,color,escalera,trio) pareja será la mejor jugada.
		Si existe doble pareja (pareja no existirá).*/
		}else if(pareja&&!trio&&!poker&&!full){
			valorJugada = valorJugada +(1*100); 
	  /*Si existe carta alta es porque no existe ninguna jugada*/
		}else if(cAlta){
			valorJugada=0;
			valorJugada = valorJugada + parseCartas.figuraToInt(cartaAlta.charAt(0)); 
		}

		return valorJugada;
		}
	

/*PROCESAR ESCALERA
·Parámetros de entrada:
    -Array de int en el que cada posición está asociada a una figura y cada poaición contiene el palo de la figura correspondiente:
  		(0)->A,(1)->2,(2)->3,(3)->4,(4)->5,(5)->6,(6)->7,(7)->8,(8)->9,(9)->T,(10)->J,(11)->Q,(12)->K,(13)->A.
       *Empieza con as ya que la escalera más baja es A,2,3,4,5 y acaba en as ya que la escalera más alta es T,J,Q,K,A.
    -int paloAux, si es cero nos indica que no existe color, si es distinto de cero indicará el palo con el que se ha formado 
     la jugada de color(Nos ayudará a gestionar una posible escalera de color).
·Funcionamiento:
    -Empezaremos recorriendo el array desde la posición cero e iremos mirando si hay cinco posiciones consecutivas que tengan palo asignado.
     una vez encontradas las cinco posiciones tendremos escalera, en caso de haber más de cinco cartas que formen escalera nos quedaremos
     con la escalera más alta del array.
    -Si hay parejas o trios tendremos varios palos en una posición, para formar escalera simplemente nos quedamos con uno de ellos ya
     que nos da igual el palo (Solo nos fijamos en la figura). Antes de elegir un palo al azar comprobaremos si existe color y si una de
     las cartas coincide con el palo de color(paloAux) será esta carta la que pondremos en la escalera y no una al azar.
     (Esto nos ayudará despues a comprobar si existe escalera de color).
·Parámetros de salida:
     Devolveremos un String con la escalera formada ,ej:As,2s,3s,4c,5s
     *Si es String devuelto es null es porque no existe la escalera.
 */
	public String procesarEscalera(int[] arrayEscalera,int paloAux, ParseCartas parseCartas){
		int palo, posEsc, contEsc=0;
		StringBuilder auxEsc= new StringBuilder();
		StringBuilder esc = new StringBuilder();
		for(int i=0; i<arrayEscalera.length; i++){
			palo=arrayEscalera[i];
			if(palo!=0){
				if(i==0)posEsc=12;
				else posEsc=i-1;
				contEsc++;
				if(contEsc==1){ 
					if(palo>100){
						if(palo%10==paloAux ||(palo/10)%10==paloAux ||(palo/10)/10==paloAux){
							auxEsc.setLength(0);
							auxEsc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							auxEsc.setLength(0);
							auxEsc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else if(palo>10){
						if(palo%10==paloAux ||palo/10==paloAux){
							auxEsc.setLength(0);
							auxEsc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							auxEsc.setLength(0);
							auxEsc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else{
						auxEsc.setLength(0);
						auxEsc.append(parseCartas.convertToCard(posEsc, palo));
					}
				}else if(contEsc<5){
					if(palo>100){
						if(palo%10==paloAux ||(palo/10)%10==paloAux ||(palo/10)/10==paloAux){
							auxEsc.append(",");
							auxEsc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							auxEsc.append(",");
							auxEsc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else if(palo>10){
						if(palo%10==paloAux ||palo/10==paloAux){
							auxEsc.append(",");
							auxEsc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							auxEsc.append(",");
							auxEsc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else{
						auxEsc.append(",");
						auxEsc.append(parseCartas.convertToCard(posEsc, palo));
					}
				}else if(contEsc==5){
					if(palo>100){
						if(palo%10==paloAux ||(palo/10)%10==paloAux ||(palo/10)/10==paloAux){
							esc.setLength(0);
							esc.append(auxEsc);
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							esc.setLength(0);
							esc.append(auxEsc);
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else if(palo>10){
						if(palo%10==paloAux ||palo/10==paloAux){
							esc.setLength(0);
							esc.append(auxEsc);
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else {
							esc.setLength(0);
							esc.append(auxEsc);
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
					}else{
						esc.setLength(0);
						esc.append(auxEsc);
						esc.append(",");
						esc.append(parseCartas.convertToCard(posEsc, palo));	
					}
				}else{
					if(palo>100){
						if(palo%10==paloAux ||(palo/10)%10==paloAux ||(palo/10)/10==paloAux){
						esc.append(",");
						esc.append(parseCartas.convertToCard(posEsc, paloAux));
						}else{
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, palo%10));
						}
						
						}else if(palo>10){
							if(palo%10==paloAux ||palo/10==paloAux){
								esc.append(",");
								esc.append(parseCartas.convertToCard(posEsc, paloAux));
							}else{
								esc.append(",");
								esc.append(parseCartas.convertToCard(posEsc, palo%10));	
							}
						}else{
							esc.append(",");
							esc.append(parseCartas.convertToCard(posEsc, palo));
						}
					}
			}else{
				auxEsc.setLength(0);
				contEsc=0;
			}
		}
		return esc.toString();
}

/*PROCESAR ESCALERA DE COLOR
·Parámetros de entrada:
    -String que forma una escalera (del cual comprobaremos si es escalera de color o no):
·Funcionamiento:
    -Esta función solo se llama en caso de que exista escalera y color, debemos comprobar que el color corresponda a la escalera formada,
     ya que el máximo de cartas con el que podemos formar una jugada es siete y puede darse el caso que exista color y escalera pero no
     escalera de color.
    -Iremos recorriendo carta a carta de la escalera mirando que existan cinco cartas consecutivas con el mismo color, de ser así 
     tendremos escalera de color. Si existen más cartas consecutivas que forman escalera de color las iremos añadiendo al String (Para 
     después quedarnos con las cinco cartas más altas que forman escalera de color)
·Parámetros de salida:
     Devolveremos un String con la escalera de color formada ,ej:As,2s,3s,4s,5s,6s...
     *Si es String devuelto es null es porque no existe la escalera de color.
 */
public String procesarEscaleraColor(String escalera, ParseCartas parseCartas){

	String[] escColor;
	char[] auxEscColor1, auxEscColor2;
	int conEscFlush=0;
	StringBuilder escFlush= new StringBuilder();
	StringBuilder escFlushFinal= new StringBuilder();
	escColor=escalera.split(",");
	
	for(int h=1; h<escColor.length; h++){
		auxEscColor1=escColor[h].toCharArray();
		auxEscColor2=escColor[h-1].toCharArray();
		if(parseCartas.paloToInt(auxEscColor1[1])==parseCartas.paloToInt(auxEscColor2[1])){
			conEscFlush++;
			if(conEscFlush==1){
				escFlush.setLength(0);
				escFlush.append(String.valueOf(auxEscColor2[0]));
				escFlush.append(String.valueOf(auxEscColor2[1]));
				escFlush.append(",");
				escFlush.append(String.valueOf(auxEscColor1[0]));
				escFlush.append(String.valueOf(auxEscColor1[1]));
			}
			else if(conEscFlush<4){
				escFlush.append(",");
				escFlush.append(String.valueOf(auxEscColor1[0]));
				escFlush.append(String.valueOf(auxEscColor1[1]));
			}else if(conEscFlush==4){
				escFlushFinal.setLength(0);
				escFlushFinal.append(escFlush);
				escFlushFinal.append(",");
				escFlushFinal.append(String.valueOf(auxEscColor1[0]));
				escFlushFinal.append(String.valueOf(auxEscColor1[1]));
			}else{
				escFlushFinal.append(",");
				escFlushFinal.append(String.valueOf(auxEscColor1[0]));
				escFlushFinal.append(String.valueOf(auxEscColor1[1]));
			}
			
		}else{ 
			conEscFlush=0;
			escFlush.setLength(0);
		}
	}
	return escFlushFinal.toString();
	}

/*VALOR DE UNA MANO:
·Funcionamiento:
	-Recorre el array de una mano y le da a cada carta el valor correspondiente según su posición en el array.
	 *El "dos" tendrá el valor más bajo y el "as" el valor más alto.
	-Esto nos ayudará a determinar quién tiene una mejor mano en caso de empate de jugadas.
		ej: Dos jugadores empatan con una pareja de ases, se calcula el valor de la mano total de cada uno y se compara
			el que tenga el valor más alto tiene mejores cartas por lo que este gana la partida.
 */
	public int valorMano(String mano){	
		int valor=0;
		int[] arrayMano = transformarMano(mano);
		for(int j=arrayMano.length-1 ; j>=0; j--){
			if(arrayMano[j]!=0){
				//4 figuras iguales
				if(arrayMano[j]>1000){	
				valor+=j*4;
				//3 figuras iguales
				}else if(arrayMano[j]>100){
					valor+=j*3;
				//2 figuras iguales	
				}else if(arrayMano[j]>10){
					valor+=j*2;
				}else{
					valor+=j;
				}
			}
		}
		return valor;
	}
	
	public int[] transformarMano(String mano){
		int[] arrayMano = new int[13];
		int posicion = 0, paloIni=0;
		boolean  impar=false;
		ParseCartas parseCartas = new ParseCartas();
		char[] aux = mano.toCharArray();
		
		//Inicializa el array de enteros correspondiente a la mano.
		for(int i=0; i<aux.length; i++){
			if(!impar){
				posicion=parseCartas.figuraToInt(aux[i]);
			impar=true;
			}else{
				paloIni = parseCartas.paloToInt(aux[i]);
				if(arrayMano[posicion] != 0){ //Ya hay una carta de la misma figura
					paloIni=(arrayMano[posicion]*10)+paloIni;
				}
				arrayMano[posicion]=paloIni;
				impar=false;
			}
		}
		return arrayMano;
	}
}

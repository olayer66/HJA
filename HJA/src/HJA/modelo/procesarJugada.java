package HJA.modelo;

public class procesarJugada {

	private int rango; // 0->MA, 1->janda
	private String mano;
	private int posicion;
	private int accion; // 0->OR, 1->fold

	public procesarJugada(String[] datos){
		rango = Integer.valueOf(datos[0]);
		ParseCartas parse = new ParseCartas();
		mano = parse.manoToRango(datos[1]);
		posicion = Integer.valueOf(datos[2]);
		accion = Integer.valueOf(datos[3]);
	}
	public boolean evaluarJugada(){
		String[] pares = null;
		int i=0;
		boolean encontrado=false;
		
		//MA
		if(rango==0){
			if(posicion==1){//BB
				if(accion==0)return true;
				else return false;
			}else pares=evaluarMa();
		//JANDA
		}else if(rango==1){
			if(posicion==1){//BB
				if(accion==0)return true;
				else return false;
			}else pares=evaluarJanda();
		}
		
		while(i<pares.length && !encontrado){
			if(pares[i].equalsIgnoreCase(mano))encontrado=true;
			else i++;
		}
		if(encontrado){
			if(accion==0)return true;
			else return false;
		}else{
			if(accion==0)return false;
			else return true;
		}
	}
	
	//Devuelve array con los pares de cartas del rango Janda segun la posicion
	public String[] evaluarJanda(){
		String rangoJanda="";
		if(posicion==0)//SB
			rangoJanda="AA-22,AKo-A7o,KQo-K9o,QJo-Q9o,JTo-J9o,T9o,98o,AKs-A2s,KQs-K2s,QJs-Q4s,JTs-J7s,T9s-T7s,98s-97s,87s-86s,76s-75s,65s-64s,54s";
		else if (posicion==2)//UTG
			rangoJanda="AA-33,AKo-AJo,KQo,AKs-ATs,KQs-KTs,QJs-QTs,JTs-J9s,T9s,98s,87s,76s,65s";	
		else if(posicion==3)//MP
			rangoJanda="AA-22,AKo-ATo,KQo,AKs-A7s,A5s,KQs-KTs,QJs-QTs,JTs-J9s,T9s-T8s,98s-97s,87s-86s,76s-75s,65s,54s";
		else if(posicion==4)//CO
			rangoJanda="AA-22,AKo-ATo,KQo-KJo,QJo,AKs-A2s,KQs-K6s,QJs-Q7s,JTs-J8s,T9s-T8s,98s-97s,87s-86s,76s-75s,65s-64s,54s";
		else{//BTN
			rangoJanda="AA-22,AKo-A2o,KQo-K7o,QJo-Q9o,JTo-J9o,T9o-T8o,98o,87o,AKs-A2s,KQs-K2s,QJs-Q2s,JTs-J5s,T9s-T6s,98s-96s,87s-85s,76s-74s,65s-64s,54s-53s,43s";
		}
		transformarString trans = new transformarString(rangoJanda);
		return trans.procesarString();
	}
	
	//Devuelve array con los pares de cartas del rango Ma segun la posicion
	public String[] evaluarMa(){
		String rangoMa="";
		if(posicion==0)//SB
			rangoMa="22+,A2s+,JTo,QTo+,KTo+,A9o+,32s,43s,54s,65s,76s,87s,98s,T9s,JTs,QTs+,KTs+";
		else if (posicion==2)//UTG
			rangoMa="88+,AJs+,KQs,AQo+";	
		else if(posicion==3)//MP
			rangoMa="77+,AJo+,KQo,ATs+,KQs";
		else if(posicion==4)//CO
			rangoMa="66+,ATo+,A9s+,KJs+,KQo";
		else{//BTN
			rangoMa="55+,A8s+,A9o+,KJo+,JTs,QTs+,KTs+";
		}
		transformarString trans = new transformarString(rangoMa);
		return trans.procesarString();
	}
}

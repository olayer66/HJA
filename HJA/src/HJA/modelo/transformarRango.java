package HJA.modelo;

public class transformarRango {
	
	private String[] arrayCartas;
	private boolean[] parejas;
	private boolean[] suited;
	private boolean[] offsuited;
	private ParseCartas parse;
	
	
	public transformarRango(String[] arrayCartas){
		this.arrayCartas=arrayCartas;
		parejas=new boolean[13];
		suited=new boolean[78];
		offsuited=new boolean[78];
		parse=new ParseCartas();
	}
	
	public String crearRango(){
		String cadena="";
		char[] caracter;
		int pos;
		boolean pareja=false,offs=false,suit=false;//Lo usamos para si no hay ese tipo de par de cartas no recorremos su array
		for(int i=0; i<arrayCartas.length;i++){
			caracter=arrayCartas[i].toCharArray();
			//Parejas
			if(caracter.length==2){
				pareja=true;
				parejas[parse.figuraToInt(caracter[0])]=true;
			//Par de cartas suited o offsuited
			}else{
				pos=parse.figuraRangoToInt(caracter[0])+parse.figuraToInt(caracter[1]);
				if(caracter[2]=='s'){
				suit=true;
				suited[pos]=true;
				}else{
				offs=true;
				offsuited[pos]=true;	
				}
			}
		}
		int contPares=0;
		String auxPar="";
//		
		if(pareja){
			for(int i=parejas.length-1; i>=0; i--){
				if(parejas[i]){
					contPares++;
					auxPar=parse.intToFigura(i);
				}else if(contPares==1){
					cadena+=auxPar+auxPar;
				}
			}
		}
		
		return cadena;
	}

}

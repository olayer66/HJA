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
		StringBuilder cadena= new StringBuilder();
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
		if(pareja)
		cadena.append(procesarParejas());	
		
		if(suit)
		cadena.append(procesarSuited());
		
		if(offs)
		cadena.append(procesarOffsuited());	
		
		//Quitamos la ultima "," y devolvemos el string
		return cadena.toString().substring(0, cadena.length()-1);
	}
	public String procesarParejas(){
		StringBuilder cadena=new StringBuilder();
		String auxPar, parFinal="";
		boolean mas=false, rango=false;
		
		for(int i=parejas.length-2; i>=0; i--){
			if(i+1 == 12 && parejas[12] && parejas[11])
				mas=true;
			if(parejas[i+1]){
				auxPar=parse.intToFigura(i+1);
				if(!parejas[i]){
					if(mas){
						cadena.append(auxPar);
						cadena.append(auxPar);
						cadena.append("+");
						cadena.append(",");
						mas=false;
					}else if(rango){
						cadena.append(auxPar);
						cadena.append(auxPar);
						cadena.append("-");
						cadena.append(parFinal);
						cadena.append(parFinal);
						cadena.append(",");
						rango=false;
					}else{
						cadena.append(auxPar);
						cadena.append(auxPar);
						cadena.append(",");
					}
				}else if(!mas && !rango){
					parFinal=auxPar;
					rango=true;
				}
			}	
		}
		if(parejas[0]){
			if(mas)
				cadena.append("22+,");
			else if(rango){
				cadena.append("22-");
				cadena.append(parFinal);
				cadena.append(parFinal);
				cadena.append(",");
			}else
				cadena.append("22,");
		}
		return cadena.toString();
	}
	
	public String procesarSuited(){
		StringBuilder cadena=new StringBuilder();
		String auxPar, parFinal="";
		boolean mas=false, rango=false;
		char[] aux1, aux2;
		int resultado;
		
		for(int i=suited.length-2; i>=0; i--){
			if(suited[i+1]){
				auxPar=parse.intTofiguraRango(i+1);
				if(!suited[i]){
					if(mas){
						cadena.append(auxPar);
						cadena.append("s");
						cadena.append("+");
						cadena.append(",");
						mas=false;
					}else if(rango){
						cadena.append(auxPar);
						cadena.append("s");
						cadena.append("-");
						cadena.append(parFinal);
						cadena.append("s");
						cadena.append(",");
					    rango=false;
					}else{
						cadena.append(auxPar);
						cadena.append("s");
						cadena.append(",");
					}
				}else{
					aux1=auxPar.toCharArray();
					aux2=parse.intTofiguraRango(i).toCharArray();
					if(aux1[0]!=aux2[0]){
						if(mas){
							cadena.append(auxPar);
							cadena.append("s");
							cadena.append("+");
							cadena.append(",");
						    mas=false;
						}else if(rango){
							cadena.append(auxPar);
							cadena.append("s");
							cadena.append("-");
							cadena.append(parFinal);
							cadena.append("s");
							cadena.append(",");
						    rango=false;
						}else{
							cadena.append(auxPar);
							cadena.append("s");
							cadena.append(",");
						}
					}else if(!mas && !rango){
					resultado = Integer.parseInt(String.valueOf(aux1[0]))-Integer.parseInt(String.valueOf(aux1[1]));
					if(resultado==1)mas=true;
					else{						
						rango=true;
						parFinal=auxPar;
					}
				}
				}
			}	
		}
		if(suited[0]) cadena.append("32s,");
	return cadena.toString();	
	}
	
	public String procesarOffsuited(){
		StringBuilder cadena=new StringBuilder();
		String auxPar, parFinal="";
		boolean mas=false, rango=false;
		char[] aux1, aux2;
		int resultado;
		
		for(int i=offsuited.length-2; i>=0; i--){
			if(offsuited[i+1]){
				auxPar=parse.intTofiguraRango(i+1);
				if(!offsuited[i]){
					if(mas){
						cadena.append(auxPar);
						cadena.append("o");
						cadena.append("+");
						cadena.append(",");
						mas=false;
					}else if(rango){
						cadena.append(auxPar);
						cadena.append("o");
						cadena.append("-");
						cadena.append(parFinal);
						cadena.append("o");
						cadena.append(",");
					    rango=false;
					}else{
						cadena.append(auxPar);
						cadena.append("o");
						cadena.append(",");
					}
				}else{
					aux1=auxPar.toCharArray();
					aux2=parse.intTofiguraRango(i).toCharArray();
					if(aux1[0]!=aux2[0]){
						if(mas){
							cadena.append(auxPar);
							cadena.append("o");
							cadena.append("+");
							cadena.append(",");
						    mas=false;
						}else if(rango){
							cadena.append(auxPar);
							cadena.append("o");
							cadena.append("-");
							cadena.append(parFinal);
							cadena.append("o");
							cadena.append(",");
						    rango=false;
						}else{
							cadena.append(auxPar);
							cadena.append("o");
							cadena.append(",");
						}
					}else if(!mas && !rango){
					resultado = Integer.parseInt(String.valueOf(aux1[0]))-Integer.parseInt(String.valueOf(aux1[1]));
					if(resultado==1)mas=true;
					else{						
						rango=true;
						parFinal=auxPar;
					}
				}
				}
			}	
		}
		if(offsuited[0]) cadena.append("32o,");
	return cadena.toString();	
	}

}

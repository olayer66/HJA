package HJA;

import HJA.GUI.GUIPlayers;
import HJA.controlador.controlador;
import HJA.modelo.calculoEquity;
import HJA.modelo.evaluarJugadores;

public class startClass 
{
	
	private controlador miControlador;
	static public GUIPlayers vtnPlayers;
	
	public static void main(String[] args)
	{
	
		/*startClass st;
		st=new startClass();
		st.inicia();
		if (st.comprobarArgumentos(args)==true)
		{	            
			st.ejecutameDesdeConsola(args);
		}
		else
		{			
			st.ejecutame();
		}
		*/
		
		String[] rangos= {"KK+","32s,33","99,34s,56o"};
		calculoEquity ev= new calculoEquity();
		ev.calcular(null,"As,Ad,Ah,Ac", rangos);
		
	}
	
	
	/**
	 * Metodo que inicia todas las clases necesarias para ejecutar la aplicacion
	 */
	private void inicia()
	{
		//iniciamos los objetos
		miControlador=new controlador();
		vtnPlayers=new GUIPlayers(miControlador);
		new constante();
		
		vtnPlayers.getFrame().setVisible(true);
		
		// ejemplo de llamada a la singleton
		constante.getInstance().getManos();
		
	}
	/**
	 * Metodo que ejecuta la aplicacion en modo vista
	 * @throws misExcepciones
	 */
	private void ejecutame()
	{		

	}
	/**
	 * Metodo que ejecuta la aplicacion recibiendo parametros desde la consola
	 * @param argumentos
	 */
	private void ejecutameDesdeConsola(String [] argumentos)
	{
		
	}
	private boolean comprobarArgumentos(String[] argumentos)
	{
		boolean correctos=false;
		
		return correctos;
	}
}

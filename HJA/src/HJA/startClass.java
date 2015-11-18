package HJA;

import HJA.GUI.GUIPlayers;
import HJA.controlador.controlador;

public class startClass 
{
	private controlador miControlador;
	static public GUIPlayers vtnPlayers;
	public static void main(String[] args)
	{
		/*LLAMADA A TRANSFORMARSTRING
		 * 1.Se le pasa al constructor el String con el rango de cartas.
		 * 2.Se llama a procesarString, esto devuelve un array de Strings
			
			transformarString ejemplo = new transformarString(cadena);
			String[] resultado = ejemplo.procesarString()
		 
		 **/
		startClass st;
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

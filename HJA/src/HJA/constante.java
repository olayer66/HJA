package HJA;

import java.util.HashMap;

public class constante 
{
	//Constante de la clase singleton
	private static constante instance = null;
	//Hashmap que contiene todos los pares de cartas posibles
	private HashMap<String,datosMano> manos;
	
	//clase privada para los datos relacionados con la mano
	private class datosMano
   {
	   private int x;
	   private int y;
	   private int valorChubukov;
	   private int valor2;
	   public datosMano(int miX,int miY, int valorCH,int v2)
	   {
		   x=miX;
		   y=miY;
		   valorChubukov=valorCH;
		   valor2=v2;
	   }
		public int getX() 
		{
			return x;
		}
		public int getY() 
		{
			return y;
		}
		public int getValorChubukov() 
		{
			return valorChubukov;
		}
		public int getValor2() 
		{
			return valor2;
		} 
   }
	
	//Contructor de la clase
    protected constante() 
    {
      manos= new HashMap<String,datosMano>();
      crearParejas();
    }
    //Devuelve la clase singleton en caso de que no exista la crea
    public static constante getInstance() {
      if(instance == null) 
      {
         instance = new constante();
      }
      return instance;
   }
   
   //Funcion que crea el hashmap de la carta (tu trabajo andres)
   private void crearParejas()
   {
	   //Ejemplo faltan otros 168
	   manos.put("AA",new datosMano(0, 0, 500, 500));
   }
	public HashMap<String, datosMano> getManos() 
	{
		return manos;
	}
   
}

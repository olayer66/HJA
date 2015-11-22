package HJA;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class constante 
{
	//Constante de la clase singleton
	private static constante instance = null;
	//Hashmap que contiene todos los pares de cartas posibles
	private LinkedHashMap<String,datosMano> manos;
	
	//clase privada para los datos relacionados con la mano
	public class datosMano
   {
	   private int x;
	   private int y;
	   private double valorChubukov;
	   private int valor2;
	   public datosMano(int miX,int miY, double valorCH,int v2)
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
		public double getValorChubukov() 
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
      manos= new LinkedHashMap<String,datosMano>();
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
	   manos.put("AKs",new datosMano(0, 1, 297, 500));
	   manos.put("AQs",new datosMano(0, 2, 137, 500));
	   manos.put("AJs",new datosMano(0, 3, 91.6, 500));
	   manos.put("ATs",new datosMano(0, 4, 69.5, 500));
	   manos.put("A9s",new datosMano(0, 5, 52, 500));
	   manos.put("A8s",new datosMano(0, 6, 44.9, 500));
	   manos.put("A7s",new datosMano(0, 7, 39.5, 500));
	   manos.put("A6s",new datosMano(0, 8, 35.3, 500));
	   manos.put("A5s",new datosMano(0, 9, 36.1, 500));
	   manos.put("A4s",new datosMano(0, 10, 33.3, 500));
	   manos.put("A3s",new datosMano(0, 11, 31.1, 500));
	   manos.put("A2s",new datosMano(0, 12, 29, 500));
	   manos.put("AKo",new datosMano(1, 0, 166, 500));
	   manos.put("KK",new datosMano(1, 1, 477, 500));
	   manos.put("KQs",new datosMano(1, 2, 43.3, 500));
	   manos.put("KJs",new datosMano(1, 3, 36.3, 500));
	   manos.put("KTs",new datosMano(1, 4, 31.4, 500));
	   manos.put("K9s",new datosMano(1, 5, 23.9, 500));
	   manos.put("K8s",new datosMano(1, 6, 19.9, 500));
	   manos.put("K7s",new datosMano(1, 7, 18.6, 500));
	   manos.put("K6s",new datosMano(1, 8, 17.4, 500));
	   manos.put("K5s",new datosMano(1, 9, 16.1, 500));
	   manos.put("K4s",new datosMano(1, 10, 15, 500));
	   manos.put("K3s",new datosMano(1, 11, 14.1, 500));
	   manos.put("K2s",new datosMano(1, 12, 13.3, 500));
	   manos.put("AQo",new datosMano(2, 0, 96, 500));
	   manos.put("KQo",new datosMano(2, 1, 29.3, 500));
	   manos.put("QQ",new datosMano(2, 2, 239, 500));
	   manos.put("QJs",new datosMano(2, 3, 24.7, 500));
	   manos.put("QTs",new datosMano(2, 4, 21.9, 500));
	   manos.put("Q9s",new datosMano(2, 5, 16.2, 500));
	   manos.put("Q8s",new datosMano(2, 6, 13.3, 500));
	   manos.put("Q7s",new datosMano(2, 7, 11.3, 500));
	   manos.put("Q6s",new datosMano(2, 8, 10.9, 500));
	   manos.put("Q5s",new datosMano(2, 9, 10.1, 500));
	   manos.put("Q4s",new datosMano(2, 10, 9.4, 500));
	   manos.put("Q3s",new datosMano(2, 11, 8.8, 500));
	   manos.put("Q2s",new datosMano(2, 12, 8.3, 500));
	   manos.put("AJo",new datosMano(3, 0, 68.1, 500));
	   manos.put("KJo",new datosMano(3, 1, 25.4, 500));
	   manos.put("QJo",new datosMano(3, 2, 16.4, 500));
	   manos.put("JJ",new datosMano(3, 3, 159, 500));
	   manos.put("JTs",new datosMano(3, 4, 18, 500));
	   manos.put("J9s",new datosMano(3, 5, 12.8, 500));
	   manos.put("J8s",new datosMano(3, 6, 10.3, 500));
	   manos.put("J7s",new datosMano(3, 7, 8.5, 500));
	   manos.put("J6s",new datosMano(3, 8, 7.3, 500));
	   manos.put("J5s",new datosMano(3, 9, 7, 500));
	   manos.put("J4s",new datosMano(3, 10, 6.4, 500));
	   manos.put("J3s",new datosMano(3, 11, 6, 500));
	   manos.put("J2s",new datosMano(3, 12, 5.5, 500));
	   manos.put("ATo",new datosMano(4, 0, 53.1, 500));
	   manos.put("KTo",new datosMano(4, 1, 22.4, 500));
	   manos.put("QTo",new datosMano(4, 2, 14.8, 500));
	   manos.put("JTo",new datosMano(4, 3, 11.5, 500));
	   manos.put("TT",new datosMano(4, 4, 120, 500));
	   manos.put("T9s",new datosMano(4, 5, 11.2, 500));
	   manos.put("T8s",new datosMano(4, 6, 8.7, 500));
	   manos.put("T7s",new datosMano(4, 7, 7, 500));
	   manos.put("T6s",new datosMano(4, 8, 5.9, 500));
	   manos.put("T5s",new datosMano(4, 9, 4.9, 500));
	   manos.put("T4s",new datosMano(4, 10, 4.6, 500));
	   manos.put("T3s",new datosMano(4, 11, 4.2, 500));
	   manos.put("T2s",new datosMano(4, 12, 3.7, 500));
	   manos.put("A9o",new datosMano(5, 0, 40.8, 500));
	   manos.put("K9o",new datosMano(5, 1, 17.8, 500));
	   manos.put("Q9o",new datosMano(5, 2, 11.7, 500));
	   manos.put("J9o",new datosMano(5, 3, 8.8, 500));
	   manos.put("T9o",new datosMano(5, 4, 7.4, 500));
	   manos.put("99",new datosMano(5, 5, 95.7, 500));
	   manos.put("98s",new datosMano(5, 6, 7.6, 500));
	   manos.put("97s",new datosMano(5, 7, 6.1, 500));
	   manos.put("96s",new datosMano(5, 8, 5, 500));
	   manos.put("95s",new datosMano(5, 9, 4.1, 500));
	   manos.put("94s",new datosMano(5, 10, 3.2, 500));
	   manos.put("93s",new datosMano(5, 11, 3, 500));
	   manos.put("92s",new datosMano(5, 12, 2.6, 500));
	   manos.put("A8o",new datosMano(6, 0, 35.4, 500));
	   manos.put("K8o",new datosMano(6, 1, 15.2, 500));
	   manos.put("Q8o",new datosMano(6, 2, 9.9, 500));
	   manos.put("J8o",new datosMano(6, 3, 7.4, 500));
	   manos.put("T8o",new datosMano(6, 4, 6, 500));
	   manos.put("98o",new datosMano(6, 5, 5.1, 500));
	   manos.put("88",new datosMano(6, 6, 79.6, 500));
	   manos.put("87s",new datosMano(6, 7, 5.5, 500));
	   manos.put("86s",new datosMano(6, 8, 4.5, 500));
	   manos.put("85s",new datosMano(6, 9, 3.6, 500));
	   manos.put("84s",new datosMano(6, 10, 2.8, 500));
	   manos.put("83s",new datosMano(6, 11, 2.2, 500));
	   manos.put("82s",new datosMano(6, 12, 2, 500));
	   manos.put("A7o",new datosMano(7, 0, 31.3, 500));
	   manos.put("K7o",new datosMano(7, 1, 14.2, 500));
	   manos.put("Q7o",new datosMano(7, 2, 8.5, 500));
	   manos.put("J7o",new datosMano(7, 3, 6.3, 500));
	   manos.put("T7o",new datosMano(7, 4, 5.1, 500));
	   manos.put("97o",new datosMano(7, 5, 4.2, 500));
	   manos.put("87o",new datosMano(7, 6, 3.7, 500));
	   manos.put("77",new datosMano(7, 7, 67.4, 500));
	   manos.put("76s",new datosMano(7, 8, 4.1, 500));
	   manos.put("75s",new datosMano(7, 9, 3.2, 500));
	   manos.put("74s",new datosMano(7, 10, 2.5, 500));
	   manos.put("73s",new datosMano(7, 11, 2, 500));
	   manos.put("72s",new datosMano(7, 12, 1.6, 500));
	   manos.put("A6o",new datosMano(8, 0, 28, 500));
	   manos.put("K6o",new datosMano(8, 1, 13.3, 500));
	   manos.put("Q6o",new datosMano(8, 2, 8.1, 500));
	   manos.put("J6o",new datosMano(8, 3, 5.3, 500));
	   manos.put("T6o",new datosMano(8, 4, 4.2, 500));
	   manos.put("96o",new datosMano(8, 5, 3.5, 500));
	   manos.put("86o",new datosMano(8, 6, 3, 500));
	   manos.put("76o",new datosMano(8, 7, 2.7, 500));
	   manos.put("66",new datosMano(8, 8, 57.6, 500));
	   manos.put("65s",new datosMano(8, 9, 3.1, 500));
	   manos.put("64s",new datosMano(8, 10, 2.3, 500));
	   manos.put("63s",new datosMano(8, 11, 1.8, 500));
	   manos.put("62s",new datosMano(8, 12, 1.5, 500));
	   manos.put("A5o",new datosMano(9, 0, 28.2, 500));
	   manos.put("K5o",new datosMano(9, 1, 12.3, 500));
	   manos.put("Q5o",new datosMano(9, 2, 7.5, 500));
	   manos.put("J5o",new datosMano(9, 3, 5, 500));
	   manos.put("T5o",new datosMano(9, 4, 3.4, 500));
	   manos.put("95o",new datosMano(9, 5, 2.8, 500));
	   manos.put("85o",new datosMano(9, 6, 2.4, 500));
	   manos.put("75o",new datosMano(9, 7, 2.1, 500));
	   manos.put("65o",new datosMano(9, 8, 1.9, 500));
	   manos.put("55",new datosMano(9, 9, 49.3, 500));
	   manos.put("54s",new datosMano(9, 10, 2.4, 500));
	   manos.put("53s",new datosMano(9, 11, 1.9, 500));
	   manos.put("52s",new datosMano(9, 12, 1.5, 500));
	   manos.put("A4o",new datosMano(10, 0, 25.9, 500));
	   manos.put("K4o",new datosMano(10, 1, 11.4, 500));
	   manos.put("Q4o",new datosMano(10, 2, 6.8, 500));
	   manos.put("J4o",new datosMano(10, 3, 4.4, 500));
	   manos.put("T4o",new datosMano(10, 4, 3.1, 500));
	   manos.put("94o",new datosMano(10, 5, 2.1, 500));
	   manos.put("84o",new datosMano(10, 6, 1.8, 500));
	   manos.put("74o",new datosMano(10, 7, 1.6, 500));
	   manos.put("64o",new datosMano(10, 8, 1.5, 500));
	   manos.put("54o",new datosMano(10, 9, 1.6, 500));
	   manos.put("44",new datosMano(10, 10, 40.9, 500));
	   manos.put("43s",new datosMano(10, 11, 1.7, 500));
	   manos.put("42s",new datosMano(10, 12, 1.4, 500));
	   manos.put("A3o",new datosMano(11, 0, 24.2, 500));
	   manos.put("K3o",new datosMano(11, 1, 10.6, 500));
	   manos.put("Q3o",new datosMano(11, 2, 6.2, 500));
	   manos.put("J3o",new datosMano(11, 3, 3.9, 500));
	   manos.put("T3o",new datosMano(11, 4, 2.7, 500));
	   manos.put("93o",new datosMano(11, 5, 2, 500));
	   manos.put("83o",new datosMano(11, 6, 1.5, 500));
	   manos.put("73o",new datosMano(11, 7, 1.3, 500));
	   manos.put("63o",new datosMano(11, 8, 1.3, 500));
	   manos.put("53o",new datosMano(11, 9, 1.3, 500));
	   manos.put("43o",new datosMano(11, 10, 1.1, 500));
	   manos.put("33",new datosMano(11, 11, 32.7, 500));
	   manos.put("32s",new datosMano(11, 12, 1.2, 500));
	   manos.put("A2o",new datosMano(12, 0, 22.5, 500));
	   manos.put("K2o",new datosMano(12, 1, 10, 500));
	   manos.put("Q2o",new datosMano(12, 2, 5.6, 500));
	   manos.put("J2o",new datosMano(12, 3, 3.44, 500));
	   manos.put("T2o",new datosMano(12, 4, 2.4, 500));
	   manos.put("92o",new datosMano(12, 5, 1.8, 500));
	   manos.put("82o",new datosMano(12, 6, 1.4, 500));
	   manos.put("72o",new datosMano(12, 7, 1.1, 500));
	   manos.put("62o",new datosMano(12, 8, 1, 500));
	   manos.put("52o",new datosMano(12, 9, 1, 500));
	   manos.put("42o",new datosMano(12, 10, 0.9, 500));
	   manos.put("32o",new datosMano(12, 11, 0.9, 500));
	   manos.put("22",new datosMano(12, 12, 24, 500));
	   
	   
   }
	public HashMap<String, datosMano> getManos() 
	{
		return manos;
	}
   
}

package HJA;

import java.util.HashMap;

public class constante 
{
		   private static constante instance = null;
		   private HashMap<String,datosMano> manos;
		   public class datosMano
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
			   
		   }
		   protected constante() {
		      // Exists only to defeat instantiation.
		   }
		   public static constante getInstance() {
		      if(instance == null) 
		      {
		         instance = new constante();
		      }
		      return instance;
		   }
}

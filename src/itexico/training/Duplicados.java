package itexico.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Duplicados {
	
	public static void encuentraDuplicados(int[] num) {
		Map<Integer,Integer> mp = new HashMap<Integer, Integer>();
		int cont=0;
		
		for (int i=0;i<num.length;i++) {
			if(mp.get(num[i]) == null)
				cont = 1;
			else
				cont = mp.get(num[i]) + 1;
			
			mp.put(num[i], cont);
		}
		
		mp.forEach((k,v) -> 
				System.out.println("El numero " + k + " se ha encontrado " + v + " veces" )
		);
	}
	
	public static void main(String[] arg) {
		int[] n = {1,1,2,2,2,3,3,4,4,4,5,5,5,5,5,6,7,7,7,7,7};
		
		encuentraDuplicados(n);
	}

}

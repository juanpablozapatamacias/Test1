package itexico.training;

import java.util.HashMap;

public class HourTime {
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static String getMaxTime(int[] a) {
		// TODO Auto-generated method stub
		String ret = dfs(a,0,"","");
		
		if(ret.length() > 0) return ret.substring(0,2) + ":" + ret.substring(2); 
		
		return ret;
	}
	
	private static String dfs(int[] a,int from, String cur, String cmax) {
		int hour;
		int minute;
		
		String oneRet;
		
		if(from == a.length) {
			hour = Integer.valueOf(cur.substring(0,2));
			minute = Integer.valueOf(cur.substring(2));
			
			if(hour >= 24 || minute >= 60 || cur.compareTo(cmax) < 0) {
				return cmax;
			}
			
			return cur;
		}
		
		for(int i=from;i<a.length;++i) {
			swap(a,from,i);
			oneRet = dfs(a,from+1,cur + a[from],cmax);
			
			if(oneRet.compareTo(cmax) > 0) cmax = oneRet;
			
			swap(a,from,i);
		}
		return cmax;
	}
	
	public static void main(String[] arg) {
		int[] A = {1,2,3,4};
		System.out.println(getMaxTime(A));
	}

}

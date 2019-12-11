package itexico.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


public class Calculos {
	public static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static int factorial(int n) {
		if(n < 0) return -1;
		else if(n == 0) return 1;
		else return n * factorial(n - 1);
	}
	
	public static int fibonaci(int n) {
		if(n<=0) return 0;
		else if(n == 1) return 1;
		else return fibonaci(n-1) + fibonaci(n-2);
	}
	
	public static void sonPrimos(int[] a) {
		Map<Integer,Boolean> map = new TreeMap<Integer,Boolean>();
		
		for(int i=0;i<a.length;i++) map.put(a[i],isPrime(a[i]));
		
		Set<Entry<Integer,Boolean>> ent = map.entrySet();
		for(Entry<Integer,Boolean> e : ent) {
			if(e.getValue() == true) {
				System.out.println(e.getKey() + " es numero primo");
			}
			else continue;
		}
	}
	
	public static void allSumDigits(int[] a) {
		Map<Integer, Integer> map =  new TreeMap<Integer,Integer>();
		
		for (int i=0;i<a.length;i++) map.put(a[i], sumDigits(a[i]));
		
		Set<Entry<Integer,Integer>> ent = map.entrySet();
		for(Entry<Integer,Integer> e : ent) {
			System.out.println("El valor " + e.getKey() 
				+ " tiene una sumatoria de digitos de " + e.getValue());
		}
	}
	
	public static int[] copyArray(int[] ar) {
		int[] copy = new int[0];
		for(int value : ar)
			copy = appendToNew(copy,value);
		
		return copy;
	}
	
	public static int[] appendToNew(int[] array, int value) {
		// TODO Auto-generated method stub
		int[] bigger = new int[array.length + 1];
		for (int i =0;i<array.length;i++)
			bigger[i] = array[i];
		
		bigger[bigger.length - 1] = value;
		
		return bigger;
	}
	
	public static int sumDigits(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n%10;
			n/=10;
		}
		return sum;
	}
	
	public static int reverseInt(int n) {
		long rev=0;
		while(n != 0) {
			int digit = n % 10;
			rev = rev * 10 + digit;
			n/=10;
		}
		
		if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)rev;
        }
	}
	
	public static int[] twoSum(int[] num, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			int complement = target - num[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(num[i],i);
		}
		throw new IllegalArgumentException("No solution");
	}
	
	public static int sqrt(int x) {
		long start = 0, mid = 0, end = x;
		
		while (start +1 < end) {
			mid = start + (end - start) / 2;
			if (mid * mid == x)return (int)mid;
			else if(mid * mid < x) start =  mid;
			else end = mid;
		}
		
		if(end * end == x) return (int)end;
		
		return (int)start;
		
	}
	
	public static double pow(double x, int z) {
		if(z < 0) return 1 / helper(x,z);
		else return helper(x,z);
	}
	
	private static double helper (double x, int n) {
		if (n==0) return 1;
		
		double v = helper(x, n/2);
		
		if(n%2==0) return v*v;
		else return v*v*x;
	}
	
	public static int superPow(int a, int[] b) {
		int result = 1 ;
		for (int i=0;i<b.length;i++) {
			result = helper(result,10) * helper(a,b[i]) % 1337;
		}
		
		return result;
	}

	private static int helper(int x, int n) {
		if(n==0) return 1;
		if(n==1) return x % 1337;
		
		return helper(x%1337, n/2) * helper(x%1337, n-n/2) % 1337;
	}
	
	public static int nthUglyNumber(int n) {
		if(n<=0 || n > 1690) return 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int i=0,j=0,k=0;
		
		while(list.size() < n) {
			int m2 = list.get(i)*2;
			int m3 = list.get(j)*3;
			int m5 = list.get(k)*5;
			
			int min = Math.min(m2, Math.min(m3, m5));
			list.add(min);
			
			if(min==m2) i++;
			if(min==m3) j++;
			if(min==m5) k++;
		}
		
		return list.get(list.size()-1);
	}
	
	public static int divide(int dividend, int divisor) {
		if(divisor == 0) return Integer.MAX_VALUE;
		if(divisor == -1 && dividend == Integer.MIN_VALUE) 
			return Integer.MAX_VALUE;
		
		long pDividend = Math.abs((long)dividend);
		long pDivisor = Math.abs((long)divisor);
		
		int result = 0;
		
		while (pDividend >= pDivisor) {
			int numShift = 0;
			while(pDividend >=(pDivisor << numShift)) numShift++;
			
			result += 1<<(numShift-1);
			pDividend -= (pDivisor<<(numShift-1));
		}
		
		if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) return result;
		else return -result;
	}
	
	public static int minCostToMoveChips(int[] chips) {
		return (int) Math.min(Arrays.stream(chips).filter(chip -> chip %2 ==0).count(),
				Arrays.stream(chips).filter(chip -> chip % 2 !=0).count());
	}
	
	public static int magicSquare(int[][] s) {
		int[][] frame1 =
			{{4, 9, 2},
			 {3, 5, 7},
			 {8, 1, 6}};

		    int[][] frame11 =
			{{8, 1, 6},
			 {3, 5, 7},
			 {4, 9, 2}};

		    int[][] frame2 =
			{{8, 3, 4},
			 {1, 5, 9},
			 {6, 7, 2}};

		    int[][] frame12 =
			{{4, 3, 8},
			 {9, 5, 1},
			 {2, 7, 6}};

		    int[][] frame3 =
			{{6, 1, 8},
			 {7, 5, 3},
			 {2, 9, 4}};

		    int[][] frame13 =
			{{2, 9, 4},
			 {7, 5, 3},
			 {6, 1, 8}};

		    int[][] frame4 =
			{{2, 7, 6},
			 {9, 5, 1},
			 {4, 3, 8}};

		    int[][] frame14 =
			{{6, 7, 2},
			 {1, 5, 9},
			 {8, 3, 4}};
		    
		    int cost1 = diff(s,frame1);
		    int cost2 = diff(s,frame2);
		    int cost3 = diff(s,frame3);
		    int cost4 = diff(s,frame4);
		    
		    int cost11 = diff(s,frame11);
		    int cost12 = diff(s,frame12);
		    int cost13 = diff(s,frame13);
		    int cost14 = diff(s,frame14);
		    
		    int min1 = Math.min(cost1, Math.min(cost2, Math.min(cost3, cost4)));
		    int min2 = Math.min(cost11, Math.min(cost13, Math.min(cost13, cost14)));
		    
		    return Math.min(min1, min2);
	}
	
	private static int diff(int[][] numbers, int[][]frame) {
		int cost = 0;
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cost += Math.abs(numbers[i][j] - frame[i][j]);
			}
		}
		return cost;
	}
	
	public static boolean zeroSumSubArray(int[] A) {
		Set<Integer> set = new HashSet<>();
		
		set.add(0);
		int sum = 0;
		
		for (int n : A) {
			sum += n;
			if(set.contains(sum)) return true;
			set.add(sum);
		}
		
		return false;
	}
		
	public static void printAllSubArrays(int[] A) {
		Map<Integer,List<Integer>> hashMap = new HashMap<>();
		
		insert(hashMap,0,-1);
		int sum = 0;
		
		for (int i=0;i<A.length;i++) {
			sum += A[i];
			if (hashMap.containsKey(sum)) {
				List<Integer> list = hashMap.get(sum);
				
				for(Integer value: list) {
					System.out.println("Subarray [ " + (value+1) + ".." + i +"]");
				} 
			}
			insert(hashMap,sum,i);
		}
	}
	
	private static<K,V> void insert (Map<K,List<V>> hashMap, K key, V value) {
		if(!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}
		
		hashMap.get(key).add(value);
	}
	
	
	public static int findMissingNumber(int[] nums) {
		int val;
		int nextval;
		
		int n = nums.length;
		
		for (int i=0;i<n;i++) {
			if(nums[i] <= 0 || nums[i] > n) continue;
			
			val = nums[i];
			
			while(nums[val-1] != val) {
				nextval = nums[val-1];
				nums[val-1] = val;
				val = nextval;
				if(val <= 0 || val > n) break;
			}
		}
		
		for (int i=0;i<n;i++) {
			if(nums[i] != i+1) return i+1;
		}
		
		return n+1;
	}
	
	public static int missingNumber(int[] nums) {
		int total=0;
		int n = nums.length;
		
		//total = (n+1) * (n+2) / 2;
		for (int i=0;i<n;i++) {
			total += nums[i];
			//total -=nums[i-2];
		}
		
		return n*(n+1)/2-total;
	}
	
	public static int activityNotifications(int[] expenditure, int d) {
		final int MAX_EXP = 201;
		
		int[] count = new int[MAX_EXP];
		int result = 0;
		int median =0;
		
		for(int i=0;i<d;i++)
			count[expenditure[i]]++;
		
		for(int i=d;i<expenditure.length;i++) {
			median = getMedian(count,d);
			if(median <= expenditure[i]) {
				result++;
			}
			count[expenditure[i-d]]--;
			count[expenditure[i]]++;
		}
		return result;
	}

	private static int getMedian(int[] count, int d) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0;i<count.length;i++) {
			sum += count[i];
			if((2*sum) == d) return 2*i+1;
			else if((2*sum) > d) return i*2;
		}
		return 1;
	}
	
	/*
	 * 
	 * Implement find median with quicksort algotrithm*/
	public static int findMedian(int[] arr) {
		//Arrays.sort(arr);
		quickSort(arr,0,arr.length-1);
		return arr[arr.length/2];
	}
	
	private static void quickSort(int[] arr, int izq, int der) {
		// takes a O(n log(n)) time for execution
		int pivot = arr[izq];
		int elemIzq = izq+1;
		int elemDer = der;
		int temp=0;
		
		if(izq>=der) return;
		
		while(elemIzq <= elemDer) {
			while(elemIzq <= der && arr[elemIzq]< pivot) {
				elemIzq++;
			} 
			
			while(elemDer > izq && arr[elemDer] >= pivot) {
				elemDer--;
			}
			
			if(elemIzq < elemDer) {
				temp = arr[elemIzq];
				arr[elemIzq] = arr[elemDer];
				arr[elemDer] = temp;
			}
		}
		if(elemDer > izq) {
			temp = arr[izq];
			arr[izq] = arr[elemDer];
			arr[elemDer]=temp;
		}
		
		quickSort(arr,izq,elemDer-1);
		quickSort(arr,elemDer+1,der);
		
	}
	
	public static int centuryFromYear(int year) {
		if(year % 100 == 0)
			return year/100;
		else
			return (year/100)+1;
	}
	
	/*
	 * end implementation
	 * */
	
	public static void main(String[] arg) {
		int[] ar = {3,5,2,1,77,4,89,32,5,9,54,202,100,997,3,1,3,2,8,115,225,547};
		sonPrimos(ar);
		
		System.out.println(factorial(8));
		System.out.println(fibonaci(8));
		
		int[] ar2 = copyArray(ar);
		
		allSumDigits(ar2);
		
		int[] ar3 = twoSum(ar2,14);
		for (int a : ar3) {
			System.out.println(a);
			
		}
		
		System.out.println(reverseInt(543));
		System.out.println(sqrt(8));
		System.out.println(pow(2.0,-2));
		System.out.println(superPow(2,ar2));
		System.out.println(nthUglyNumber(10));
		
		System.out.println(divide(-2147483648,-1));
		System.out.println(minCostToMoveChips(new int[] {2,2,2,3,3}));
		
		System.out.println(zeroSumSubArray(new int[] {4,-6,3,-1,4,2,7}) ? "Subarray" : "No Subarray");
		printAllSubArrays(new int[] {4,-6,3,-1,4,2,7});
		
		System.out.println(findMissingNumber(new int[] {3,4,-1,1}));
		
		System.out.println(missingNumber(new int[] {3,0,1}));
		
		System.out.println(activityNotifications(new int[] {2,3,4,2,3,6,8,4,5},5));
		
		System.out.println(findMedian(new int[] {4,2,3,5,1,9,10,8,7,6,0}));
		
		System.out.println(centuryFromYear(1905));
	}
}

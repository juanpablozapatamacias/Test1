package training.sorting.quicksort.itereativeQS;

public class IterativeQuickSort implements QuickSort {

	@Override
	public void swap(int[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}

	@Override
	public int partition(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		int x = arr[h];
		int i = (l-1);
		
		for(int j=l;j<=h;j++) {
			if(arr[j] <= x) {
				i++;
				swap(arr,i,j);
			}
			
		}
		swap (arr,i+1,h);
		return (i+1);
	}
	
	@Override
	public void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	@Override
	public void quickSort(int[] arr, int l, int h) {
		// initialize auxiliar stack
		int[] stack = new int[h-1+1];
		
		// initialize top of stack
		int top = -1;
		
		// push initial values in stack
		stack[++top] = l;
		stack[++top] = h;
		
		while(top >=0) {
			//pop h and l
			h = stack[top--];
			l = stack[top--];
			
			// set pivot element as its proper position
			int p = partition(arr,l,h);
			
			//if there are elements on the left side pivot
			// then push to the left side to stack
			if(p-1 > l) {
				stack[++top] = l;
				stack[++top] = p-1;
			}
			
			//if there are elements on the right side pivot
			// then push to the right side to stack
			if(p+1 < h) {
				stack[++top] = p+1;
				stack[++top] = h;
			}
		}
	}

	
}

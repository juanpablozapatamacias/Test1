package training.heaps;

public class MinHeap<T extends Comparable> extends Heap<T> {

	public MinHeap(Class<T> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}
	
	public MinHeap(Class<T> clazz, int size) {
		super(clazz,size);
	}

	protected void siftDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		
		int smallerIndex = -1;
		
		if(leftIndex != -1 && rightIndex != -1) {
			smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 
					? leftIndex:rightIndex;
		}
		
		else if(leftIndex != -1) smallerIndex = leftIndex;
		else smallerIndex = rightIndex;
		
		if(smallerIndex == -1) return;
		
		if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
			swap(smallerIndex,index);
			siftDown(smallerIndex);
		}
		
	}
	
	protected void siftUp(int index){
		int parentIndex = getParentIndex(index);
		
		if(parentIndex !=-1 && 
				getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex))>0) {
			swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}
	
	public void insert(T value) throws HeapFullException{
		if(count >= array.length) throw new HeapFullException();
		array[count] =  value;
		siftUp(count);
		count++;
	}	
	
	public T removeHighestPriority() {
		T min;
		try {
			min = getHighestPriority();
			array[0] = array[count-1];
			count--;
			siftDown(0);
			
			return min;
		} catch (HeapEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public T getHighestPriority() throws HeapEmptyException {
		// TODO Auto-generated method stub
		if(count ==0) throw new HeapEmptyException();
		
		return array[0];
	}
}

class HeapFullException extends Exception{}
class HeapEmptyException extends Exception{}

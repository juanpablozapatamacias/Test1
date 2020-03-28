package training;

public class ArrayContainer implements Comparable<ArrayContainer>{

	private int[] arr;
	private int index;
	
	public ArrayContainer(int[] arr, int index) {
		this.arr = arr;
		this.index = index;
	}
	
	@Override
	public int compareTo(ArrayContainer o) {
		return this.arr[this.index] - o.arr[o.index];
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}

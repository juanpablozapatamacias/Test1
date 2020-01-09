package itexico.training.colas.implementation;

class Point{

	int x;
	int y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

public class CastleGrid {

	public static final int[] X_OFFSETS = {-1,0,1,0};
	public static final int[] Y_OFFSETS = {0,1,0,-1};
	
	public static int minimumMoves(String[] x) {
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

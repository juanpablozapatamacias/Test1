package itexico.training.figures;


public class CircleThree {
	
	static final double TOL = 0.0000001;
	
	static class Point{
		double x = 0.0, y=0.0;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "("+x+","+y+")";
		}
		
	}
	
	static class Circle{
		Point center;
		double rad;
		
		public Circle(Point c, double r) {
			this.center = c;
			this.rad = r;
		}
		
		@Override
		public String toString() {
			return new StringBuilder().append("Center= ").append(center).append(" Radius= ").append(rad).toString();
		}
	}
	
	public static double getOrientation(Point p1, Point p2, Point p3) {
		double val1 = (p2.y-p1.y) * (p3.x-p2.x);
		double val2 = (p2.x-p1.x) * (p3.y-p2.y);
		double val = val1 - val2;
		
		return (val == 0.0) ? 0 : val;
	}
	
	public static Circle circleFromThreePoints(Point p1, Point p2, Point p3) {
		
		
		if (getOrientation(p1,p2,p3) != 0.0) {
			//Point 2 gets the equation x^2 + y^2
			final double offset = Math.pow(p2.x, 2) + Math.pow(p2.y, 2);
			
			// Get midpoints from P1 to P2
			final double bc = (Math.pow(p1.x,2) + Math.pow(p1.y, 2) - offset) / 2.0;
			
			// Get midpoints from P2 to P3
			final double cd = (offset - Math.pow(p3.x, 2) - Math.pow(p3.y, 2)) / 2.0;
			
			final double det = (p1.x - p2.x) * (p1.y - p2.y) - (p2.x - p3.x) * (p2.y - p3.x);
			
			if(Math.abs(det) < TOL) throw new IllegalArgumentException("Too Lazy");	
			
			final double idet = 1/det;
			
			final double centerx = (bc *(p2.y - p3.y) - cd*(p1.y - p2.y)) *idet;
			final double centery = (cd *(p1.x - p2.x) - bc*(p2.x - p3.x)) *idet;
			final double radius = Math.sqrt(Math.pow(p2.x-centerx, 2) + Math.pow(p2.y - centery, 2));
			
			return new Circle(new Point(centerx,centery),radius);
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		//CircleThree circle = new CircleThree();
		Point p1 = new Point(0.0,1.0);
	    Point p2 = new Point(1.0,0.0);
	    Point p3 = new Point(2.0,3.0);
	    
	    System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p2.toString());
	    
	    Circle c = circleFromThreePoints(p1, p2, p3);
	    System.out.println(c.toString());
	}

}



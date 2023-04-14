package ¼÷Á¦¸¦ÇØº¾½Ã´Ù;

class Point
{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class ¼÷Á¦_´ëÄªÀÌµ¿ {

	public static void main(String[] args) {
		
		// Á¡ p1
		Point p1 = new Point(3,3);
	
		// ´ëÄªÁ¡
		Point SymmetryPoint = new Point(5,5);
		
		System.out.println("XÃà ´ëÄªÀº : p2 = " + 
				(SymmetryPoint.x -((SymmetryPoint.x - p1.x) * 2)) + "," + p1.y);
		
		System.out.println("YÃà ´ëÄªÀº : p2 = " + 
				p1.x + "," +  (SymmetryPoint.y -((SymmetryPoint.y - p1.y) * 2)));
		
		System.out.println("p1Á¡ ´ëÄªÀº : p2 = " +
				(SymmetryPoint.x -((SymmetryPoint.x - p1.x) * 2)) + "," + 
				(SymmetryPoint.y -((SymmetryPoint.y - p1.y) * 2)));
		
	}

}

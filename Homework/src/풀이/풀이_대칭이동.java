package 풀이;

class Point
{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void PrintPoint()
	{
		System.out.println(x + "," + y);
	}
}


public class 풀이_대칭이동 {

	public static void main(String[] args) {
		
		Point p1 = new Point(3,3);
		Point p2 = new Point(5,5);
		
		p1.x = -p1.x;
		System.out.println("x축 대칭 : ");
		p1.PrintPoint();
		p1.y = -p1.y;
		p1.x = -p1.x;
		System.out.println("y축 대칭 : ");
		p1.PrintPoint();
		p1.x = -p1.x;
		System.out.println("원점 대칭 : ");
		p1.PrintPoint();
		
	}

}

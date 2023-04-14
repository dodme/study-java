package 숙제를해봅시다;

// 도형만들기
// Shape을 상속받는
// Ellipse, RectAngle, TriAngle을 만드세요!


// output
// 원을 그립니다.
// 사각형을 그립니다.
// 삼각형을 그립니다.

class Shape
{
	public void Draw()
	{
		System.out.println("을 그립니다.");
	}
}

class Ellipse extends Shape
{
	public void Draw()
	{
		System.out.print("원");
		super.Draw();
	}
}

class RectAngle extends Shape
{
	public void Draw()
	{
		System.out.print("사각형");
		super.Draw();
	}
}

class TriAngle extends Shape
{
	public void Draw()
	{
		System.out.print("삼각형");
		super.Draw();
	}
}

public class 문제_도형만들기 {

	public static void main(String[] args) {
		
		Shape shape[] = { new Ellipse(), new RectAngle(), new TriAngle() };
		
		for(int i = 0; i < 3; i++)
		{
			shape[i].Draw();
		}
		
	}

}

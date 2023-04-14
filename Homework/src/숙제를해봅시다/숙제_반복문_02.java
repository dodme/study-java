package 숙제를해봅시다;

public class 숙제_반복문_02 {

	public static void main(String[] args) {
		
		//출력하고싶은 줄의 수
		int line = 5;
		//출력할 문자
		char star = '*';
		
		
		// *이 line수만큼 하나씩 증가하며 출력
		for(int i = 1; i <= line; i++)
		{
			for(int num = 1; num <= i; num++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// *이 line수만큼 하나씩 감소하며 출력
		for(int i = line; i >= 1; i--)
		{
			for(int num = 1; num <= i; num++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
		
		System.out.println();
		
		// *이 line줄만큼 삼각형모양으로 출력
		for(int i = 1; i <= line; i++)
		{
			// 공백을 출력하는 코드
			for(int num1 = (line - 1); i <= num1; num1--)
			{
			System.out.print(" ");
			}
			// *을 출력하는 코드
			for(int num2 = 1; ((i * 2) - 1) >= num2; num2++)
			{
			System.out.print(star);
			}
			System.out.println();
		}
	}

}

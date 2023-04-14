package 풀이;

public class 풀이_반복문_02 {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < (i + 1); j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < (5 - i); j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < (6 - i); j++)
			{
				System.out.print(" ");
			}
			
			for(int k = 0; k < (1 + (i * 2)); k++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
	}

}




// 피보나치수열 
/// 

// 유클리드호제법
/// 두 수의 최대공약수를 구하는 알고리즘


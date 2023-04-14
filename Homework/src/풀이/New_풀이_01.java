package 문제;

import java.util.Scanner;

public class New_풀이_01 {

	public static void main(String[] args) {
		
		// 두 수의 최대공약수를 구하세요
		// 두 수를 입력받으세요
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter The Integer : ");
		int A = Integer.parseInt(scan.nextLine());
		
		System.out.print("Enter The Integer : ");
		int B = Integer.parseInt(scan.nextLine());
		
		int result = 0;
		// 약수 : 어떤 수로 정수를 나눴을 때 나머지가 0이 되는 수
		
		while(B > 0)
		{
			result = A % B;
			A = B;
			B = result;
		}
		
		System.out.println(A);
		
		scan.close();
	}

}

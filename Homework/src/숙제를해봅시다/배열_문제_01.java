package 숙제를해봅시다;

import java.util.Scanner;

public class 배열_문제_01 {

	public static void main(String[] args) {

		// 철수의 점수는 20, 30, 48 50
		// 철수의 성적을 출력하는 프로그램을 만듭니다.
		// 철수의 국어성적, 영어성적, 수학성적, Java성적을 모두 출력하세요.


		Scanner scan = new Scanner(System.in);
		
		//int Subject = Integer.parseInt(scan.nextLine());

		Object[] inputNum = {Integer.parseInt(scan.nextLine())};		

		for(Object i : inputNum)
		{
			System.out.println(i);
		}
		
		scan.close();
	}

}

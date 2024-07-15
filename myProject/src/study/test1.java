package study;

import java.util.Scanner;

public class test1 {
	public static void main(String[] arags) {
		/*
		 * for(int i = 1; i <= 9; i++) { System.out.println(i * 3); }
		 * 
		 * for(int i = 1; i <= 9; i++) { System.out.println("3*" + i + "=" + i * 3); }
		 */
				
		// 클래스를 사용가능 상태로 만듦
		Scanner scn = new Scanner(System.in);
		
		System.out.print("단을 입력해주세요>>");		
		
		// nextInt() 라는 메소드를 통해 입력값을 받음
		int dan = scn.nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.println( dan + "*" + i + "=" + i * dan);
		}
		
		System.out.print("별 갯수를 입력하세요>>");
		int number = scn.nextInt();
		for(int i = 1; i <=number; i++) {
			System.out.print("*");
		}
		
		scn.close();
	}
}

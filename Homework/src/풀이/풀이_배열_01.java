package 풀이;

import java.util.Scanner;

public class 풀이_배열_01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] arrStr = new String[] {"국어", "영어", "수학", "java"};
		
		/* int[] arrScore = new int[] {20,30,48,50}; */
		
		/*
		 * for(int i = 0; i < 4; i++) { System.out.print(arrStr[i]);
		 * System.out.println(arrScore[i]); }
		 */
		
		for(String str : arrStr)
		{
			System.out.print(str + "성적 : ");
			int score = Integer.parseInt(scan.nextLine());
			System.out.println(score);
		}
		
		scan.close();
		
	}

}

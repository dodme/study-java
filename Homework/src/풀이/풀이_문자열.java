package 풀이;

import java.util.Scanner;

public class 풀이_문자열 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// 문자열 뒤집기~
		String inputStr = scan.nextLine();
		
		scan.close();
		
		for(int i = inputStr.length() - 1; i >= 0; i--)
		{
			System.out.print(inputStr.charAt(i));
		}
		
		
	}

}

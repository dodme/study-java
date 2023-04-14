package 숙제를해봅시다;

import java.util.Scanner;

public class 문제_문자열 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		
		for(int i =  (str.length() - 1); i >= 0; i--)
		{
			System.out.print(str.charAt(i));
		}
		
	}

}

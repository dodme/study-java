package iteration;

import java.util.Scanner;

public class _02_Iteration {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		/*
		 * Multiplier: for(int i = 0; i < 9; i++) { for(int j = 0; j < 9; j++) {
		 * System.out.println(i + "/" + j);
		 * 
		 * if(j > 5) { break Multiplier; } } }
		 */
		
		int num = input.nextInt();
		
		if(num > 2 && num < 10 && num == 5)
		{
			System.out.println("¸ÂÀ½");
		}
		
	}

}

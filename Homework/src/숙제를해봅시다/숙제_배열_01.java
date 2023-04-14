package ¼÷Á¦¸¦ÇØº¾½Ã´Ù;

import java.util.Scanner;

public class ¼÷Á¦_¹è¿­_01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int Num1 = Integer.parseInt(scan.nextLine());
		int Num2 = Integer.parseInt(scan.nextLine());
		

		if(Num1 > Num2)
		{
			for(int i = Num1; i > 0 ; i--)
			{
				if((Num1 % i) == 0)
				{
					if((Num2 % i ) == 0)
					{
						System.out.println(i);
						break;
					}
				}
			}
		}
		else
		{
			for(int i = Num2; i > 0 ; i--)
			{
				if((Num1 % i) == 0)
				{
					if((Num2 % i ) == 0)
					{
						System.out.println(i);
						break;
					}
				}
			}
		}
		

		scan.close();
	}

}

package 숙제를해봅시다;

import java.util.Scanner;

public class 수우우욱제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int workTime = 8;
		int pay = 8590;
		int startTime = Integer.parseInt(scan.nextLine());
		
		if(startTime <= 24 && startTime >= 0)
		{
			if(startTime >= 6 && startTime <= 14)
				System.out.println(workTime * pay + "원");
			else if(startTime > 14)
				System.out.println((workTime * pay) + ((startTime - 14) * 500) + "원");
			else
				System.out.println((workTime * pay) + ((6 - startTime) * 500) + "원");
		}
		else
			System.out.println("0 ~ 24사이의 시간을 입력해주세요.");
		
		
		scan.close();
		
	}

}

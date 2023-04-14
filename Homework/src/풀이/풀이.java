package 풀이;

import java.util.Scanner;

public class 풀이 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//일하는 시간
		int workTime = 8;
		//최저임금
		int pay = 8590;
		int nightTime = 0;
		int startworkTime = Integer.parseInt(scan.nextLine());


		if(startworkTime < 24)
		{
			if(startworkTime > 14)
			{
				//야간수당
				nightTime = startworkTime - 14;
				pay += (500 * nightTime);
				System.out.println((8590 * (workTime - nightTime)) + pay);
			}
			else
			{
				System.out.println((pay * workTime));
			}
				
		}
		else
			System.out.println("하루가 몇시간이지..?");
		
		scan.close();
	}

}
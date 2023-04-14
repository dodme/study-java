import java.util.Scanner;

public class Random {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		double double0 = (Math.random() * 100);
		
		int answer = (int)Math.floor(double0);
		
		
		System.out.println(double0);
		System.out.println(answer);
		
		int select = 0;
		while(true)
		{
			select = scan.nextInt();
			if(select > answer)
			{
				System.out.println("다운");
			}
			else if(select < answer)
			{
				System.out.println("업");
			}
			else
			{
				System.out.println("정답!");
				break;
			}
		}
		
	}

}

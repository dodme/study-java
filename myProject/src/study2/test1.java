package study2;

public class test1 {

	public static void main(String[] args) {

		int price = 2000;
		if(price >= 2000) {
			System.out.println("고가");
		}
		else {
			System.out.println("저가");
		}
		
		
		int number = 35;
		if(number == 0) {
			number -= 10;
		}
		else if (number%2 == 1) {
			number += 20;
		}
		else {
			number += 10;
		}
		System.out.println(number);
		
		
		boolean onOff = false;
		if(onOff == true) {
			onOff = false;
		}
		else {
			onOff = true;
		}
		System.out.println(onOff);
		
		
		int a = 10;
		int b = 20;
		int speed = 0;
		if (a > b) {
			speed += 10;
		}
		else if (a < b) {
			speed += 20;
		}
		else {
			speed = 0;
		}
		System.out.println(speed);
		
		
		int admission = 10000;
		int age = 7;
		if (age >= 1 && age <= 13) {
			admission *= 0.5;
		}
		else if (age > 13 && age <= 70) {
			admission *= 0.75;
		}
		else
		{
			admission = 0;
		}
		System.out.println("손님의 나이는 " + age + "세로 입장료는 " + admission + "원입니다.");
	}

}

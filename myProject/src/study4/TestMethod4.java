package study4;

import java.util.Calendar;

public class TestMethod4 {

	public static void main(String[] args) {

		System.out.println(args[0]);
		System.out.println(args[1]);

		myAge1(1999);
		System.out.println(myAge2(1994));
	}

	public static void myAge1(int yy) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		System.out.println("사용자 나이는 " + (year - yy) + "입니다.");
	}

	public static int myAge2(int yy) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		return (year - yy);
	}

	public static double test1() {

		double pi = 3.14;

		return pi;
	}

	public static String test2() {

		String msg = "welcome";

		return msg;

	}

	public static String[] test3() {

		String[] aa = { "a", "b" };
		return aa;
	}
}

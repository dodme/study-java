package study4;

public class CalcTest1 {

	public static void main(String[] args) {
		int a = 100;
		int b = 20;

		myCalc(a, b, "+");
	}

	public static void myCalc(int a, int b, String c) {

		int result = 0;

		switch (c) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}
		System.out.println(a + c + b + "=" + result);
	}
}

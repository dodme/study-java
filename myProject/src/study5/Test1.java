package study5;

public class Test1 {
	public static void main(String[] args) {

		int kor = 90;
		int eng = 80;
		sum(kor, eng);
		int avg = sum2(kor, eng) / 2;
		System.out.println("합계 : " + sum2(kor, eng) + ", 평균 : " + avg);
	}

	public static void sum(int a, int b) {
		int result = a + b;
		System.out.println(" 총합 : " + result);
	}

	public static int sum2(int a, int b) {
		int result = a + b;
		return result;
	}
}

package study4;

public class TestMethod6 {

	public static void main(String[] args) {
		int kor = 90;
		int eng = 88;

		mySum(kor, eng);
		myAvg(kor, eng);

		int[] score = { 90, 98, 56, 82, 76 };
		arraySum(score);
	}

	public static void mySum(int kor, int eng) {
		int sum = kor + eng;
		System.out.println(sum);
	}

	public static void myAvg(int kor, int eng) {
		int avg = (kor + eng) / 2;
		System.out.println(avg);
	}

	public static void arraySum(int[] score) {
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println("총합 : " + sum);
	}
}

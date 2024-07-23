package study3;

public class Test_Math2 {

	public static void main(String[] args) {

		int s1 = 90;
		int s2 = 80;
		int s3 = 100;

		System.out.println(Math.max(s1, s2));

		System.out.println(Math.max(s1, Math.max(s2, s3)));

		double avg = 86.67;
		// ceil(올림메서드) : 설정된 값보다 큰 정수값을 얻는 메서드
		System.out.println(Math.ceil(avg));
		// floor(내림메서드) : 설정된 값보다 작은 정수값을 얻는 메서드
		System.out.println(Math.floor(avg));

		// 소숫점 자리 아래를 출력되지 않게
		System.out.println(Math.ceil(avg));
		System.out.println((int) Math.ceil(avg));
		System.out.println(Math.round(Math.ceil(avg)));

	}

}

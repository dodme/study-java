package study3;

public class Test_Random {

	public static void main(String[] args) {

		// 난수 : 시스템이 임의로 던져주는 값
		// 난수의 값 : 0~1 사이의 값
		System.out.println(Math.random());

		double r1 = Math.random();
		System.out.println(r1);
		System.out.println(r1 * 100);
		System.out.println((int) (r1 * 100));

		System.out.println((int) (r1 * 45) + 1);

		for (int i = 0; i < 6; i++) {
			System.out.println((int) (Math.random() * 45) + 1);
		}
	}

}

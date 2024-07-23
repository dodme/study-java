package study3;

public class Test_Math {

	public static void main(String[] args) {

		// 1. ceil() : 소숫점 자리 아래를 올리는 메소드
		System.out.println(Math.ceil(98.2));
		System.out.println(Math.ceil(98.234));
		System.out.println(Math.ceil(98.9));
		System.out.println(Math.ceil(98.0));

		// 2. floor() : 소숫점 자리 아래를 내리는 메소드
		System.out.println(Math.floor(98.2));
		System.out.println(Math.floor(98.234));
		System.out.println(Math.floor(98.9));
		System.out.println(Math.floor(98.0));

		// 3. round() : 반올림(.5 이상)
		System.out.println(Math.round(98.2));
		System.out.println(Math.round(98.5));
		System.out.println(Math.round(98.9));
		System.out.println(Math.round(98.0));

		// 4. rint() : 반올림(.6 이상)
		System.out.println(Math.rint(98.2));
		System.out.println(Math.rint(98.5));
		System.out.println(Math.rint(98.6));
		System.out.println(Math.rint(98.0));

		// 5. abs() : 절댓값( 부호를 없앤다)
		System.out.println(Math.abs(-17));
		System.out.println(Math.abs(17));

		// 6. pow() : 제곱수
		System.out.println(Math.pow(10, 2));
		System.out.println(Math.pow(10, 3));

		// 7. sqrt() : 루트
		System.out.println(Math.sqrt(100));
		System.out.println(Math.sqrt(125));

		// 8. max(), min()
		System.out.println(Math.max(100, 101));
		System.out.println(Math.min(100, 101));

	}

}

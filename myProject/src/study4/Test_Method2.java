package study4;

public class Test_Method2 {

	public static void main(String[] args) {
		loop10();
		System.out.print("\n");
		loop20();
	}

	public static void loop10() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}

		int a = 1;
		while (a <= 10) {
			System.out.print(a + " ");
			a++;
		}
	}

	public static void loop20() {
		for (int i = 1; i <= 20; i++) {
			System.out.print(i + " ");
		}
	}

}

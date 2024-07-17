package study2;

public class test2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			System.out.println("포도 " + i + "송이");
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		int count1 = 0;
		for (int i = 101; i <= 109; i++) {
			System.out.print(i);
			count1++;
			if (count1 % 3 == 0) {
				System.out.print("\n");
				count1 = 0;
			}

		}

		int count2 = 0;
		for (int i = 1; i <= 14; i++) {
			System.out.print(i + "일");
			count2++;
			if (count2 % 7 == 0) {
				System.out.print("\n");
				count2 = 0;
			}
		}

		int count3 = 0;
		for (int i = 1; i <= 14; i++) {
			if (i < 10) {
				System.out.print("0" + i + "일");
			} else {
				System.out.print(i + "일");
			}
			count3++;
			if (count3 % 7 == 0) {
				System.out.print("\n");
				count3 = 0;
			}
		}

		int[] num = { 10, 20, 30, 40, 50, 60 };
		int sum = 0;
		for (int i = 0; i <= num.length - 1; i++) {
			sum += num[i];
		}
		System.out.print(sum);
	}

}

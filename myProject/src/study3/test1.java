package study3;

public class test1 {

	public static void main(String[] args) {
		String subject = "    Html,mysql,java    ";

		System.out.println(subject);

		subject = subject.replace("mysql", "oracle");
		System.out.println(subject);

		System.out.println(subject.length());

		// 공백 제거
		subject = subject.trim();
		System.out.println(subject);
		System.out.println(subject.length());

		System.out.println(subject.substring(12, 16));
		System.out.println(subject.substring(12));

		System.out.println(subject.charAt(5));
		System.out.println(subject.substring(5, 6));

		if (subject.indexOf("javascript") > -1) {
			System.out.println("존재함");
		} else {
			System.out.println("존재안함");
		}

		String[] split = subject.split(",");
		System.out.println(split[1]);

		String title = "자바프로그램 입문";
		String content = "자바를 이용하여 완성한다.";

		if (title.indexOf("자바") > -1 && content.indexOf("자바") > -1) {
			System.out.println("둘다 존재함");
		} else if (title.indexOf("자바") > -1 || content.indexOf("자바") > -1) {
			System.out.println("둘중 한곳에만 존재");
		} else {
			System.out.println("둘다 존재하지 않음");
		}

		String score = "eng:70,kor:90,math:80";
		String[] array = score.split(",");
		// String[] array = {"eng:70", "kor:90", math:80"};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		String score2 = "eng:70,kor:90,math:80";
		String[] array2 = score2.split(",");
		// String[] array = {"eng:70", "kor:90", math:80"};
		for (int i = 0; i < array2.length; i++) {
			String[] str = array2[i].split(":");
			System.out.print(str[1] + " ");
		}

		System.out.print("\n");

		String str = "java";
//		System.out.println("" + str.substring(0, 1));
//		System.out.println(" " + str.substring(1, 2));
//		System.out.println("  " + str.substring(2, 3));
//		System.out.println("   " + str.substring(3, 4));
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(str.substring(i, i + 1));
		}
	}

}

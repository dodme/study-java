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
	}

}

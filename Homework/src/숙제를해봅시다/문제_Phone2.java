package 숙제를해봅시다;

import java.util.Scanner;

class Phone
{
	public void From() { System.out.print("From."); }
	
	public void To() { System.out.print("To."); }
}

// 영희폰
class YPhone extends Phone
{
	private String UserName = "영희";
	
	// 영희가 메세지를 보내는 코드
	public void SendMessage(String username, String message)
	{
		super.From();
		System.out.println(UserName);
		System.out.println(message);
		super.To();
		System.out.println(username);
		System.out.println();
		
	}
	
	public String GetUserName() { return UserName; }
}

// 철수폰
class CPhone extends Phone
{
	private String UserName = "철수";
	
	// 철수가 메세지를 보내는 코드
	public void SendMessage(String username, String message)
	{
		super.From();
		System.out.println(UserName);
		System.out.println(message);
		super.To();
		System.out.println(username);
		System.out.println();
	}
	
	public String GetUserName() { return UserName; }
}



public class 문제_Phone2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 영희
		YPhone yh = new YPhone();
		// 철수
		CPhone cs = new CPhone();
		
		System.out.print("철수에게 보낼 문자 내용을 입력하세요 : ");
		String messagec = scan.nextLine();
		yh.SendMessage(cs.GetUserName(), messagec);
		
		System.out.print("영희에게 보낼 문자 내용을 입력하세요 : ");
		String messagey = scan.nextLine();
		cs.SendMessage(yh.GetUserName(), messagey);
		
		scan.close();
	}

}

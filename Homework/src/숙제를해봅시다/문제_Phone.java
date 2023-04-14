package 숙제를해봅시다;

// Phone을 만듭니다.

// 철수의 핸드폰과 영희의 핸드폰을 만들고,
// 철수가 보낸 문자를 영희가 받도록 하고,
// 영희가 철수에게 답장을 보내는 프로그램을 작성하세요.

// 문자내용 유저네임 보내는이 받는이

// output
// From. 철수
// 문자내용
// To. 영희

//From. 영희
//문자내용
//To. 철수

class Phone
{
	public void From()
	{
		System.out.print("From.");
	}
	
	public void To()
	{
		System.out.print("To.");
	}
}

class YPhone extends Phone
{
	private static String UserName;
	private String Message;
	
	public YPhone(String userName, String message)
	{
		UserName = userName;
		Message = message;
	}
	
	public void SendMessage()
	{
		super.From();
		System.out.println(YPhone.UserName);
		System.out.println(Message);
		super.To();
		System.out.println(CPhone.UserName);
	}
	
	public String GetUserName() { return UserName; }
}

class CPhone extends Phone
{
	private static String UserName;
	private String Message;
	
	public CPhone(String userName, String message)
	{
		UserName = userName;
		Message = message;
	}
	
	public void SendMessage()
	{
		super.From();
		System.out.println(CPhone.UserName);
		System.out.println(Message);
		super.To();
		System.out.println(YPhone.UserName);
	}
	
	public String GetUserName() { return UserName; }
}



public class 문제_Phone {

	public static void main(String[] args) {
		
		
		
	}

}

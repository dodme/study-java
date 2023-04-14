package 숙제를해봅시다;

class Character
{
	enum Job
	{
		전사,
		궁수,
		돚거,
		마법사
	}
	
	public String name;
	public int atk;
	public int def;
	public Job job;
	
	public void PrintCharacterInfo()
	{
		System.out.println("직업 : " + job);
		System.out.println("이릅 : " + name);
		System.out.println("공격력 : " + atk);
		System.out.println("방여력 : " + def);
	}
	
}

public class 문제_클래스_01 {

	public static void main(String[] args) {
		
		Character Player1 = new Character();
		Character Player2 = new Character();
		
		Player1.job = Character.Job.돚거;
		Player1.name = "도적야캐요";
		Player1.atk = 200;
		Player1.def = 50;
		
		Player1.PrintCharacterInfo();
		
		System.out.println();
		
		Player2.job = Character.Job.전사;
		Player2.name = "전사강해요";
		Player2.atk = 100;
		Player2.def = 5;
		
		Player2.PrintCharacterInfo();
	}

}




//Character 클래스를 만듭니다.
/// 이름
/// 직업
/// 공격력
/// 방여력

//output
/// 이름 : @@@
/// 직업 : @@@
/// 공격력 : 00
/// 방여력 : 00




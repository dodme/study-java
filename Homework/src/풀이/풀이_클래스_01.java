package 풀이;

// 변수 명령법
/// 카멜표기법 : 첫 단어의 첫글자는 소문자, 두번째단어의 첫굴자는 대문자(변수명명시) ex) int arrNum;
/// 파스칼표기법 : 첫 단어의 첫글자도 대문자, 두번째단어의 첫글자도 대문자(메서드, 열거형, 클래스 등) ex) int ArrNum;

class Character
{
	enum CharacterJob
	{
		김민자,
		홍팔천,
		홍칠천,
		김필두,
		민두식
	}
	
	// default 값이나 private의 경우 이름 앞에 _를 자주 붙인다.
	String _name;
	CharacterJob _job;
	int _damage;
	int _defence;
	
	public void SetCharacterInfo(String name, CharacterJob job, int damage, int defence)
	{
		_name = name;
		_job = job;
		_damage = damage;
		_defence = defence;
	}
	
	public void PrintCharacterInfo()
	{
		System.out.println(_name);
		System.out.println(_job);
		System.out.println(_damage);
		System.out.println(_defence);
	}
	
}




public class 풀이_클래스_01 {

	public static void main(String[] args) {
		
		Character player1 = new Character();
		player1.SetCharacterInfo("자바는 재밌어~?", Character.CharacterJob.민두식, 10, 10);
		player1.PrintCharacterInfo();
		
		Character player2 = new Character();
		player2.SetCharacterInfo("자바는 재밌어~?", Character.CharacterJob.민두식, 20, 30);
		player2.PrintCharacterInfo();
	}

}

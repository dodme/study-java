package TextRPG;

class Character
{
	public enum Job
	{
		Warrior,
		Thief,
		Archor
	}
	
	String _name;
	private Job _job;
	private int _hp;
	private int _atk;
	private int _def;
	
	public void SetCharacterInfo(String name, Job job)
	{
		_name = name;
		_job = job;
		
		if(_job == Job.Warrior)
		{
			_hp = 200;
			_atk = 15;
			_def = 15;
		}
		else if(_job == Job.Thief)
		{
			_hp = 150;
			_atk = 20;
			_def = 10;
		}
		else if(_job == Job.Archor)
		{
			_hp = 100;
			_atk = 30;
			_def = 10;
		}
	}
	
	public void PrintCharacterInfo()
	{
		System.out.println("이름 : " + _name);
		System.out.println("직업 : " + _job);
		System.out.println("체력 : " + _hp);
		System.out.println("공격력 : " + _atk);
		System.out.println("방어력 : " + _def);
	}
	
	public int GetHp() { return _hp; };
	public int GetAtk() { return _atk; };
	public int GetDef() { return _def; };
	
}

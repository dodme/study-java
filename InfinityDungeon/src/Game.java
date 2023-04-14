import java.util.Scanner;
public class Game {
	static Scanner input = new Scanner(System.in);
	static Creature user = new Human();
	static Creature monster = new Human();
	static int killCount = 0;
	static int potion = 3;
	
	public static void main(String[] args) 
	{
		game:
		while(true)
		{
			PrintState();
			if ( !UserAction( UserInput() ) )
			{
				continue game;
			};
			Sleep(0.5f);
			MonsterAction();
		}
	}
	
	public static void Sleep(int amount)
	{
		try
		{
			Thread.sleep(amount);
		}
		catch(Exception e)
		{
			
		};
	}
	public static void Sleep(float second)
	{
		try
		{
			Thread.sleep( (int)(second * 1000) );
		}
		catch(Exception e)
		{
			
		};
	}
	
	public static void MonsterAction()
	{
		if(monster.getAlive())
		{
			monster.AI(user);
		}
		else
		{
			monster.Death(user);
			++killCount;
			System.out.println(monster.getName() + ", 쓰러뜨렸다!");
			
			CloseBattle();
		}
	}
	
	public static void CloseBattle()
	{
		user.skillCooldown -= 1;
		Sleep(1.0f);
		monster = EnterMonster();
		System.out.println("쉴 틈 없이 " + monster.getName() + "의 습격!");
	}
	
	public static Creature EnterMonster()
	{
		int currentMonster = Creature.Random(0, 1);
		
		switch( currentMonster )
		{
			case 0 : return new Human();
			default: return new Human();
		}
	}
	
	public static boolean UserAction(int number)
	{
		switch(number)
		{
		case 1:
			user.DoAttack(monster);
			return true;
		case 2:
			if(user.skillCooldown <= 0)
			{
				user.Skill(monster);
				return true;
			}
			else
			{
				System.out.println("이번 전투에서 이미 스킬을 사용하셨습니다.");
				return false;
			}
		case 3:
			if(potion > 0)
			{
				--potion;
				user.TakeDamage(-100);
				System.out.println("포션을 사용하여 생명력을 100 회복했다!");
				return true;
			}
			else
			{
				System.out.println("남은 포션이 없습니다.");
				return false;
			}
		default : return false;
		}
	}
	
	public static int UserInput()
	{
		String CurrentInput = input.next();
		
		if(CurrentInput.length() > 0)
		{
			switch(CurrentInput.charAt(0))
			{
				case '1': return 1;
				case '2': return 2;
				case '3': return 3;
				default : return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	public static void PrintState()
	{
		System.out.println("-------------------------");
		System.out.println("[" + user.getName() + "]        |[" + monster.getName() + "]");
		System.out.println("[" + user.getCurHealth() + "/" + user.getMaxHealth() + "]    |"
				+ "[" + monster.getCurHealth() + "/" + monster.getMaxHealth() + "]");
		System.out.println("죽인 몬스터 : " + killCount + " / 남은 포션 : " + potion);
		if(user.skillCooldown > 0)
		{
			System.out.println("남은 쿨타임 : " + user.skillCooldown);
		}
		else
		{
			System.out.println("스킬 사용 가능");
		};
		System.out.println("-------------------------");
		System.out.println("1.공격 2.스킬 3.포션");
	}

}

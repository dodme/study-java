import java.util.Scanner;
public class game {

	static Scanner input = new Scanner(System.in);
	static Creature user = new Human();
	static Creature monster = EnterMonster();
	static int killCount = 0;
	static int potion = 3;
	
	public static void main(String[] args) 
	{
		System.out.println("당신은 던전에 빠졌습니다.");
		System.out.println("어디선가 자꾸만 몬스터가 튀어나오고 있습니다.");
		System.out.println("생존을 위해선 그들을 물리쳐야 할 겁니다.");
		Sleep(1.0f);
		
		game:
			while(true)
			{
				PrintState();  // 현재 상태를 보여줌
				if ( !UserAction( UserInput() ) )    // !를 붙이므로써 게임 중  false가 나오면 다시 처음으로 되돌려 준다는 의미
				{
					continue game;
				};
				Sleep(0.5f);
				MonsterAction();
				Sleep(0.5f);
				if ( !UserDeathCheck() )
				{
					break game;
				};
			};
			
			System.out.println("----------------------------------------");
			System.out.println(killCount + "마리의 몬스터를 사냥하고");
			if(potion > 0)
			{
				System.out.println("포션각을 재다가 죽었습니다.");
			}
			else
			{
				System.out.println("포션까지 다 써봤지만 역부족이었습니다.");
			};
			System.out.println("당신의 여정은 여기서 끝났습니다.");
	}
	
	public static void PrintState()
	{
		System.out.println("-----------------------------------------");
		System.out.println("[" + user.getName() + "]        |   [" + monster.getName() + "]");
		System.out.println("[" + user.getCurHealth() + "/" + user.getMaxHealth() + "]   | "
				+ "  [" +monster.getCurHealth() + "/" + monster.getMaxHealth() + "]" );
		System.out.println("죽인 몬스터 수: " + killCount + " | 남은 포션: " + potion);
        if(user.skillCooldown > 0)
        {
        	System.out.println("남은 쿨타임: " + user.skillCooldown);
        }
        else
        {
        	System.out.println("스킬 사용 가능");
        };
		System.out.println("-----------------------------------------");
		System.out.println("1. 공격  2. 스킬  3. 포션");
	}
	public static void Sleep(float second)
	{
		try
		{
			Thread.sleep( (int) (second * 1000) );
		}
		catch(Exception e)
		{
			
		};
	}

	public static int UserInput()    // 유저의 입력을 제한
	{
		String CurrentInput = input.next();
		
		if(CurrentInput.length() > 0)
		{
			switch(CurrentInput.charAt(0)) 
			{
			case '1' : return 1;
			case '2' : return 2;
			case '3' : return 3;
			default : return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	public static boolean UserAction(int number)   // 입력 받은 것을 액션으로 수행
	{
		switch(number)
		{
		case 1 : 
			  user.DoAttack(monster);
			  return true;
		case 2 : 
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
			
		case 3 : 
			  if(potion > 0)
			  {
				  --potion;
				  int totalHeal = user.TakeHeal(100);
				  System.out.println("포션을 사용하여 생명력을 " + totalHeal + " 회복했다!");
				  
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
	
	public static boolean UserDeathCheck()
	{
		return user.getAlive();
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
			System.out.println(monster.getName() + ", 쓰러뜨렸다!" );
			
			CloseBattle(); 
		};
	}
	
	public static void CloseBattle()
	{
		user.skillCooldown -= 1;  // 유저가 한 마리 죽일 때마다 쿨타임 1이 줄어듬
		Sleep(1.0f);
		monster = EnterMonster();
		System.out.println("쉴 틈 없이 " + monster.getName() + "의 습격!");
	}
 
	public static Creature EnterMonster()
	{
		//랜덤 뒤를 개수라고 생각하세요.
		int currentMonster = Creature.Random(0, 5);
		switch( currentMonster )
		{
		case 0 : return new Goblin();
		case 1 : return new Orc();
		case 2 : return new Dragon();
		case 3 : return new Vampire();
		case 4 : return new Gambler();
		default : return new Human();
		}
	}
}

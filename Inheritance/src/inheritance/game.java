package inheritance;

public class game {
	public static void main(String[] args)
	{
		attacker target = new attacker();
		
		target.Hit(10);
		
		System.out.println(target.GetHp());
	}
		
}

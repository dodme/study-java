public class game {

	public static void main(String[] args) {
		monster target = new monster();
		monster newOne = new monster(1024);
		
		target = null;
		//여기 쓰레기 있다. 치워.
		System.gc();
		
		monster monsterArray[] = { new monster(), new monster()};

		for(monster current : monsterArray)
		{
			System.out.println(current.ShowLife());
		};
		
		for(int i = 0; i < monsterArray.length; i++)
		{
			System.out.println(monsterArray[i].ShowLife());
		};
		
		try
		{
			Thread.sleep(1000);
			target.Hit(50);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("언제든");
		};
		
		
		//System.out.println("타겟 피 : " + target.ShowLife());
		System.out.println("뉴원 피 : " + newOne.ShowLife());
		
		System.out.println("전체 개수 : " + monster.currentNumber);
	}

}
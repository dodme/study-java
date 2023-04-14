package NumberBaseBall;

import java.util.Scanner;

public class NumberBaseBall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		//정답이 되는 배열입니다.
		int[] answerArray = new int[4];
        //수를 받아서 배열에 넣습니다.
		int[] selectArray = new int[answerArray.length]; //answerArray의 배열 길이와 동일하게 생성. 4
		//유저가 입력하는 실제 수입니다.
		int select = 0;
				
		int currentDigit = 1 ;
		//스트라이크랑 볼을 나중에 넣기 위해서 만들었습니다.
		int strike, ball = 0;
		
		//중복이 없을 때까지 돕니다.
		for(int i = 0; i < answerArray.length; i++)
		{   
			//랜덤 숫자 만들기
			answerArray[i] = (int)Math.floor(Math.random() * 9d +1);
			//중복확인
			for(int j = 0; j < i; j++)
			{
				if(answerArray[i] == answerArray[j])
				{
					--i;
				};
			};
		};
		
		System.out.println("준비됐어요.");
		
		/*
		for(int i = 0; i < answerArray.length; i++)
		{
			System.out.print(answerArray[i]);
		};
		System.out.println();
		*/
		
		game:
		while(true) //true 일단 그냥 실행하라는 의미 (게임같은 경우에는 사람이 끌 때까지 계속 돌려야하므로) , while(true)문 밑에 오는 것은 실행이 안됨.
		{
			select = input.nextInt();
			
			//플레이어의 입력을 4자리수로 고정합니다.
			select = select % 10000;
			if(select >= 1000)
			{
				System.out.println(select);
			}
			else
			{
				System.out.println("잘못 입력했어요.");
				continue;  //여기서 while문이 한 번 끝났다는 의미. break는 끝을 내면 완전히 끝. continue는 여기가 끝이긴 한데 다시 시작해라는 의미.
			};
		
    	    for(int i = 0; i < answerArray.length; i++)
    	    {
    		currentDigit = (int)Math.pow(10, 3-i);
    		selectArray[i] = select / currentDigit;
    	    select %= currentDigit;
    	    };
			
    	    
    	    strike = 0;
    	    ball = 0;
    	    
    	   //select 하나를 모든 answer에 하나하나 비교하는 과정
    	    for(int sel = 0; sel < selectArray.length; sel++)
    	    {
    	    	answerCheck:
    	    	for(int ans = 0; ans < answerArray.length; ans++)
    	    	{
    	    		
    	    		if(selectArray[sel] == answerArray[ans])
    	    		{
    	    			 if(ans == sel)
    	    	    	{
    	    	    		++strike;  //ans와 sel이 같은 지를 확인. 같다면 strike를 하나 추가
    	    	    		} 
    	    	         else 
    	    	    	{
    	    	    		++ball;  //다르다면 ball을 추가
    	    	    		} 
    	    	    	break answerCheck;
    	    		};
    	    	};
    	    };
    	    
    	    
    	    if(strike >= answerArray.length) //strike >= 4와 동일
    	    {
    	    	System.out.println("정답입니다!");
    	    	break game;
    	    }
    	    else
    	    {
    	    	System.out.println(strike + "스트라이크");
    	    	System.out.println(ball + "볼");
    	    };
			
		}
		
		

	}

}
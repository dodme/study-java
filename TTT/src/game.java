import java.util.Scanner;

public class game {
	//타일을 [비어있음 / O / X ] 세 개로 구분하기 위해 enum을 사용합니다.
	enum gridState
	{
		None,
		O,
		X
	}

	public static void main(String[] args) 
	{
		//맵입니다.
		gridState currentGrid[][] =
		{
			{gridState.None, gridState.None, gridState.None}, 
			{gridState.None, gridState.None, gridState.None},
			{gridState.None, gridState.None, gridState.None}
		};
		
		//입력을 받기 위해 스캐너를 준비합니다.
		Scanner input = new Scanner(System.in);
		
		//입력받은 내용을 저장하는 공간입니다.
		String currentInput;
		
		//유저 입력을 X축과 Y축 값으로 저장합니다.
		int lastInputX = 0;
		int lastInputY = 0;
		
		//현재 X의 턴이면 true, O의 턴이면 false로 구분하기 위해 넣습니다.
		boolean turnX = true;
		
		//실제 게임이 돌아가는 반복문입니다.
		//앞에 game이라고 이름을 붙여서 게임을 언제든 중단할 수 있게 합니다.
		game:
		while(true)
		{
			//X축과 Y축 입력을 받기 전에 초기화합니다.
			lastInputX = 0;
			lastInputY = 0;
			
			//입력을 받기 전에 누구의 턴인지 알려줍니다.
			if(turnX)
			{
				System.out.println("X의 턴입니다!");
			}
			else
			{
				System.out.println("O의 턴입니다!");
			};
			
			//실제 입력을 받는 부분.
			//[a~c] [0~2]까지 입력할 수 있습니다. (예시 : a1)
			currentInput = input.next();
			
			//a1과 같이 입력을 받을 때, 두 글자 이상 받지 않으면 오류가 발생합니다.
			//이를 방지하기 위해 글자 길이를 확인합니다.
			if(currentInput.length() < 2)
			{
				System.out.println("다시 입력하세요.");
				continue;
			}
			else
			{
				//글자 길이가 확인되면, 각 문자에 'a'와 '0'을 뺍니다
				//설명용 프레젠테이션 50P ~ 62P 참조
				lastInputY = currentInput.charAt(0) - 'a';
				lastInputX = currentInput.charAt(1) - '0';
				
				//맵은 [0][0]부터 [2][2]까지만 있기 때문에
				//이 범위를 넘는 값을 받았을 때에는 오류를 알려주고
				//처음으로 돌아갑니다.
				if( (lastInputY < 0 || lastInputY > 2) || (lastInputX < 0 || lastInputX > 2) )
				{
					System.out.println("범위를 넘었습니다.");
					continue;
				}
				else
				{
					//현재 놓으려는 위치가 비어있을 때에만, 타일을 놓습니다.
					if(currentGrid[lastInputY][lastInputX] == gridState.None)
					{
						if(turnX)
						{
							currentGrid[lastInputY][lastInputX] = gridState.X;
						}
						else
						{
							currentGrid[lastInputY][lastInputX] = gridState.O;
						};
					}
					//놓으려는 위치에 다른 것이 있다면, 오류를 알리고 되돌아갑니다.
					else
					{
						System.out.println("이미 있어요 ㅜㅜ");
						continue;
					};
				};
			};
			
			
			//현재 맵을 모두 출력합니다.
			for(int y = 0; y < currentGrid.length; y++)
			{
				for(int x = 0; x < currentGrid[y].length; x++)
				{
					//현재 참조하고 있는 위치에 따라서
					//무슨 글자를 출력할지 정합니다.
					switch(currentGrid[y][x])
					{
					case None:
						System.out.print("□");
						break;
					case X:
						System.out.print("X");
						break;
					case O:
						System.out.print("O");
						break;
					default:
						System.out.print(currentGrid[y][x]);
					};
				};
				//한 줄이 모두 끝난 뒤에 다음 줄로 넘어가기 위해서
				//한 줄 넘어가는 코드를 여기에 넣습니다.
				// System.out.println();도 같은 역할을 합니다.
				System.out.print("\n");
			}
			
			//가로와 세로를 돌면서, 누군가 이겼는지 확인합니다.
			//설명용 프레젠테이션 19P ~ 24P참조
			for(int i =0 ; i < currentGrid.length; i++)
			{
				if(currentGrid[0][i] == currentGrid[1][i] && currentGrid[0][i] == currentGrid[2][i])
				{
					if(currentGrid[0][i] != gridState.None)
					{
						System.out.println(currentGrid[0][i] + "가 이겼어요.");
						break game;
					};
				};
				if(currentGrid[i][0] == currentGrid[i][1] && currentGrid[i][0] == currentGrid[i][2])
				{
					if(currentGrid[i][0] != gridState.None)
					{
						System.out.println(currentGrid[i][0] + "가 이겼어요.");
						break game;
					};
				};
			};
			
			//대각선을 확인합니다.
			//설명용 프레젠테이션 25P
			if(currentGrid[1][1] == currentGrid[2][0] && currentGrid[1][1] == currentGrid[0][2])
			{
				if(currentGrid[1][1] != gridState.None)
				{
					System.out.println(currentGrid[1][1] + "가 이겼어요.");
					break game;
				};
			};
			//마찬가지로 반대쪽 대각선을 확인합니다.
			//설명용 프레젠테이션 26P
			if(currentGrid[1][1] == currentGrid[0][0] && currentGrid[1][1] == currentGrid[2][2])
			{
				if(currentGrid[1][1] != gridState.None)
				{
					System.out.println(currentGrid[1][1] + "가 이겼어요.");
					break game;
				};
			};
			
			//현재 턴을 확인해서 X의 턴이면 O로, O의 턴이면 X로 바꿉니다.
			//설명용 프레젠테이션 74P ~ 81P
			turnX = !turnX;
			
			//무승부를 확인하기 위해 모든 칸이 차있는지 확인합니다.
			//그러기 위해 우선 숫자 세는 칸을 0으로 초기화합니다.
			int currentFill = 0;

			//모든 칸을 돌면서, None이 아닌 타일이 있다면
			//무엇인가 들어있다는 뜻으로 해석하여
			//카운트를 1씩 더합니다.
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if( currentGrid[i][j] != gridState.None )
					{
						++currentFill;
					};
				};
			};

			//위에서 카운트를 한 개수가 9개 이상이면, 모든 칸이 차 있다는 뜻으로
			//무승부라고 띄운 뒤, 게임을 종료합니다.
			if(currentFill >= 9)
			{
				System.out.print("무승부입니다~");
				break game;
			};
		};
		
		input.close();
	}

}




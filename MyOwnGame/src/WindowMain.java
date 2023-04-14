import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WindowMain extends JFrame
{
	MainScreen myMainScreen = new MainScreen();
	SettingScreen mySettingScreen = new SettingScreen();
	GameScreen myGameScreen = new GameScreen();
	
	KeyboardPanel currentScreen;
	
	public WindowMain()
	{
		setTitle("바운스볼");
		setSize(640,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(null);
		myMainScreen.setSize(640,480);
		mySettingScreen.setSize(640,480);
		myGameScreen.setSize(640,480);
		setResizable(false);
		
		add(myMainScreen);
		add(mySettingScreen);
		add(myGameScreen);
		
		SetScreen(myMainScreen);
		//SetScreen(mySettingScreen);
	}
	
	public void SetScreen(int targetIndex)
	{
		switch(targetIndex)
		{
		case 0:
			SetScreen(myMainScreen);
			break;
		case 1:
			SetScreen(mySettingScreen);
			break;
		case 2:
			SetScreen(myGameScreen);
		default:
			return;
		};
	}
	
	public void SetScreen(KeyboardPanel target)
	{
		myMainScreen.setVisible(false);
		mySettingScreen.setVisible(false);
		myGameScreen.setVisible(false);
		
		if(target == myGameScreen)
		{
			myGameScreen.Start();
		};
		
		target.setVisible(true);
		currentScreen = target;
		repaint();
	}
}

class KeyboardPanel extends JPanel
{
	public void InputCheck(){}
	
	//가로 세로 똑같은 애
	void DrawImage(Graphics2D java2d, BufferedImage target, int locationX, int locationY, int size)
	{
		java2d.drawImage
		(
				//그리는 대상
				target,
				
				//위치
				locationX, locationY,
				
				//그리는 끝 위치
				locationX + size, locationY + size,
				
				//그림에서 그릴 위치
				0, 0,
				
				//그림에서 그릴 범위
				target.getWidth(), target.getHeight(),
				
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
	}
	
	//가로 세로 똑같은 애
	void DrawImage(Graphics2D java2d, BufferedImage target, int locationX, int locationY, int size, int maxIndex, int curIndex)
	{
		int eachPixel = target.getWidth() / maxIndex;
		java2d.drawImage
		(
				//그리는 대상
				target,
				
				//위치
				locationX, locationY,
				
				//그리는 끝 위치
				locationX + size, locationY + size,
				
				//그림에서 그릴 위치
				eachPixel * curIndex, 0,
				
				//그림에서 그릴 범위
				(eachPixel * curIndex) + eachPixel, target.getHeight(),
				
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
	}
	
	//가로와 세로가 다른 애
	void DrawImage(Graphics2D java2d, BufferedImage target, int locationX, int locationY, int sizeX, int sizeY)
	{
		java2d.drawImage
		(
				//그리는 대상
				target,
				
				//위치
				locationX, locationY,
				
				//그리는 끝 위치
				locationX + sizeX, locationY + sizeY,
				
				//그림에서 그릴 위치
				0, 0,
				
				//그림에서 그릴 범위
				target.getWidth(), target.getHeight(),
				
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
	}
}

class GameScreen extends KeyboardPanel
{
	BufferedImage imageBall;
	BufferedImage imageBlock;
	BufferedImage imageStar;
	BufferedImage imageBonc;
	BufferedImage imageOBnc;
	BufferedImage imageBrek;
	BufferedImage imageBlnk;
	BufferedImage imageDash;
	BufferedImage imageLsft;
	BufferedImage imageRsft;
	BufferedImage imageOlsf;
	BufferedImage imageOrsf;
	BufferedImage imageIsft;
	BufferedImage imageGrav;
	public GameScreen()
	{
		try
		{
			imageBall = ImageIO.read(new File("./src/sprites/ball.png"));
			imageBlock= ImageIO.read(new File("./src/sprites/block.png"));
			imageStar = ImageIO.read(new File("./src/sprites/star.png"));
			imageBlnk = ImageIO.read(new File("./src/sprites/blocks/blink.png"));
			imageBonc = ImageIO.read(new File("./src/sprites/blocks/bounce.png"));
			imageOBnc = ImageIO.read(new File("./src/sprites/blocks/bounceonce.png"));
			imageBrek = ImageIO.read(new File("./src/sprites/blocks/breakable.png"));
			imageDash = ImageIO.read(new File("./src/sprites/blocks/dash.png"));
			
			imageLsft = ImageIO.read(new File("./src/sprites/blocks/leftshift.png"));
			imageRsft = ImageIO.read(new File("./src/sprites/blocks/rightshift.png"));
			imageOlsf = ImageIO.read(new File("./src/sprites/blocks/leftshiftonce.png"));
			imageOrsf = ImageIO.read(new File("./src/sprites/blocks/rightshiftonce.png"));
			imageIsft = ImageIO.read(new File("./src/sprites/blocks/shiftItem.png"));
			imageGrav = ImageIO.read(new File("./src/sprites/blocks/reverse gravity.png"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		};
	}
	
	public void End()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		};
		GameMain.myWindow.SetScreen(0);
	}
	
	public void Start()
	{
		GameStatus.starNumber = 0;
		
		GameStatus.gravityDirection = Direction.down;
		
		GameStatus.isGravity = false;
		GameStatus.isDash = false;
		
		GameStatus.ball.radius = GameStatus.ballRadius;
		
		GameStatus.ball.posX = GameStatus.ballRadius;
		GameStatus.ball.posY = GameStatus.ballRadius;
		
		GameStatus.ball.spdX = 0;
		GameStatus.ball.spdY = 0;
		
		GameStatus.passedFrame = 0;
		
		GameStatus.currentMap = new BT[GameStatus.initialMap.length][];
		for(int y = 0; y < GameStatus.initialMap.length; y++)
		{
			GameStatus.currentMap[y] = new BT[GameStatus.initialMap[y].length];
			
			for(int x = 0; x < GameStatus.initialMap[y].length; x++)
			{
				GameStatus.currentMap[y][x] = GameStatus.initialMap[y][x];
				
				switch(GameStatus.currentMap[y][x])
				{
				case Star:
					++GameStatus.starNumber;
					break;
				case Spon:
					GameStatus.ball.posX = (x * GameStatus.gridSize) + (GameStatus.gridSize / 2);
					GameStatus.ball.posY = (y * GameStatus.gridSize) + (GameStatus.gridSize / 2);
					break;
				default:
					break;
				};
			};
		};
		
	}
	
	@Override 
	public void InputCheck()
	{
		//프레임 지날 때마다 하나씩
		++GameStatus.passedFrame;
		
		boolean leftMove = GameMain.checkKey.GetKey(KeyType.left);
		boolean rightMove = GameMain.checkKey.GetKey(KeyType.right);
		
		if(!(leftMove ^ rightMove))
		{
			if(Math.abs(GameStatus.ball.spdX) <= GameStatus.maxSpd + GameStatus.velSpd)
			{
				GameStatus.ball.spdX /= 2;
			}
			else
			{
				GameStatus.ball.spdX += (-GameStatus.ball.spdX / Math.abs(GameStatus.ball.spdX)) * 0.5f;
			};
		}
		else if(leftMove)
		{
			if(GameStatus.ball.spdX > -GameStatus.maxSpd)
			{
				GameStatus.ball.spdX -= GameStatus.velSpd;
			};
		}
		else if(rightMove)
		{
			if(GameStatus.ball.spdX < GameStatus.maxSpd)
			{
				GameStatus.ball.spdX += GameStatus.velSpd;
			};
		};
		
		if(GameMain.checkKey.GetKeyDown(KeyType.jump))
		{
			if(GameStatus.isGravity)
			{
				if(GameStatus.gravityDirection == Direction.down)
				{
					GameStatus.gravityDirection = Direction.up;
				}
				else if(GameStatus.gravityDirection == Direction.up)
				{
					GameStatus.gravityDirection = Direction.down;
				};
				GameStatus.isGravity = false;
			}
			else if(GameStatus.isDash)
			{
				if(leftMove ^ rightMove)
				{
					GameStatus.isDash = false;
					if(GameStatus.gravityDirection == Direction.up)
					{
						GameStatus.ball.spdY = 5.0f;
					}
					else if(GameStatus.gravityDirection == Direction.down)
					{
						GameStatus.ball.spdY = -5.0f;
					};
					
					if(leftMove)
					{
						GameStatus.ball.spdX = -12.0f;
					}
					else if(rightMove)
					{
						GameStatus.ball.spdX = 12.0f;
					};
				};
			};
		};
		
		GameLogic.Physics(GameStatus.ball);
		
		if(GameStatus.starNumber <= 0)
		{
			End();
		};
		
		if(GameStatus.ball.posY > 480.0f)
		{
			Start();
		};
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D java2d = (Graphics2D)g;
		java2d.setColor(Color.white);
		java2d.fillRect(0, 0, getWidth(), getHeight());

		int currentOpen = 0;
		
		try
		{
			for(int y = 0; y < GameStatus.currentMap.length; y++)
			{
				for(int x = 0; x < GameStatus.currentMap[y].length; x++)
				{
					
					currentOpen = 0;
					
					switch(GameStatus.currentMap[y][x])
					{
					case Wall:
						DrawImage(java2d, imageBlock, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Star:
						DrawImage(java2d, imageStar, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Bonc:
						DrawImage(java2d, imageBonc, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case OBnc:
						DrawImage(java2d, imageOBnc, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Brek:
						DrawImage(java2d, imageBrek, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Bln1:
						if(GameStatus.passedFrame % GameStatus.totalFrame < GameStatus.rapid)
						{
							currentOpen = 1;
						};
						DrawImage(java2d, imageBlnk, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize, 2, currentOpen);
						break;
					case Bln2:
						if(GameStatus.passedFrame % GameStatus.totalFrame >= GameStatus.rapid && GameStatus.passedFrame % GameStatus.totalFrame < GameStatus.rapid * 2)
						{
							currentOpen = 1;
						};
						DrawImage(java2d, imageBlnk, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize, 2, currentOpen);
						break;
					case Bln3:
						if(GameStatus.passedFrame % GameStatus.totalFrame >= GameStatus.rapid * 2)
						{
							currentOpen = 1;
						};
						DrawImage(java2d, imageBlnk, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize, 2, currentOpen);
						break;
					case Dash:
						DrawImage(java2d, imageDash, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Lsft:
						DrawImage(java2d, imageLsft, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Rsft:
						DrawImage(java2d, imageRsft, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Olsf:
						DrawImage(java2d, imageOlsf, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Orsf:
						DrawImage(java2d, imageOrsf, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Isft:
						DrawImage(java2d, imageIsft, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					case Grav:
						DrawImage(java2d, imageGrav, x * GameStatus.gridSize, y * GameStatus.gridSize, GameStatus.gridSize);
						break;
					default:
						break;
					};
				};
			};
		}
		catch(Exception e)
		{
			
		};
		
		
		DrawImage
		(
			java2d, imageBall, 
			(int)GameStatus.ball.posX - GameStatus.ballRadius,
			(int)GameStatus.ball.posY - GameStatus.ballRadius,
			GameStatus.ballRadius * 2
		);
		
		repaint();
	}
}

class SettingScreen extends KeyboardPanel
{
	JLabel upLabel = new JLabel("UP");
	JLabel downLabel = new JLabel("DOWN");
	JLabel leftLabel = new JLabel("LEFT");
	JLabel rightLabel = new JLabel("RIGHT");
	JLabel selectLabel = new JLabel("SELECT");
	JTextField upText;
	JTextField downText;
	JTextField leftText;
	JTextField rightText;
	JTextField selectText;
	
	public SettingScreen()
	{
		setLayout(null);
		
		JLabel InfoLabel = new JLabel("키보드 세팅");
		InfoLabel.setBounds(20,20,300,50);
		InfoLabel.setFont(new Font("나눔 고딕",Font.BOLD, 50));
		add(InfoLabel);
		
		upLabel.setBounds(50,100,200,30);
		upLabel.setFont(new Font("나눔 고딕",Font.BOLD, 30));
		downLabel.setBounds(50,150,200,30);
		downLabel.setFont(new Font("나눔 고딕",Font.BOLD, 30));
		rightLabel.setBounds(50,250,200,30);
		rightLabel.setFont(new Font("나눔 고딕",Font.BOLD, 30));
		leftLabel.setBounds(50,200,200,30);
		leftLabel.setFont(new Font("나눔 고딕",Font.BOLD, 30));
		selectLabel.setBounds(50,300,200,30);
		selectLabel.setFont(new Font("나눔 고딕",Font.BOLD, 30));
		
		upText = SettingSet(100, KeyInput.KeyCode2String(38), "위 키 변경",
		new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GameMain.checkKey.SetKeyChange(KeyType.up);
			}
		});
		
		downText = SettingSet(150, KeyInput.KeyCode2String(40), "아래 키 변경", 
			new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GameMain.checkKey.SetKeyChange(KeyType.down);
			}
		});
		
		rightText = SettingSet(250, KeyInput.KeyCode2String(39), "오른쪽 키 변경", 
			new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GameMain.checkKey.SetKeyChange(KeyType.right);
			}
		});
		
		leftText = SettingSet(200, KeyInput.KeyCode2String(37), "왼쪽 키 변경",
			new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GameMain.checkKey.SetKeyChange(KeyType.left);
			}
		});
		
		//키세팅용 버튼 세트를 만들어서, 버튼에 원하는 기능을 할당
		selectText = SettingSet(300, KeyInput.KeyCode2String(32), "선택 키 변경", 
			new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//점프 키를 바꾸고 싶다고 키 인풋한테 이야기를 합니다.
				GameMain.checkKey.SetKeyChange(KeyType.jump);
			}
		});
		
		JButton exitButton = new JButton();
		exitButton.setBounds(490,380,100,50);
		exitButton.setHorizontalAlignment(SwingConstants.CENTER);
		exitButton.setIcon(new ImageIcon("./src/sprites/button.png"));
		exitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GameMain.myWindow.SetScreen(0);
			}
		});
		add(exitButton);
		
		add(upLabel);
		add(downLabel);
		add(rightLabel);
		add(leftLabel);
		add(selectLabel);
	}
	
	private JTextField SettingSet(int wantY, String viewerString, String buttonString, ActionListener listener)
	{
		JTextField upViewer = new JTextField(viewerString);
		upViewer.setBounds(200, wantY, 100,30);
		upViewer.setEditable(false);
		upViewer.setHorizontalAlignment(SwingConstants.CENTER);
		add(upViewer);
		
		JButton upChange = new JButton(buttonString);
		upChange.setBounds(300, wantY, 150,30);
		upChange.addActionListener(listener);
		add(upChange);
		
		return upViewer;
	}
	
	@Override
	public void InputCheck()
	{
		upText.setText(KeyInput.KeyCode2String(KeyInput.keyCurrent[0]));
		downText.setText(KeyInput.KeyCode2String(KeyInput.keyCurrent[1]));
		leftText.setText(KeyInput.KeyCode2String(KeyInput.keyCurrent[2]));
		rightText.setText(KeyInput.KeyCode2String(KeyInput.keyCurrent[3]));
		selectText.setText(KeyInput.KeyCode2String(KeyInput.keyCurrent[4]));
		
		if(GameMain.checkKey.GetKey(KeyType.up))
		{
			upLabel.setForeground(Color.green);
		}
		else
		{
			upLabel.setForeground(Color.black);
		};
		
		if(GameMain.checkKey.GetKey(KeyType.down))
		{
			downLabel.setForeground(Color.green);
		}
		else
		{
			downLabel.setForeground(Color.black);
		};
		
		if(GameMain.checkKey.GetKey(KeyType.left))
		{
			leftLabel.setForeground(Color.green);
		}
		else
		{
			leftLabel.setForeground(Color.black);
		};
		
		if(GameMain.checkKey.GetKey(KeyType.right))
		{
			rightLabel.setForeground(Color.green);
		}
		else
		{
			rightLabel.setForeground(Color.black);
		};
		
		if(GameMain.checkKey.GetKey(KeyType.jump))
		{
			selectLabel.setForeground(Color.green);
		}
		else
		{
			selectLabel.setForeground(Color.black);
		};
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D java2d = (Graphics2D)g;
		java2d.setColor(Color.white);
		java2d.fillRect(0, 0, getWidth(), getHeight());
	}
}

class MainScreen extends KeyboardPanel
{
	BufferedImage imageBall;
	BufferedImage imageBlock;
	BufferedImage imageStar;
	BufferedImage imageClickableButton;
	BufferedImage imageLogo;
	
	int currentSelect = 0;
	
	boolean lastKeyUp = false;
	boolean lastKeyDown = false;
	
	@Override
	public void InputCheck()
	{
		if(GameMain.checkKey.GetKeyDown(KeyType.jump))
		{
			PlayMenu();
		};
		
		if(GameMain.checkKey.GetKeyDown(KeyType.up))
		{
			//currentSelect = Math.max(0, currentSelect - 1); // 멈추는 거
			currentSelect = ((currentSelect - 1) + 3) % 3; //넘어가는 거
			repaint();
		};
		
		if(GameMain.checkKey.GetKeyDown(KeyType.down))
		{
			//currentSelect = Math.min(2, currentSelect + 1); // 멈추는 거
			currentSelect = (currentSelect + 1) % 3; //넘어가는 거
			repaint();
		};
	}
	
	public MainScreen()
	{
		try
		{
			imageBall = ImageIO.read(new File(".//src//sprites//ball.png"));
			imageBlock = ImageIO.read(new File(".//src//sprites//block.png"));
			imageStar = ImageIO.read(new File(".//src//sprites//star.png"));
			imageClickableButton = ImageIO.read(new File(".//src//sprites//clickable button.png"));
			imageLogo = ImageIO.read(new File(".//src//sprites//logo.png"));
			
			setLayout(null);
			JButton gameButton = new JButton();
			gameButton.setBounds(0,150,313,81);
			gameButton.setBackground(new Color(0,0,0,0));
			gameButton.setFocusPainted(false);
			gameButton.setBorderPainted(false);
			
			gameButton.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) 
				{
					currentSelect = 0;
					PlayMenu();
					repaint();
				}
				@Override
				public void mouseExited(MouseEvent e) {repaint();}
				@Override
				public void mouseEntered(MouseEvent e) {
					currentSelect = 0;
					repaint();
				}
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					
				}
			});
			add(gameButton);
			
			JButton optionButton = new JButton();
			optionButton.setBounds(0,250,313,81);
			optionButton.setBackground(new Color(0,0,0,0));
			optionButton.setFocusPainted(false);
			optionButton.setBorderPainted(false);
			
			optionButton.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) 
				{
					currentSelect = 1;
					PlayMenu();
					repaint();
				}
				@Override
				public void mouseExited(MouseEvent e) {repaint();}
				@Override
				public void mouseEntered(MouseEvent e) {
					currentSelect = 1;
					repaint();
				}
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					
				}
			});
			add(optionButton);
			
			JButton ExitButton = new JButton();
			ExitButton.setBounds(0,350,313,81);
			ExitButton.setBackground(new Color(0,0,0,0));
			ExitButton.setFocusPainted(false);
			ExitButton.setBorderPainted(false);
			
			ExitButton.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) 
				{
					currentSelect = 2;
					PlayMenu();
					repaint();
				}
				@Override
				public void mouseExited(MouseEvent e) {repaint();}
				@Override
				public void mouseEntered(MouseEvent e) {
					currentSelect = 2;
					repaint();
				}
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					
				}
			});
			add(ExitButton);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D java2d = (Graphics2D)g;
		java2d.setColor(new Color(200,200,230));
		java2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
		
		java2d.setColor(Color.white);
		java2d.setFont(new Font("showcard Gothic",Font.BOLD, 80));
		//java2d.drawString("BouncyBall", 60, 100);
		DrawImage(java2d, imageLogo, 20, 50, 392, 73);
		
		java2d.setFont(new Font("showcard Gothic",Font.PLAIN, 30));
		
		
		int firstSelect = 0;
		if(currentSelect == 0)
		{
			firstSelect = 313;
		};
		
		java2d.drawImage
		(
				//그리는 대상
				imageClickableButton,
				//위치
				0, 150,
				//그리는 끝 위치
				0 + 313, 150 + 81,
				//그림에서 그릴 위치
				0 + firstSelect, 0,
				//그림에서 그릴 범위
				313 + firstSelect, 81,
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
		
		int secondSelect = 0;
		if(currentSelect == 1)
		{
			secondSelect = 313;
		};
		
		java2d.drawImage
		(
				//그리는 대상
				imageClickableButton,
				//위치
				0, 250,
				//그리는 끝 위치
				0 + 313, 250 + 81,
				//그림에서 그릴 위치
				0 + secondSelect, 0,
				//그림에서 그릴 범위
				313 + secondSelect, 81,
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
		
		int thirdSelect = 0;
		if(currentSelect == 2)
		{
			thirdSelect = 313;
		};
		
		java2d.drawImage
		(
				//그리는 대상
				imageClickableButton,
				//위치
				0, 350,
				//그리는 끝 위치
				0 + 313, 350 + 81,
				//그림에서 그릴 위치
				0 + thirdSelect, 0,
				//그림에서 그릴 범위
				313 + thirdSelect, 81,
				//그냥 넣어주시면 됩니다.
				getFocusCycleRootAncestor()
		);
		java2d.setColor(Color.black);
		//java2d.drawString(myString, (getWidth() / 2) - (width / 2), 200);
		java2d.drawString("Game Start", 50, 200);
		java2d.drawString("Option", 50, 300);
		java2d.drawString("Exit", 50, 400);
	}
	
	void PlayMenu()
	{
		switch(currentSelect)
		{
		case 0:
			GameMain.myWindow.SetScreen(2);
			break;
		case 1:
			GameMain.myWindow.SetScreen(1);
			break;
		case 2:
			GameMain.myWindow.dispose();
			break;
		default:
				return;
		}
	}
}
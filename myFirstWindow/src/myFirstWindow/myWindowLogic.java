package myFirstWindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myWindowLogic {

	static myOwnWindow myWindow = new myOwnWindow();
	
	
    public static void main(String[] args) 
    {
        
        myWindow.setTitle("그대로 쓸 수 있습니다");
        
        JLabel myLabel = new JLabel("글을 저장하는 용도");
        myWindow.add(myLabel);
        myWindow.setLayout(null);
    
        myLabel.setBounds(0, 0, myWindow.getWidth(), myWindow.getHeight() - 25);
        myLabel.setFont( new Font("궁서", Font.BOLD, 50) );
        myLabel.setVerticalAlignment(SwingConstants.TOP);
        myLabel.setText("중간에도 바꿔줄 수 있어요.");
        
        JButton myButton = new JButton();
        myWindow.add(myButton);
        myButton.setBounds(100, 100, 200, 50);
        myButton.setText("이건 버튼임");
        myButton.setFont( new Font("맑은 고딕", Font.BOLD, 30));
        myButton.setToolTipText("이거 누르면 안돼요");
        myButton.setForeground(Color.YELLOW);
        myButton.setBackground(Color.BLACK);
        
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                myWindow.dispose();
            }
        };
        myButton.addActionListener(listener);
        
        JButton fullscreenButton = new JButton();
        
        ActionListener listenForFullscreen = new ActionListener()
        {
            GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice myDevice = graphics.getScreenDevices()[0];
            boolean isFullScreen = false;
            
            @Override
            public void actionPerformed(ActionEvent e)
            {    
            	isFullScreen = myDevice.getFullScreenWindow() == myWindow;
            	
            	if(isFullScreen)
            	{
            		myDevice.setFullScreenWindow(null);
            		fullscreenButton.setText("전체화면");
            	}
            	else
            	{
            		myDevice.setFullScreenWindow(myWindow);
            		fullscreenButton.setText("창모드");
            	}
            	
            	//System.out.println(graphics.getScreenDevices()[0].getDisplayMode().getWidth());
            	
                //myWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        };
        myWindow.add(fullscreenButton);
        fullscreenButton.setBounds(300, 100, 200, 50);
        fullscreenButton.setText("키워주기");
        fullscreenButton.setFont( new Font("맑은 고딕", Font.BOLD, 30));
        fullscreenButton.setToolTipText("창 크기를 키워요");
        fullscreenButton.setForeground(Color.BLACK);
        fullscreenButton.setBackground(Color.YELLOW);
        
        fullscreenButton.addActionListener(listenForFullscreen);
        
        JTextField myTF = new JTextField();
        myTF.setBounds(100, 300, 200, 50);
        myTF.addActionListener(new ActionListener()
        {
        	@Override
        	public void actionPerformed(ActionEvent e)
        	{
        		myLabel.setText(myTF.getText());
        	}
        });
        
        ButtonGroup myGroup = new ButtonGroup();
        
        JRadioButton firstRadio = new JRadioButton("내용");
        firstRadio.setBounds(200, 270, 100, 20);
        myWindow.add(firstRadio);

        JRadioButton secondRadio = new JRadioButton("내용");
        secondRadio.setBounds(300, 270, 100, 20);
        //secondRadio.addActionListener(new ActionListener);
    }
}

class action implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}

class myOwnWindow extends JFrame
{
    public myOwnWindow()
    {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("이름까지 정해볼게요.");
        setVisible(true);
    }
}
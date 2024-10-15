package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePrep  extends JFrame implements KeyListener{
	//declare copies of our character
	
	
	// GUI variables
	private Container content;
	private JLabel backgroundImageLabel;
	private ImageIcon backgroundImage ; 
	private JLabel frogLabel;
	private ImageIcon frogImage;
	
	private Frog frog;
	
	
	
	
	// buttons
	private JButton startButton;
	
	
	public GamePrep() {
		super("Frogger");
		//set up screen
		frog = new Frog(GameProperties.x_left,GameProperties.y_left,120,200,"frog1-copy.png");
		
		
		setSize(GameProperties.SCREEN_WIDTH,GameProperties.SCREEN_HEIGHT);
		
		
		content = getContentPane();
		content.setBackground(Color.gray);
		setLayout(null);   
		
		
		//
		
		backgroundImageLabel = new JLabel();
		backgroundImage = new ImageIcon(getClass().getResource("images/"+GameProperties.BG_IMAGE));
		backgroundImageLabel.setIcon(backgroundImage); // this is important step
		// it basically connects front-end and back-end 
		
		backgroundImageLabel.setSize(800,600);
		backgroundImageLabel.setLocation(0,0);
		
		// frog setup
		frog.setX(GameProperties.x_left);
		frog.setY(GameProperties.y_left);
		frog.setWidth(100);
		frog.setHeight(200);
		frog.setImage("frog1-copy.png");
		
		frogLabel = new JLabel();
		frogImage = new ImageIcon(getClass().getResource("images/"+frog.getImage()));
		frogLabel.setIcon(frogImage);
		
		frogLabel.setSize(frog.getWidth(),frog.getHeight());
		frogLabel.setLocation(frog.getX(),frog.getY());
		frog.display();
		
		
		
		
		//buttons
//		startButton = new JButton("Start");
		
		
		// would have to declare the characters from up
		content.addKeyListener(this);
		add(frogLabel);
		add(backgroundImageLabel);
		content.setFocusable(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		GamePrep myGame = new GamePrep();
		myGame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// get the current position of frog
		int x = frog.getX();
		int y = frog.getY();
		
		//detech the direction
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			y-=GameProperties.CHARACTER_STEP;
			
//			if(y+frog.getHeight()<=0) {
//				y = GameProperties.SCREEN_HEIGHT;
//				
//			}
			
			if(y<=GameProperties.y_top) {
				y= GameProperties.y_top;
			}
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			y+=GameProperties.CHARACTER_STEP;
			
//			if(y>= GameProperties.SCREEN_HEIGHT) {
//				y=-1*frog.getHeight();
//			}
			if(y>=GameProperties.y_low) {
				y = GameProperties.y_low;
			}
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			x-= GameProperties.CHARACTER_STEP;
			

			
			if(x <=0 ) {
				x = GameProperties.x_left;
			}
			
		}else if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			x+= GameProperties.CHARACTER_STEP;
			

			
			if(x>=GameProperties.x_right) {
				x = GameProperties.x_right;
			}
		}
		
		frog.setX(x);
		frog.setY(y);
		
		// moving the label as per back-end 
		frogLabel.setLocation(frog.getX(),frog.getY());
		
		System.out.println("X: "+x + " Y: "+y);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}

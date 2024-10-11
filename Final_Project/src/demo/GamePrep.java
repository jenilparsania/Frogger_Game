package demo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePrep  extends JFrame{
	private Container content;
	private JLabel backgroundImageLabel;
	private ImageIcon backgroundImage ; 
	
	// buttons
	private JButton startButton;
	
	
	public GamePrep() {
		super("Frogger");
		//set up screen
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
		
		//buttons
//		startButton = new JButton("Start");
		
		add(backgroundImageLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		GamePrep myGame = new GamePrep();
		myGame.setVisible(true);
	}
	
	

}

package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePrep  extends JFrame implements KeyListener, ActionListener{
	//declare copies of our character
	private Frog frog;
	private Car car;
	private Log log;
	
	
	// GUI variables
	private Container content;
	private JLabel backgroundImageLabel;
	private ImageIcon backgroundImage ; 
	private JLabel frogLabel;
	private ImageIcon frogImage;
	private JLabel carLabel;
	private ImageIcon carImage;
	private JLabel logLabel;
	private ImageIcon logImage;
	
	
	// buttons
	private JButton startButton;
	private Car[] cars;  
	
	private JLabel[] carLabels;
	
	public GamePrep() {
		super("Frogger");
		//set up screen
		// public Sprite(int x,int y, int height, int width,String image) 
		frog = new Frog(GameProperties.x_left,GameProperties.y_left,39,40,"frog1-copy.png");
		car = new Car(7,491,40,100,"car-3.png");
		log = new Log(7,239,40,110,"log-big.png");
		
		
		
		 		 
		
		
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
		startButton = new JButton("Start");
		startButton.setSize(75, 50);
		startButton.setLocation(
				GameProperties.SCREEN_WIDTH - 100, 
				GameProperties.SCREEN_HEIGHT - 100);
		startButton.setFocusable(false);
		startButton.addActionListener(this);

		
		// frog setup
		frog.setX(GameProperties.x_left);
		frog.setY(GameProperties.y_left);
		frog.setWidth(40);
		frog.setHeight(39);
		frog.setImage("frog1-copy.png");
		
		frogLabel = new JLabel();
		frogImage = new ImageIcon(getClass().getResource("images/"+frog.getImage()));
		frogLabel.setIcon(frogImage);
		
		frogLabel.setSize(frog.getWidth(),frog.getHeight());
		frogLabel.setLocation(frog.getX(),frog.getY());
		frog.display();
		
		car.setX(7);
		car.setY(491 );
		car.setWidth(100);
		car.setHeight(40);
		car.setImage("car-3.png");
		car.setFrog(frog ); // I was missing this part
		car.setLog(log);
		
		carLabel = new JLabel();
		carImage = new ImageIcon(getClass().getResource("images/"+car.getImage()));
		carLabel.setIcon(carImage);
		
		carLabel.setSize(car.getWidth(),car.getHeight());
		carLabel.setLocation(car.getX(),car.getY());
		car.display();
		
		// carLabel has a memory label
		car.setCarLabel(carLabel);
		car.setFrogLabel(frogLabel);
		car.setLogLabel(logLabel);
		
		// the car array code is in here 
		carLabels = new JLabel[3];
		cars = new Car[3];
		
		
		cars[0] = new Car(175,491,40,100,"car-3.png");
		cars[1] = new Car(385,491,40,100,"car-3.png");
		cars[2] = new Car(615,491,40,100,"car-3.png");
		car.setGamePrep(this);	
		
				 
				 
		for(int i=0;i<cars.length;i++) {
			cars[i].setFrog(frog);
			cars[i].setLog(log);
			cars[i].setStartButton(startButton);
			
			carLabels[i] = new JLabel();
			carLabels[i].setIcon(new ImageIcon(getClass().getResource("images/" + cars[i].getImage())));
	        carLabels[i].setSize(cars[i].getWidth(), cars[i].getHeight());
	        carLabels[i].setLocation(cars[i].getX(), cars[i].getY());
	        cars[i].display();

	            // Connect car to its JLabel
	         cars[i].setCarLabel(carLabels[i]);
	         //cars[i].setCarLabel(carLabel);
	 		 cars[i].setFrogLabel(frogLabel);
	 		 cars[i].setLogLabel(logLabel);
	 		 // have t 
	         
	         add(carLabels[i]);
	         cars[i].setGamePrep(this);	
	         
			
			
		}

		
		// log = new Log(7,160,120,250,"log-delete.png");
		log.setX(7);
		log.setY(239 );
		log.setWidth(110);
		log.setHeight(40);
		log.setImage("log-big.png");
		log.setFrog(frog);
		log.setCar(car);
		
		
		logLabel = new JLabel();
		logImage = new ImageIcon(getClass().getResource("images/"+log.getImage()));
		logLabel.setIcon(logImage);
		
		logLabel.setSize(log.getWidth(),log.getHeight());
		logLabel.setLocation(log.getX(),log.getY());
		log.display();		
		log.setLogLabel(logLabel);
		log.setFrogLabel(frogLabel);
		log.setCarLabel(carLabel);
		
		car.setStartButton(startButton);
		
		
		

		// would have to declare the characters from up
		content.addKeyListener(this);
		add(startButton);
		add(frogLabel);
		add(carLabel);
		add(logLabel);
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
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		// get the current position of frog
		int x = frog.getX();
		int y = frog.getY();
		
		//detech the direction
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
			y-=GameProperties.CHARACTER_STEP;
			
			
			if(y<=GameProperties.y_top) {
				y= GameProperties.y_top;
			}
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			y+=GameProperties.CHARACTER_STEP;
			

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
		System.out.println("frog X : "+this.frog.getRectangle().x+",  frog y : "+ this.frog.getRectangle().y+ " , frog w : "+this.frog.getRectangle().width+ " ,frog h : " +this.frog.getRectangle().height);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton) {
			
			
			System.out.println("Start button pressed");
			
			if(car.getMoving()) { // just to check
				
				car.stopThread();
				log.stopThread();
			}else {
				for(Car car:cars) {
					if(car.getMoving()) {
						car.stopThread();
						
						log.stopThread();
					}else {
						car.startThread();
						log.stopThread();
					}
				}
				car.startThread();
				log.startThread();
			}
		}
		
	}
	
	public void stopAllCars() {
		for(Car car : cars) {
			car.stopThread();
		}
	}
	
	

}

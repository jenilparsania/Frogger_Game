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
	private Car[] cars1;
	private Car[] cars2;
	
	private JLabel[] carLabels;
	private JLabel[] carLabels1;
	private JLabel[] carLabels2;
	
	private Log[] logs;
	private Log[] logs1;
	private Log[] logs2;
	
	private JLabel[] logLabels;
	
	
	
	public GamePrep() {
		super("Frogger");
		//set up screen
		// public Sprite(int x,int y, int height, int width,String image) 
		frog = new Frog(GameProperties.x_left,GameProperties.y_left,39,40,"frog1-copy.png");
//		car = new Car(7,491,40,100,"car-3.png");
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
		/*
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
//		car.display();
		
		// carLabel has a memory label
		car.setCarLabel(carLabel);
		car.setFrogLabel(frogLabel);
		car.setLogLabel(logLabel);
		
		*/
		
		// the car array code is in here 
		carLabels = new JLabel[4];
		carLabels1 = new JLabel[4];
		carLabels2 = new JLabel[4];
		cars = new Car[4];
		cars1= new Car[4];
		cars2 = new Car[4];
		
		
		cars[0] = new Car(175,491,40,100,"car-3.png");
		cars[1] = new Car(385,491,40,100,"car-3.png");
		cars[2] = new Car(615,491,40,100,"car-3.png");
		cars[3] = new Car(7,491,40,100,"car-3.png");
		
		cars1[0] = new Car(7,407,40,100,"car-3.png");
		cars1[1] = new Car(175,407,40,100,"car-3.png");
		cars1[2] = new Car(385,407,40,100,"car-3.png");
		cars1[3] = new Car(615,407,40,100,"car-3.png");
		
		cars2[0] = new Car(7,323,40,100,"car-3.png");
		cars2[1] = new Car(175,323,40,100,"car-3.png");
		cars2[2] = new Car(385,323,40,100,"car-3.png");
		cars2[3] = new Car(615,323,40,100,"car-3.png");
		
		
		
				 
				 
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
	         
	         
	         
	         // for the car1 array 
	         cars1[i].setFrog(frog);
			 cars1[i].setLog(log);
			 cars1[i].setStartButton(startButton);
				
			 carLabels1[i] = new JLabel();
			 carLabels1[i].setIcon(new ImageIcon(getClass().getResource("images/" + cars1[i].getImage())));
		     carLabels1[i].setSize(cars1[i].getWidth(), cars1[i].getHeight());
		     carLabels1[i].setLocation(cars1[i].getX(), cars1[i].getY());
		     cars1[i].display();

		            // Connect car to its JLabel
		     cars1[i].setCarLabel(carLabels1[i]);
		        //cars[i].setCarLabel(carLabel);
		 	 cars1[i].setFrogLabel(frogLabel);
		 	 cars1[i].setLogLabel(logLabel);
		 		 // have t 
		         
		     add(carLabels1[i]);
		     cars1[i].setGamePrep(this);	
		         
		         
		         
		         //for the car2 array
		      cars2[i].setFrog(frog);
			  cars2[i].setLog(log);
			  cars2[i].setStartButton(startButton);
					
			  carLabels2[i] = new JLabel();
			  carLabels2[i].setIcon(new ImageIcon(getClass().getResource("images/" + cars2[i].getImage())));
		      carLabels2[i].setSize(cars2[i].getWidth(), cars2[i].getHeight());
		      carLabels2[i].setLocation(cars2[i].getX(), cars2[i].getY());
		      cars2[i].display();

			            // Connect car to its JLabel
		      cars2[i].setCarLabel(carLabels2[i]);
			         //cars[i].setCarLabel(carLabel);
		 	  cars2[i].setFrogLabel(frogLabel);
		 	  cars2[i].setLogLabel(logLabel);
			 		 // have t 
			         
		      add(carLabels2[i]);
		     cars2[i].setGamePrep(this);	
	        
	         
	    	
		}

		
		// log = new Log(7,160,120,250,"log-delete.png");
		log.setX(7);
		log.setY(239 );
		log.setWidth(110);
		log.setHeight(40);
		log.setImage("log-big.png");
		log.setFrog(frog);
		log.setCar(car);
//		for(Car car:cars) {
//			log.setCar(car);
//		}
		// instead of the loop would have to pass the whole array 
		// inside the new methods which would accept the Car array 
		
		log.setCars(cars);
		log.setCars1(cars1);
		log.setCars2(cars2);
		
		
		logLabel = new JLabel();
		logImage = new ImageIcon(getClass().getResource("images/"+log.getImage()));
		logLabel.setIcon(logImage);
		
		logLabel.setSize(log.getWidth(),log.getHeight());
		logLabel.setLocation(log.getX(),log.getY());
		log.display();		
		log.setLogLabel(logLabel);
		log.setFrogLabel(frogLabel);
		log.setCarLabel(carLabel);
//		for(JLabel label:carLabels) {
//			log.setCarLabel(label);
//		}
		
		log.setCarLabels(carLabels);
		log.setCarLabels(carLabels1);
		
		
//		car.setStartButton(startButton);
		
		
		

		// would have to declare the characters from up
		content.addKeyListener(this);
		add(startButton);
		add(frogLabel);
//		add(carLabel);
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
			
			if(cars[0].getMoving()) { // just to check
				
				cars[0].stopThread();
				
				log.stopThread();
			}else {
				// for(int i=0;i<cars.length;i++) 
				for(int z = 0;z < cars.length;z++) {
					if(cars[z].getMoving()) {
						cars[z].stopThread();
						cars1[z].stopThread();
						cars2[z].stopThread();
						log.stopThread();
						
					}else {
						cars[z].startThread();
						cars1[z].startThread();
						cars2[z].startThread();
						log.startThread();
					}
				}
				
//				for(Car car:cars) {
//					if(car.getMoving()) {
//						car.stopThread();
//						
//						log.stopThread();
//					}else {
//						car.startThread();
//						log.startThread();
//					}
//				}
//				cars[0].startThread();
//				log.startThread();
			}
		}
		
	}
	
	public void stopAllCars() {
		
		for(int i=0; i < cars.length;i++) {
			cars[i].stopThread();
			cars1[i].stopThread();
			cars2[i].stopThread();
			
		}
	}
	
	

}

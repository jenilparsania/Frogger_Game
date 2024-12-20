package demo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Log  extends Sprite implements Runnable{
	private Boolean moving;
	private Boolean direction;
	private Thread t;
	private Boolean hasPassedCars;
	private JButton startButton;
	private Car car;
	private Car cars[];
	private Car cars1[];
	private Car cars2[];
	private JLabel carLabel;
	private JLabel[] carLabels;
	private JLabel logLabel;
	
	private Frog frog;
	private JLabel frogLabel;
	
	public void setStartButton(JButton temp) {
		startButton = temp;
		
	}
	
	public void setFrog(Frog temp) {
		frog = temp;
	}
	
	
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setLogLabel(JLabel temp) {
		this.logLabel = temp;
	}
	
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	
	public void setCar(Car temp) { 
		this.car = temp;
	}
	
	public void setCarLabel(JLabel temp) { 
		this.carLabel = temp;
	}
	
	public void setCars(Car[] temp) { //could be used for array
		this.cars = temp;
	}
	
	public void setCars1(Car[] temp) { //could be used for array
		this.cars1 = temp;
	}
	
	public void setCars2(Car[] temp) { //could be used for array
		this.cars2 = temp;
	}
	
	public void setCarLabels(JLabel[] temp) { // could be used for array 
		this.carLabels = temp;
	}
	
	public Boolean getDirection() {
		return this.direction;
	}
	
	public void setDirection(boolean temp) { 
		this.direction = temp;
	}
	
	
	public Log() {
		super();
		this.moving = false;
	}
	
	public Log(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
		
	}
	private GamePrep gamePrep;
	public void setGamePrep(GamePrep gamePrep) {
		this.gamePrep = gamePrep;
	}
	
	
	public void startThread() {
		// run will  be triggered
		System.out.println("Current Moving logs : "+this.moving);
		
		if(!this.moving) {
			this.moving = true;
			
			this.setImage("log-big.png");
			
			logLabel.setIcon(new ImageIcon(getClass().getResource("images/"+this.getImage())));
			
			frog.setImage("frog1-copy.png");
			frogLabel.setIcon(new ImageIcon(getClass().getResource("images/"+ frog.getImage())));
			
			
			System.out.println("Starting thread");
			t = new Thread(this,"Log Thread");
			t.start();   // it automatically calls the run method 
		}
		
	}
	
	public void startAgain() { // as the thread is stopped frog should move again to initial phase
		frog.setX(GameProperties.x_left);
		frog.setY(GameProperties.y_left);
		frogLabel.setLocation(frog.getX(),frog.getY());
		
		
	}
	
	public void stopThread() {
		if(this.moving) {
			this.moving = false;
//			car.setMoving(false);
			for(int i=0; i < cars.length;i++) {
				cars[i].setMoving(false);
				cars1[i].setMoving(false);
				cars2[i].setMoving(false);
				
			}
			
		}
	}

	
	public void run() {
		
		System.out.println("run triggered");
		/**/
		while(this.moving) {
			int x = this.x;
			
			if(!this.getDirection()) {
				//going other way 
				x -= GameProperties.CHARACTER_STEP;
				
				if(x<= -1*this.width) {
					x =GameProperties.SCREEN_WIDTH;
				}
				
				this.setX(x);
				System.out.println("log x: \"+this.r.x+\",  log y : \"+ this.r.y+ \" , log w : \"+this.r.width+ \" ,log h : \" +this.r.height");
				
				logLabel.setLocation(this.x,this.y);
				
				this.detechCollision();
				
			}else { 
				// regular movement 
				
				x += GameProperties.CHARACTER_STEP;
				
				if(x>= GameProperties.SCREEN_WIDTH) {
					x = -1 * this.width;
					
					
				}
				
				this.setX(x);
				System.out.println("log x: "+this.r.x+",  log y : "+ this.r.y+ " , log w : "+this.r.width+ " ,log h : " +this.r.height);
				
				logLabel.setLocation(this.x,this.y);
				
				this.detechCollision();
				System.out.println("x,y: "+ this.x + " " + this.y);
			}
			

			
			try {
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread Stopped");
		
	}
	
	
	private void detechCollision() {
	
		if(frog.getY() <= GameProperties.y_safe) {

			
			if(this.r.intersects(frog.getRectangle())) {
				
				
				int frogx = frog.getX();
				
				if(!this.direction) {
					frogx -= GameProperties.CHARACTER_STEP;
					frog.setX(frogx);
					frogLabel.setLocation(frog.getX(),frog.getY());
				}else {
					frogx += GameProperties.CHARACTER_STEP;
					frog.setX(frogx);
					frogLabel.setLocation(frog.getX(),frog.getY());
				}
				
				if(frogx <= 0) {
					gamePrep.stopAllCars();
					gamePrep.stopAllLogs();
					this.startAgain();
					gamePrep.gameEndsLose();
					
				}else if(frogx >= GameProperties.x_right) {
					gamePrep.stopAllCars();
					gamePrep.stopAllLogs();
					gamePrep.gameEndsLose();
					this.startAgain();
				}
				
//				frog.setX(frogx);
//				frogLabel.setLocation(frog.getX(),frog.getY());
				
				
				
				
//				
			}
//			
//			if(!collided) {
//				
//					this.stopThread();
//					gamePrep.stopAllCars();
//					gamePrep.stopAllLogs();
//					this.startAgain();
//				
//			}
//			
//					
			}
		}
			
	}


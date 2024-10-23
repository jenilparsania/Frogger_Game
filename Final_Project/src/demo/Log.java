package demo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Log  extends Sprite implements Runnable{
	private Boolean moving;
	private Thread t;
	private Boolean hasPassedCars;
	private JButton startButton;
	private Car car;
	private JLabel carLabel;
	
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
		car = temp;
	}
	
	public void setCarLabel(JLabel temp) {
		this.carLabel = temp;
	}
	
	
	public Log() {
		super();
		this.moving = false;
	}
	
	public Log(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
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
	
	public void stopThread() {
		if(this.moving) {
			this.moving = false;
			car.setMoving(false);
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run triggered");
		while(this.moving) {
			int x = this.x;
			x += GameProperties.CHARACTER_STEP;
			
			if(x>= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
			}
			
			this.setX(x);
			System.out.println("log x: "+this.r.x+",  log y : "+ this.r.y+ " , log w : "+this.r.width+ " ,log h : " +this.r.height);
			
			logLabel.setLocation(this.x,this.y);
			
			this.detechCollision();
			System.out.println("x,y: "+ this.x + " " + this.y);
			
			try {
				Thread.sleep(200);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread Stopped");
		
	}
	
	
	private void detechCollision() {
		if(this.r.intersects(frog.getRectangle())) {
			System.out.println("BOOM!");
			this.stopThread();
		}
	
	}

		
	
	
	
	
	

}

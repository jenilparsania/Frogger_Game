package demo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Car extends Sprite implements Runnable {
	// would have to look that the Boolean variables like: 
	// visible and moving 
	private Boolean moving;
	private Thread t;
	
	private JLabel carLabel;
	
	private Frog frog;
	private JLabel frogLabel;
	
	private JButton startButton;
	
	public void setStartButton(JButton temp) {
		startButton = temp;
		
	}
	
	public void setFrog(Frog temp) {
		frog = temp;
	}
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	public void setCarLabel(JLabel temp) {
		this.carLabel = temp;
	}
	
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public Car() {
		super();
		this.moving = false;
		
	}
	
	public Car(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
	}
	
	public void startThread() {
		// run will be triggered 
		System.out.println("Current moving : "+ this.moving);
		
		
		if(!this.moving) {
			this.moving = true;
			startButton.setText("yah started");
			this.setImage("car-3.png");
			
			carLabel.setIcon(new ImageIcon(getClass().getResource("images/"+ this.getImage())));
			
			frog.setImage("frog1-copy.png");
			frogLabel.setIcon(new ImageIcon(getClass().getResource("images/"+ frog.getImage())));
			
			
			System.out.println("Starting thread");
			t = new Thread(this,"Car Thread");
			t.start();   // it automatically calls the run method 
			
			
		}
		
	}
	
	public void stopThread() {
		if(this.moving) {
			this.moving = false;
			startButton.setText("collided");
		}
	}
	
	@Override
	public void run() {
		System.out.println("run triggered");
		while(this.moving) {
			int x = this.x;
			x += GameProperties.CHARACTER_STEP;
			
			if(x>= GameProperties.SCREEN_WIDTH) {
				x = -1 * this.width;
			}
			
			this.setX(x);
			System.out.println("carx: "+this.r.x+",  car y : "+ this.r.y+ " , car w : "+this.r.width+ " ,car h : " +this.r.height);
			
			carLabel.setLocation(this.x,this.y);
			
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

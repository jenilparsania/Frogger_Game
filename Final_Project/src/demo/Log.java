package demo;

import javax.swing.JLabel;

public class Log  extends Sprite{
	private Boolean moving;
	private Thread t;
	
	private JLabel logLabel;
	
	private Frog frog;
	private JLabel frogLabel;
	
	public void setFrog(Frog temp) {
		frog = temp;
	}
	
	public void setFrogLabel(JLabel temp) {
		frogLabel = temp;
	}
	
	private void setLogLabel(JLabel temp) {
		this.logLabel = temp;
	}
	
	public Boolean getMoving() {
		return moving;
	}
	
	public void setMoving(Boolean moving) {
		this.moving = moving;
	}
	
	public Log() {
		super();
		this.moving = false;
	}
	
	public Log(int x, int y,int height, int width, String image) {
		super(x,y,height,width,image);
		this.moving = false;
		
	}
	
	
	
	

}

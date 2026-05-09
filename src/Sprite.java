import java.awt.Graphics;

public class Sprite extends Rect{
	String name;
	
	boolean moving = false;
	
	
	
	Animation[] animation = new Animation[4];
	
	String[] pose;
	
	public Sprite(String name, int x, int y, int w, int h, int direction, String[] pose)
	{
		super(x, y, w, h);
		this.name = name;
		this.pose = pose;
		
		for(int i = 0; i < animation.length; i++) {
			animation[i] = new Animation(name, 7, pose[i], "png");
		}
		
		this.direction = direction;
	}	
	
	public void moveUP(int dy) {
		y -= dy;
		direction = UP;
		moving = true;
	}
	
	public void moveDN(int dy) {
		y += dy;
		direction = DN;
		moving = true;
	}
	
	public void moveLT(int dx) {
		x -= dx;
		direction = LT;
		moving = true;
	}
	
	public void moveRT(int dx) {
		x += dx;
		direction = RT;
		moving = true;
	}	
		
	public void draw(Graphics g) {
		if(moving) {
			g.drawImage(animation[direction].nextImage(), x, y, w, h, null);
	    }
		else {
			g.drawImage(animation[direction].stillImage(), x, y, w, h, null);
		}
		
		new Rect(x, y, w, h).draw(g);
		
		moving = false;
	}
}

import java.awt.Graphics;

public class Sprite {
	String name;
	
	int x;
	int y;
	
	int w;
	int h;
	
	int direction = 0;
	boolean moving = false;
	
	Animation[] animation = new Animation[4];
	
	boolean selected = false;
	
	public Sprite(String name, int x, int y, int w, int h)
	{
		this.name = name;
		
		String[] pose = {"up", "dn", "lt", "rt"};
		
		for(int i = 0; i < animation.length; i++) {
			animation[i] = new Animation(name, pose[i]);
		}
		
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected() {
		selected = true;
	}
	
	public void clearSelected() {
		selected = false;
	}
	
	public boolean overlaps(Rect r)
	{
		return (x <= r.x + r.w) &&
			   (y <= r.y + r.h) &&
			   
			   (r.x <= x + w)   &&
			   (r.y <= y + h);	
	}
	
	public boolean contains(int mx, int my)
	{
		return (mx > x)   && 
			   (mx < x+w) && 
			   (my > y)   && 
			   (my < y+h);
	}
	
	public void moveUP(int dy) {
		y -= dy;
		direction = 0;
		moving = true;
	}
	
	public void moveDN(int dy) {
		y += dy;
		direction = 1;
		moving = true;
	}
	
	public void moveLT(int dx) {
		x -= dx;
		direction = 2;
		moving = true;
	}
	
	public void moveRT(int dx) {
		x += dx;
		direction = 3;
		moving = true;
	}	
		
	public void draw(Graphics g) {
		if(moving) {
			g.drawImage(animation[direction].nextImage(), x, y, w, h, null);
	    }
		else {
			g.drawImage(animation[direction].stillImage(), x, y, w, h, null);
		}
		
		moving = false;
	}
}

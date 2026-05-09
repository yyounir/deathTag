import java.awt.*;

public class Rect
{
	int x;
	int y;
	
	int w;
	int h;
	
	boolean selected = false;

	int direction;
	
	// Constant values that are used to index the animation array to select the correct animation for the direction the soldier is moving
	static final int UP = 0;
	static final int DN = 1;
	static final int LT = 2;
	static final int RT = 3;
	
//	Diagonal
	static final int UL = 4;
	static final int DL = 5;
	static final int UR = 6;
	static final int DR = 7;
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected()
	{
		selected = true;
	}
	
	public void clearSelected()
	{
		selected = false;
	}
	
	public void toggle()
	{
		selected = ! selected;
	}
	
	public void pushLeftOn(Rect r) {
		r.x -= (r.x + r.w - x + 2);
	}
	
	public void pushRightOn(Rect r) {
		r.x += (x + w - r.x + 2);
	}
	
	public void pushUpOn(Rect r) {
		r.y -= (r.y + r.h - y + 2);
	}
	
	public void pushDownOn(Rect r) {
		r.y += (y + h - r.y + 2);
	}
	
	public void pushes(Rect r) {
		if(r.direction == UP) 	pushDownOn(r);
		if(r.direction == DN) 	pushUpOn(r);
		if(r.direction == LT) 	pushRightOn(r);
		if(r.direction == RT) 	pushLeftOn(r);
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
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	
	public void draw(Graphics g)
	{
		g.drawRect(x, y, w, h);
	}
	
}	
	

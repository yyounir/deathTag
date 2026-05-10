import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Food extends Rect{

	String filename;
	int x;
	int y;
	int w = 50;
	int h = 50;
	boolean incrementScore = true;
	
	
	Image image;
	
	boolean eaten = false;
	
	public Food(String filename, int x, int y) {
		super(x, y, 50, 50);
		this.filename = filename;
		this.x = x;
		this.y = y;
		
		image = Toolkit.getDefaultToolkit().createImage(filename + ".png");
	}
	
	public void draw(Graphics g) {
		if(!eaten) 	g.drawImage(image, x, y, w, h, null);
		else 		g.drawImage(image, 0, 0, 0, 0, null);
	}
}

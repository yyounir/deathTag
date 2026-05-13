import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



public class Obstacle extends Rect {
	Image image;
	String filename;
	int x, y;
	
	public Obstacle(String filename, int x, int y) {
		super(x, y, 50, 15);
		this.filename = filename + ".png";
		this.x = x;
		this.y = y;
		
		image = Toolkit.getDefaultToolkit().createImage(this.filename);
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, 50, 66, null);
//		new Rect(x, y, 50, 15).draw(g);
	}
}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class NonObstacles {
	
	String filename;
	int x, y, w, h;
	Image image;
	
	public NonObstacles(String filename, int x, int y) {
		this.filename = filename;
		this.x = x;
		this.y = y;
		
		switch (filename) {
			case "puddle":
				this.w = 50;
				this.h = 33;
		}
		
		image = Toolkit.getDefaultToolkit().createImage(filename + ".png");
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, w, h, null);
	}
}

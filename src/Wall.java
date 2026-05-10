import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Wall extends Rect{
	
	Image image;
	
	String filename;
	int x;
	int y;
	
	int w;
	int h;
	
	Rect rect2 = null;
	
	public Wall(String filename, int x, int y) {
		super(x, y, filename.equals("mazeTop1.png") ? 134 : 134, filename.equals("mazeTop1.png") ? 41  : 87);
//		super(x, y, w, h);
		
		this.filename = filename;
		
		switch (filename) {
			case "mazeTop1.png":
				this.w = 134;
				this.h = 41;
				break;
			case "mazeWall1.png":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeTop2.png":
				super.y += 240;
				super.w = 192;
				super.h = 65;
				rect2 = new Rect(x, y, 65, 302);
				this.w = 192;
				this.h = 302;
				break;
			case "mazeWall2.png":
				this.w = 192;
				this.h = 87;
				break;
		}
		
//		this.w = filename.equals("mazeTop1.png") ? 134 : 134;
//		this.h = filename.equals("mazeTop1.png") ? 41  : 87;
		this.x = x;
		this.y = y;
		image = Toolkit.getDefaultToolkit().getImage(filename);
		
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, w, h, null);
	
		
//		switch (filename) {
//			case "mazeTop2.png":
//				g.setColor(Color.YELLOW);
////				new Rect(x, y+240, 192, 65).draw(g);
////				new Rect(x, y, 65, 302).draw(g);
//				
//				g.drawImage(image, x, y, w, h, null);
//				
//				
//			default:
//				g.drawImage(image, x, y, w, h, null);
//		}
	}
}

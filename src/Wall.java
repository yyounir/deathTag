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
	Rect rect3 = null;
	Rect rect4 = null;
	Rect rect5 = null;
	Rect rect6 = null;
	
	public Wall(String filename, int x, int y) {
		super(x, y, filename.equals("mazeTop1") ? 134 : 134, filename.equals("mazeTop1") ? 41  : 87);
//		super(x, y, w, h);
		
		this.filename = filename;
		
		switch (filename) {
			case "mazeTop1":
				this.w = 134;
				this.h = 41;		
				super.w = 134;
				super.h = 41;
				break;
			case "mazeWall1":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeWall1alt":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeTop2":
				super.y += 240;
				super.w = 192;
				super.h = 65;
				rect2 = new Rect(x, y, 65, 302);
				this.w = 192;
				this.h = 302;
				break;
			case "mazeWall2":
				this.w = 192;
				this.h = 87;
				break;
			case "mazeTop3":
				super.w = 68;
				super.h = 201;
				this.w = 68;
				this.h = 201;
				break;
			case "mazeWall3":
				this.w = 68;
				this.h = 87;
				break;
			case "mazeTopWall4":
				super.y += 160;
				super.w = 70;
				super.h = 100;
				rect2 = new Rect(x, y+225, 300, 35);
				rect3 = new Rect(x+231, y+5, 69, 380);
				rect4 = new Rect(x+200, y+225, 69, 161);
				rect5 = new Rect(x+231, y+5, 200, 50);
				rect6 = new Rect(x+365, y+5, 59, 235);
				this.w = 433;
				this.h = 473;
				break;
			case "mazeTop1[2]":
				this.w = 134;
				this.h = 41;
				super.w = 134;
				super.h = 41;
				break;
			case "mazeWall1[2]":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeWall1alt[2]":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeTop2[2]":
				super.y += 240;
				super.w = 192;
				super.h = 65;
				rect2 = new Rect(x, y, 65, 302);
				this.w = 192;
				this.h = 302;
				break;
			case "mazeWall2[2]":
				this.w = 192;
				this.h = 87;
				break;
			case "mazeTop3[2]":
				super.w = 68;
				super.h = 201;
				this.w = 68;
				this.h = 201;
				break;
			case "mazeWall3[2]":
				this.w = 68;
				this.h = 87;
				break;
			case "mazeTopWall4[2]":
				super.y += 160;
				super.w = 70;
				super.h = 100;
				rect2 = new Rect(x, y+225, 300, 35);
				rect3 = new Rect(x+231, y+5, 69, 380);
				rect4 = new Rect(x+200, y+225, 69, 161);
				rect5 = new Rect(x+231, y+5, 200, 50);
				rect6 = new Rect(x+365, y+5, 59, 235);
				this.w = 433;
				this.h = 473;
				break;
			case "mazeTop1[3]":
				this.w = 134;
				this.h = 41;
				super.w = 134;
				super.h = 41;
				break;
			case "mazeWall1[3]":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeWall1alt[3]":
				this.w = 134;
				this.h = 87;
				break;
			case "mazeTop2[3]":
				super.y += 240;
				super.w = 192;
				super.h = 65;
				rect2 = new Rect(x, y, 65, 302);
				this.w = 192;
				this.h = 302;
				break;
			case "mazeWall2[3]":
				this.w = 192;
				this.h = 87;
				break;
			case "mazeTop3[3]":
				super.w = 68;
				super.h = 201;
				this.w = 68;
				this.h = 201;
				break;
			case "mazeWall3[3]":
				this.w = 68;
				this.h = 87;
				break;
			case "mazeTopWall4[3]":
				super.y += 160;
				super.w = 70;
				super.h = 100;
				rect2 = new Rect(x, y+225, 300, 35);
				rect3 = new Rect(x+231, y+5, 69, 380);
				rect4 = new Rect(x+200, y+225, 69, 161);
				rect5 = new Rect(x+231, y+5, 200, 50);
				rect6 = new Rect(x+365, y+5, 59, 235);
				this.w = 433;
				this.h = 473;
				break;
			default:
				System.out.println(filename + " isn't configured");
		}
		
		this.x = x;
		this.y = y;
		image = Toolkit.getDefaultToolkit().getImage(filename + ".png");
		
		
	}
	
	public void draw(Graphics g) {
//		g.drawImage(image, x, y, w, h, null);

		switch (filename) {
			case "mazeWall1.png":
				g.drawImage(image, x, y, w, h, null);
				g.setColor(Color.YELLOW);
				new Rect(x, y, w, h).draw(g);
//				new Rect(rect2.x, rect2.y, rect2.w, rect2.h).draw(g);
//				new Rect(rect3.x, rect3.y, rect3.w, rect3.h).draw(g);
//				new Rect(rect4.x, rect4.y, rect4.w, rect4.h).draw(g);
//				new Rect(rect5.x, rect5.y, rect5.w, rect5.h).draw(g);
//				new Rect(rect6.x, rect6.y, rect6.w, rect6.h).draw(g);
				
			default:
				g.drawImage(image, x, y, w, h, null);
		}
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Sign extends Rect{
	
	String filename;
	int x;
	int y;
	int w;
	int h;
	Image image;
	
	public Sign(String filename, int x, int y) {
		super(x, y, 0, 0);
		this.filename = filename;
		this.x = x;
		this.y = y;
		
		switch(filename) {
			case "sign1":
				this.w = 158;
				this.h = 50;
				break;
			case "sign2":
				this.w = 104;
				this.h = 50;
				break;
			case "sign3":
				this.w = 104;
				this.h = 50;
				break;
			case "sign4":
				this.w = 104;
				this.h = 50;
				break;
			case "sign5":
				this.w = 86;
				this.h = 65;
				break;
			case "sign6":
				this.w = 108;
				this.h = 50;
				break;
			case "sign7":
				this.w = 103;
				this.h = 50;
				break;
			case "sign11":
				this.w = 113;
				this.h = 50;
				break;
			case "sign8":
				this.w = 108;
				this.h = 50;
				break;
			case "sign9":
				this.w = 86;
				this.h = 50;
				break;
			case "sign10":
				this.w = 70;
				this.h = 50;
				break;
			default:
				System.out.println(filename + " hasn't been configured");
		}
		image = Toolkit.getDefaultToolkit().createImage(filename + ".png");
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, this.x, this.y, this.w, this.h, null);
	}
}

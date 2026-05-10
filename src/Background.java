import java.awt.*;

public class Background {
	Image image;
	
	int w;
	int h;
	
	public Background(String filename, int w, int h) {
		this.w = w;
		this.h = h;
		image = Toolkit.getDefaultToolkit().getImage(filename);
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, w, h, null);
	}
}

import java.applet.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;

public class GameS26 extends GameBase {		
	
//	Violetta v = new Violetta(1205, 575, Violetta.DN);
	Younir y = new Younir(300, 800, Younir.UP);
	
	BadChar bc = new BadChar(800, 450, Violetta.LT);
		
	Rect[] r = {
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 800), // RIGHT
	    new Rect(1565, 0, 20, 1000), // LEFT
	    new Rect(0, 850, 1700, 20), // BOTTOM
	    new Rect(20, 100, 350, 125),
	};
	
	Wall[] wall = {
//			Wall Type 1:
			new Wall("mazeWall2.png", 500, 500)
	};
	
	Wall[] wallTop = {
			new Wall("mazeTop2.png", 500, 200)
	};
	
//	Wall wall1 = new Wall("mazeWall1.png", 500, 500);
	Wall top1 = new Wall("mazeTop1.png", 500, 460);
//	Image wallTop = Toolkit.getDefaultToolkit().createImage("mazeTop1.png");
	
	Background background = new Background("mazeEmpty.png", 1600, 900);
	
	public void inGameLoop()
	{
		// Code that executes 60 times per second
		
		// Move User Controlled Objects
		bc.chase(y);
		
		int speed = 5;
		
		if(pressing[SHFT]) {
			speed = 10;
		}
//		y.physics = true;
		if(pressing[UP] || pressing[_W]) 	y.goUP(speed);
		if(pressing[DN] || pressing[_S]) 	y.goDN(speed);
		if(pressing[LT] || pressing[_A])	y.goLT(speed);
		if(pressing[RT] || pressing[_D])	y.goRT(speed);
		
		y.move();
		
		// Move Computer Controlled Objects

		
		// Handle Collisions
		for(int i = 0; i < r.length; i++) {
			if(r[i].overlaps(y)) r[i].pushes(y);
			if(r[i].overlaps(bc)) r[i].pushes(bc);
		}
		
		for(int i = 0; i < wallTop.length; i++) {
			
			if(wallTop[0].overlaps(y)) 	wallTop[0].pushes(y);
			if(wallTop[0].overlaps(bc)) wallTop[0].pushes(bc);
			
			if(wallTop[0].rect2 != null && wallTop[0].rect2.overlaps(y)) wallTop[0].rect2.pushes(y);
			if(wallTop[0].rect2 != null && wallTop[0].rect2.overlaps(bc)) wallTop[0].rect2.pushes(bc);
		}
		
//		if(v.overlaps(y)) v.pushes(y);
		
//		if(y.overlaps(r4)) r4.pushes(y);
		
		
		
		// Update the Screen

	}
	
	public void paint(Graphics g) {	
		background.draw(g);
		
		
		g.setColor(Color.YELLOW);
		
		
//		g.drawImage(wallTop, 500, 500, 234, 72, null);
		
		
		
//		if(y.overlaps(r1))	g.setColor(Color.RED);
		
//		r1.draw(g);
//		r2.draw(g);
//		r3.draw(g);
//		r4.draw(g);
		
		for(int i = 0; i < wall.length; i++) {
			wall[i].draw(g);
		}
		
		for(int i = 0; i < wallTop.length; i++) {
			wallTop[i].draw(g);
		}
		
		for(int i = 0; i < r.length; i++) {
//			 r[i].draw(g);
		}
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
	}	
}
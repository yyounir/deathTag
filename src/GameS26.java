import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class GameS26 extends GameBase {		
	
	Violetta v = new Violetta(1205, 575, Violetta.DN);
	Younir y = new Younir(300, 800, Younir.UP);
		
	Rect[] r = {
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 800), // RIGHT
	    new Rect(1565, 0, 20, 1000), // LEFT
	    new Rect(0, 850, 1700, 20), // BOTTOM
	    new Rect(810, 110, 50, 300),	    
	    new Rect(20, 100, 350, 125), 	    
	    new Rect(120, 375, 50, 275),
	    new Rect(120, 600, 160, 50),
	    new Rect(50, 225, 50, 40), // Barrel
	    new Rect(50, 700, 116, 200),
	    new Rect(50, 700, 116, 200),
	    
	};
	
	Image pool = Toolkit.getDefaultToolkit().getImage("maze1.png");
	
	public void inGameLoop()
	{
		// Code that executes 60 times per second
		
		// Move User Controlled Objects
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
//		if((pressing[UP] || pressing[_W]) && y.overlaps(r2)) 	r2.pushDown(y);;
//		if((pressing[DN] || pressing[_S]) && y.overlaps(r2)) 	r2.pushUp(y);;
//		if((pressing[LT] || pressing[_A]) && y.overlaps(r2)) 	r2.pushRight(y);;
//		if((pressing[RT] || pressing[_D]) && y.overlaps(r2))	r2.pushLeft(y);;
		
//		if(r1.overlaps(y)) r1.pushes(y);
//		if(r2.overlaps(y)) r2.pushes(y);
//		if(r3.overlaps(y)) r3.pushes(y);
		
		for(int i = 0; i < r.length; i++) {
			if(r[i].overlaps(y)) r[i].pushes(y);
		}
//		if(y.overlaps(r4)) r4.pushes(y);
		
		
		
		// Update the Screen

	}
	
	public void paint(Graphics g) {	
		g.drawImage(pool, 0, 0, 1600, 900, null);
		
		g.setColor(Color.YELLOW);
		y.draw(g);
		v.draw(g);
		
//		if(y.overlaps(r1))	g.setColor(Color.RED);
		
//		r1.draw(g);
//		r2.draw(g);
//		r3.draw(g);
//		r4.draw(g);
		
		for(int i = 0; i < r.length; i++) {
			r[i].draw(g);
		}
	}	
}
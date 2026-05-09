import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class GameS26 extends GameBase {		
	
	Violetta v = new Violetta(100, 100, Violetta.DN);
	Younir y = new Younir(100, 100, Younir.DN);
		
	Rect r1 = new Rect(800, 100, 20, 500);
	Rect r2 = new Rect(800, 100, 600, 20);
	Rect r3 = new Rect(20, 100, 800, 20);
	Rect r4 = new Rect(800, 100, 20, 800);
	
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
		
		if(r1.overlaps(y)) r1.pushes(y);
		if(r2.overlaps(y)) r2.pushes(y);
		if(r3.overlaps(y)) r3.pushes(y);
//		if(y.overlaps(r4)) r4.pushes(y);
		
		
		
		// Update the Screen

	}
	
	public void paint(Graphics g) {	
		g.setColor(Color.BLACK);
		y.draw(g);
		
//		if(y.overlaps(r1))	g.setColor(Color.RED);
		
		r1.draw(g);
		r2.draw(g);
		r3.draw(g);
//		r4.draw(g);
	}	
}
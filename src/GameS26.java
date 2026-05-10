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
	    new Rect(30, 0, 20, 1000), // LEFT
	    new Rect(1565, 0, 20, 1000), // RIGHT
	    new Rect(0, 850, 290, 60), // BOTTOM
	    new Rect(350, 850, 1290, 60), // BOTTOM
	    new Rect(20, 90, 350, 145),
	};
	
	Wall[] wall = {
		new Wall("mazeWall1.png", 450, 240),
		new Wall("mazeWall2.png", 315, 630),
		new Wall("mazeWall3.png", 150, 430),
		new Wall("mazeWall3.png", 925, 280),
		new Wall("mazeWall1alt.png", 877, 593),
		new Wall("mazeWall1.png", 900, 730),
		new Wall("mazeWall1alt.png", 1034, 730),
		new Wall("mazeWall1alt.png", 1168, 730),
		new Wall("mazeWall1alt.png", 180, 473),
		new Wall("mazeWall2.png", 1300, 530),
	};
	
	Wall[] wallTop = {
		new Wall("mazeTop1.png", 450, 200), // mazeWall1.y -= 40			
		new Wall("mazeTop2.png", 315, 330), // mazeWall2.y -= 300
		new Wall("mazeTop3.png", 150, 230), // mazeWall3.y -= 200
		new Wall("mazeTop3.png", 150, 635),
		new Wall("mazeTopWall4.png", 450, 190),
		new Wall("mazeTopWall4.png", 810, 200),
		new Wall("mazeTop3.png", 925, 80), // mazeWall3.y -= 200
		new Wall("mazeTop1.png", 877, 553), // mazeWall1.y -= 40	
		new Wall("mazeTop2.png", 585, 543),
		new Wall("mazeTop1.png", 450, 800),
		new Wall("mazeTop1.png", 900, 690), // mazeWall1.y -= 40
		new Wall("mazeTop1.png", 1034, 690), // mazeWall1.y -= 40
		new Wall("mazeTop1.png", 1168, 690),
		new Wall("mazeTop3.png", 1168, 638),
		new Wall("mazeTop1.png", 180, 433), // mazeWall1.y -= 40
		new Wall("mazeTop2.png", 585, 543),
		new Wall("mazeTop3.png", 1300, 80),
		new Wall("mazeTop2.png", 1300, 230), // mazeWall2.y -= 300
		new Wall("mazeTop3.png", 1400, 638),
		new Wall("mazeTop3.png", 1425, 275),
	};
	
	Food[] food = {
		new Food("strawberry", 100, 300),
		new Food("avocado", 50, 300),
		new Food("apple", 100, 700),
		new Food("appleworm", 50, 700),
		new Food("beer", 100, 750),
		new Food("boar", 50, 750),
	};
	int score = 0;
	
	double speed = 5;
	
//	Wall wall1 = new Wall("mazeWall1.png", 500, 500);
//	Wall top1 = new Wall("mazeTop1.png", 500, 460);
//	Image strawberry = Toolkit.getDefaultToolkit().createImage("strawberry.png");
	
	Background background = new Background("mazeEmpty.png", 1600, 900);
	
	public void inGameLoop()
	{
		// Code that executes 60 times per second
		
		// Move User Controlled Objects
		bc.chase(y);
		
		
		
//		if(pressing[SHFT]) {
//			speed = 10;
//		}
//		y.physics = true;
		if(pressing[UP] || pressing[_W]) 	y.goUP((int)speed);
		if(pressing[DN] || pressing[_S]) 	y.goDN((int)speed);
		if(pressing[LT] || pressing[_A])	y.goLT((int)speed);
		if(pressing[RT] || pressing[_D])	y.goRT((int)speed);
		
		y.move();
		
		// Move Computer Controlled Objects

		
		// Handle Collisions
		for(int i = 0; i < r.length; i++) {
			if(r[i].overlaps(y)) r[i].pushes(y);
			if(r[i].overlaps(bc)) r[i].pushes(bc);
		}
		
		for(int i = 0; i < wallTop.length; i++) {
			
			if(wallTop[i].overlaps(y)) 	wallTop[i].pushes(y);
			if(wallTop[i].overlaps(bc)) wallTop[i].pushes(bc);
			
			if(wallTop[i].rect2 != null && wallTop[i].rect2.overlaps(y)) wallTop[i].rect2.pushes(y);
			if(wallTop[i].rect2 != null && wallTop[i].rect2.overlaps(bc)) wallTop[i].rect2.pushes(bc);
			
			if(wallTop[i].rect3 != null && wallTop[i].rect3.overlaps(y)) wallTop[i].rect3.pushes(y);
			if(wallTop[i].rect3 != null && wallTop[i].rect3.overlaps(bc)) wallTop[i].rect3.pushes(bc);
			
			if(wallTop[i].rect4 != null && wallTop[i].rect4.overlaps(y)) wallTop[i].rect4.pushes(y);
			if(wallTop[i].rect4 != null && wallTop[i].rect4.overlaps(bc)) wallTop[i].rect4.pushes(bc);
			
			if(wallTop[i].rect5 != null && wallTop[i].rect5.overlaps(y)) wallTop[i].rect5.pushes(y);
			if(wallTop[i].rect5 != null && wallTop[i].rect5.overlaps(bc)) wallTop[i].rect5.pushes(bc);
			
			if(wallTop[i].rect6 != null && wallTop[i].rect6.overlaps(y)) wallTop[i].rect6.pushes(y);
			if(wallTop[i].rect6 != null && wallTop[i].rect6.overlaps(bc)) wallTop[i].rect6.pushes(bc);

		}
		
		for(int i = 0; i < food.length; i++) {
			if(food[i].overlaps(y)) {
				food[i].eaten = true;
				if(food[i].incrementScore) {
					speed+= 0.5;
					score++;
					System.out.println("Speed is now " + speed + ". Total score " + score);
					food[i].incrementScore = false;
				}
			}
		}
		
//		if(bc.overlaps(y)) bc.pushes(y);
		
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
		
		for(int i = 0; i < food.length; i++) {
			food[i].draw(g);
		}
		
//		food[0].draw(g);
//		System.out.println(food[0].filename);
//		g.drawImage(strawberry, 100, 300, 50, 50, null);
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
	}	
}
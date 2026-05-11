import java.applet.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

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
	    new Rect(1450, 90, 100, 100), // COMPLETE r[6]
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
		new Food("strawberry", 100, 350),
		new Food("avocado", 50, 300),
		new Food("apple", 100, 700),
		new Food("appleworm", 50, 700),
		new Food("beer", 100, 750),
		new Food("boar", 50, 750),
		new Food("bread", 265, 550),
		new Food("brownie", 265, 375),
		new Food("cheese", 215, 375),
		new Food("cherry", 400, 375),
		new Food("chicken", 400, 275),
		
		new Food("chickenleg", 990, 375),
		new Food("cookie", 940, 375),
		new Food("dragonfruit", 890, 375),
		
		new Food("eggplant", 1115, 325),
		new Food("eggs", 1115, 375),
		new Food("fish", 1115, 425),
		
		new Food("fishfillet", 1115, 550),
		new Food("fishsteak", 1115, 600),
	};
	
	Obstacle[] barrel = {
		new Obstacle("web", 100, 300),
		new Obstacle("barrel", 220, 600),
		new Obstacle("barrel", 50, 550),
		new Obstacle("barrel", 50, 600),
		new Obstacle("barrel", 215, 300),
		new Obstacle("barrel", 350, 675),
		new Obstacle("web", 400, 675),
		new Obstacle("web", 400, 100),
	};

	int score = 0;	
	double speed = 2;
	int lives = 5;
	boolean outputOnce = true;
	String scoreMessage = "FOODS EATEN: " + score; 
	String speedMessage = "SPEED: " + speed + "mph";
	
	
//	Wall wall1 = new Wall("mazeWall1.png", 500, 500);
//	Wall top1 = new Wall("mazeTop1.png", 500, 460);
	Image sign1 = Toolkit.getDefaultToolkit().createImage("sign1.png");
	Image sign2 = Toolkit.getDefaultToolkit().createImage("sign2.png");
	Image sign3 = Toolkit.getDefaultToolkit().createImage("sign3.png");
	
	Background background = new Background("mazeEmpty.png", 1600, 900);
	Background complete = new Background("complete.png", 1600, 900);
	Background gameover = new Background("gameover.png", 1600, 900);
	
	
	
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
		for(int i = 0; i < r.length-1; i++) {
			if(r[i].overlaps(y)) r[i].pushes(y);
			if(r[i].overlaps(bc)) r[i].pushes(bc);
		}
		
		
		
		for(int i = 0; i < barrel.length; i++) {
			if(barrel[i].overlaps(y)) barrel[i].pushes(y);
			if(barrel[i].overlaps(bc)) barrel[i].pushes(bc);
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
					score++;
					if(speed <= 15) {
						speed+= 0.25;
//						System.out.println("Speed is now " + speed + ". Total score " + score);
						scoreMessage = "FOODS EATEN: " + score;
						speedMessage = "SPEED: " + speed + "mph";
					}
					
					
					food[i].incrementScore = false;
				}
			}
		}
		
		if(bc.overlaps(y)) {
			bc.pushes(y);
			lives -= 1;
			y.setPosition(300, 800);
			
		}
		
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
		
		for(int i = 0; i < barrel.length; i++) {
			barrel[i].draw(g);
		}
		
//		food[0].draw(g);
//		System.out.println(food[0].filename);
		g.drawImage(sign1, 520, 100, 158, 50, null);
		g.drawImage(sign2, 1100, 100, 104, 50, null);
		g.drawImage(sign3, 1345, 535, 104, 50, null);
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
		
		g.setFont(customFont);
		g.drawString(scoreMessage + "/" + food.length, 50, 100);
		g.setFont(customFontSub);
		g.drawString(speedMessage, 50, 156);
		g.drawString("Lives: " + lives, 50, 186);
		
		if(r[6].overlaps(y)) complete.draw(g);
		
		if(lives == 0) {
			gameover.draw(g);
		}
		
		if(outputOnce) {
//			System.out.println(new File("bin/PixelifySans-Regular.ttf").getAbsolutePath());
			outputOnce = false;
		}
	}	
}
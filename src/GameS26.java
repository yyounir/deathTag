import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GameS26 extends GameBase {		
	
	Younir y = new Younir(300, 800, Younir.UP);
	
	BadChar bc = new BadChar(800, 450, Violetta.LT);
	
	BadChar[] bcMultiple = {
		new BadChar(70, 740, Violetta.RT),
		new BadChar(70, 400, Violetta.RT),
	};
		
	Rect[][] r = {{
//		Level 1: Index 0-6 7 is complete
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 1000), // LEFT
	    new Rect(1565, 0, 20, 1000), // RIGHT
	    new Rect(0, 850, 290, 60), // BOTTOM
	    new Rect(0, 900, 1290, 60), // BOTTOM
	    new Rect(350, 850, 1290, 60), // BOTTOM
	    new Rect(20, 90, 350, 145),
	    new Rect(1450, 90, 100, 100), // LV1 COMPLETE r[7]
	    
	},{
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 1000), // LEFT
	    new Rect(1565, 0, 20, 1000), // RIGHT
	    new Rect(0, 850, 290, 60), // BOTTOM
	    new Rect(0, 900, 1290, 60), // BOTTOM
	    new Rect(350, 850, 1290, 60), // BOTTOM
	    new Rect(20, 90, 350, 145),
	    new Rect(1450, 90, 100, 100), // LV2 COMPLETE r[7]
	},{
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 1000), // LEFT
	    new Rect(1565, 0, 20, 1000), // RIGHT
	    new Rect(0, 850, 290, 60), // BOTTOM
	    new Rect(0, 900, 1290, 60), // BOTTOM
	    new Rect(350, 850, 1290, 60), // BOTTOM
	    new Rect(20, 90, 350, 145),
	    new Rect(1450, 90, 100, 100), // LV3 COMPLETE r[7]
	},
	{
		new Rect(0, 70, 1700, 20), // TOP
	    new Rect(30, 0, 20, 1000), // LEFT
	    new Rect(1565, 0, 20, 1000), // RIGHT
	    new Rect(0, 850, 290, 60), // BOTTOM
	    new Rect(0, 900, 1290, 60), // BOTTOM
	    new Rect(350, 850, 1290, 60), // BOTTOM
	    new Rect(20, 90, 350, 145),
	    new Rect(1450, 90, 100, 100), // LV3 COMPLETE r[7]
	}};
	
	Wall[][] wall = {{
//		Level 1: Index 0-9
		new Wall("mazeWall1", 450, 240),
		new Wall("mazeWall2", 315, 630),
		new Wall("mazeWall3", 150, 430),
		new Wall("mazeWall3", 925, 280),
		new Wall("mazeWall1alt", 877, 593),
		new Wall("mazeWall1", 900, 730),
		new Wall("mazeWall1alt", 1034, 730),
		new Wall("mazeWall1alt", 1168, 730),
		new Wall("mazeWall1alt", 180, 473),
		new Wall("mazeWall2", 1300, 530),
		}, {
		new Wall("mazeWall2[2]", 300, 530),
		new Wall("mazeWall1[2]", 300, 680),
		new Wall("mazeWall1alt[2]", 434, 680),
		new Wall("mazeWall1alt[2]", 166, 680),
		new Wall("mazeWall3[2]", 430, 280),
		new Wall("mazeWall3[2]", 1050, 280),
		new Wall("mazeWall3[2]", 1050, 501),
		new Wall("mazeWall1alt[2]", 570, 320),
		new Wall("mazeWall1alt[2]", 915, 565),
		new Wall("mazeWall1[2]", 1049, 565),
//		new Wall("mazeWall1alt[2]", 1183, 565),
		new Wall("mazeWall1alt[2]", 915, 725),
		new Wall("mazeWall1[2]", 1049, 725),
		new Wall("mazeWall1alt[2]", 1183, 725),
		new Wall("mazeWall3[2]", 1315, 725),
		new Wall("mazeWall3[2]", 1430, 725),
		new Wall("mazeWall1alt[2]", 1430, 521),
		new Wall("mazeWall3[2]", 1180, 420),
		new Wall("mazeWall1[2]", 1430, 290),
		new Wall("mazeWall1alt[2]", 1247, 320),
	},{
		new Wall("mazeWall1[3]", 1427, 250),
		new Wall("mazeWall1alt[3]", 1227, 250),
		new Wall("mazeWall1[3]", 1030, 250),
		new Wall("mazeWall1alt[3]", 833, 250),
		new Wall("mazeWall1[3]", 636, 250),
		new Wall("mazeWall1alt[3]", 439, 250),
		new Wall("mazeWall1alt[3]", 1427, 391),
		new Wall("mazeWall1[3]", 1227, 391),
		new Wall("mazeWall1alt[3]", 1030, 391),
		new Wall("mazeWall1[3]", 833, 391),
		new Wall("mazeWall1alt[3]", 636, 391),
		new Wall("mazeWall1[3]", 439, 391),
		new Wall("mazeWall1alt[3]", 242, 391),
		new Wall("mazeWall1[3]", 51, 391),
		
		new Wall("mazeWall1[3]", 1427, 532),
		new Wall("mazeWall1alt[3]", 1227, 532),
		new Wall("mazeWall1[3]", 1030, 532),
		new Wall("mazeWall1alt[3]", 833, 532),
		new Wall("mazeWall1[3]", 636, 532),
		new Wall("mazeWall1alt[3]", 439, 532),
		new Wall("mazeWall1[3]", 242, 532),
		new Wall("mazeWall1alt[3]", 51, 532),
		
		new Wall("mazeWall1alt[3]", 1427, 673),
		new Wall("mazeWall1[3]", 1227, 673),
		new Wall("mazeWall1alt[3]", 1030, 673),
		new Wall("mazeWall1[3]", 833, 673),
		new Wall("mazeWall1alt[3]", 636, 673),
		new Wall("mazeWall1[3]", 439, 673),
		new Wall("mazeWall1alt[3]", 242, 673),
		new Wall("mazeWall1[3]", 51, 673),
	},
	{}};
	
	Wall[][] wallTop = {{
		new Wall("mazeTop1", wall[0][0].x, (wall[0][0].y - 40)), // mazeWall1.y -= 40			
		new Wall("mazeTop2", wall[0][1].x, (wall[0][1].y - 300)), // mazeWall2.y -= 300
		new Wall("mazeTop3", wall[0][2].x, (wall[0][2].y - 200)), // mazeWall3.y -= 200
		new Wall("mazeTop3", 150, 635),
		new Wall("mazeTopWall4", 450, 190),
		new Wall("mazeTopWall4", 810, 200),
		new Wall("mazeTop3", wall[0][3].x, (wall[0][3].y - 200)), // mazeWall3.y -= 200
		new Wall("mazeTop1", wall[0][4].x, (wall[0][4].y - 40)), // mazeWall1.y -= 40	
		new Wall("mazeTop2", 585, 543),
		new Wall("mazeTop1", 450, 800),
		new Wall("mazeTop1", wall[0][5].x, (wall[0][5].y - 40)), // mazeWall1.y -= 40
		new Wall("mazeTop1", wall[0][6].x, (wall[0][6].y - 40)), // mazeWall1.y -= 40
		new Wall("mazeTop1", 1168, 690),
		new Wall("mazeTop3", 1168, 638),
		new Wall("mazeTop1", 180, 433), // mazeWall1.y -= 40
		new Wall("mazeTop2", 585, 543),
		new Wall("mazeTop3", 1300, 80),
		new Wall("mazeTop2", 1300, 230), // mazeWall2.y -= 300
		new Wall("mazeTop3", 1400, 638),
		new Wall("mazeTop3", 1425, 275)		
		},{
		new Wall("mazeTop2[2]", wall[1][0].x, (wall[1][0].y - 300)), // mazeWall2.y -= 300
		new Wall("mazeTop1[2]", wall[1][1].x, (wall[1][1].y - 40)), // mazeWall1.y -= 40	
		new Wall("mazeTop1[2]", wall[1][2].x, (wall[1][2].y - 40)),
		new Wall("mazeTop1[2]", wall[1][3].x, (wall[1][3].y - 40)),
		new Wall("mazeTopWall4[2]", 564, 190),
		new Wall("mazeTop3[2]", 166, 440),
		new Wall("mazeTop3[2]", 565, 650),
		new Wall("mazeTop3[2]", 565, 449),
		new Wall("mazeTop3[2]", wall[1][4].x, (wall[1][4].y - 200)),
		new Wall("mazeTop3[2]", wall[1][5].x, (wall[1][5].y - 200)),
		new Wall("mazeTop3[2]", wall[1][6].x, (wall[1][6].y - 200)),
		new Wall("mazeTop1[2]", wall[1][7].x, (wall[1][7].y - 40)),
		new Wall("mazeTop1[2]", wall[1][8].x, (wall[1][8].y - 40)),
		new Wall("mazeTop1[2]", wall[1][9].x, (wall[1][9].y - 40)),
//		new Wall("mazeTop1[2]", wall[1][10].x, (wall[1][10].y - 40)),
		new Wall("mazeTop1[2]", 730, 800),
		new Wall("mazeTop1[2]", wall[1][10].x, (wall[1][10].y - 40)),
		new Wall("mazeTop1[2]", wall[1][11].x, (wall[1][11].y - 40)),
		new Wall("mazeTop1[2]", wall[1][12].x, (wall[1][12].y - 40)),
		new Wall("mazeTop3[2]", wall[1][13].x, (wall[1][13].y - 200)),
		new Wall("mazeTop3[2]", 1315, 323),
		new Wall("mazeTop3[2]", wall[1][14].x, (wall[1][14].y - 200)),
		new Wall("mazeTop1[2]", wall[1][15].x, (wall[1][15].y - 40)),
		new Wall("mazeTop3[2]", wall[1][16].x, (wall[1][16].y - 200)),
		new Wall("mazeTop1[2]", wall[1][17].x, (wall[1][17].y - 40)),
		new Wall("mazeTop1[2]", wall[1][18].x, (wall[1][18].y - 40)),
	},{
		new Wall("mazeTop1[3]", wall[2][0].x, (wall[2][0].y - 40)),
		new Wall("mazeTop1[3]", wall[2][1].x, (wall[2][1].y - 40)),
		new Wall("mazeTop1[3]", wall[2][2].x, (wall[2][2].y - 40)),
		new Wall("mazeTop1[3]", wall[2][3].x, (wall[2][3].y - 40)),
		new Wall("mazeTop1[3]", wall[2][4].x, (wall[2][4].y - 40)),
		new Wall("mazeTop1[3]", wall[2][5].x, (wall[2][5].y - 40)),
		new Wall("mazeTop1[3]", wall[2][6].x, (wall[2][6].y - 40)),
		new Wall("mazeTop1[3]", wall[2][7].x, (wall[2][7].y - 40)),
		new Wall("mazeTop1[3]", wall[2][8].x, (wall[2][8].y - 40)),
		new Wall("mazeTop1[3]", wall[2][9].x, (wall[2][9].y - 40)),
		new Wall("mazeTop1[3]", wall[2][10].x, (wall[2][10].y - 40)),
		new Wall("mazeTop1[3]", wall[2][11].x, (wall[2][11].y - 40)),
		new Wall("mazeTop1[3]", wall[2][12].x, (wall[2][12].y - 40)),
		new Wall("mazeTop1[3]", wall[2][13].x, (wall[2][13].y - 40)),
		new Wall("mazeTop1[3]", wall[2][14].x, (wall[2][14].y - 40)),
		new Wall("mazeTop1[3]", wall[2][15].x, (wall[2][15].y - 40)),
		new Wall("mazeTop1[3]", wall[2][16].x, (wall[2][16].y - 40)),
		new Wall("mazeTop1[3]", wall[2][17].x, (wall[2][17].y - 40)),
		new Wall("mazeTop1[3]", wall[2][18].x, (wall[2][18].y - 40)),
		new Wall("mazeTop1[3]", wall[2][19].x, (wall[2][19].y - 40)),
		new Wall("mazeTop1[3]", wall[2][20].x, (wall[2][20].y - 40)),
		new Wall("mazeTop1[3]", wall[2][21].x, (wall[2][21].y - 40)),
		new Wall("mazeTop1[3]", wall[2][22].x, (wall[2][22].y - 40)),
		new Wall("mazeTop1[3]", wall[2][23].x, (wall[2][23].y - 40)),
		new Wall("mazeTop1[3]", wall[2][24].x, (wall[2][24].y - 40)),
		new Wall("mazeTop1[3]", wall[2][25].x, (wall[2][25].y - 40)),
		new Wall("mazeTop1[3]", wall[2][26].x, (wall[2][26].y - 40)),
		new Wall("mazeTop1[3]", wall[2][27].x, (wall[2][27].y - 40)),
		new Wall("mazeTop1[3]", wall[2][28].x, (wall[2][28].y - 40)),
		new Wall("mazeTop1[3]", wall[2][29].x, (wall[2][29].y - 40)),
	},
	{}};
	
	Food[][] food = {{
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
		new Food("grub", 515, 550),
		new Food("honeycomb", 515, 605),		
		new Food("honey", 525, 310),
		new Food("grubs", 525, 360),	
		new Food("eggplant", 1115, 325),
		new Food("eggs", 1115, 375),
		new Food("fish", 1115, 425),		
		new Food("fishfillet", 1115, 550),
		new Food("fishsteak", 1115, 605),
		new Food("Jam", 755, 350),
		new Food("Jerky", 755, 400),
		new Food("Lemon", 755, 450),
		new Food("marmalade", 755, 500),
		new Food("Onion", 755, 650),
		new Food("Peach", 755, 700),
		new Food("Melonhoneydew", 805, 650),
		new Food("peppergreen", 805, 700),
		new Food("Moonshine", 1300, 735),
		new Food("Pepperoni", 1300, 785),
		new Food("Pepperred", 1250, 785),
		new Food("Olive", 1350, 785),
		new Food("Melonwater", 1350, 735),
		new Food("Pickle", 1470, 785),
		new Food("PieApple", 1505, 785),
		new Food("Pickle", 1465, 605),
		new Food("PieApple", 1510, 605),
	}, {
		new Food("PieApple", 300, 800),
		new Food("pielemon", 400, 750),
		new Food("potatored", 450, 790),
		new Food("pielemon", 200, 750),
		new Food("pretzel", 150, 790),
		new Food("potato", 1200, 790),
		new Food("ribs", 1250, 790),
		new Food("brownie", 1300, 790),
		new Food("bread", 1350, 780),
		new Food("potato", 55, 640),
		new Food("roll", 60, 680),
		new Food("saki", 60, 590),
		new Food("sardines", 865, 420),
		new Food("sashimi", 865, 370),
		new Food("shrimp", 245, 350),
		new Food("steak", 245, 400),
		new Food("strawberry", 700, 350),
		new Food("tomato", 640, 350),
		new Food("sushi", 380, 250),
		new Food("tart", 380, 200),
		new Food("piepumpkin", 850, 750),
		new Food("pineapple", 900, 790),
		new Food("avocado", 650, 640),
		new Food("whiskey", 650, 690),
		new Food("turnip", 650, 740),
		new Food("waffles", 650, 790),
		new Food("boar", 950, 630),
		new Food("beer", 1000, 630),
		new Food("apple", 1050, 630),
		new Food("bug", 1100, 630),
		new Food("chickenleg", 1260, 400),
		new Food("cherry", 1260, 450),
		new Food("chicken", 1500, 730),
		new Food("cheese", 1500, 680),
		new Food("cookie", 1500, 630),
		new Food("dragonfruit", 1500, 425),
		new Food("eggs", 1500, 375),
		new Food("fish", 1440, 425),
		new Food("eggplant", 1440, 375),
		new Food("fish", 1125, 300),
		new Food("fishsteak", 1125, 240),
	},{
		new Food("Apple", 300, 800),
		new Food("avocado", 350, 740),
		new Food("beer", 410, 740),
		new Food("boar", 470, 740),
		new Food("brownie", 530, 740),
		new Food("bread", 350, 790),
		new Food("cheese", 410, 790),
		new Food("cherry", 470, 790),
		new Food("chicken", 530, 790),
		
		new Food("appleworm", 150, 575),
		new Food("chickenleg", 210, 575),
		new Food("cookie", 270, 575),
		new Food("eggplant", 330, 575),
		new Food("dragonfruit", 550, 575),
		new Food("eggs", 610, 575),
		new Food("fish", 670, 575),
		new Food("fishsteak", 730, 575),
		new Food("fishfillet", 950, 575),
		new Food("grub", 1010, 575),
		new Food("honey", 1070, 575),
		new Food("jam", 1130, 575),
		
		new Food("honeycomb", 350, 435),
		new Food("grubs", 410, 435),
		new Food("jerky", 470, 435),
		new Food("lemon", 530, 435),
		new Food("marmalade", 750, 435),
		new Food("meloncantaloupe", 810, 435),
		new Food("melonhoneydew", 870, 435),
		new Food("melonwater", 930, 435),
		new Food("moonshine", 1150, 435),
		new Food("olive", 1210, 435),
		new Food("onion", 1270, 435),
		new Food("peach", 1330, 435),
		
		new Food("peppergreen", 90, 300),
		new Food("pepperoni", 150, 300),
		new Food("pepperred", 210, 300),
		new Food("pickle", 270, 300),
		new Food("pickledeggs", 330, 300),
		new Food("PieApple", 490, 300),
		new Food("pielemon", 550, 300),
		new Food("Piepumpkin", 610, 300),
		new Food("pineapple", 670, 300),
		new Food("potato", 730, 300),
		new Food("pretzel", 790, 300),
		new Food("ribs", 850, 300),
		new Food("roll", 910, 300),
		new Food("sardines", 1250, 300),
		new Food("saki", 1310, 300),
		new Food("sashimi", 1370, 300),
		new Food("shrimp", 1430, 300),
		
		new Food("fish", 490, 160),
		new Food("chicken", 550, 160),
		new Food("steak", 610, 160),
		new Food("stein", 670, 160),
		new Food("strawberry", 730, 160),
		new Food("sushi", 790, 160),
		new Food("tart", 850, 160),
		new Food("tomato", 910, 160),
		new Food("turnip", 970, 160),
		new Food("waffles", 1030, 160),
		new Food("whiskey", 1090, 160),
	},
	{}};
	
	
	Obstacle[][] barrel = {{
		new Obstacle("web", 100, 300),
		new Obstacle("barrel", 220, 600),
		new Obstacle("barrel", 50, 550),
		new Obstacle("barrel", 50, 600),
		new Obstacle("barrel", 215, 300),
		new Obstacle("barrel", 350, 675),
		new Obstacle("web", 400, 675),
		new Obstacle("web", 400, 80),
		new Obstacle("web", 800, 80),
		new Obstacle("web", 1000, 80),
		new Obstacle("web",755, 250),
		new Obstacle("barrel", 755, 300),
		new Obstacle("barrel", 1470, 715)
	}, {
		new Obstacle("barrel", 100, 440),
		new Obstacle("barrel", 100, 640),
		new Obstacle("web", 100, 240),
		new Obstacle("web", 380, 110),
		new Obstacle("web", 700, 90),
		new Obstacle("web", 1120, 90),
		new Obstacle("barrel", 200, 290),
		new Obstacle("barrel", 250, 290),
		new Obstacle("barrel", 450, 320),
		new Obstacle("web", 875, 250),
		new Obstacle("barrel", 875, 300),
		new Obstacle("web", 700, 450),
		new Obstacle("barrel", 650, 500),
		new Obstacle("web", 1255, 325),
		new Obstacle("barrel", 1500, 570),
	},{
		new Obstacle("barrel", 1500, 570),
		new Obstacle("web", 1125, 80),
		new Obstacle("barrel", 1370, 660),
//		new Obstacle("barrel", 1172, 660),
		new Obstacle("barrel", 974, 660),
		new Obstacle("barrel", 776, 660),
		new Obstacle("barrel", 578, 660),
//		new Obstacle("barrel", 380, 660),
//		new Obstacle("barrel", 190, 660),
		
		new Obstacle("barrel", 974, 500),
		new Obstacle("barrel", 578, 500),
		new Obstacle("barrel", 190, 500),
		
		new Obstacle("barrel", 1370, 370),
		new Obstacle("barrel", 1172, 370),
//		new Obstacle("barrel", 974, 370),
		new Obstacle("barrel", 578, 370),
		
		new Obstacle("barrel", 380, 300),
		new Obstacle("barrel", 380, 230),
	},
	{}};
	
	NonObstacles[][] nobstacle= {{}, {
		new NonObstacles("puddle", 110, 505),
		new NonObstacles("puddle", 60, 535),
		new NonObstacles("puddle", 60, 760),
		new NonObstacles("puddle", 250, 535),
		new NonObstacles("puddle", 500, 575),
		new NonObstacles("puddle", 500, 775),
		new NonObstacles("puddle", 500, 375),
		new NonObstacles("puddle", 1000, 205),
		new NonObstacles("puddle", 1000, 375),
		new NonObstacles("puddle", 700, 600),
		new NonObstacles("puddle", 1200, 600),
		new NonObstacles("puddle", 1250, 200),
		new NonObstacles("puddle", 1260, 200),
		new NonObstacles("puddle", 1270, 200),
	},{
		new NonObstacles("puddle", 1170, 200),
		new NonObstacles("puddle", 1170, 540),
		new NonObstacles("puddle", 1170, 320),
	},
	{}};
	
	Sign[][] sign = {{
		new Sign("sign1", 520, 100),
		new Sign("sign2", 1100, 100),
		new Sign("sign4", 1345, 535),
	},{
		new Sign("sign6", 520, 100),
		new Sign("sign7", 820, 100),
		new Sign("sign9", 1320, 100),
	}, {
		new Sign("sign10", 420, 100),
		new Sign("sign8", 520, 100),
		new Sign("sign11", 920, 100),
		new Sign("sign5", 1320, 100),
	},
	{}};
	
	

	int level = 1;
	int[] score = {0, 0, -1, -1, 0};
	int totalFoods = 0;
	
	boolean gameStart = false;
	
	double speed = 2;
	int lives = 5;
	boolean outputOnce = true;
	boolean[] gameComplete = {false, false, false, false, 
			false};
	
	String scoreMessage = "FOODS EATEN: " + score[level]; 
	
	String speedMessage = "SPEED: " + speed + "mph";
	
	Background title = new Background("title.png", 1600, 900);
	Background background = new Background("mazeEmpty.png", 1600, 900);
	Background background2 = new Background("mazeEmpty2.png", 1600, 900);
	Background background3 = new Background("mazeEmpty3.png", 1600, 900);
	Background backgroundthanks = new Background("thanks.png", 1600, 900);
	Background complete = new Background("complete.png", 1600, 900);
	Background gameover = new Background("gameover.png", 1600, 900);
	
	
	
	public void inGameLoop()
	{
		// Code that executes 60 times per second
		
		// Move User Controlled Objects
		bc.chase(y);
		
		for(int i = 0; i < bcMultiple.length; i++) {
			if(level == 3) {bcMultiple[i].chase(y);}
		}
		
		if(r[level-1][7].overlaps(y) && pressing[SPACE]) {
		    gameComplete[level] = true;
		    score[level] = 0;
		    speed = 1.75;
		    y.setPosition(300, 800);
		    switch(level) {
		    	case 1:
		    		bc.setPosition(750, 450);
					break;
		    	case 2:
//		    		bc.setPosition(750, 450);
		    		bc.setPosition(70, 550);
					bcMultiple[0].setPosition(70, 740);
					bcMultiple[1].setPosition(70, 400);
					break;
		    	case 3:
		    		bc.setPosition(70, 550);
					bcMultiple[0].setPosition(70, 740);
					bcMultiple[1].setPosition(70, 400);
					break;
		    }
		    level++;
		    
		}
		
		if(!gameStart && pressing[SPACE]) {
			gameStart = true;
		}
		
//		y.physics = true;
		if(pressing[UP] || pressing[_W]) 	y.goUP((int)speed);
		if(pressing[DN] || pressing[_S]) 	y.goDN((int)speed);
		if(pressing[LT] || pressing[_A])	y.goLT((int)speed);
		if(pressing[RT] || pressing[_D])	y.goRT((int)speed);
		
		y.move();
		
		// Move Computer Controlled Objects

		
		// Handle Collisions
		for(int i = 0; i < r[level-1].length - 1; i++) {
			if(r[level-1][i].overlaps(y)) r[level-1][i].pushes(y);
			if(r[level-1][i].overlaps(bc)) r[level-1][i].pushes(bc);
		}
		
		
		for(int i = 0; i < barrel[level-1].length; i++) {
			if(barrel[level-1][i].overlaps(y)) barrel[level-1][i].pushes(y);
			if(barrel[level-1][i].overlaps(bc)) barrel[level-1][i].pushes(bc);
			if(barrel[level-1][i].overlaps(bcMultiple[0])) barrel[level-1][i].pushes(bcMultiple[0]);
			if(barrel[level-1][i].overlaps(bcMultiple[1])) barrel[level-1][i].pushes(bcMultiple[1]);
		}
		
		for(int i = 0; i < wallTop[level-1].length; i++) {
			
			if(wallTop[level-1][i].overlaps(y)) wallTop[level-1][i].pushes(y);
			if(wallTop[level-1][i].overlaps(bc)) wallTop[level-1][i].pushes(bc);
			if(wallTop[level-1][i].overlaps(bcMultiple[0])) wallTop[level-1][i].pushes(bcMultiple[0]);
			if(wallTop[level-1][i].overlaps(bcMultiple[1])) wallTop[level-1][i].pushes(bcMultiple[1]);
			
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(y)) wallTop[level-1][i].rect2.pushes(y);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bc)) wallTop[level-1][i].rect2.pushes(bc);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[0])) wallTop[level-1][i].rect2.pushes(bcMultiple[0]);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[1])) wallTop[level-1][i].rect2.pushes(bcMultiple[1]);
			
			if(wallTop[level-1][i].rect3 != null && wallTop[level-1][i].rect3.overlaps(y)) wallTop[level-1][i].rect3.pushes(y);
			if(wallTop[level-1][i].rect3 != null && wallTop[level-1][i].rect3.overlaps(bc)) wallTop[level-1][i].rect3.pushes(bc);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[0])) wallTop[level-1][i].rect2.pushes(bcMultiple[0]);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[1])) wallTop[level-1][i].rect2.pushes(bcMultiple[1]);
			
			if(wallTop[level-1][i].rect4 != null && wallTop[level-1][i].rect4.overlaps(y)) wallTop[level-1][i].rect4.pushes(y);
			if(wallTop[level-1][i].rect4 != null && wallTop[level-1][i].rect4.overlaps(bc)) wallTop[level-1][i].rect4.pushes(bc);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[0])) wallTop[level-1][i].rect2.pushes(bcMultiple[0]);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[1])) wallTop[level-1][i].rect2.pushes(bcMultiple[1]);
			
			if(wallTop[level-1][i].rect5 != null && wallTop[level-1][i].rect5.overlaps(y)) wallTop[level-1][i].rect5.pushes(y);
			if(wallTop[level-1][i].rect5 != null && wallTop[level-1][i].rect5.overlaps(bc)) wallTop[level-1][i].rect5.pushes(bc);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[0])) wallTop[level-1][i].rect2.pushes(bcMultiple[0]);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[1])) wallTop[level-1][i].rect2.pushes(bcMultiple[1]);
			
			if(wallTop[level-1][i].rect6 != null && wallTop[level-1][i].rect6.overlaps(y)) wallTop[level-1][i].rect6.pushes(y);
			if(wallTop[level-1][i].rect6 != null && wallTop[level-1][i].rect6.overlaps(bc)) wallTop[level-1][i].rect6.pushes(bc);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[0])) wallTop[level-1][i].rect2.pushes(bcMultiple[0]);
			if(wallTop[level-1][i].rect2 != null && wallTop[level-1][i].rect2.overlaps(bcMultiple[1])) wallTop[level-1][i].rect2.pushes(bcMultiple[1]);

		}
		
		for(int i = 0; i < food[level-1].length; i++) {
			if(food[level-1][i].overlaps(y)) {
				food[level-1][i].eaten = true;
				if(food[level-1][i].incrementScore) {
					score[level]++;
					totalFoods++;
					if(speed <= 15) {
						speed+= 0.25;
//						
						speedMessage = "SPEED: " + speed + "mph";
						
					}
//					System.out.println("Speed is now " + speed + ". Total score " + score);
					scoreMessage = "FOODS EATEN: " + score[level];
					
					
					food[level-1][i].incrementScore = false;
				}
			}
		}
		
		if(bc.overlaps(y) || bcMultiple[0].overlaps(y) || bcMultiple[1].overlaps(y)) {
			bc.pushes(y);
			lives -= 1;
			y.setPosition(300, 800);
			switch(level) {
				case 1:
					bc.setPosition(800, 450);
					break;
				case 2:
					bc.setPosition(750, 450);
					break;
				case 3:
					bc.setPosition(70, 550);
					bcMultiple[0].setPosition(70, 740);
					bcMultiple[1].setPosition(70, 400);
					break;
			}
			
			
		}
	}
	
	public void title(Graphics g) {
		
//		y.still();
		if(!gameStart) {
			title.draw(g);
		}
		
	}
	
	public void level1(Graphics g) {
		
		
//		System.out.println("game has started");
		
		background.draw(g);
		

		g.setColor(Color.YELLOW);
		
//		g.drawImage(wallTop, 500, 500, 234, 72, null);
		
//		if(y.overlaps(r1))	g.setColor(Color.RED);
		
//		r1.draw(g);
//		r2.draw(g);
//		r3.draw(g);
//		r4.draw(g);
		
		for(int i = 0; i < wall[level-1].length; i++) {
			wall[level-1][i].draw(g);
		}
		
		for(int i = 0; i < wallTop[level-1].length; i++) {
			wallTop[level-1][i].draw(g);
		}
		
		for(int i = 0; i <= r[level-1].length; i++) {
//			 r[i].draw(g);
		}
		
		for(int i = 0; i < food[level-1].length; i++) {
			food[level-1][i].draw(g);
		}
		
		for(int i = 0; i < barrel[level-1].length; i++) {
			barrel[level-1][i].draw(g);
		}

		for(int i = 0; i < sign[level-1].length; i++) {
			sign[level-1][i].draw(g);
		}
		
//		food[0].draw(g);
//		System.out.println(food[0].filename);
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
		
		g.setFont(customFont);
		g.drawString(scoreMessage + "/" + 40, 50, 90);
		g.setFont(customFontSub);
		g.drawString("Level "+ level, 50, 126);
		g.drawString(speedMessage, 50, 156);
		g.drawString("Lives: " + lives, 50, 186);
		
		if(r[level-1][7].overlaps(y)) { 
		    complete.draw(g);
		    g.setColor(Color.WHITE);
		    g.setFont(customFont);
		    score[level] = 0;
		    g.drawString("MOST FOODS EATEN: " + totalFoods, 50, 90);
		    g.setFont(customFontSub);
		    g.drawString("Level "+ (level), 50, 126);
		    g.drawString(speedMessage, 50, 156);
		    g.drawString("Lives: " + lives, 50, 186);
		}
		
		if(lives < 1) {
			gameover.draw(g);
		}
		
		if(outputOnce) {
//			System.out.println(new File("bin/PixelifySans-Regular.ttf").getAbsolutePath());
			bcMultiple[0].setPosition(-970, -9550);
			bcMultiple[1].setPosition(-970, -9550);
			outputOnce = false;
		}
		
		
	}
	
	public void level2(Graphics g) {
		background2.draw(g);
		g.setColor(Color.YELLOW);
		
		
		for(int i = 0; i < wall[level-1].length; i++) {
			wall[level-1][i].draw(g);
		}
		
		for(int i = 0; i < wallTop[level-1].length; i++) {
			wallTop[level-1][i].draw(g);
		}
		
		for(int i = 0; i < r[level-1].length; i++) {
			//  r[i].draw(g);
		}
		
		for(int i = 0; i < food[level-1].length; i++) {
			food[level-1][i].draw(g);
		}
		
		for(int i = 0; i < barrel[level-1].length; i++) {
			barrel[level-1][i].draw(g);
		}
		for(int i = 0; i < nobstacle[level-1].length; i++) {
			nobstacle[level-1][i].draw(g);
		}
		for(int i = 0; i < sign[level-1].length; i++) {
			sign[level-1][i].draw(g);
		}
		
//		food[0].draw(g);
//		System.out.println(food[0].filename);
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
		
		g.setFont(customFont);
		g.drawString(scoreMessage + "/" + (food[level-1].length - 1), 50, 90);
		g.setFont(customFontSub);
		g.drawString("Level "+ level, 50, 126);
		g.drawString(speedMessage, 50, 156);
		g.drawString("Lives: " + lives, 50, 186);
		
		if(r[level-1][7].overlaps(y)) { 
		    complete.draw(g);
		    g.setColor(Color.WHITE);
		    g.setFont(customFont);
		    score[level] = 0;
		    g.drawString("MOST FOODS EATEN: " + (totalFoods-1), 50, 90);
		    g.setFont(customFontSub);
		    g.drawString("Level "+ (level), 50, 126);
		    g.drawString(speedMessage, 50, 156);
		    g.drawString("Lives: " + lives, 50, 186);
		}
		
		if(lives < 1) {
			gameover.draw(g);
		}
		
		if(outputOnce) {
//			System.out.println(new File("bin/PixelifySans-Regular.ttf").getAbsolutePath());
			bcMultiple[0].setPosition(-970, -9550);
			bcMultiple[1].setPosition(-970, -9550);
			outputOnce = false;
		}
	}
	
	public void level3(Graphics g) {
		background3.draw(g);
		g.setColor(Color.YELLOW);
		
		
		for(int i = 0; i < wall[level-1].length; i++) {
			wall[level-1][i].draw(g);
		}
		
		for(int i = 0; i < wallTop[level-1].length; i++) {
			wallTop[level-1][i].draw(g);
		}
		
		for(int i = 0; i < r[level-1].length; i++) {
			//  r[i].draw(g);
		}
		
		for(int i = 0; i < food[level-1].length; i++) {
			food[level-1][i].draw(g);
		}
		
		for(int i = 0; i < barrel[level-1].length; i++) {
			barrel[level-1][i].draw(g);
		}
		for(int i = 0; i < nobstacle[level-1].length; i++) {
			nobstacle[level-1][i].draw(g);
		}
		for(int i = 0; i < sign[level-1].length; i++) {
			sign[level-1][i].draw(g);
		}
		
//		food[0].draw(g);
//		System.out.println(food[0].filename);
		
		y.draw(g);
//		v.draw(g);
		bc.draw(g);
		
		for(int i = 0; i < bcMultiple.length; i++) {
			bcMultiple[i].draw(g);
		}
		
		g.setFont(customFont);
		g.drawString(scoreMessage + "/" + (food[level-1].length - 1), 50, 90);
		g.setFont(customFontSub);
		g.drawString("Level "+ level, 50, 126);
		g.drawString(speedMessage, 50, 156);	
		g.drawString("Lives: " + lives, 50, 186);
		
		if(r[level-1][7].overlaps(y)) { 
		    complete.draw(g);
		    g.setColor(Color.WHITE);
		    g.setFont(customFont);
		    score[level] = 0;
		    g.drawString("MOST FOODS EATEN: " + (totalFoods-2), 50, 90);
		    g.setFont(customFontSub);
		    g.drawString("Level "+ (level), 50, 126);
		    g.drawString(speedMessage, 50, 156);
		    g.drawString("Lives: " + lives, 50, 186);
		}
		
		if(lives < 1) {
			gameover.draw(g);
		}
		
		if(outputOnce) {
//			System.out.println(new File("bin/PixelifySans-Regular.ttf").getAbsolutePath());
			bc.setPosition(70, 550);
			bcMultiple[0].setPosition(70, 740);
			bcMultiple[1].setPosition(70, 400);
			outputOnce = false;
		}
	}
	
	public void thanks(Graphics g) {
		backgroundthanks.draw(g);
		
	}
	
	
	
	public void paint(Graphics g) {	
		title(g);
		if(gameStart) {
			switch(level) {
				
				case 1:
					level1(g);
	//				System.out.println("Level " + 1);
					break;
				case 2:
					level2(g);
	//				System.out.println("Level " + 2);
					break;
				case 3:
					level3(g);
	//				System.out.println("Level " + 3);
					break;
				case 4:
					thanks(g);
	//				System.out.println("Level " + 4);
					break;
			}
		}
		
		
		
	}	
}
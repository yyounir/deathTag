import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class GameS26 extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener
{		
	Image off_screen;
	Graphics off_screen_g;
	
	boolean pressing_UP = false;
	boolean pressing_DN = false;
	boolean pressing_LT = false;
	boolean pressing_RT = false;
	
	int mx;
	int my;
	
	
	Thread t;
	
	Animation animationUP = new Animation("y", "up");
	Animation animationDN = new Animation("y", "dn");
	Animation animationLT = new Animation("y", "lt");
	Animation animationRT = new Animation("y", "rt");
	
//	Sprite r = new Sprite("v", 100, 100, 100, 181);
	Sprite r = new Sprite("y", 100, 100, 100, 214);
	
	public void run()
	{
		while(true)
		{
			// Code that executes 60 times per second
			
			// Move User Controlled Objects
			if(pressing_UP) r.moveUP(5);
			if(pressing_DN) r.moveDN(5);
			if(pressing_LT) r.moveLT(5);
			if(pressing_RT) r.moveRT(5);
			
			// Move Computer Controlled Objects

			
			// Handle Collisions
			
			
			
			// Update the Screen
			
			repaint();
			
			try
			{
				Thread.sleep(16);
			}
			catch(Exception x) {};
		}

	}
	
	public void update(Graphics g) {
		off_screen_g.clearRect(0, 0, 1920, 1080);
		paint(off_screen_g);
		g.drawImage(off_screen, 0, 0, null);
	}
	
	public void paint(Graphics g) {	
		r.draw(g);
//		g.drawImage(animationUP.nextImage(), 100, 100, 100, 214, null);
//		g.drawImage(animationDN.nextImage(), 300, 100, 100, 214, null);
//		g.drawImage(animationLT.nextImage(), 500, 100, 100, 214, null);
//		g.drawImage(animationRT.nextImage(), 700, 100, 100, 214, null);
	}	
	
	public void init()
	{		
		off_screen = createImage(1920, 1080);
		off_screen_g = off_screen.getGraphics();
		
		requestFocus();
		
		addKeyListener(this);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		
		t = new Thread(this);
		
		t.start();
	}
	
	public void mouseMoved(MouseEvent e)
	{
		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX();
		int ny = e.getY();
		
		int w = nx - mx;
		int h = ny - my;
	}
	
	public void mousePressed(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
	}

	/*
	// This version allows you to pick one of the rectangles by pressing the mouse button
	// while the mouse is inside the rectangle
	 
	public void mousePressed(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
		
		for(int i = 0; i < r.length; i++)
		{
			if(r[i].contains(mx, my))   my_r = r[i];
		}
	}
	*/
	
	public void mouseReleased(MouseEvent e)
	{
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e)  {}
	
	

	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == e.VK_UP)      pressing_UP = true;
		if(code == e.VK_DOWN)    pressing_DN = true;
		if(code == e.VK_LEFT)    pressing_LT = true;
		if(code == e.VK_RIGHT)   pressing_RT = true;		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == e.VK_UP)      pressing_UP = false;
		if(code == e.VK_DOWN)    pressing_DN = false;
		if(code == e.VK_LEFT)    pressing_LT = false;
		if(code == e.VK_RIGHT)   pressing_RT = false;				
	}
	
	public void keyTyped(KeyEvent e)  {}
	
	
	

	
}
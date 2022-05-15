package airplane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.util.Random;
/**
 *
 * @author geff6
 */
public class Board extends JPanel{
	
	private Airplane airplane;
	private ArrayList missiles;
	private Timer timer;
	private int level = 1;
	private boolean inGame;
	
	

	public Board(){
		
	    setFocusable(true);
	    setBackground(Color.BLACK);
	    setDoubleBuffered(true);
	    setSize(600,400);
	    addKeyListener(new TAdapter());   
	    
	    inGame = true;
	    
	    airplane = new Airplane();
	    
	    initEnemys();
	    
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new ScheduleTask(), 100, 5);
	}
	
	
	public void initEnemys(){
		missiles = new ArrayList();
		 
		Random r = new Random();
		for (int i=0; i<level;i++){
			
			int n1 = 700;
			int n0 = 1000-n1;
			int x = r.nextInt(n0)+n1;
			
			int y =  (int)(Math.random()*400);
			missiles.add(new Missile(x,y));
		}
		level++;
	}

	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D)g;
		if(inGame){
			
			g2.drawImage(airplane.getImage(),airplane.getX(),airplane.getY(),this);
			for (int i = 0; i<missiles.size(); i++){
				Missile m = (Missile)missiles.get(i);
				if (m.isVisible()){
					g.drawImage(m.getImage(), m.getX(), m.getY(), this);
				}
			}
		
		} else{
					
			 String msg = "Game Over";
	            Font small = new Font("Helvetica", Font.BOLD, 14);
	            FontMetrics metr = this.getFontMetrics(small);

	            g.setColor(Color.white);
	            g.setFont(small);
	            g.drawString(msg, (600 - metr.stringWidth(msg)) / 2,
	                         400 / 2); 
	                         
	            
		}
	}

	public void checkCollision(){
		Rectangle rA = airplane.getBounds();
	
		
		for (int i = 0; i<missiles.size();i++){
			Missile m = (Missile)missiles.get(i);
			
			Rectangle rM = m.getBounds();
			if (rA.intersects(rM)){
				inGame = false;
			}
			
		}
		
				
	}
	
	public class ScheduleTask extends TimerTask{
		@Override
		public void run() {
			airplane.move();
			
			for (int i = 0; i<missiles.size();i++){
				Missile m = (Missile)missiles.get(i);
				m.move();
				if (m.getX() <10){
					m.setVisible(false);
					missiles.remove(i);
				}
			}
			if (missiles.size() == 0){
			    initEnemys();
			}
			checkCollision();
			repaint();	
		}
	}

	
	
	private class TAdapter extends KeyAdapter {
		public void keyReleased(KeyEvent e){
			airplane.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_SPACE){
				inGame = true;
				level = 1;
				initEnemys();
			}
            airplane.keyPressed(e);
        }
	
		
	}
	
	
    
}


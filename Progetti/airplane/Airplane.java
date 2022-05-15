package airplane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
 *
 * @author geff6
 */
public class Airplane {
private String airplaneImage = "airplane.png";
	
	private Image image;
	private boolean visible;
	private int x;
	private int y;
	private int dy;
	private int width, height;
	
	public Airplane(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(airplaneImage));
		image = ii.getImage();
		x = 40;
		y = 60;
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void move(){
		
		y+=dy;
		
		if (y<1){
			y = 1;
		} 
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP){
			dy = -1;
		}
		
		if (key == KeyEvent.VK_DOWN){
			dy = 1;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP){
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN){
			dy = 0;
		}
	}
    
}

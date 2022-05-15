/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
 *
 * @author geff6
 */
public class Missile {
    private Image image;
	private String missileImage = "missile.png";
	private boolean visible;
	private int x;
	private int y;
	private int width,height;
	
	public Missile(int x,int y){
		ImageIcon ii = new ImageIcon(this.getClass().getResource(missileImage));
		image = ii.getImage();
		this.x = x;
		this.y = y;
		width = image.getWidth(null);
		height = image.getHeight(null);
		setVisible(true);
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
	
	public boolean isVisible(){
		return visible;
	}
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public void move(){
		x-=1;
	}
	
}

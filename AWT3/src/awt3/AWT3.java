/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt3;
import java.awt.*;
/**
 *
 * @author Utente
 */
public class AWT3 {

    
    
    public static void main(String[] args) {
        
        Frame f=new Frame();
        f.setLayout(new BorderLayout());
        f.setLocation(100,100);
        
        f.add("North",new Button("North"));
        f.add("West",new Button("West"));
        f.add("South",new Button("South"));
        f.add("Center",new Button("Center"));
        f.add("East",new Button("East"));
        f.pack();
        f.setVisible(true);
        
    }
    
}

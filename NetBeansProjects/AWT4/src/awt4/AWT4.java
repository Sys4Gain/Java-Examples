/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt4;
import java.awt.*;
/**
 *
 * @author Utente
 */
public class AWT4 {

    
    
    public static void main(String[] args) {
        
        Panel p=new Panel(new GridLayout(2,2));
        p.add(new TextField("1"));
        p.add(new TextField("2"));
        p.add(new TextField("3"));
        
        Frame f=new Frame();
        f.setLayout(new BorderLayout());
        f.setLocation(100,100);
        
        f.add("North",new Button("North"));
        f.add("West",new Button("West"));
        f.add("South",new Button("South"));
        f.add("Center",p);
        f.add("East",new Button("East"));
        f.pack();
        f.setVisible(true);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt1;
import java.awt.*;
/**
 *
 * @author Utente
 */
public class AWT1 {
    
    public static void main(String[] args) {
        
        Frame f=new Frame();
        f.setLayout(new FlowLayout());
        f.setLocation(100,100);
        
        f.add(new Button("Button 1"));
        f.add(new Button("Button 2"));
        f.add(new TextField("Casella di testo"));
        f.pack();
        f.setVisible(true);
        
    }
    
}

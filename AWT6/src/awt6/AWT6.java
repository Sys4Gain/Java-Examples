/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt6;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Utente
 */
public class AWT6 {

    
    
    public static void main(String[] args) {
        
        Frame f=new Frame();
        f.setLayout(new FlowLayout());
        f.setLocation(100,100);
        
        MyActionListener a=new MyActionListener();
        Button b=new Button("Clickami");
        b.addActionListener(a);
        
        f.add(b);
        
        f.pack();
        f.setVisible(true);
    }
    
}

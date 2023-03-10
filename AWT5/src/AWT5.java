/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt5;
import java.awt.*;
/**
 *
 * @author Utente
 */
public class AWT5 {

    
    
    public static void main(String[] args) {
        
        Choice c=new Choice();
        c.addItem("Scelta 1");
        c.addItem("Scelta 2");
        c.addItem("Scelta 3");
        
        TextArea ta=new TextArea(5,20);
        TextField tf=new TextField();
        
        Label lb=new Label("Questa e' una label");
        
        Frame f=new Frame("Alcuni esempi");
        f.setLayout(new GridLayout(2,2));
        f.setLocation(100,100);
        
        f.add(lb);
        f.add(c);
        f.add(ta);
        f.add(tf);
        
        f.pack();
        f.setVisible(true);
        
    }
    
}

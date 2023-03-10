/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiffTempoGrafica;
import java.time.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Utente
 */
public class DateUtilsGrafica extends JFrame{

    JFrame f=new JFrame();
    Container c=f.getContentPane();
    JButton bottone;
    JLabel inserire,primaData,secondaData,confronto;
    JTextField ggmmyyyy;
    JPanel p;
    
    public DateUtilsGrafica(){
        
        p=new JPanel(new GridLayout(3,3,25,25));
        bottone=new JButton("Calcola");
        inserire=new JLabel("Inserisci le date");
        ggmmyyyy=new JTextField();
        primaData=new JLabel("");
        secondaData=new JLabel("");
        confronto=new JLabel("");
        p.add(inserire);
        p.add(primaData);
        p.add(ggmmyyyy);
        p.add(secondaData);
        p.add(bottone);
        p.add(confronto);
        c.add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(p);
        setSize(700,300);
        setLocation(600,350);
        setVisible(true);
        
    /*@Override
        public void actionPerformed(ActionEvent e){
            
        }*/
        
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        
        DateUtilsGrafica a=new DateUtilsGrafica();
        
    }
    
}

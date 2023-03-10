/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data2;
import java.util.Date;
import java.text.*;
import java.util.Locale;
/**
 *
 * @author Utente
 */
public class Data2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String s;
        Locale loca=Locale.ITALY;
        DateFormat formatter=new SimpleDateFormat("HH:mm:ss");
        s=formatter.format(new Date());
        System.out.println(s);
        s=DateFormat.getTimeInstance(DateFormat.MEDIUM, loca).format(new Date());
        System.out.println(s);
        
    }
    
}

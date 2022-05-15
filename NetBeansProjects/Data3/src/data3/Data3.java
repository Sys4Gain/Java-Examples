/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data3;
import java.util.Date;
import java.text.*;
import java.util.Locale;
/**
 *
 * @author Utente
 */
public class Data3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locale locale=Locale.ITALY;
        DateFormat formatter=DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        String s=formatter.format(new Date());
        System.out.println(s);
        s=DateFormat.getTimeInstance(DateFormat.LONG, locale).format(new Date());
        System.out.println(s);
        
    }
    
}

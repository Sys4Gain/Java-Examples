/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data1;
import java.util.Date;
import java.text.*;
/**
 *
 * @author Utente
 */
public class Data1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(df.format(date));
        
    }
    
}

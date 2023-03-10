/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es13;
import static java.lang.Math.sqrt;
import java.util.Scanner;
/**
 *
 * @author leona
 */
public class Es13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Scrivi un numero intero");
        int a=in.nextInt();
        System.out.println("La sua radice quadrata e':");
        System.out.println(sqrt(a));
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es3;

import java.util.Scanner;

/**
 *
 * @author leona
 */
public class Es3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Scrivi un numero");
        int a=in.nextInt();
        System.out.println("Questa e' la sua tabellina");
        
        for(int i=1;i<=10;i++){
            int risultato=a*i;
            System.out.println(risultato+"  -- "+i);
        }
    }
    
}

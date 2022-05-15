/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es6;

/**
 *
 * @author leona
 */
public class Es6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String a="123456";
        String b="654321";
        String c,d;
        
        for(int i=1;i<=6;i++){
            c=a.substring(0, i);
            d=b.substring(i-1);
            System.out.println(c+"   "+d);
        }
    }
    
}

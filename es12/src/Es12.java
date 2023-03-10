/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es12;

import java.util.Random;

/**
 *
 * @author leona
 */
public class Es12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        
        int[] array=new int[10];
        
        for(int i=0;i<array.length;i++){
            int a=r.nextInt(41)-20;
            array[i]=a;
            System.out.println(array[i]);
        }
    }
    
}

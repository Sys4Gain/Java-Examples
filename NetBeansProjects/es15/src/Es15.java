/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es15;

/**
 *
 * @author leona
 */
public class Es15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array={1,6,9,54,2,23,12,18};
        int a;
        int b=0;
        int conta=0;
        
        for(int i=0;i<array.length;i++){
            
            a=array[i];
            
            if(a>b){
                conta=i;
                b=a;   
            }
        }
        System.out.println("L'indice del numero piu' grande e' "+conta);
    }
}



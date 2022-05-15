/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es17;

/**
 *
 * @author leona
 */
public class Es17{
    
    static boolean isCrescente(int []array){
        int a=0;
        boolean b=false;
        
        for(int i=0;i<array.length;i++){
            
            if(array[i]>a){
                a=array[i];
                b=true;
            }
            else{
                b=false;
            }
            
        }
        
        System.out.println(b);
        return b;
    }
    
    public static void main(String[] args) {
        
        int[] array={2,6,8,4,3,67,0,3};
        int[] array2={1,2,3,4,5,6,7,8,9};
        
        isCrescente(array);
        isCrescente(array2);
        
    }
    
}

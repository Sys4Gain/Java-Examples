/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es16;

/**
 *
 * @author leona
 */
public class Es16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array={2,6,3,8,45,12,34,84};
        int a=45;
        boolean b=false;
        
        for(int i=0;i<array.length;i++){
            if(array[i]==a){
                b=true;
                break;
            }
            else{
                b=false;
            }
        }
        System.out.println(b);
        
    }
    
}

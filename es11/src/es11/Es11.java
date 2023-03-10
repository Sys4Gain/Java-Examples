/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es11;

import java.util.Random;

/**
 *
 * @author leona
 */
public class Es11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        
        int a=1;
	int b=3;
		
	while(a%b!=0){
			
	a=r.nextInt(15)+1;
	System.out.println(a);
			
			
			
        }
	System.out.println(a+" e' divisibile per 3.");
            
        
    }
    
}

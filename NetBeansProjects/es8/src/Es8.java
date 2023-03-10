/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es8;

import java.util.Scanner;

/**
 *
 * @author leona
 */
public class Es8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        
        char g1,g2;
        
        System.out.println("Turno di g1:");
        System.out.println("s = sasso");
        System.out.println("c = carta");
        System.out.println("f = forbice");
        g1=s.next().charAt(0);
        
        System.out.println("-------------------");
        
        System.out.println("Turno di g2:");
        g2=s.next().charAt(0);
        
        System.out.println("-------------------");
        
        if(g1=='s' && g2=='c'){
            System.out.println("g2 vince!");
        }
        
        else if(g1=='s' && g2=='f'){
            System.out.println("g1 vince!");
        }
        
        else if(g1=='c' && g2=='s'){
            System.out.println("g1 vince!");
        }
        
        else if(g1=='c' && g2=='f'){
            System.out.println("g2 vince!");
        }
        
        else if(g1=='f' && g2=='s'){
            System.out.println("g2 vince!");
        }
        
        else if(g1=='f' && g2=='c'){
            System.out.println("g1 vince!");
        }
        
        else{
            System.out.println("Pareggio");
        }
    }
    
}

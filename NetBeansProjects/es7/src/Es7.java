/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es7;
import java.util.Random;
/**
 *
 * @author leona
 */
public class Es7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Random r=new Random();
        
        int scritto,pratico,somma;
        
        scritto=r.nextInt(17)-8;
        pratico=r.nextInt(24);
        somma=(scritto+pratico);
        
        if(scritto<=0 && somma>18){
            System.out.println("Sei stato bocciato");
        }
        
        else if(scritto<=0 && pratico<18){
            System.out.println("Sei stato bocciato");
        }
        
        else if(scritto>0 && somma<18){
            System.out.println("Sei stato bocciato");
        }
        
        else if(somma==31 || somma==32){
            System.out.println("Congratulazioni! 30 e lode");
        }
        
        else{
            System.out.println("Sei stato promosso");
            System.out.println("Voto scritto="+scritto);
            System.out.println("Voto pratico="+pratico);
            System.out.println("Somma voti="+somma);
        }
    }
    
}

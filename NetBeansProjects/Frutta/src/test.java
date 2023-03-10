/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frutta;

/**
 *
 * @author Utente
 */
public class test {
    
    public static void main(String[] args){
        Cesto<Mela> cestoDiMele=new Cesto<>();
        for(int i=0;i<=20;i++){
            try{
                Mela mela=new Mela(100);
                cestoDiMele.aggiungiFrutta(mela);
            } catch(PesoException exc){
                System.out.println(exc.getMessage());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frutta;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Utente
 */
public class Cesto<F extends Frutta>{
    
    private ArrayList<F> frutta;
    
    public Cesto(){
        frutta=new ArrayList<>();
    }
    
    public ArrayList<F> getFrutta(){
        return frutta;
    }
    
    public void aggiungiFrutta(F frutto) throws PesoException{
        final int nuovoPeso=getPeso()+frutto.getPeso();
        if(nuovoPeso>2000){
            throw new PesoException("Troppo peso: "+nuovoPeso+" grammi!");
        }
        frutta.add(frutto);
        System.out.println(frutto.getClass().getName()+" da "+frutto.getPeso()+" grammi aggiunta alla cesta");
    }
    
    public int getPeso(){
        int peso=0;
        for(F frutto:frutta){
            peso=+frutto.getPeso();
        }
        return peso;
    }
}

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
public abstract class Frutta {
    
    private int peso;
    
    public Frutta(int peso){
        this.peso=peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}

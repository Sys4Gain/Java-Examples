/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testuniversita;

/**
 *
 * @author Utente
 */
public class Persona {
    
    private String nome;
    private int eta;
    
    public Persona(String nome,int eta){
        this.nome=nome;
        this.eta=eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
    
    
}

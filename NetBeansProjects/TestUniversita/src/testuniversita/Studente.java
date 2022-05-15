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
public class Studente extends Persona{
    
    private int numeroMatricola;
    private String corsoLaurea;
    
    public Studente(String nome,int eta,int numeroMatricola,String corsoLaurea){
        super(nome,eta);
        this.corsoLaurea=corsoLaurea;
        this.numeroMatricola=numeroMatricola;
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }

    public String getCorsoLaurea() {
        return corsoLaurea;
    }

    public void setNumeroMatricola(int numeroMatricola) {
        this.numeroMatricola = numeroMatricola;
    }

    public void setCorsoLaurea(String corsoLaurea) {
        this.corsoLaurea = corsoLaurea;
    }
    
    
    
}

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
public class Docente extends Persona{
    
    private String materia;
    
    public Docente(String nome,int eta,String materia){
        super(nome,eta);
        this.materia=materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
}

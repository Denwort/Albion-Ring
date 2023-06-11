/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Clase;

import java.util.Random;

/**
 *
 * @author FIVILAN
 */
public class Enemigo{

    private int Fuerza, Suerte, Esquivar, Vida, Dificultad;
    
    //Constructor
    public Enemigo(int Dificultad){
        this.Dificultad = Dificultad;
        Vida = 5;
    }
    
    //Metodos
    public void Establecer() {
        int random;
        
        Random rand = new Random();
        
        random = rand.nextInt(5-0+1)+0;
        this.Fuerza = random + random*Dificultad;
        random = rand.nextInt(5-0+1)+0;
        this.Suerte = random + random*Dificultad;
        random = rand.nextInt(5-0+1)+0;
        this.Esquivar = random + random*Dificultad;
    }

    
    
    //Getters and Setters
    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int Fuerza) {
        this.Fuerza = Fuerza;
    }

    public int getSuerte() {
        return Suerte;
    }

    public void setSuerte(int Suerte) {
        this.Suerte = Suerte;
    }

    public int getEsquivar() {
        return Esquivar;
    }

    public void setEsquivar(int Esquivar) {
        this.Esquivar = Esquivar;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getDificultad() {
        return Dificultad;
    }

    public void setDificultad(int Dificultad) {
        this.Dificultad = Dificultad;
    }
}

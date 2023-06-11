/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Clase;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author FIVILAN
 */
public abstract class Personaje{
    
    protected String Nombre, itemEquipado;
    protected Boolean[] items;
    protected int Fuerza, Suerte, Esquivar, Vida,Monedas;
    protected ArrayList<Enemigo> enemigo;
    
    //Constructor
    public Personaje(String Nombre, int Fuerza, int Suerte, int Esquivar) {
        this.Esquivar = Esquivar;
        this.Fuerza = Fuerza;
        this.Suerte = Suerte;
        this.Nombre = Nombre;
        this.Monedas = 2;
        Vida = 5;
        items = new Boolean[] {false, false, false};
        enemigo = new ArrayList<Enemigo>();
    }
    
    
    //Metodos
    public abstract void Mejorar();
    
    public void Equipar()
    {
        int random;
        Random rand = new Random();
        
        random = rand.nextInt(3);
        items[random] = true;
        
        if(items[0] == true)
        {
            itemEquipado = "Escudo";
        }
        else if(items[1] == true)
        {
            itemEquipado = "Espada";
        }
        else if(items[2] == true)
        {
            itemEquipado = "Bolza";
        }
    }
    
    public void Adicionar(Enemigo obj)
    {
        this.enemigo.add(obj);
    }
    
    //Getters and Setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getMonedas() {
        return Monedas;
    }

    public void setMonedas(int Monedas) {
        this.Monedas = Monedas;
    }

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

    public Boolean[] getItems() {
        return items;
    }

    public void setItems(Boolean[] items) {
        this.items = items;
    }

    public String getItemEquipado() {
        return itemEquipado;
    }

    public void setItemEquipado(String itemEquipado) {
        this.itemEquipado = itemEquipado;
    }

    public ArrayList<Enemigo> getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(ArrayList<Enemigo> enemigo) {
        this.enemigo = enemigo;
    }

    
}

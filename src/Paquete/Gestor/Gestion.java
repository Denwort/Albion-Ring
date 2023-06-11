/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Gestor;

import Paquete.Clase.Personaje;
import javax.swing.JOptionPane;

/**
 *
 * @author FIVILAN
 */
public class Gestion {
    private Personaje[] arreglo;
    private int contador;
    
    //Constructor
    public Gestion() {
        arreglo = new Personaje[5];
        contador = 0;
    }
    
    //Metodos
    public void Ingresar(Personaje ref)
    {
        try{
            arreglo[contador] = ref;
            contador++;
        }
        catch(ArrayIndexOutOfBoundsException es){
            JOptionPane.showMessageDialog(null, "NO HAY ESPACIO, TAMAÑO MAXIMO ES: "
                    + es.getMessage());
        }
    }
    
    public void EliminarPersonaje(int cont)
    {
        for(int i=0;i<contador;i++) {
            if(i == cont) {  
                for(int j=i; j<contador-1;j++) {
                    arreglo[j]=arreglo[j+1];
                }
                arreglo[contador-1]=null;
                contador--;
            }
        }
    }
    
    
    //Getters and Setters   

    public Personaje[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Personaje[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}

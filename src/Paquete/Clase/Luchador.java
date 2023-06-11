/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Clase;

import Paquete.Constante.PorcentFuerza;
import Paquete.Constante.PorcentSuerte;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author FIVILAN
 */
public class Luchador extends Personaje implements PorcentFuerza, PorcentSuerte
{
    //Constructor
    public Luchador(String Nombre, int Fuerza, int Suerte, int Esquivar ) {
        super(Nombre, Fuerza, Suerte, Esquivar);
        this.Fuerza = Fuerza + 3;
        this.Suerte = Suerte + 1;
        this.Esquivar = Esquivar + 1;
    }

    //Metodos
    @Override
    public void Mejorar() {
        int random;
        Random rand = new Random();
        
        try {
            for (int i = 0; i < 4; i++) {
                random = rand.nextInt(100 - 1 + 1) + 1;

                if (random <= DEFAULTFUERZA && Fuerza < 20) {
                    Fuerza += 1;
                }
                else if (random <= (DEFAULTSUERTE + DEFAULTFUERZA) && Suerte < 20) {
                    Suerte += 1;
                }
                else if (random <= 100 && Esquivar < 20) {
                    Esquivar += 1;
                }
                else {
                    if (Fuerza == 20 && Suerte == 20 && Esquivar == 20) {
                        JOptionPane.showMessageDialog(null, "LLEGO AL TOPE DE LAS ESTADISTICAS");
                        break;
                    }
                    i--;
                }
            }
        }
        finally {
            JOptionPane.showMessageDialog(null, "RECUERDE QUE LAS ESTADISTACAS MAXIMAS ES DE 20");
        }
    }
}

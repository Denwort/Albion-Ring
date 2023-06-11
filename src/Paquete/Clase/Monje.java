/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Clase;

import Paquete.Constante.PorcentEsquivar;
import Paquete.Constante.PorcentSuerte;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author FIVILAN
 */
public class Monje extends Personaje implements PorcentEsquivar, PorcentSuerte
{

    public Monje(String Nombre, int Fuerza, int Suerte, int Esquivar) {
        super(Nombre, Fuerza, Suerte, Esquivar);
        this.Esquivar = Esquivar += 1;
        this.Fuerza = Fuerza += 1;
        this.Suerte = Suerte += 3;
    }

    @Override
    public void Mejorar() {
        int random;
        Random rand = new Random();
        
        try {
            for (int i = 0; i < 4; i++) {
                random = rand.nextInt(100 - 1 + 1) + 1;

                if (random <= DEFAULTESQUIVAR && Suerte < 20) {
                    Suerte += 1;
                }
                else if (random <= (DEFAULTSUERTE + DEFAULTESQUIVAR) && Esquivar < 20) {
                    Esquivar += 1;
                }
                else if (random <= 100 && Fuerza < 20) {
                    Fuerza += 1;
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

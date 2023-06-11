/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Grafica;

import Paquete.Clase.Enemigo;
import Paquete.Clase.Personaje;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author FIVILAN
 */
public class Lucha extends javax.swing.JFrame {
    
    FondoImagen fondo = new FondoImagen();
    private Personaje player;
    private Menu menu;
    private Enemigo enemy;
    
    //Utilizado una vez
    private int dificultad;
    private int flechasPlayer, flechasEnemy;
    
    //Designa la poscion
    private final int ATACAR = 0;
    private final int RECARGAR = 1;
    private final int DEFENDER = 2;
    
    
    //Constructor
    public Lucha(Personaje ref, int dificultad) {
        
        this.setContentPane(fondo);
        this.setResizable(false);
        
        this.player = ref;
        this.dificultad = dificultad;
        
        this.enemy = new Enemigo(dificultad);
        this.enemy.Establecer();
        player.Adicionar(this.enemy);
        initComponents();
        
        ActualizarInfoFlechas();
        ActualizarInfoEnemigo();
        ActualizarInfoPlayer();
        
    }
    
    public Menu getMenu() {
        return menu;}

    public void setMenu(Menu menu) {
        this.menu = menu;}
    
    
    // ACTUALIZA INFO -----------------------------------------
    
    private void ActualizarInfoEnemigo()
    {
        this.EnemigoFuerza.setText("Fuerza: " + String.valueOf(enemy.getFuerza()));
        this.EnemigoSuerte.setText("Suerte: " + String.valueOf(enemy.getSuerte()));
        this.EnemigoEsquivar.setText("Esquivar: " + String.valueOf(enemy.getEsquivar()));
        this.EnemigoVida.setText("Vida: " + String.valueOf(enemy.getVida()));
    }
    
    private void ActualizarInfoPlayer() 
    {
        this.JugadorFuerza.setText("Fuerza: " + String.valueOf(player.getFuerza()));
        this.JugadorSuerte.setText("Suerte: " + String.valueOf(player.getSuerte()));
        this.JugadorEsquivar.setText("Esquivar: " + String.valueOf(player.getEsquivar()));
        this.JugadorVida.setText("Vida: " + String.valueOf(player.getVida()));
    }
    
    private void ActualizarInfoFlechas()
    {
        this.jLabelMisFlechas.setText(String.valueOf(this.flechasPlayer));
        this.jLabelSusFlechas.setText(String.valueOf(this.flechasEnemy));
    }
    
    // VUELVE MENU ------------------------------------------------------------
    
    private void VolverMenu()
    {
        player.setVida(5);
        menu.setPlayer(player);
        menu.setVisible(true);
        this.dispose();
    }
    
    
    // METODOS AUXILIARES -----------------------
    // Devuelve 0:atacar ; 1:recargar ; 2:defender
    private int GenerarDecisionEnemigo()
    {
        Random rnd = new Random();
        int aleat;

        if(this.flechasEnemy > 0){
            aleat = rnd.nextInt(2 - 0 + 1) + 0;
        }
        else{
            // Sin balas, solo puede recargar o defender
            aleat = rnd.nextInt(2 - 1 + 1) + 1;
        }
        
        return aleat;
    }
    
    // Devuelve el aleatorio para comparar si realiza una accion especial
    private boolean CalcularProbabilidad(int stat)
    {
        int maximo = 20;
        Random rnd = new Random();
        
        int aleat = rnd.nextInt(maximo - 0 + 1) + 0;
        
        if (stat > aleat){
            return true;
        }
        return false;
    }
    
    // Cuando el enmigo muere hay cambios en la estidista del personaje
    private void VerificarMuerte(Enemigo enemy)
    {
        if (enemy.getVida() <= 0 )
        {
            JOptionPane.showMessageDialog(null, "GANASTE: MEJORO TU PERSONAJE Y RECIBISTE UNA MONEDA");
            
            //CAMBIOS DE LA ESTADISTICA
            player.Mejorar();
            player.setMonedas(player.getMonedas() + 1);
            menu.setPlayer(player);
            
            this.VolverMenu();
        }
    }
    
    // Cuando el personaje muere no tiene cambios sus estadisticas
    private void VerificarMuerte(Personaje player)
    {
        if (player.getVida() <= 0 )
        {
            JOptionPane.showMessageDialog(null, "PERDISTE");
            this.VolverMenu();
        }
    }

//--------------------------------------------------------------------------------------------//
    // METODOS DE ATAQUE; RECARGA; DEFENSA ---------------------------------------------------//
    
        //METODOS DEL PERSONAJE
    
    private void RealizarAtaque(Personaje player, boolean attack)
    {
        if(attack){
            this.flechasPlayer -= 1;
        
            boolean atacaDoble = CalcularProbabilidad(player.getFuerza());
        
            // si ataca doble, baja 2 de vida; sino, baja 1 de vida
            if(atacaDoble){
                enemy.setVida(enemy.getVida() - 2);
                this.AnuncioPlayer.setText("PLAYER ATACA SPECIAL 'doble daño'");
            }
            else{
                enemy.setVida(enemy.getVida() - 1);
                this.AnuncioPlayer.setText("PLAYER ATACA");
            }
        
            VerificarMuerte(enemy);
        }
    }
    
    
    private void RealizarRecarga(Personaje player){
        this.flechasPlayer += 1;
        boolean recargaDoble = CalcularProbabilidad(player.getSuerte());
        
        // Si recarga doble, recarga 2 balas en vez de 1
        if (recargaDoble){
            this.flechasPlayer += 1;
            this.AnuncioPlayer.setText("PLAYER RECARGA SPECIAL 'recarga doble'");
        }
        else{
            this.AnuncioPlayer.setText("PLAYER RECARGA");
        }
    }
    
    
    private void RealizarDefensa(Personaje player, boolean defensaExitosa){
        boolean seCura = CalcularProbabilidad(player.getEsquivar());
        
        //Saber si el enemigo realizo un ataque
        if(defensaExitosa){
            this.AnuncioEnemy.setText("ENEMIGO FALLO ATAQUE");
            this.flechasEnemy -=1;
            
            //Saber si el jugador recupera vida
            if(seCura) {
                this.player.setVida(this.player.getVida() + 1);
                this.AnuncioPlayer.setText("JUGADOR DEFIENDE SPECIAL (se cura)");
            }
            else{
                this.AnuncioPlayer.setText("JUGADOR DEFIENDE");
            } 
        }
        
        //El enemigo no hizo un ataque
        else{
            this.AnuncioPlayer.setText("JUGADOR DEFIENDE");
        }
    }
    
//--------------------------------------------------------------------------------------------//
        //METODOS DEL ENEMIGO
    
    private void RealizarAtaqueEnemigo(Enemigo enemy){
        this.flechasEnemy -= 1;
        boolean atacaDoble = CalcularProbabilidad(enemy.getFuerza());
        
        // si ataca doble, baja 2 de vida; sino, baja 1 de vida
        if (atacaDoble){
            player.setVida(player.getVida() - 2);
            this.AnuncioEnemy.setText("ENEMIGO ATACA SPECIAL (doble daño)");
        }
        else{
            player.setVida(player.getVida() - 1);
            this.AnuncioEnemy.setText("ENEMIGO ATACA");
        }
        
        VerificarMuerte(player);
    }
    
    
    private void RealizarRecargaEnemigo(Enemigo enemy){
        this.flechasEnemy += 1;
        boolean recargaDoble = CalcularProbabilidad(enemy.getSuerte());
        
        // Si recarga doble, recarga 2 balas en vez de 1
        if (recargaDoble){
            this.flechasEnemy += 1;
            this.AnuncioEnemy.setText("ENEMIGO RECARGA SPECIAL (recarga doble)");
        }
        else{
            this.AnuncioEnemy.setText("ENEMIGO RECARGA");
        }
    }
    
    
    private void RealizarDefensaEnemigo(Enemigo enemy, boolean defensaExitosa){
        if (defensaExitosa){
            this.AnuncioPlayer.setText("JUGADOR FALLO ATAQUE");
            if(this.flechasPlayer >= 0){
            this.flechasPlayer -= 1;
            }
            
            boolean seCura = CalcularProbabilidad(enemy.getEsquivar());
            
            if(seCura){
                this.enemy.setVida(this.enemy.getVida() + 1);
                this.AnuncioEnemy.setText("ENEMIGO DEFIENDE SPECIAL (se cura)");
            }
            else{
                this.AnuncioEnemy.setText("ENEMIGO DEFIENDE");
            }
        } 
        else{
            this.AnuncioEnemy.setText("ENEMIGO DEFIENDE");
        }
    }
    
    
//---------------------------------------------------------------------------------------------//
    
    
    //Parte que realiza automaticamente el NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Atacar = new javax.swing.JButton();
        Defender = new javax.swing.JButton();
        Recargar = new javax.swing.JButton();
        Rendirse = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ApartadoEnemigo = new javax.swing.JLabel();
        EnemigoFuerza = new javax.swing.JLabel();
        EnemigoSuerte = new javax.swing.JLabel();
        EnemigoEsquivar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ApartadoPersonaje = new javax.swing.JLabel();
        JugadorFuerza = new javax.swing.JLabel();
        JugadorSuerte = new javax.swing.JLabel();
        JugadorEsquivar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TextoFlechasEnemigo = new javax.swing.JLabel();
        jLabelSusFlechas = new javax.swing.JLabel();
        EnemigoVida = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TextoFlechasPersonaje = new javax.swing.JLabel();
        jLabelMisFlechas = new javax.swing.JLabel();
        JugadorVida = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        AnuncioEnemy = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        AnuncioPlayer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Atacar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Atacar.setText("Atacar");
        Atacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtacarActionPerformed(evt);
            }
        });

        Defender.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Defender.setText("Defender");
        Defender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefenderActionPerformed(evt);
            }
        });

        Recargar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Recargar.setText("Recargar");
        Recargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecargarActionPerformed(evt);
            }
        });

        Rendirse.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Rendirse.setText("Rendirse");
        Rendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RendirseActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        ApartadoEnemigo.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        ApartadoEnemigo.setText("Enemigo");

        EnemigoFuerza.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        EnemigoFuerza.setText("Fuerza");

        EnemigoSuerte.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        EnemigoSuerte.setText("Suerte");

        EnemigoEsquivar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        EnemigoEsquivar.setText("Esquivar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EnemigoEsquivar)
                    .addComponent(EnemigoSuerte)
                    .addComponent(EnemigoFuerza)
                    .addComponent(ApartadoEnemigo))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ApartadoEnemigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnemigoFuerza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnemigoSuerte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EnemigoEsquivar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        ApartadoPersonaje.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        ApartadoPersonaje.setText("Jugador");

        JugadorFuerza.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        JugadorFuerza.setText("Fuerza");

        JugadorSuerte.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        JugadorSuerte.setText("Suerte");

        JugadorEsquivar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        JugadorEsquivar.setText("Esquivar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ApartadoPersonaje)
                    .addComponent(JugadorFuerza)
                    .addComponent(JugadorSuerte)
                    .addComponent(JugadorEsquivar))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ApartadoPersonaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JugadorFuerza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JugadorSuerte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JugadorEsquivar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextoFlechasEnemigo.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        TextoFlechasEnemigo.setText("SusFlechas");

        jLabelSusFlechas.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabelSusFlechas.setText("Se Borra");

        EnemigoVida.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        EnemigoVida.setText("Vida");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoFlechasEnemigo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(EnemigoVida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSusFlechas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoFlechasEnemigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSusFlechas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(EnemigoVida)
                .addContainerGap())
        );

        TextoFlechasPersonaje.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        TextoFlechasPersonaje.setText("MisFlechas");

        jLabelMisFlechas.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabelMisFlechas.setText("Se Borra");

        JugadorVida.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        JugadorVida.setText("Vida");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoFlechasPersonaje)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(JugadorVida))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabelMisFlechas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoFlechasPersonaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMisFlechas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(JugadorVida)
                .addContainerGap())
        );

        AnuncioEnemy.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnuncioEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnuncioEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnuncioPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnuncioPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(Recargar))
                                .addComponent(Atacar)))
                        .addGap(79, 79, 79)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Defender)
                        .addGap(18, 18, 18)
                        .addComponent(Rendirse)
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Defender)
                        .addComponent(Rendirse))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Atacar)
                        .addComponent(Recargar)))
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
//--------------------------------------------------------------------------------------------//
    // 0:ATACAR  ; 1:RECARGAR ; 2:DEFENDER
    
    //Acciones que hacen los botones
    private void AtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtacarActionPerformed
        //Saber si ataca teniendo flechas
        boolean attack = true;
        
        // VERIFICAR QUE TENGA FLECHAS
        if (this.flechasPlayer < 1){
            JOptionPane.showMessageDialog(null, "TIENES QUE RECARGAR PARA ATACAR");
            attack = false;
            return;
        }

        // Enemigo toma su decision
        int enemigoDecision = GenerarDecisionEnemigo();
        
        // CASO ATAQUE - ATAQUE
        if(enemigoDecision == ATACAR){
            // Ambos se atacan mutuamente
            RealizarAtaqueEnemigo(enemy);
            RealizarAtaque(player, attack);
        }
        
        // CASO ATAQUE - RECARGAR
        else if (enemigoDecision == RECARGAR){
            RealizarRecargaEnemigo(enemy);
            RealizarAtaque(player, attack);
        }
        
        //CASO ATAQUE - DEFENSA
        else if (enemigoDecision == DEFENDER){
            // Fue defensa exitosa
            RealizarDefensaEnemigo(enemy, true);
        }
      
        // Actualiza la informacion
        this.ActualizarInfoFlechas();
        this.ActualizarInfoEnemigo();
        this.ActualizarInfoPlayer();
    }//GEN-LAST:event_AtacarActionPerformed

    
    private void DefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefenderActionPerformed
        // Enemigo toma su decision
        int enemigoDecision = this.GenerarDecisionEnemigo();

        // CASO DEFENDER - ATAQUE
        if(enemigoDecision == ATACAR){
            RealizarDefensa(player, true);
        }
        
        // CASO DEFENDER - RECARGAR
        else if (enemigoDecision == RECARGAR){
            RealizarDefensa(player, false);
            RealizarRecargaEnemigo(enemy);
        }
        
        //CASO DEFENDER - DEFENSA
        else if (enemigoDecision == DEFENDER){
            // No fue defensa exitosa
            RealizarDefensa(player, false);
            // No fue defensa exitosa
            RealizarDefensaEnemigo(enemy, false);
        }
      
        // Actualiza la informacion
        this.ActualizarInfoFlechas();
        this.ActualizarInfoEnemigo();
        this.ActualizarInfoPlayer();
    }//GEN-LAST:event_DefenderActionPerformed

    private void RecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecargarActionPerformed
        // Enemigo toma su decision
        int enemigoDecision = this.GenerarDecisionEnemigo();

        //Si o si recarga
        RealizarRecarga(player);
        
        // CASO RECARGAR - ATAQUE
        if(enemigoDecision == ATACAR){
            //Como no se defiende, recibe daño
            RealizarAtaqueEnemigo(enemy);
        }
        
        // CASO RECARGAR - RECARGAR
        else if (enemigoDecision == RECARGAR){
            RealizarRecargaEnemigo(enemy);
        }
        
        //CASO RECARGAR - DEFENSA
        else if (enemigoDecision == DEFENDER){
            // No fue defensa exitosa
            RealizarDefensaEnemigo(enemy, false);
        }
      
        // Actualiza la informacion
        this.ActualizarInfoFlechas();
        this.ActualizarInfoEnemigo();
        this.ActualizarInfoPlayer();
    }//GEN-LAST:event_RecargarActionPerformed

    // Simple, no hay cambios
    private void RendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RendirseActionPerformed
        this.VolverMenu();
    }//GEN-LAST:event_RendirseActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnuncioEnemy;
    private javax.swing.JLabel AnuncioPlayer;
    private javax.swing.JLabel ApartadoEnemigo;
    private javax.swing.JLabel ApartadoPersonaje;
    private javax.swing.JButton Atacar;
    private javax.swing.JButton Defender;
    private javax.swing.JLabel EnemigoEsquivar;
    private javax.swing.JLabel EnemigoFuerza;
    private javax.swing.JLabel EnemigoSuerte;
    private javax.swing.JLabel EnemigoVida;
    private javax.swing.JLabel JugadorEsquivar;
    private javax.swing.JLabel JugadorFuerza;
    private javax.swing.JLabel JugadorSuerte;
    private javax.swing.JLabel JugadorVida;
    private javax.swing.JButton Recargar;
    private javax.swing.JButton Rendirse;
    private javax.swing.JLabel TextoFlechasEnemigo;
    private javax.swing.JLabel TextoFlechasPersonaje;
    private javax.swing.JLabel jLabelMisFlechas;
    private javax.swing.JLabel jLabelSusFlechas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables

    //Clase para poner fondo
    class FondoImagen extends JPanel {

        //Variables
        private Image imagen;
        
        //Metodos
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("FondoLucha.jpg")).getImage();
            g.drawImage(imagen, 0, 0, 800, 600, this);
            setOpaque(false);
            super.paint(g);
        }
    }
}

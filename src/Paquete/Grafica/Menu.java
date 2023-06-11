/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Grafica;

import Paquete.Clase.Personaje;
import Paquete.Gestor.Gestion;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author FIVILAN
 */
public class Menu extends javax.swing.JFrame { 
    
    FondoImagen fondo = new FondoImagen();
    private Personaje player;
    private CreadorPersonaje creador;
    private int dificultad;
    
    
    //Constructor
    public Menu(Personaje ref) {
        this.setContentPane(fondo);
        this.setResizable(false);
        
        this.player = ref;
        initComponents();
        ActualizarInfoPlayer();
    }

    public CreadorPersonaje getCreador() {
        return creador;}
    public void setCreador(CreadorPersonaje creador) {
        this.creador = creador;}

    public Personaje getPlayer() {
        return player;}
    public void setPlayer(Personaje player) {
        this.player = player;this.ActualizarInfoPlayer();}
    
    private void ActualizarInfoPlayer()
    {
        this.jLabel1.setText("Nombre: " + player.getNombre());
        this.jLabel2.setText("Fuerza: " + String.valueOf(player.getFuerza()));
        this.jLabel3.setText("Suerte: " + String.valueOf(player.getSuerte()));
        this.jLabel4.setText("Esquivar: " + String.valueOf(player.getEsquivar()));
        this.jLabel5.setText("Monedas: " + String.valueOf(player.getMonedas()));
    }
    
//---------------------------------------------------------------------------------------------//
    
    
    //Parte que realiza automaticamente el NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Luchar = new javax.swing.JButton();
        Comprar = new javax.swing.JButton();
        SeleccionarPersonaje = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Luchar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Luchar.setText("Luchar");
        Luchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LucharActionPerformed(evt);
            }
        });

        Comprar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Comprar.setText("Comprar");
        Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprarActionPerformed(evt);
            }
        });

        SeleccionarPersonaje.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        SeleccionarPersonaje.setText("Seleccionar Personaje");
        SeleccionarPersonaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarPersonajeActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Medio", "Dificil" }));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Paquete/Grafica/Personaje.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Luchar)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SeleccionarPersonaje))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(Comprar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Luchar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeleccionarPersonaje)
                    .addComponent(Comprar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Acciones que hacen los botones
    private void LucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LucharActionPerformed
        setVisible(false);
        dificultad = this.jComboBox1.getSelectedIndex(); // Facil: 0, Medio: 1, Dificil:2;
        Lucha pantallaLucha = new Lucha(player, dificultad);
        pantallaLucha.setMenu(this);
        pantallaLucha.setVisible(true);
    }//GEN-LAST:event_LucharActionPerformed

    private void ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprarActionPerformed
        setVisible(false);
        Tienda pantallaTienda = new Tienda(player);
        pantallaTienda.setMenu(this);
        pantallaTienda.setVisible(true);
    }//GEN-LAST:event_ComprarActionPerformed

    private void SeleccionarPersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarPersonajeActionPerformed
        this.dispose();
        Gestion aux = creador.getGestor();
        aux.getArreglo()[creador.getSelect()] = player;
        creador.setGestor(aux);
        creador.setVisible(true);
        
    }//GEN-LAST:event_SeleccionarPersonajeActionPerformed

    
    //Parte no modificable
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprar;
    private javax.swing.JButton Luchar;
    private javax.swing.JButton SeleccionarPersonaje;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    //Clase para poner fondo
    class FondoImagen extends JPanel {

        //Variables
        private Image imagen;
        
        //Metodos
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("FondoMenu.jpg")).getImage();
            g.drawImage(imagen, 0, 0, 800, 600, this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
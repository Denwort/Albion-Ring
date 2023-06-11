/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Grafica;

import Paquete.Clase.*;
import Paquete.Gestor.Gestion;
//Imports para que funciona el fondo de pantalla
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class CreadorPersonaje extends javax.swing.JFrame {

    FondoImagen fondo = new FondoImagen();
    private Gestion gestor;
    private DefaultTableModel modelo;
    private int select;
       
    
    //Constructor
    public CreadorPersonaje(){
        this.setContentPane(fondo);
        this.setResizable(false);
        initComponents();
        
        gestor = new Gestion();
        modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Rol");
        modelo.addColumn("Fueza");
        modelo.addColumn("Suerte");
        modelo.addColumn("Esquivar");
        modelo.addColumn("Monedas");
        modelo.addColumn("Item");
        this.TablaPersonaje.setModel(modelo);
    }
    
    
    //Metodos
    public void ActualizarTabla()
    {
        int filas = this.TablaPersonaje.getRowCount();
        for(int i = 0; i < filas; i++)
        {
            modelo.removeRow(0);
        }
        
        String[] datos = new String[7];
        Personaje[] arreglo = gestor.getArreglo();
        int contador = gestor.getContador();
        
        for(int i = 0; i < contador; i++)
        {
            
            datos[0] = arreglo[i].getNombre();
            
            if(arreglo[i] instanceof Luchador){
                datos[1] = "Luchador";
            }
            else if(arreglo[i] instanceof Monje){
                datos[1] = "Monje";
            } 
            else if(arreglo[i] instanceof Picaro){
                datos[1] = "Picaro";
            }
            
            datos[2] = String.valueOf(arreglo[i].getFuerza());
            datos[3] = String.valueOf(arreglo[i].getSuerte());
            datos[4] = String.valueOf(arreglo[i].getEsquivar());
            datos[5] = String.valueOf(arreglo[i].getMonedas());
            datos[6] = arreglo[i].getItemEquipado();
                        
            modelo.addRow(datos);
        }
    }
    
    public void RecargarTabla()
    {
        modelo.addRow(gestor.getArreglo());
    }

    
    
    //SETTERS Y GETTERS
    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public Gestion getGestor() {
        return gestor;
    }

    public void setGestor(Gestion gestor) {
        this.gestor = gestor;
        this.ActualizarTabla();
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    
    
    
//---------------------------------------------------------------------------------------------//
    
    
    //Parte que realiza automaticamente el NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Crear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPersonaje = new javax.swing.JTable();
        TextoNombre = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSliderFuerza = new javax.swing.JSlider();
        jSliderSuerte = new javax.swing.JSlider();
        jSliderEsquivar = new javax.swing.JSlider();
        Jugar = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(java.awt.Color.lightGray);
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("Clase");

        Crear.setBackground(new java.awt.Color(255, 255, 255));
        Crear.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });

        TablaPersonaje.setBackground(new java.awt.Color(204, 204, 204));
        TablaPersonaje.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        TablaPersonaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaPersonaje.setRowHeight(34);
        jScrollPane1.setViewportView(TablaPersonaje);

        TextoNombre.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luchador", "Monje", "Picaro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(java.awt.Color.lightGray);
        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setText("Fuerza");

        jLabel4.setBackground(java.awt.Color.lightGray);
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setText("Suerte");

        jLabel5.setBackground(java.awt.Color.lightGray);
        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setText("Esquivar");

        jSliderFuerza.setBackground(new java.awt.Color(255, 255, 255));
        jSliderFuerza.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jSliderFuerza.setMajorTickSpacing(1);
        jSliderFuerza.setMaximum(4);
        jSliderFuerza.setMinorTickSpacing(1);
        jSliderFuerza.setPaintLabels(true);
        jSliderFuerza.setValue(0);

        jSliderSuerte.setBackground(new java.awt.Color(255, 255, 255));
        jSliderSuerte.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jSliderSuerte.setMajorTickSpacing(1);
        jSliderSuerte.setMaximum(4);
        jSliderSuerte.setMinorTickSpacing(1);
        jSliderSuerte.setPaintLabels(true);
        jSliderSuerte.setValue(0);

        jSliderEsquivar.setBackground(new java.awt.Color(255, 255, 255));
        jSliderEsquivar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jSliderEsquivar.setMajorTickSpacing(1);
        jSliderEsquivar.setMaximum(4);
        jSliderEsquivar.setMinorTickSpacing(1);
        jSliderEsquivar.setPaintLabels(true);
        jSliderEsquivar.setValue(0);

        Jugar.setBackground(new java.awt.Color(255, 255, 255));
        Jugar.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Jugar.setText("Jugar");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(255, 255, 255));
        Delete.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(Crear)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSliderFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextoNombre)
                    .addComponent(jSliderSuerte, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSliderEsquivar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jugar)
                .addGap(45, 45, 45)
                .addComponent(Delete)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Delete)
                            .addComponent(Jugar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(Crear))
                            .addComponent(jSliderFuerza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderSuerte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderEsquivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Acciones que hacen los botones
    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        // TODO add your handling code here:
        if(TextoNombre.getText().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "¿No le vas a poner Nombre?");
        }
        else if(jSliderFuerza.getValue()+jSliderSuerte.getValue()+jSliderEsquivar.getValue()>4)
        {
            JOptionPane.showMessageDialog(null, "(ง︡'-'︠)ง\n!Maximo 4 puntos¡");
        }
        else
        {
            String nombre = this.TextoNombre.getText();
            String clase = this.jComboBox1.getSelectedItem().toString();
            int fuerza = this.jSliderFuerza.getValue();
            int suerte = this.jSliderSuerte.getValue();
            int esquivar = this.jSliderEsquivar.getValue();
        
            if(clase.equalsIgnoreCase("Luchador")){
                Luchador nuevo = new Luchador(nombre, fuerza, suerte, esquivar);
                nuevo.Equipar();
                gestor.Ingresar(nuevo);
            }
            else if(clase.equalsIgnoreCase("Monje")){
                Monje nuevo = new Monje(nombre, fuerza, suerte, esquivar);
                nuevo.Equipar();
                gestor.Ingresar(nuevo);
            }
            else if(clase.equalsIgnoreCase("Picaro")){
                Picaro nuevo = new Picaro(nombre, fuerza, suerte, esquivar);
                nuevo.Equipar();
                gestor.Ingresar(nuevo);
            }
            ActualizarTabla();
        }
    }//GEN-LAST:event_CrearActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //No hay nada
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed
        select = TablaPersonaje.getSelectedRow();
        
        if(select>-1 && select<5) {
            //setVisible(false);
            this.setVisible(false);
            
            Personaje aux = gestor.getArreglo()[select];
            Menu pantallaMenu = new Menu(aux);
            pantallaMenu.setCreador(this);
            pantallaMenu.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Selecciona el personaje ( ͡° ͜ʖ ͡°)");
        }
    }//GEN-LAST:event_JugarActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        select = TablaPersonaje.getSelectedRow();
        
        if(select>-1 && select<5) {
            modelo.removeRow(select);
            gestor.EliminarPersonaje(select);
        }
        else {
            JOptionPane.showMessageDialog(null, "Selecciona el personaje ( ͡° ͜ʖ ͡°)");
        }
    }//GEN-LAST:event_DeleteActionPerformed

    
    //Parte no modificable
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreadorPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreadorPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreadorPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreadorPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreadorPersonaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Crear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Jugar;
    private javax.swing.JTable TablaPersonaje;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderEsquivar;
    private javax.swing.JSlider jSliderFuerza;
    private javax.swing.JSlider jSliderSuerte;
    // End of variables declaration//GEN-END:variables

    //Clase para poner fondo
    class FondoImagen extends JPanel {

        //Variables
        private Image imagen;
        
        //Metodos
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("FondoCreador.jpg")).getImage();
            g.drawImage(imagen, 0, 0, 800, 600, this);
            setOpaque(false);
            super.paint(g);
        }
    }
}

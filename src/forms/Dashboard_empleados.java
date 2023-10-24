/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import PanelsEmpleado.*;
/**
 *
 * @author mario
 */
public class Dashboard_empleados extends javax.swing.JFrame {
    
    int ancho, alto;
    int posX, posY;
    
    int id_user;
    String nombre_user, pass_user;
    
    public Dashboard_empleados(int id, String nombre, String pass) {
        this.setUndecorated(true);
        initComponents();
        
        id_user = id;
        nombre_user = nombre;
        pass_user = pass;
        //ASIGNANDO EL VALOR DE ANCHO Y ALTO DEL JPANEL_CONTENT
        this.ancho = this.jPanel_content.getWidth();
        this.alto = this.jPanel_content.getHeight();
        //JOptionPane.showMessageDialog(null, this.ancho + " asas "+this.alto);
        
        //LLAMANDO A LA FUNCION PARA CENTRAR LA VENTANA
        this.centrarVentanaEnPantalla();
        
        //REDONDER LOS BORDES DE LA VENTANA
        this.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
        
        //LLAMANDO AL MÉTODO PARA COLOCAR LAS IMÁGENES A LOS BTN
        //this.imagenes_statics();
    }
    
    //MÉTODO PARA CENTRAR LA PANTALLA
    private void centrarVentanaEnPantalla() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = getSize();
        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        setLocation(x, y);
    }
    
    
    //--------- COMIENZO DE MÈTODOS QUE REALIZAN EL FUNCINAMIENTO DEL CAMBIO DE IMAGENES EN LOS BOTONES
    
    
    //BOTON DE USURIOS
//    public void imagen_btn_usuarios(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_usuarios.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_usuarios.setIcon(png);
//    }
//    public void imagen_btn_usuarios_hover(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_usuarios_hover.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_usuarios.setIcon(png);
//    }
    
    //BOTON DE PRODUCTOS
//    public void imagen_btn_productos(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_productos.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_productos.setIcon(png);
//    }
//    public void imagen_btn_productos_hover(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_productos_hover.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_productos.setIcon(png);
//    }
    
    //BOTON DE MATERIALES
//    public void imagen_btn_materiales(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_materiales.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_materiales.setIcon(png);
//    }
//    public void imagen_btn_materiales_hover(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_materiales_hover.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_materiales.setIcon(png);
//    }
    
    //BOTON DE ORDENES
    public void imagen_btn_ordenes(){
        ImageIcon temp_image;
        temp_image = new ImageIcon(getClass().getResource("/assets/btn_ordenes.png"));
        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
        jbtn_ordenes.setIcon(png);
    }
    public void imagen_btn_ordenes_hover(){
        ImageIcon temp_image;
        temp_image = new ImageIcon(getClass().getResource("/assets/btn_ordenes_hover.png"));
        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
        jbtn_ordenes.setIcon(png);
    }
    
    //BOTON DE COSTOS   
    public void imagen_btn_costos(){
        ImageIcon temp_image;
        temp_image = new ImageIcon(getClass().getResource("/assets/btn_costos.png"));
        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
        jbtn_costos.setIcon(png);
    }
    public void imagen_btn_costos_hover(){
        ImageIcon temp_image;
        temp_image = new ImageIcon(getClass().getResource("/assets/btn_costos_hover.png"));
        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
        jbtn_costos.setIcon(png);
    }
    
    //BOTON DE HISTORIAL   
//    public void imagen_btn_historial(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_historial.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_historial.setIcon(png);
//    }
//    public void imagen_btn_historial_hover(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_historial_hover.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_historial.setIcon(png);
//    }
    
    //BOTON DE REPORTES   
//    public void imagen_btn_reportes(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_reportes.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_reportes.setIcon(png);
//    }
//    public void imagen_btn_reportes_hover(){
//        ImageIcon temp_image;
//        temp_image = new ImageIcon(getClass().getResource("/assets/btn_reportes_hover.png"));
//        Icon png = new ImageIcon(temp_image.getImage().getScaledInstance(232, 41, Image.SCALE_DEFAULT));
//        jbtn_reportes.setIcon(png);
//    }
    
    
    //MÉTODO PARA REGRESAR LOS BOTONES A SU ESTADO NORMAL DESPUÉS DE DAR CLICK EN UNO DIFERENTE
    
    public void imagenes_statics(){
//        imagen_btn_usuarios();
//        imagen_btn_productos();
//        imagen_btn_materiales();
        imagen_btn_ordenes();
        imagen_btn_costos();
//        imagen_btn_historial();
//        imagen_btn_reportes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_btns = new javax.swing.JPanel();
        jPanel_main = new javax.swing.JPanel();
        jPanel_content = new javax.swing.JPanel();
        jbtn_min = new javax.swing.JButton();
        jbtn_close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbtn_ordenes = new javax.swing.JButton();
        jbtn_costos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 190, 186));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel_btns.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_main.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_main.setPreferredSize(new java.awt.Dimension(1666, 710));

        jPanel_content.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_content.setPreferredSize(new java.awt.Dimension(1000, 710));

        javax.swing.GroupLayout jPanel_contentLayout = new javax.swing.GroupLayout(jPanel_content);
        jPanel_content.setLayout(jPanel_contentLayout);
        jPanel_contentLayout.setHorizontalGroup(
            jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_contentLayout.setVerticalGroup(
            jPanel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        jbtn_min.setBackground(new java.awt.Color(190, 192, 186));
        jbtn_min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_min.png"))); // NOI18N
        jbtn_min.setPreferredSize(new java.awt.Dimension(18, 18));
        jbtn_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_minActionPerformed(evt);
            }
        });

        jbtn_close.setBackground(new java.awt.Color(190, 192, 186));
        jbtn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_close.png"))); // NOI18N
        jbtn_close.setPreferredSize(new java.awt.Dimension(18, 18));
        jbtn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_mainLayout = new javax.swing.GroupLayout(jPanel_main);
        jPanel_main.setLayout(jPanel_mainLayout);
        jPanel_mainLayout.setHorizontalGroup(
            jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addGap(986, 986, 986)
                .addComponent(jbtn_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtn_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel_content, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
        );
        jPanel_mainLayout.setVerticalGroup(
            jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_content, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logo_MACROA.png"))); // NOI18N

        jbtn_ordenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_ordenes.png"))); // NOI18N
        jbtn_ordenes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbtn_ordenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_ordenesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtn_ordenesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtn_ordenesMouseExited(evt);
            }
        });
        jbtn_ordenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ordenesActionPerformed(evt);
            }
        });

        jbtn_costos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn_costos.png"))); // NOI18N
        jbtn_costos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbtn_costos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtn_costosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtn_costosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtn_costosMouseExited(evt);
            }
        });
        jbtn_costos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_costosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Empleados.");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_btnsLayout = new javax.swing.GroupLayout(jPanel_btns);
        jPanel_btns.setLayout(jPanel_btnsLayout);
        jPanel_btnsLayout.setHorizontalGroup(
            jPanel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_btnsLayout.createSequentialGroup()
                .addGroup(jPanel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_btnsLayout.createSequentialGroup()
                        .addGroup(jPanel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_btnsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn_ordenes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_costos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_btnsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel_btnsLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_btnsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(74, 74, 74)))
                .addComponent(jPanel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 1053, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(619, 619, 619))
        );
        jPanel_btnsLayout.setVerticalGroup(
            jPanel_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_btnsLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jbtn_ordenes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_costos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel_main, javax.swing.GroupLayout.PREFERRED_SIZE, 766, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_btns, javax.swing.GroupLayout.PREFERRED_SIZE, 1354, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_btns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(p.x-posX, p.y-posY);        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.posX = evt.getX();
        this.posY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void jbtn_ordenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ordenesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_ordenesMouseClicked

    private void jbtn_ordenesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ordenesMouseEntered
        // LLAMAMIENTO DEL MÈTODO PARA CAMBIAR LA IMAGEN CUANDO EL MOUSE ENTRA AL BTN
        this.imagen_btn_ordenes_hover();
    }//GEN-LAST:event_jbtn_ordenesMouseEntered

    private void jbtn_ordenesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_ordenesMouseExited
        // LLAMAMIENTO DEL MÈTODO PARA VOLVER A LA IMAGEN ORIGINAL DEL MÈTODO
        if(jbtn_ordenes.isSelected() == true){
                this.imagen_btn_ordenes_hover();
            }
            else{
                this.imagen_btn_ordenes();
            }
    }//GEN-LAST:event_jbtn_ordenesMouseExited

    private void jbtn_ordenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ordenesActionPerformed
        // LLAMAMIENTO DE LOS MÉTODOS PARA MANTENER LA INTEGRIDAD DE LAS IMÁGENES DE LOS BOTONES
        this.imagenes_statics();
        this.imagen_btn_ordenes_hover();
        
        //LOGICA PARA ABRIR EL form pendiente
        Panel_ordenes_empleados frm_ordenes_empleados = null;
        
        frm_ordenes_empleados = new Panel_ordenes_empleados(id_user, nombre_user, pass_user);
        
        frm_ordenes_empleados.setSize(this.ancho, this.alto);
        
        frm_ordenes_empleados.setLocation(0,0);
        
        jPanel_content.removeAll();
        this.jPanel_content.add(frm_ordenes_empleados , BorderLayout.CENTER);
        this.jPanel_content.revalidate();
        this.jPanel_content.repaint();
        
        //MANTENER EL GRIS EN EL BOTON SELECCIONADO Y DEJAR EL NEGRO EN LOS DEMÁS
//        jbtn_usuarios.setSelected(false);
//        jbtn_productos.setSelected(false);
//        jbtn_materiales.setSelected(false);
        jbtn_ordenes.setSelected(true);
        jbtn_costos.setSelected(false);
//        jbtn_historial.setSelected(false);
//        jbtn_reportes.setSelected(false);
    }//GEN-LAST:event_jbtn_ordenesActionPerformed

    private void jbtn_costosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_costosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_costosMouseClicked

    private void jbtn_costosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_costosMouseEntered
        // LLAMAMIENTO DEL MÈTODO PARA CAMBIAR LA IMAGEN CUANDO EL MOUSE ENTRA AL BTN
        this.imagen_btn_costos_hover();
    }//GEN-LAST:event_jbtn_costosMouseEntered

    private void jbtn_costosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtn_costosMouseExited
        // LLAMAMIENTO DEL MÈTODO PARA VOLVER A LA IMAGEN ORIGINAL DEL MÈTODO
        if(jbtn_costos.isSelected() == true){
                this.imagen_btn_costos_hover();
            }
            else{
                this.imagen_btn_costos();
            }
    }//GEN-LAST:event_jbtn_costosMouseExited

    private void jbtn_costosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_costosActionPerformed
        // LLAMAMIENTO DE LOS MÉTODOS PARA MANTENER LA INTEGRIDAD DE LAS IMÁGENES DE LOS BOTONES
        this.imagenes_statics();
        this.imagen_btn_costos_hover();
        
        //LOGICA PARA ABRIR EL form pendiente
        Panel_costos_empleados frm_costos_empleados = null;
        
        frm_costos_empleados = new Panel_costos_empleados(id_user, nombre_user, pass_user);
        
        frm_costos_empleados.setSize(this.ancho, this.alto);
        
        frm_costos_empleados.setLocation(0,0);
        
        jPanel_content.removeAll();
        this.jPanel_content.add(frm_costos_empleados , BorderLayout.CENTER);
        this.jPanel_content.revalidate();
        this.jPanel_content.repaint();
        
        //MANTENER EL GRIS EN EL BOTON SELECCIONADO Y DEJAR EL NEGRO EN LOS DEMÁS
//        jbtn_usuarios.setSelected(false);
//        jbtn_productos.setSelected(false);
//        jbtn_materiales.setSelected(false);
        jbtn_ordenes.setSelected(false);
        jbtn_costos.setSelected(true);
//        jbtn_historial.setSelected(false);
//        jbtn_reportes.setSelected(false);
    }//GEN-LAST:event_jbtn_costosActionPerformed

    private void jbtn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtn_closeActionPerformed

    private void jbtn_minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_minActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_minActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login login = new  Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //BLOQUE DE CODIGO PARA CENTRAR EL FORMULARIO MAIN

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard_empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard_empleados(0, "", "").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_btns;
    private javax.swing.JPanel jPanel_content;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JButton jbtn_close;
    private javax.swing.JButton jbtn_costos;
    private javax.swing.JButton jbtn_min;
    private javax.swing.JButton jbtn_ordenes;
    // End of variables declaration//GEN-END:variables
}

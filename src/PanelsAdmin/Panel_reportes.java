/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelsAdmin;

/**
 *
 * @author mario
 */
public class Panel_reportes extends javax.swing.JPanel {

    int id_user;
    String nombre_user, pass_user;
    public Panel_reportes(int id, String nombre, String pass) {
        initComponents();
        
        id_user = id;
        nombre_user = nombre;
        pass_user = pass;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBIngresarSistema = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 190, 186));
        setPreferredSize(new java.awt.Dimension(1000, 710));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setText("Recuperación.");

        jBIngresarSistema.setBackground(new java.awt.Color(0, 0, 0));
        jBIngresarSistema.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jBIngresarSistema.setForeground(new java.awt.Color(255, 255, 255));
        jBIngresarSistema.setText("Recuperar Información");
        jBIngresarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarSistemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBIngresarSistema)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jBIngresarSistema)
                .addContainerGap(530, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarSistemaActionPerformed
        try {
          
        } catch (Exception e) {
            
        }

    }//GEN-LAST:event_jBIngresarSistemaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBIngresarSistema;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

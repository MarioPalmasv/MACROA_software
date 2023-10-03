/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

/**
 *
 * @author mario
 */
public class Panel_costos extends javax.swing.JPanel {

    /**
     * Creates new form Panel_costos
     */
    public Panel_costos() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jBEliminar = new javax.swing.JButton();
        jBActivate = new javax.swing.JButton();
        jTNombre = new javax.swing.JTextField();
        JTPorcentaje = new javax.swing.JTextField();
        jTDecimal = new javax.swing.JTextField();
        jBIngresar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTNombre3 = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 190, 186));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(143, 5, 30));
        jLabel1.setText("Costos");

        jPanel1.setBackground(new java.awt.Color(192, 190, 186));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jBEliminar.setBackground(new java.awt.Color(143, 5, 30));
        jBEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminar.setText("Eliminar");

        jBActivate.setBackground(new java.awt.Color(143, 5, 30));
        jBActivate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBActivate.setForeground(new java.awt.Color(255, 255, 255));
        jBActivate.setText("Activar");

        jTNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombre.setText("Ingrese el nombre del impuesto");
        jTNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreMouseClicked(evt);
            }
        });

        JTPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTPorcentaje.setText("Ingrese el porcentaje");
        JTPorcentaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPorcentajeMouseClicked(evt);
            }
        });
        JTPorcentaje.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JTPorcentajePropertyChange(evt);
            }
        });
        JTPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTPorcentajeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPorcentajeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTPorcentajeKeyTyped(evt);
            }
        });

        jTDecimal.setEditable(false);
        jTDecimal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTDecimal.setText("Valor en decimal");

        jBIngresar.setBackground(new java.awt.Color(143, 5, 30));
        jBIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jBIngresar.setText("Ingresar");

        jBModificar.setBackground(new java.awt.Color(143, 5, 30));
        jBModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBModificar.setForeground(new java.awt.Color(255, 255, 255));
        jBModificar.setText("Modificar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBIngresar)
                        .addGap(26, 26, 26)
                        .addComponent(jBModificar)
                        .addGap(26, 26, 26)
                        .addComponent(jBEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jBActivate))
                    .addComponent(jTNombre)
                    .addComponent(JTPorcentaje)
                    .addComponent(jTDecimal))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JTPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIngresar)
                    .addComponent(jBModificar)
                    .addComponent(jBEliminar))
                .addGap(18, 18, 18)
                .addComponent(jBActivate)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(192, 190, 186));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);

        jTNombre3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombre3.setText("Ingrese el nombre del impuesto a buscar");

        jBBuscar.setBackground(new java.awt.Color(143, 5, 30));
        jBBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(426, 426, 426))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreMouseClicked
        if (this.jTNombre.getText().equals("Ingrese el nombre del impuesto")) {
            this.jTNombre.setText("");
        }
    }//GEN-LAST:event_jTNombreMouseClicked

    private void JTPorcentajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPorcentajeMouseClicked
        if (this.JTPorcentaje.getText().equals("Ingrese el porcentaje")) {
            this.JTPorcentaje.setText("");
        }
    }//GEN-LAST:event_JTPorcentajeMouseClicked

    private void JTPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeKeyTyped
        
    }//GEN-LAST:event_JTPorcentajeKeyTyped

    private void JTPorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeKeyPressed
        
    }//GEN-LAST:event_JTPorcentajeKeyPressed

    private void JTPorcentajePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JTPorcentajePropertyChange
        
    }//GEN-LAST:event_JTPorcentajePropertyChange

    private void JTPorcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeKeyReleased
        String porcentaje = this.JTPorcentaje.getText();
        this.jTDecimal.setText(porcentaje);
    }//GEN-LAST:event_JTPorcentajeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTPorcentaje;
    private javax.swing.JButton jBActivate;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDecimal;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTNombre3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

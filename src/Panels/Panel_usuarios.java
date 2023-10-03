/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import javax.swing.JOptionPane;
import classes.*;
import classesDAO.*;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Panel_usuarios extends javax.swing.JPanel {

    User usuario;
    UserDAO usuarioDAO;
    Encode encrip;
    DefaultTableModel model;
    int id;
    List<User> lUsuarios;
   
    
    public Panel_usuarios() {
        initComponents();
        encrip = new Encode();
        usuarioDAO = new UserDAO();
        model = new DefaultTableModel();
        this.cargar_table();
        id = 0;
        
        //desactivar botones
        this.jBActivar.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonModificar.setEnabled(false);
    }

    void cargar_table(){
        model.setRowCount(0);
        String[] nombreColum = {"Nombres", "Apellidos", "UserName", "Clave", "Salario", "Dirección", "Teléfono", "tipo usuario", "Estado"};
        model.setColumnIdentifiers(nombreColum);
        
        lUsuarios = usuarioDAO.ListarUsuarios();
        
       
    
        if (lUsuarios.size()>-1) {
            for (int i = 0; i < lUsuarios.size(); i++) {
                if (lUsuarios.get(i).getState().equals("a")) {
                    model.addRow(new Object[]{lUsuarios.get(i).getFirst_name(), lUsuarios.get(i).getLast_name(), lUsuarios.get(i).getUser_name(),
                                           lUsuarios.get(i).getPassword_user(), lUsuarios.get(i).getSalary_employee(), lUsuarios.get(i).getAddress(),
                                            lUsuarios.get(i).getPhone(), lUsuarios.get(i).getType_user(), "Trabajando"});
                }
                else{
                    model.addRow(new Object[]{lUsuarios.get(i).getFirst_name(), lUsuarios.get(i).getLast_name(), lUsuarios.get(i).getUser_name(),
                                           lUsuarios.get(i).getPassword_user(), lUsuarios.get(i).getSalary_employee(), lUsuarios.get(i).getAddress(),
                                            lUsuarios.get(i).getPhone(), lUsuarios.get(i).getType_user(), "Despedido"});
                }
                
            }
            this.jTableUser.setModel(model);
            this.jTableUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableUser.setFillsViewportHeight(true);
        }
    }
    
    void cargar_tableNombre(String pNombre){
        model.setRowCount(0);
        String[] nombreColum = {"Nombres", "Apellidos", "UserName", "Clave", "Salario", "Dirección", "Teléfono", "tipo usuario", "Estado"};
        model.setColumnIdentifiers(nombreColum);
        
        lUsuarios = usuarioDAO.ListarUsuariosNombre(pNombre);
        if (lUsuarios.size()>-1) {
            for (int i = 0; i < lUsuarios.size(); i++) {
                if (lUsuarios.get(i).getState().equals("a")) {
                    model.addRow(new Object[]{lUsuarios.get(i).getFirst_name(), lUsuarios.get(i).getLast_name(), lUsuarios.get(i).getUser_name(),
                                           lUsuarios.get(i).getPassword_user(), lUsuarios.get(i).getSalary_employee(), lUsuarios.get(i).getAddress(),
                                            lUsuarios.get(i).getPhone(), lUsuarios.get(i).getType_user(), "Trabajando"});
                }
                else{
                    model.addRow(new Object[]{lUsuarios.get(i).getFirst_name(), lUsuarios.get(i).getLast_name(), lUsuarios.get(i).getUser_name(),
                                           lUsuarios.get(i).getPassword_user(), lUsuarios.get(i).getSalary_employee(), lUsuarios.get(i).getAddress(),
                                            lUsuarios.get(i).getPhone(), lUsuarios.get(i).getType_user(), "Despedido"});
                }
                
            }
            this.jTableUser.setModel(model);
            this.jTableUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableUser.setFillsViewportHeight(true);
        }
    }
    void limpiar(){
        this.cargar_table();
        this.jBActivar.setEnabled(false);
        this.jButtonEliminar.setEnabled(false);
        this.jButtonModificar.setEnabled(false);
        this.jButtonIngresar.setEnabled(true);
        id = 0;
        this.jTextNombreIN.setText("Ingrese el nombre del empleado");
        this.jTextApellidoIN.setText("Ingrese el apellido del empleado");
        this.jTextNombreUsuarioIN.setText("Ingrese el nombre de usuario");
        this.jTextCorreoIN.setText("Ingrese el correo");
        this.jTextSalarioIN.setText("Ingrese el salario");
        this.jTextAreaDireccion.setText("Ingrese la dirección");
        this.jTextTelefono.setText("Ingrese el teléfono");
        this.jPassClave.setText("                ");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextNombreIN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jTextBuscarEmpleado = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jTextApellidoIN = new javax.swing.JTextField();
        jTextNombreUsuarioIN = new javax.swing.JTextField();
        jTextCorreoIN = new javax.swing.JTextField();
        jPassClave = new javax.swing.JPasswordField();
        jButtonIngresar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jTextSalarioIN = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDireccion = new javax.swing.JTextArea();
        jTextTelefono = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jBActivar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 190, 186));
        setPreferredSize(new java.awt.Dimension(990, 710));

        jTextNombreIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextNombreIN.setText("Ingrese el nombre del empleado");
        jTextNombreIN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextNombreIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextNombreINMouseClicked(evt);
            }
        });
        jTextNombreIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreINActionPerformed(evt);
            }
        });

        jTableUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUser);

        jTextBuscarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextBuscarEmpleado.setText("Bucar empleado por nombre");
        jTextBuscarEmpleado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextBuscarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarEmpleadoMouseClicked(evt);
            }
        });

        jBBuscar.setBackground(new java.awt.Color(143, 5, 30));
        jBBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTextApellidoIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextApellidoIN.setText("Ingrese el apellido del empleado");
        jTextApellidoIN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextApellidoIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextApellidoINMouseClicked(evt);
            }
        });
        jTextApellidoIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoINActionPerformed(evt);
            }
        });

        jTextNombreUsuarioIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextNombreUsuarioIN.setText("Ingrese el nombre de usuario");
        jTextNombreUsuarioIN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextNombreUsuarioIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextNombreUsuarioINMouseClicked(evt);
            }
        });
        jTextNombreUsuarioIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreUsuarioINActionPerformed(evt);
            }
        });

        jTextCorreoIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextCorreoIN.setText("Ingrese el correo");
        jTextCorreoIN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextCorreoIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextCorreoINMouseClicked(evt);
            }
        });
        jTextCorreoIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCorreoINActionPerformed(evt);
            }
        });

        jPassClave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPassClave.setText("                ");
        jPassClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPassClaveMouseClicked(evt);
            }
        });

        jButtonIngresar.setBackground(new java.awt.Color(143, 5, 30));
        jButtonIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jButtonModificar.setBackground(new java.awt.Color(143, 5, 30));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(143, 5, 30));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jTextSalarioIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextSalarioIN.setText("Ingrese el salario");
        jTextSalarioIN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextSalarioIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextSalarioINMouseClicked(evt);
            }
        });
        jTextSalarioIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSalarioINActionPerformed(evt);
            }
        });

        jTextAreaDireccion.setColumns(20);
        jTextAreaDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextAreaDireccion.setRows(5);
        jTextAreaDireccion.setText("Ingrese la dirección");
        jTextAreaDireccion.setToolTipText("");
        jTextAreaDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaDireccionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaDireccion);

        jTextTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextTelefono.setText("Ingrese el teléfono");
        jTextTelefono.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTextTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextTelefonoMouseClicked(evt);
            }
        });
        jTextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Administrador" }));

        jBActivar.setBackground(new java.awt.Color(143, 5, 30));
        jBActivar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBActivar.setForeground(new java.awt.Color(255, 255, 255));
        jBActivar.setText("Activar");
        jBActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActivarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(143, 5, 30));
        jLabel1.setText("Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(420, 420, 420))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextCorreoIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombreUsuarioIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextApellidoIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombreIN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextSalarioIN)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(jTextTelefono, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonEliminar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBActivar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonIngresar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                            .addComponent(jButtonModificar)))
                                    .addGap(58, 58, 58))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jPassClave, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextNombreIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextApellidoIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextNombreUsuarioIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextCorreoIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextSalarioIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPassClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIngresar)
                            .addComponent(jButtonModificar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButtonEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jBActivar)))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBBuscar)
                            .addComponent(jTextBuscarEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextApellidoINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoINActionPerformed
        if (this.jTextApellidoIN.getText().equals("Ingrese el apellido del empleado")) {
            this.jTextApellidoIN.setText("");
        }
    }//GEN-LAST:event_jTextApellidoINActionPerformed

    private void jTextNombreUsuarioINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreUsuarioINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreUsuarioINActionPerformed

    private void jTextCorreoINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCorreoINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoINActionPerformed

    private void jTextNombreINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreINActionPerformed
        
        
    }//GEN-LAST:event_jTextNombreINActionPerformed

    private void jTextNombreINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreINMouseClicked
        if (this.jTextNombreIN.getText().equals("Ingrese el nombre del empleado")) {
            this.jTextNombreIN.setText("");
        }
    }//GEN-LAST:event_jTextNombreINMouseClicked

    private void jTextNombreUsuarioINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNombreUsuarioINMouseClicked
        if (this.jTextNombreUsuarioIN.getText().equals("Ingrese el nombre de usuario")) {
            this.jTextNombreUsuarioIN.setText("");
        }
    }//GEN-LAST:event_jTextNombreUsuarioINMouseClicked

    private void jTextCorreoINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCorreoINMouseClicked
        if (this.jTextCorreoIN.getText().equals("Ingrese el correo")) {
            this.jTextCorreoIN.setText("");
        }
    }//GEN-LAST:event_jTextCorreoINMouseClicked

    private void jPassClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPassClaveMouseClicked
        if (this.jPassClave.getText().equals("                ")) {
            this.jPassClave.setText("");
        }
    }//GEN-LAST:event_jPassClaveMouseClicked

    private void jTextApellidoINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextApellidoINMouseClicked
        if (this.jTextApellidoIN.getText().equals("Ingrese el apellido del empleado")) {
            this.jTextApellidoIN.setText("");
        }
    }//GEN-LAST:event_jTextApellidoINMouseClicked

    private void jTextBuscarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarEmpleadoMouseClicked
        if (this.jTextBuscarEmpleado.getText().equals("Bucar empleado por nombre")) {
            this.jTextBuscarEmpleado.setText("");
        }
    }//GEN-LAST:event_jTextBuscarEmpleadoMouseClicked

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        boolean bandUser = false, bandUserName = false;
        double salario = 0;
        
        
        String nombre = this.jTextNombreIN.getText();
        String apellido = this.jTextApellidoIN.getText();
        String nombreUs =this.jTextNombreUsuarioIN.getText();
        String correo = this.jTextCorreoIN.getText();
        String direccion = this.jTextAreaDireccion.getText();
        String telefono = this.jTextTelefono.getText();
        String clave = this.jPassClave.getText();
        String typeUS = this.jComboBox1.getSelectedItem().toString();
        
        try {
            salario = Double.parseDouble(this.jTextSalarioIN.getText());
        } catch (Exception e) {
        }
        
        if (direccion.equals("Ingrese la dirección") || direccion.trim().length() == 0) {
            direccion = "N/A";
        }
        if (telefono.equals("Teléfono") || telefono.trim().length() == 0) {
            telefono = "N/A";
        }
        
        if (correo.equals("Ingrese el correo") || correo.trim().length() == 0) {
            correo = "N/A";
        }
        if (telefono.equals("Ingrese el teléfono") && telefono.trim().length() == 0) {
            telefono = "N/A";
        }
        
        //se evaluan q los campos requeridos no sean nulos
        if (!nombre.equals("Ingrese el nombre del empleado") && nombre.trim().length()> 0 &&
            !apellido.equals("Ingrese el apellido del empleado") && apellido.trim().length()> 0 &&
            !nombreUs.equals("Ingrese el nombre de usuario") && nombreUs.trim().length()> 0 &&
            !clave.equals("                ") && clave.trim().length()> 0) {
            
            //evaluar en la lista si el usuairo existe
            for (int i = 0; i < lUsuarios.size(); i++) {
                if (nombre.toLowerCase().equals(lUsuarios.get(i).getFirst_name().toLowerCase()) &&
                    apellido.toLowerCase().equals(lUsuarios.get(i).getLast_name().toLowerCase()) ) {
                    bandUser = true;
                }
                if (nombreUs.toLowerCase().equals(lUsuarios.get(i).getUser_name().toLowerCase())) {
                    bandUserName = true;
                }
            }
            
            //evaluar si el usuario existe 
            if (!bandUser) {
                if (!bandUserName) {
                    String claveEncriptada = encrip.Encriptar(clave);
                    usuario = new User(nombre, apellido, nombreUs, claveEncriptada, correo, salario, direccion, telefono,typeUS);

                    if (usuarioDAO.insert(usuario)) {
                        JOptionPane.showMessageDialog(null, "Se ingresó el usuario");
                        this.cargar_table();
                        this.limpiar();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al ingresar el usuario");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Error! \n El nombre de usuario debe ser diferente.");
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "El usuario existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
        }
          
            
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jTextSalarioINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextSalarioINMouseClicked
        if (this.jTextSalarioIN.getText().equals("Ingrese el salario")) {
            this.jTextSalarioIN.setText("");
        }
    }//GEN-LAST:event_jTextSalarioINMouseClicked

    private void jTextSalarioINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSalarioINActionPerformed
        
    }//GEN-LAST:event_jTextSalarioINActionPerformed

    private void jTextAreaDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaDireccionMouseClicked
        if (this.jTextAreaDireccion.getText().equals("Ingrese la dirección")) {
            this.jTextAreaDireccion.setText("");
        }
    }//GEN-LAST:event_jTextAreaDireccionMouseClicked

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        try {
            if(this.jTableUser.getSelectedRow() > -1){
                //activar botones
                this.jBActivar.setEnabled(true);
                this.jButtonEliminar.setEnabled(true);
                this.jButtonModificar.setEnabled(true);
                
                this.jButtonIngresar.setEnabled(false);
                
                int index = this.jTableUser.getSelectedRow();
                String pass = encrip.Desencriptar(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 3).toString());
              
                id = this.lUsuarios.get(index).getUser_id();
                this.jTextNombreIN.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 0).toString());
                this.jTextApellidoIN.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 1).toString());
                this.jTextNombreUsuarioIN.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 2).toString());
                this.jPassClave.setText(pass);
                this.jTextCorreoIN.setText(lUsuarios.get(index).getEmail());
                this.jTextSalarioIN.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 4).toString());
                this.jTextAreaDireccion.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 5).toString());
                this.jTextTelefono.setText(((DefaultTableModel)this.jTableUser.getModel()).getValueAt(index, 6).toString());
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jTextTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextTelefonoMouseClicked
        if (this.jTextTelefono.getText().equals("Ingrese el teléfono")) {
            this.jTextTelefono.setText("");
        }
    }//GEN-LAST:event_jTextTelefonoMouseClicked

    private void jTextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        double salario = 0;
        
        
        String nombre = this.jTextNombreIN.getText();
        String apellido = this.jTextApellidoIN.getText();
        String nombreUs =this.jTextNombreUsuarioIN.getText();
        String correo = this.jTextCorreoIN.getText();
        String direccion = this.jTextAreaDireccion.getText();
        String telefono = this.jTextTelefono.getText();
        String clave = this.jPassClave.getText();
        String typeUS = this.jComboBox1.getSelectedItem().toString();
        
        try {
            salario = Double.parseDouble(this.jTextSalarioIN.getText());
        } catch (Exception e) {
        }
        
        if (direccion.equals("Ingrese la dirección") || direccion.trim().length() == 0) {
            direccion = "N/A";
        }
        if (telefono.equals("Teléfono") || telefono.trim().length() == 0) {
            telefono = "N/A";
        }
        
        if (correo.equals("Ingrese el correo") || correo.trim().length() == 0) {
            correo = "N/A";
        }
        if (telefono.equals("Ingrese el teléfono") && telefono.trim().length() == 0) {
            telefono = "N/A";
        }
        
        if (!nombre.equals("Ingrese el nombre del empleado") && nombre.trim().length()> 0 &&
            !apellido.equals("Ingrese el apellido del empleado") && apellido.trim().length()> 0 &&
            !nombreUs.equals("Ingrese el nombre de usuario") && nombreUs.trim().length()> 0 &&
            !clave.equals("                ") && clave.trim().length()> 0) {
            
            String claveEncriptada = encrip.Encriptar(clave);
            usuario = new User(id, nombre, apellido, nombreUs, claveEncriptada, correo,salario, direccion, telefono, typeUS);
            
            int response = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
                
            if (response == JOptionPane.YES_OPTION) {
                if (usuarioDAO.update(usuario)) {
                    JOptionPane.showMessageDialog(null, "Se actualizó el usuario");
                    this.cargar_table();
                    this.limpiar();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al actulizar el usuario");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se canceló la accción modificar el usuario");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
        }        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
                
        if (response == JOptionPane.YES_OPTION) {
            if (usuarioDAO.delete(id)) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                this.cargar_table();
                this.limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                this.limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se canceló la accción eliminar el usuario");
        }        
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jBActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActivarActionPerformed
    int response = JOptionPane.showConfirmDialog(null, "¿Desea activar el usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
                
    if (response == JOptionPane.YES_OPTION) {
        if (usuarioDAO.activate(id)) {
            JOptionPane.showMessageDialog(null, "Se activó correctamente");
            this.cargar_table();
            this.limpiar();
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al activar el usuario");
            this.limpiar();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Se canceló la accción activar el usuario");
    }    
    }//GEN-LAST:event_jBActivarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String nombre = this.jTextBuscarEmpleado.getText();
        
        if (!nombre.equals("Bucar empleado por nombre")&& nombre.trim().length() > 0) {
            this.cargar_tableNombre(nombre);
        }else{
            JOptionPane.showMessageDialog(null, "No ha ingresado nombre a buscar");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActivar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPassClave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextApellidoIN;
    private javax.swing.JTextArea jTextAreaDireccion;
    private javax.swing.JTextField jTextBuscarEmpleado;
    private javax.swing.JTextField jTextCorreoIN;
    private javax.swing.JTextField jTextNombreIN;
    private javax.swing.JTextField jTextNombreUsuarioIN;
    private javax.swing.JTextField jTextSalarioIN;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}

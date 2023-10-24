/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelsAdmin;

import classes.Combination;
import classes.Material;
import classes.Product;
import classesDAO.CombinationDAO;
import classesDAO.MaterialDAO;
import classesDAO.ProductDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Panel_productos extends javax.swing.JPanel {

    Product product;
    ProductDAO productDAO;
    MaterialDAO materialDAO;
    Material materialAgg;
    Combination combinatino;
    CombinationDAO combinatinoDAO;
    
    
    List<Product> lProducts;
    List<Material> lMateriales;
    List<Material> lcombination;
    
    DefaultTableModel model;
    DefaultTableModel modelMaterial;
    DefaultTableModel modelCombination;
    
    boolean bandCombiTable = false;
    
    int idProducto, idMaterial, idCombination;
    
    int id_user;
    String nombre_user, pass_user;
    
    public Panel_productos(int id, String nombre, String pass) {
        initComponents();
        productDAO = new ProductDAO();
        materialDAO = new MaterialDAO();
        combinatinoDAO = new CombinationDAO();
                
        model = new DefaultTableModel();
        modelMaterial = new DefaultTableModel();
        modelCombination = new DefaultTableModel();
        
        //desactivar botones.
        this.jBModificar.setEnabled(false);
        this.jBEliminar.setEnabled(false);
        this.jBActivar.setEnabled(false);
        
        idProducto = -1;
        idMaterial = -1;
        idCombination = -1;
        
        //inicializacion de la lista de combinacion
        lcombination = new ArrayList<>();
        
        id_user = id;
        nombre_user = nombre;
        pass_user = pass;
        
        this.jLUser.setText(nombre_user);
        
        this.cargar_table();
    }

    void cargar_table(){
        model.setRowCount(0);
        String[] nombreColum = {"Nombre", "Modelo", "time in", "MOD", "Estado"};
        model.setColumnIdentifiers(nombreColum);
        
        lProducts = productDAO.ListarProdcut();
      
        if (lProducts.size()>-1) {
            for (int i = 0; i < lProducts.size(); i++) {
                if (lProducts.get(i).getState().equals("a")) {
                    model.addRow(new Object[]{lProducts.get(i).getNombre(), lProducts.get(i).getModelo(), lProducts.get(i).getTime_in(), 
                                              lProducts.get(i).getConstante_mod(),"En uso"});
                }
                else{
                    model.addRow(new Object[]{lProducts.get(i).getNombre(), lProducts.get(i).getModelo(), lProducts.get(i).getTime_in(), 
                                              lProducts.get(i).getConstante_mod(), "Descontinuado"});
                }
            }
            this.jTableProducts.setModel(model);
            this.jTableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableProducts.setFillsViewportHeight(true);
        }
    }
    
    void cargarTableNombre(String pNombre){
        model.setRowCount(0);
        String[] nombreColum = {"Nombre", "Modelo", "time in", "MOD", "Estado"};
        model.setColumnIdentifiers(nombreColum);
        
        lProducts = productDAO.ListarProdcutNombre(pNombre);
        
        if (lProducts.size()>-1) {
            for (int i = 0; i < lProducts.size(); i++) {
                if (lProducts.get(i).getState().equals("a")) {
                    model.addRow(new Object[]{lProducts.get(i).getNombre(), lProducts.get(i).getModelo(), lProducts.get(i).getTime_in(), 
                                              lProducts.get(i).getConstante_mod(),"En uso"});
                }
                else{
                    model.addRow(new Object[]{lProducts.get(i).getNombre(), lProducts.get(i).getModelo(), lProducts.get(i).getTime_in(), 
                                              lProducts.get(i).getConstante_mod(), "Descontinuado"});
                }
            }
            this.jTableProducts.setModel(model);
            this.jTableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableProducts.setFillsViewportHeight(true);
        }
    }
     
    void cargarTableMaterial(){
        modelMaterial.setRowCount(0);
        String[] nombreColum = {"Nombre", "Pulgada", "cms", "precio", "Pintura empaque", "Estado"};
        modelMaterial.setColumnIdentifiers(nombreColum);
        
        lMateriales = materialDAO.ListarMateriales();
        
       
    
        if (lMateriales.size()>-1) {
            for (int i = 0; i < lMateriales.size(); i++) {
                if (lMateriales.get(i).getEstado().equals("a")) {
                    modelMaterial.addRow(new Object[]{lMateriales.get(i).getNombre(), lMateriales.get(i).getPulgada(), lMateriales.get(i).getCms(),
                                               lMateriales.get(i).getPrecio(), lMateriales.get(i).getPintura_empaque(), "En uso"});
                }
                else{
                    modelMaterial.addRow(new Object[]{lMateriales.get(i).getNombre(), lMateriales.get(i).getPulgada(), lMateriales.get(i).getCms(),
                                               lMateriales.get(i).getPrecio(), lMateriales.get(i).getPintura_empaque(), "Descontinuado"});
                }
            }
            this.jTableMaterial.setModel(modelMaterial);
            this.jTableMaterial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableMaterial.setFillsViewportHeight(true);
        }
    }
    
    void cargarTableMaterialNombre(String pNombre){
        modelMaterial.setRowCount(0);
        String[] nombreColum = {"Nombre", "Pulgada", "cms", "precio", "Pintura empaque", "Estado"};
        modelMaterial.setColumnIdentifiers(nombreColum);
        
        lMateriales = materialDAO.ListarMaterialesNombre(pNombre);
        
       
    
        if (lMateriales.size()>-1) {
            for (int i = 0; i < lMateriales.size(); i++) {
                if (lMateriales.get(i).getEstado().equals("a")) {
                    modelMaterial.addRow(new Object[]{lMateriales.get(i).getNombre(), lMateriales.get(i).getPulgada(), lMateriales.get(i).getCms(),
                                               lMateriales.get(i).getPrecio(), lMateriales.get(i).getPintura_empaque(), "En uso"});
                }
                else{
                    modelMaterial.addRow(new Object[]{lMateriales.get(i).getNombre(), lMateriales.get(i).getPulgada(), lMateriales.get(i).getCms(),
                                               lMateriales.get(i).getPrecio(), lMateriales.get(i).getPintura_empaque(), "Descontinuado"});
                }
            }
            this.jTableMaterial.setModel(modelMaterial);
            this.jTableMaterial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableMaterial.setFillsViewportHeight(true);
        }
    }
    
    void cargarTableCombination(){
        modelCombination.setRowCount(0);
        String[] nombreColum = {"Nombre", "Pulgada", "cms", "precio", "Pintura empaque", "Estado"};
        modelCombination.setColumnIdentifiers(nombreColum);
             
        
        if (lcombination.size()>-1) {
            for (int i = 0; i < lcombination.size(); i++) {
                if (lcombination.get(i).getEstado().equals("a")) {
                    modelCombination.addRow(new Object[]{lcombination.get(i).getNombre(), lcombination.get(i).getPulgada(), lcombination.get(i).getCms(),
                                               lcombination.get(i).getPrecio(), lcombination.get(i).getPintura_empaque(), "En uso"});
                }
                else{
                    modelCombination.addRow(new Object[]{lcombination.get(i).getNombre(), lcombination.get(i).getPulgada(), lcombination.get(i).getCms(),
                                               lcombination.get(i).getPrecio(), lcombination.get(i).getPintura_empaque(), "Descontinuado"});
                }
            }
            this.jTableCombination.setModel(modelCombination);
            this.jTableCombination.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableCombination.setFillsViewportHeight(true);
        }
    }
    
    //para saber si trae combinacion
    void cargarTableCombinationIdProduct(int id){
        modelCombination.setRowCount(0);
        String[] nombreColum = {"Nombre", "Pulgada", "cms", "precio", "Pintura empaque", "Estado"};
        modelCombination.setColumnIdentifiers(nombreColum);
        
        if (idProducto > 0) {
            lcombination = materialDAO.ListarMaterialesCombination(idProducto);
        }
        
        
        if (lcombination.size()>-1) {
            bandCombiTable = true;
            for (int i = 0; i < lcombination.size(); i++) {
                if (lcombination.get(i).getEstado().equals("a")) {
                    modelCombination.addRow(new Object[]{lcombination.get(i).getNombre(), lcombination.get(i).getPulgada(), lcombination.get(i).getCms(),
                                               lcombination.get(i).getPrecio(), lcombination.get(i).getPintura_empaque(), "En uso"});
                }
                else{
                    modelCombination.addRow(new Object[]{lcombination.get(i).getNombre(), lcombination.get(i).getPulgada(), lcombination.get(i).getCms(),
                                               lcombination.get(i).getPrecio(), lcombination.get(i).getPintura_empaque(), "Descontinuado"});
                }
            }
            this.jTableCombination.setModel(modelCombination);
            this.jTableCombination.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableCombination.setFillsViewportHeight(true);
        }
        else{
            bandCombiTable = false;
        }
    }
    
    
    
    
     void limpiar(){
        idProducto = 0;
        this.cargar_table();
        this.jBIngresar.setEnabled(true);
        this.jBModificar.setEnabled(false);
        this.jBEliminar.setEnabled(false);
        this.jBActivar.setEnabled(false);
        
        this.jTBuscarNombre.setText("Ingrese el nombre a buscar");
        this.jTNombreIN.setText("Ingrese el nombre del producto");
        this.jTModeloIN.setText("Ingrese el valor en pulgada");
        this.jTTimeIn.setText("Ingrese el valor en cms");
        this.jTConstanteModIN.setText("Ingrese el precio");
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTBuscarMaterial = new javax.swing.JTextField();
        jBBuscarMaterial = new javax.swing.JButton();
        jBAgregarMaterial = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMaterial = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTBuscarNombre = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCombination = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jBCrearCombination = new javax.swing.JButton();
        jBEliminarCombination = new javax.swing.JButton();
        jTNombreCombination = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTTimeIn = new javax.swing.JTextField();
        jTConstanteModIN = new javax.swing.JTextField();
        jBIngresar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBActivar = new javax.swing.JButton();
        jTNombreIN = new javax.swing.JTextField();
        jTModeloIN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLUser = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 190, 186));
        setPreferredSize(new java.awt.Dimension(1005, 701));

        jPanel1.setBackground(new java.awt.Color(192, 190, 186));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jTBuscarMaterial.setEditable(false);
        jTBuscarMaterial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTBuscarMaterial.setText("Ingrese el material");
        jTBuscarMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBuscarMaterialMouseClicked(evt);
            }
        });

        jBBuscarMaterial.setBackground(new java.awt.Color(143, 5, 30));
        jBBuscarMaterial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBBuscarMaterial.setForeground(new java.awt.Color(255, 255, 255));
        jBBuscarMaterial.setText("Buscar");
        jBBuscarMaterial.setEnabled(false);
        jBBuscarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarMaterialActionPerformed(evt);
            }
        });

        jBAgregarMaterial.setBackground(new java.awt.Color(143, 5, 30));
        jBAgregarMaterial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAgregarMaterial.setForeground(new java.awt.Color(255, 255, 255));
        jBAgregarMaterial.setText("Agregar material");
        jBAgregarMaterial.setEnabled(false);
        jBAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarMaterialActionPerformed(evt);
            }
        });

        jTableMaterial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMaterial.setRowHeight(30);
        jTableMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMaterial);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAgregarMaterial, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jTBuscarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBBuscarMaterial)
                        .addGap(27, 27, 27)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBuscarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBAgregarMaterial)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(192, 190, 186));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jTBuscarNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTBuscarNombre.setText("Ingrese el nombre a buscar");
        jTBuscarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBuscarNombreMouseClicked(evt);
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

        jTableProducts.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProducts.setRowHeight(30);
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBBuscar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(192, 190, 186));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jTableCombination.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableCombination.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableCombination.setRowHeight(30);
        jTableCombination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCombinationMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableCombination);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(143, 5, 30));
        jLabel1.setText("Materiales");

        jBCrearCombination.setBackground(new java.awt.Color(143, 5, 30));
        jBCrearCombination.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBCrearCombination.setForeground(new java.awt.Color(255, 255, 255));
        jBCrearCombination.setText("Crear producto");
        jBCrearCombination.setEnabled(false);
        jBCrearCombination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearCombinationActionPerformed(evt);
            }
        });

        jBEliminarCombination.setBackground(new java.awt.Color(143, 5, 30));
        jBEliminarCombination.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBEliminarCombination.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminarCombination.setText("Eliminar material");
        jBEliminarCombination.setEnabled(false);
        jBEliminarCombination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarCombinationActionPerformed(evt);
            }
        });

        jTNombreCombination.setEditable(false);
        jTNombreCombination.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreCombination.setText("Nombre del producto");
        jTNombreCombination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreCombinationMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTNombreCombination, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jBCrearCombination)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBEliminarCombination)
                            .addGap(63, 63, 63))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTNombreCombination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCrearCombination)
                    .addComponent(jBEliminarCombination))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(192, 190, 186));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(143, 5, 30), 2));

        jTTimeIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTTimeIn.setText("Ingrese el time in");
        jTTimeIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTimeInMouseClicked(evt);
            }
        });

        jTConstanteModIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTConstanteModIN.setText("Ingrese el MOD");
        jTConstanteModIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConstanteModINMouseClicked(evt);
            }
        });

        jBIngresar.setBackground(new java.awt.Color(143, 5, 30));
        jBIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jBIngresar.setText("Ingresar");
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });

        jBModificar.setBackground(new java.awt.Color(143, 5, 30));
        jBModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBModificar.setForeground(new java.awt.Color(255, 255, 255));
        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(143, 5, 30));
        jBEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBEliminar.setText("Eliminar");
        jBEliminar.setToolTipText("");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActivar.setBackground(new java.awt.Color(143, 5, 30));
        jBActivar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBActivar.setForeground(new java.awt.Color(255, 255, 255));
        jBActivar.setText("Activar");
        jBActivar.setToolTipText("");
        jBActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActivarActionPerformed(evt);
            }
        });

        jTNombreIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreIN.setText("Ingrese el nombre");
        jTNombreIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreINMouseClicked(evt);
            }
        });

        jTModeloIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTModeloIN.setText("Ingrese el modelo");
        jTModeloIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTModeloINMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTTimeIn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTModeloIN, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreIN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jTConstanteModIN))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBModificar)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBEliminar)
                            .addComponent(jBActivar)))
                    .addComponent(jBIngresar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBIngresar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTModeloIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBModificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTConstanteModIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBActivar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(143, 5, 30));
        jLabel2.setText("Productos");

        jLUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLUser.setText("Bienvenido: User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUser)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(437, 437, 437)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLUser)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
        boolean bandTime = false, bandMOD = false, bandProduct = false;
        double timeIn = 0, MOD = 0;
        
        String nombre = this.jTNombreIN.getText();
        String modelo = this.jTModeloIN.getText();
        try {
            timeIn = Double.parseDouble(this.jTTimeIn.getText());
            if (timeIn >-1) {
                bandTime = true;
            }
        } catch (Exception e) {
        }
        
        try {
            MOD = Double.parseDouble(this.jTConstanteModIN.getText());
            if (MOD >-1) {
                bandMOD = true;
            }
        } catch (Exception e) {
        }
        
        
        //se evalua si no vienen letras o si son negativos
        if (bandMOD && bandTime) {
            //busca si hay productos repetidos
            for (int i = 0; i < lProducts.size(); i++) {
                if (nombre.toLowerCase().equals(lProducts.get(i).getNombre().toLowerCase()) &&
                    modelo.toLowerCase().equals(lProducts.get(i).getModelo().toLowerCase())) {
                    
                    bandProduct = true;
                    break;
                }
            }
            
            //evaluacion del resultado de productos repetidos
            if (!bandProduct) {   
                //evalua si el campo vien vacio
                if (!nombre.equals("Ingrese el nombre") && nombre.trim().length() > 0 &&
                    !modelo.equals("Ingrese el modelo") && modelo.trim().length() > 0) {

                    //carga el objeto 
                    product = new Product(nombre, modelo, timeIn, MOD);
                    
                    //inserta el objetos a la bd
                    if (productDAO.insert(product)) {
                        JOptionPane.showMessageDialog(null, "El producto se ingresó exitosamente");
                        this.cargar_table();
                        this.limpiar(); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al insertar el producto");
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "No puedde dejar los campos vacios");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El producto ya existe");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Los valores de time y MOD deben ser números positivos \n"
                                                             + "y no beben ser letras");
        }

    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jTNombreINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreINMouseClicked
        if (this.jTNombreIN.getText().equals("Ingrese el nombre")) {
            this.jTNombreIN.setText("");
        }
    }//GEN-LAST:event_jTNombreINMouseClicked

    private void jTModeloINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTModeloINMouseClicked
        if (this.jTModeloIN.getText().equals("Ingrese el modelo")) {
            this.jTModeloIN.setText("");
        }
    }//GEN-LAST:event_jTModeloINMouseClicked

    private void jTTimeInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTimeInMouseClicked
        if (this.jTTimeIn.getText().equals("Ingrese el time in")) {
            this.jTTimeIn.setText("");
        }
    }//GEN-LAST:event_jTTimeInMouseClicked

    private void jTConstanteModINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConstanteModINMouseClicked
        if (this.jTConstanteModIN.getText().equals("Ingrese el MOD")) {
            this.jTConstanteModIN.setText("");
        }
    }//GEN-LAST:event_jTConstanteModINMouseClicked

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        try {
            if(this.jTableProducts.getSelectedRow() > -1){
                //activar los botones de actualizar y eliminar
                this.jBIngresar.setEnabled(false);
                this.jBModificar.setEnabled(true);
                this.jBEliminar.setEnabled(true);
                this.jBActivar.setEnabled(true);
                
                int index = this.jTableProducts.getSelectedRow();
                
                idProducto = this.lProducts.get(index).getProduct_id();
                this.jTNombreCombination.setText(((DefaultTableModel)this.jTableProducts.getModel()).getValueAt(index, 0).toString());
                this.jTNombreIN.setText(((DefaultTableModel)this.jTableProducts.getModel()).getValueAt(index, 0).toString());
                this.jTModeloIN.setText(((DefaultTableModel)this.jTableProducts.getModel()).getValueAt(index, 1).toString());
                this.jTTimeIn.setText(((DefaultTableModel)this.jTableProducts.getModel()).getValueAt(index, 2).toString());
                this.jTConstanteModIN.setText(((DefaultTableModel)this.jTableProducts.getModel()).getValueAt(index, 3).toString()); 
                
                //cargar la tabla de materiales para agregar los materiales que crean el producto
                this.cargarTableMaterial();
                this.cargarTableCombinationIdProduct(idProducto);
                this.jBBuscarMaterial.setEnabled(true);
                this.jTBuscarMaterial.setEditable(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?" ,"Confirmar", JOptionPane.YES_NO_OPTION);
                
        if (response == JOptionPane.YES_OPTION) {
            if (productDAO.delete(idProducto)) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se canceló la accción eliminar el producto");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActivarActionPerformed
    int response = JOptionPane.showConfirmDialog(null, "¿Desea activar el producto?","Confirmar", JOptionPane.YES_NO_OPTION);
                
    if (response == JOptionPane.YES_OPTION) {
        if (productDAO.delete(idProducto)) {
            JOptionPane.showMessageDialog(null, "Se reactivado correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al reactivar");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Se canceló la accción activar el producto");
    }   
    }//GEN-LAST:event_jBActivarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
    boolean bandTime = false, bandMOD = false, bandProduct = false;
        double timeIn = 0, MOD = 0;
        
        String nombre = this.jTNombreIN.getText();
        String modelo = this.jTModeloIN.getText();
        try {
            timeIn = Double.parseDouble(this.jTTimeIn.getText());
            if (timeIn >-1) {
                bandTime = true;
            }
        } catch (Exception e) {
        }
        
        try {
            MOD = Double.parseDouble(this.jTConstanteModIN.getText());
            if (MOD >-1) {
                bandMOD = true;
            }
        } catch (Exception e) {
        }
        
        
        //se evalua si no vienen letras o si son negativos
        if (bandMOD && bandTime) {
            //busca si hay productos repetidos

            //evalua si el campo vien vacio
            if (!nombre.equals("Ingrese el nombre") && nombre.trim().length() > 0 &&
                !modelo.equals("Ingrese el modelo") && modelo.trim().length() > 0) {

                //carga el objeto 
                product = new Product(idProducto, nombre, modelo, timeIn, MOD);

                int response = JOptionPane.showConfirmDialog(null, "¿Desea modificar el producto?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    //inserta el objetos a la bd
                    if (productDAO.insert(product)) {
                        JOptionPane.showMessageDialog(null, "El producto se modificó exitosamente");
                        this.cargar_table();
                        this.limpiar(); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al modificar el producto");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Se canceló la accción modificar el producto");
                }


            }else{
                JOptionPane.showMessageDialog(null, "No puedde dejar los campos vacios");
            }            
        }
        else{
            JOptionPane.showMessageDialog(null, "Los valores de time y MOD deben ser números positivos \n"
                                                             + "y no beben ser letras");
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String nombreBuscar = this.jTBuscarNombre.getText();
        
        if (!nombreBuscar.equals("Ingrese el nombre") && nombreBuscar.trim().length() > 0) {
            this.cargarTableNombre(nombreBuscar);
        }
        else{
            JOptionPane.showMessageDialog(null, "No ha ingresado nombre en el campo");
        }
        
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTBuscarNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBuscarNombreMouseClicked
        if (this.jTBuscarNombre.getText().equals("Ingrese el nombre a buscar")) {
            this.jTBuscarNombre.setText("");
        }
    }//GEN-LAST:event_jTBuscarNombreMouseClicked

    private void jTNombreCombinationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreCombinationMouseClicked
      
    }//GEN-LAST:event_jTNombreCombinationMouseClicked

    private void jTableMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMaterialMouseClicked
        try {
            materialAgg = new Material();
            if(this.jTableProducts.getSelectedRow() > -1){
                //activar los botones de actualizar y eliminar
                this.jBAgregarMaterial.setEnabled(true);
                
                int index = this.jTableMaterial.getSelectedRow();
                
                
                //id de la lista
                materialAgg.setMaterial_id(this.lMateriales.get(index).getMaterial_id());
                
                this.jTBuscarMaterial.setText(((DefaultTableModel)this.jTableMaterial.getModel()).getValueAt(index, 0).toString());
                
                materialAgg.setNombre(((DefaultTableModel)this.jTableMaterial.getModel()).getValueAt(index, 0).toString());
                materialAgg.setPulgada(lMateriales.get(index).getPulgada());
                materialAgg.setCms(lMateriales.get(index).getCms());
                materialAgg.setPrecio(lMateriales.get(index).getPrecio());
                materialAgg.setPintura_empaque(lMateriales.get(index).getPintura_empaque());
                //estado de la lista
                materialAgg.setEstado(lMateriales.get(index).getEstado());
                //activar el boton de crear producto
                this.jBAgregarMaterial.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableMaterialMouseClicked

    private void jTBuscarMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBuscarMaterialMouseClicked
        if (this.jTBuscarMaterial.getText().equals("Ingrese el material")) {
            this.jTBuscarMaterial.setText("");
        }
    }//GEN-LAST:event_jTBuscarMaterialMouseClicked

    private void jBBuscarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarMaterialActionPerformed
        String nombre = this.jTBuscarMaterial.getText();
        
        if (!nombre.equals("Ingrese el material") && nombre.trim().length()>0) {
            this.cargarTableMaterialNombre(nombre);
        }
        else{
            JOptionPane.showMessageDialog(null, "No ha el material a buscar");
        }
    }//GEN-LAST:event_jBBuscarMaterialActionPerformed

    private void jTableCombinationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCombinationMouseClicked
try {
            if(this.jTableProducts.getSelectedRow() > -1){
                //activar los botones de actualizar y eliminar
                this.jBAgregarMaterial.setEnabled(true);
                
                int index = this.jTableCombination.getSelectedRow();
                
                
                idCombination = index;
                
                //activar el boton de crear producto
                this.jBEliminarCombination.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla");
            }
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_jTableCombinationMouseClicked

    private void jBCrearCombinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearCombinationActionPerformed
        boolean bandCombination = false;
        
        //SE ELIMINAN LOS DATOS QUE YA ESTABAN EN LA COMBINACION
        if (bandCombiTable) {
            for (int i = 0; i < lcombination.size(); i++) {
                for (int j = 0; j < lcombination.size(); j++) {
                    if (lcombination.get(j).getUseId() != 0) {
                        lcombination.remove(j);
                    }
                }
            }
        }
        
        //SE EVALUA SI LA COMBINACION VIENE VACIA Y LIMPIA DE LOS QUE YA ESTAN INGRESADOS
        if (lcombination.size()>0) {
            for (int i = 0; i < lcombination.size(); i++) {
                combinatino = new Combination( idProducto, lcombination.get(i).getMaterial_id());
                if (combinatinoDAO.insert(combinatino)) {
                    bandCombination = true;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No se han ingresado materiales para creal el producto");
        }
    
        
        //SE EVALUA SI SE INGRESO LA COMBINACION
        if (bandCombination) {
            JOptionPane.showMessageDialog(null, "Se ingreso exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al ingresar");
        }
    }//GEN-LAST:event_jBCrearCombinationActionPerformed

    private void jBAgregarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarMaterialActionPerformed
        boolean bandMaterial = false;
        if (lcombination.size() > 0) {
            for (int i = 0; i < lcombination.size(); i++) {
                if (materialAgg.getMaterial_id() == lcombination.get(i).getMaterial_id()) {
                    bandMaterial = true;
                    break;
                }
            }
        }
        
        if (!bandMaterial) {
            lcombination.add(materialAgg);
            this.jBCrearCombination.setEnabled(true);
            this.cargarTableCombination();
        }
        else{
            JOptionPane.showMessageDialog(null, "El material ya se ha agregado al producto");
        }

    }//GEN-LAST:event_jBAgregarMaterialActionPerformed

    private void jBEliminarCombinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarCombinationActionPerformed
        if (lcombination.size() > 0) {
            if (bandCombiTable) {
                if (lcombination.get(idCombination).getUseId() == 0) {
                    lcombination.remove(idCombination);
                    JOptionPane.showMessageDialog(null, "Se elimnio pero no esta en bd");
                }
                else{
                    if (combinatinoDAO.delete(lcombination.get(idCombination).getUseId())) {
                        lcombination.remove(idCombination);
                        JOptionPane.showMessageDialog(null, "El material se elimino de la combinación que estaba guarda");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al eliminar la combinacion de la base de datos");
                    }
                }
            }
            this.jBCrearCombination.setEnabled(false);
        }
        this.cargarTableCombination();
        this.jBEliminarCombination.setEnabled(false);
        
        
    }//GEN-LAST:event_jBEliminarCombinationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActivar;
    private javax.swing.JButton jBAgregarMaterial;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarMaterial;
    private javax.swing.JButton jBCrearCombination;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarCombination;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JLabel jLUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTBuscarMaterial;
    private javax.swing.JTextField jTBuscarNombre;
    private javax.swing.JTextField jTConstanteModIN;
    private javax.swing.JTextField jTModeloIN;
    private javax.swing.JTextField jTNombreCombination;
    private javax.swing.JTextField jTNombreIN;
    private javax.swing.JTextField jTTimeIn;
    private javax.swing.JTable jTableCombination;
    private javax.swing.JTable jTableMaterial;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}

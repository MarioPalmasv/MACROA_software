/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelsAdmin;

import classes.Product;
import classes.ProductOrder;
import classes.ProductionOrderDetail;
import classesDAO.ProductDAO;
import classesDAO.ProductOrderDAO;
import classesDAO.production_order_detailDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Panel_ordenes extends javax.swing.JPanel {

    
    int id_user, idOrder; 
    String nombre_user, pass_user, state;
    
    DefaultTableModel modelOrder;
    List<ProductOrder> lordenes;
    ProductOrderDAO orderDao;
    
    DefaultTableModel modelProd;
    List<Product> lProd;
    ProductDAO prodDao;
    
    DefaultTableModel modelProdAgg;
    List<Product> lProdAgg;
    List<String[]> lProdDetalle;
    
    
    public Panel_ordenes(int id, String nombre, String pass) {
        initComponents();
        
        id_user = id;
        nombre_user = nombre;
        pass_user = pass;
        
        modelOrder = new DefaultTableModel();
        lordenes = new ArrayList<>();
        orderDao = new ProductOrderDAO();
        
        modelProd = new DefaultTableModel();
        lProd = new ArrayList<>();
        prodDao = new ProductDAO();
        
        modelProdAgg = new DefaultTableModel();
        lProdAgg = new ArrayList<>();
        lProdDetalle = new ArrayList<>();
        
        this.CargarOrdenes();
        this.CargarProductos();
        this.CargarListProdAgg();
        this.CargarListProdAgg();
    }
    
    void CargarOrdenes(){
        modelOrder.setRowCount(0);
        String[] nombreColum = {"Nombre", "Fecha de Orden", "Comentario", "Estado"};
        modelOrder.setColumnIdentifiers(nombreColum);
        
        lordenes = orderDao.ListarOrdenes();
      
        if (lordenes.size()>-1) {
            for (int i = 0; i < lordenes.size(); i++) {
                if (lordenes.get(i).getState().equals("a")) {
                    modelOrder.addRow(new Object[]{lordenes.get(i).getNombre(),lordenes.get(i).getOrder_date() ,
                        lordenes.get(i).getComent(), "Activa"});
                }
                else{
                    modelOrder.addRow(new Object[]{lordenes.get(i).getNombre(),lordenes.get(i).getOrder_date() ,
                        lordenes.get(i).getComent(), "Cancelada"});
                }
            }
            this.jTableOrdenes.setModel(modelOrder);
            this.jTableOrdenes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableOrdenes.setFillsViewportHeight(true);
        }
    }
    
    void CargarProductos(){
        modelProd.setRowCount(0);
        String[] nombreColum = {"Nombre", "Modelo"};
        modelProd.setColumnIdentifiers(nombreColum);
        
        lProd = prodDao.ListarProdcut();
      
        if (lProd.size()>-1) {
            for (int i = 0; i < lProd.size(); i++) {
                if (lProd.get(i).getState().equals("a")) {
                    modelProd.addRow(new Object[]{lProd.get(i).getNombre(),lProd.get(i).getModelo()});
                }
            }
            this.jTableProducts.setModel(modelProd);
            this.jTableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableProducts.setFillsViewportHeight(true);
        }
    }
    
    void cargarTableProdNombre(String pNombre){
        modelProd.setRowCount(0);
        String[] nombreColum = {"Nombre", "Modelo"};
        modelProd.setColumnIdentifiers(nombreColum);
        
        lProd = prodDao.ListarProdcutNombre(pNombre);
      
        if (lProd.size()>-1) {
            for (int i = 0; i < lProd.size(); i++) {
                if (lProd.get(i).getState().equals("a")) {
                    modelProd.addRow(new Object[]{lProd.get(i).getNombre(),lProd.get(i).getModelo()});
                }
            }
            this.jTableProducts.setModel(modelProd);
            this.jTableProducts.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableProducts.setFillsViewportHeight(true);
        }
    }
    
    void CargarListProdAgg(){
        modelProdAgg.setRowCount(0);
        String[] nombreColum = {"Nombre", "Cantidad", "Cola cromada"};
        modelProdAgg.setColumnIdentifiers(nombreColum);
      
        if (lProdDetalle.size()>-1) { 
            for (Object[] arreglo : lProdDetalle) {
                modelProdAgg.addRow(arreglo);
            }

            this.jTableProdOrd.setModel(modelProdAgg);
            this.jTableProdOrd.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableProdOrd.setFillsViewportHeight(true);
        }
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
        jTNombreOrdenIN = new javax.swing.JTextField();
        JTComentIn = new javax.swing.JTextField();
        jBAgregarOrden = new javax.swing.JButton();
        jBModificarOrdan = new javax.swing.JButton();
        jBCancelarOrden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrdenes = new javax.swing.JTable();
        jTBuscarNombre = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProdOrd = new javax.swing.JTable();
        jBAgregarProd = new javax.swing.JButton();
        jBModificarProd = new javax.swing.JButton();
        jTCantidad = new javax.swing.JTextField();
        jTColaCromada = new javax.swing.JTextField();
        jBActOrden = new javax.swing.JButton();
        jBEliminarProd = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 190, 186));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel1.setText("Productos");

        jTNombreOrdenIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreOrdenIN.setText("Ingrese el nombre de la orden");

        JTComentIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTComentIn.setText("Ingrese comentario");

        jBAgregarOrden.setBackground(new java.awt.Color(95, 207, 95));
        jBAgregarOrden.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAgregarOrden.setText("Agregar ");
        jBAgregarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarOrdenActionPerformed(evt);
            }
        });

        jBModificarOrdan.setBackground(new java.awt.Color(101, 150, 247));
        jBModificarOrdan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBModificarOrdan.setText("Modificar");
        jBModificarOrdan.setEnabled(false);
        jBModificarOrdan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarOrdanActionPerformed(evt);
            }
        });

        jBCancelarOrden.setBackground(new java.awt.Color(239, 151, 85));
        jBCancelarOrden.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBCancelarOrden.setText("Cancelar");
        jBCancelarOrden.setEnabled(false);
        jBCancelarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarOrdenActionPerformed(evt);
            }
        });

        jTableOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrdenesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrdenes);

        jTBuscarNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTBuscarNombre.setText("Ingrese el nombre a buscar");

        jBBuscar.setBackground(new java.awt.Color(255, 255, 106));
        jBBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        jScrollPane2.setViewportView(jTableProducts);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel2.setText("Órdenes");

        jLabel3.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel3.setText("Productos añadidos");

        jTableProdOrd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableProdOrd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProdOrd.setRowHeight(30);
        jTableProdOrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdOrdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProdOrd);

        jBAgregarProd.setBackground(new java.awt.Color(95, 207, 95));
        jBAgregarProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAgregarProd.setText("Agregar ");
        jBAgregarProd.setEnabled(false);
        jBAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarProdActionPerformed(evt);
            }
        });

        jBModificarProd.setBackground(new java.awt.Color(101, 150, 247));
        jBModificarProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBModificarProd.setText("Modificar");
        jBModificarProd.setEnabled(false);
        jBModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarProdActionPerformed(evt);
            }
        });

        jTCantidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTCantidad.setText("Cantidad");
        jTCantidad.setEnabled(false);

        jTColaCromada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTColaCromada.setText("Costo de cola cromada");
        jTColaCromada.setEnabled(false);

        jBActOrden.setBackground(new java.awt.Color(255, 117, 117));
        jBActOrden.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBActOrden.setText("Activar");
        jBActOrden.setEnabled(false);
        jBActOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActOrdenActionPerformed(evt);
            }
        });

        jBEliminarProd.setBackground(new java.awt.Color(176, 124, 174));
        jBEliminarProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBEliminarProd.setText("Eliminar Producto");
        jBEliminarProd.setEnabled(false);
        jBEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(789, 789, 789))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBAgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBModificarProd))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTBuscarNombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTColaCromada, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBAgregarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jBModificarOrdan)
                                            .addComponent(jLabel1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBCancelarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTNombreOrdenIN)
                            .addComponent(JTComentIn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBEliminarProd)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBActOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(440, 440, 440))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTNombreOrdenIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTComentIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAgregarOrden)
                            .addComponent(jBModificarOrdan)
                            .addComponent(jBCancelarOrden))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBBuscar)
                            .addComponent(jTBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBActOrden)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTColaCromada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBEliminarProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarProd)
                    .addComponent(jBModificarProd))
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarOrdenActionPerformed
        String nombreOrden = "", comentario = "";
        ProductOrder order;
        production_order_detailDAO detalledao = new production_order_detailDAO();
        ProductionOrderDetail detalleorden;
        int idordenult, cant = 0, idprod;
        Double cola_cromada = 0.0, subtotal = 0.0;
        
        if(!lProdDetalle.isEmpty()){
            nombreOrden = this.jTNombreOrdenIN.getText();
            comentario = this.JTComentIn.getText();

            if(!nombreOrden.equals("Ingrese el nombre de la orden") || nombreOrden.length()>0){
                if(!comentario.equals("Ingrese comentario") || comentario.length()>0){
                    order = new ProductOrder(this.id_user, nombreOrden, comentario);

                    if(orderDao.insert(order)){
                        
                        this.CargarOrdenes();
                        idordenult = orderDao.getProductOrderId();
                        for (int i = 0; i < lProdAgg.size(); i++) {
                            try{
                                cant = Integer.parseInt(this.lProdDetalle.get(i)[1]);
                            }catch(Exception e){
                                cant = 0;
                            }

                            try{
                                cola_cromada = Double.valueOf(this.lProdDetalle.get(i)[2]);
                            }catch(Exception e){
                                cola_cromada = 0.0;
                            }
                            if(cant >-1){
                                idprod = lProdAgg.get(i).getProduct_id();
                                subtotal = detalledao.getProductPriceById(idprod);
                                detalleorden = new ProductionOrderDetail(idprod, idordenult, cant,
                                        subtotal, cola_cromada, "a");
                                if(detalledao.insert(detalleorden)){
                                    System.out.print("Se inserto " + i);
                                    
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Error.");
                            }
                            
                        }
                        
                        JOptionPane.showMessageDialog(null, "La orden ha sido ingresada");
                        lProdAgg.clear();
                        lProdDetalle.clear();
                        this.CargarListProdAgg();
                        this.JTComentIn.setText("Ingrese comentario");
                        this.jTNombreOrdenIN.setText("Ingrese nombre de orden");
                    } else{
                     
                        JOptionPane.showMessageDialog(null, "No se ha logrado ingresar la orden.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese la informacion de forma correcta.");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Ingrese la informacion de forma correcta.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe agregar productos a la orden.");
        }
        
    }//GEN-LAST:event_jBAgregarOrdenActionPerformed

    private void jTableOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdenesMouseClicked
        String nombreOrden = "", comentario = "";
        
        if(this.jTableOrdenes.getSelectedRow() > -1){
            this.jBModificarOrdan.setEnabled(true);
            this.jBAgregarOrden.setEnabled(false);
            
            int index = this.jTableOrdenes.getSelectedRow();
            
            if(this.lordenes.get(index).getState().equals("a")){
                this.jBCancelarOrden.setEnabled(true);
                this.jBActOrden.setEnabled(false);
            }else{
                this.jBCancelarOrden.setEnabled(false);
                this.jBActOrden.setEnabled(true);
            }
                
            idOrder = this.lordenes.get(index).getProduction_order_id();
            state = this.lordenes.get(index).getState();
            nombreOrden = this.jTableOrdenes.getModel().getValueAt(index,0).toString();
            comentario = this.jTableOrdenes.getModel().getValueAt(index,2).toString();
            
            this.jTNombreOrdenIN.setText(nombreOrden);
            this.JTComentIn.setText(comentario);
            
        } else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }//GEN-LAST:event_jTableOrdenesMouseClicked

    private void jBModificarOrdanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarOrdanActionPerformed
        String nombreOrden = "", comentario = "";
        ProductOrder order;
        
        nombreOrden = this.jTNombreOrdenIN.getText();
        comentario = this.JTComentIn.getText();
        
        if(!nombreOrden.equals("Ingrese el nombre de la orden") || nombreOrden.length()>0){
            if(!comentario.equals("Ingrese comentario") || comentario.length()>0){
                
                order = new ProductOrder(idOrder, this.id_user, nombreOrden, comentario, state);
                int response = JOptionPane.showConfirmDialog(null, "¿Desea modificar la orden?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    
                    if(orderDao.update(order)){
                    JOptionPane.showMessageDialog(null, "La orden ha sido modificada");
                    this.CargarOrdenes();
                    this.jBAgregarOrden.setEnabled(true);
                    this.jBModificarOrdan.setEnabled(false);
                    this.jBCancelarOrden.setEnabled(false);
                    this.jBActOrden.setEnabled(false);
                    //colocar en el text field ingresar y todo eso
                } else{
                    //no se pudo, borrar lo del textfield y colocar de nuevo el ingrese nombre y eso
                    JOptionPane.showMessageDialog(null, "No se ha logrado modifcar la orden.");
                }
                } else {
                    JOptionPane.showMessageDialog(null, "Se canceló la accción modificar la orden");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese la informacion de forma correcta.");
            }
        } else{
            JOptionPane.showMessageDialog(null, "Ingrese la informacion de forma correcta.");
        }
    }//GEN-LAST:event_jBModificarOrdanActionPerformed

    private void jBCancelarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarOrdenActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la orden?" ,"Confirmar", JOptionPane.YES_NO_OPTION);
                
        if (response == JOptionPane.YES_OPTION) {
            if (orderDao.delete(idOrder)) {
                JOptionPane.showMessageDialog(null, "Se ha cancelado la orden correctamente");
                this.CargarOrdenes();
                this.jBAgregarOrden.setEnabled(true);
                this.jBModificarOrdan.setEnabled(false);
                this.jBCancelarOrden.setEnabled(false);
                this.jBActOrden.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al cancelar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se canceló la accción eliminar la orden");
        }
    }//GEN-LAST:event_jBCancelarOrdenActionPerformed

    private void jBActOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActOrdenActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Desea activar la orden?" ,"Confirmar", JOptionPane.YES_NO_OPTION);
                
        if (response == JOptionPane.YES_OPTION) {
            if (orderDao.delete(idOrder)) {
                JOptionPane.showMessageDialog(null, "Se ha activado la orden correctamente");
                this.CargarOrdenes();
                this.jBAgregarOrden.setEnabled(true);
                this.jBModificarOrdan.setEnabled(false);
                this.jBCancelarOrden.setEnabled(false);
                this.jBActOrden.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al activar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Se canceló la accción activar la orden");
        }
    }//GEN-LAST:event_jBActOrdenActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String nombreBuscar = this.jTBuscarNombre.getText();
        
        if (!nombreBuscar.equals("Ingrese el nombre") && nombreBuscar.trim().length() > 0) {
            this.cargarTableProdNombre(nombreBuscar);
        }
        else{
            JOptionPane.showMessageDialog(null, "No ha ingresado nombre en el campo");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarProdActionPerformed
        int cantidad = 0;
        Double cola_cromada = 0.0;
        
        if(this.jTableProducts.getSelectedRow() > -1){
            try{
                cantidad = Integer.parseInt(this.jTCantidad.getText());
            }catch(Exception e){
                cantidad = 0;
            }

            try{
                cola_cromada = Double.parseDouble(this.jTColaCromada.getText());
            }catch(Exception e){
                cola_cromada = 0.0;
            }
            
            int index = this.jTableProducts.getSelectedRow();
            String nombreProd = this.jTableProducts.getModel().getValueAt(index, 0).toString();
            
            if(cantidad > 0){
                String[] arreglo = {nombreProd, Integer.toString(cantidad), Double.toString(cola_cromada)};
                lProdDetalle.add(arreglo);
                Product prod = new Product(this.lProd.get(index).getProduct_id(), 
                        this.lProd.get(index).getNombre(), 
                        this.lProd.get(index).getModelo(),
                        this.lProd.get(index).getState(),
                        this.lProd.get(index).getTime_in(),
                        this.lProd.get(index).getConstante_mod());
                lProdAgg.add(prod);
                this.CargarListProdAgg();
                this.jTCantidad.setText("Cantidad");
                this.jTColaCromada.setText("Costo de cola cromada");
            } else{
                JOptionPane.showMessageDialog(null, "Error al ingresar la informacion de datos.");
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Error al ingresar la informacion");
        }
    }//GEN-LAST:event_jBAgregarProdActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        if(this.jTableProducts.getSelectedRow() > -1){
            this.jBAgregarProd.setEnabled(true);
            this.jTCantidad.setEnabled(true);
            this.jTColaCromada.setEnabled(true);
        }
    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jTableProdOrdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdOrdMouseClicked
        if(this.jTableProdOrd.getSelectedRow() > -1){
            this.jBAgregarProd.setEnabled(false);
            this.jBModificarProd.setEnabled(true);
            this.jBEliminarProd.setEnabled(true);
            int index = this.jTableProdOrd.getSelectedRow();
            
            this.jTCantidad.setText(this.jTableProdOrd.getModel().getValueAt(index, 1).toString());
            this.jTColaCromada.setText(this.jTableProdOrd.getModel().getValueAt(index, 2).toString());
        }
    }//GEN-LAST:event_jTableProdOrdMouseClicked

    private void jBModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarProdActionPerformed
        int cantidad = 0;
        Double cola_cromada = 0.0;
        
        if(this.jTableProducts.getSelectedRow() > -1){
            try{
                cantidad = Integer.parseInt(this.jTCantidad.getText());
            }catch(Exception e){
                cantidad = -1;
            }

            try{
                cola_cromada = Double.parseDouble(this.jTColaCromada.getText());
            }catch(Exception e){
                cola_cromada = 0.0;
            }
            
            int index = this.jTableProdOrd.getSelectedRow();
            String nombreProd = this.jTableProducts.getModel().getValueAt(index, 0).toString();
            
            if(cantidad > 0){
                this.lProdDetalle.get(index)[0] = nombreProd;
                this.lProdDetalle.get(index)[1] = this.jTCantidad.getText();
                this.lProdDetalle.get(index)[2] = this.jTColaCromada.getText();
                this.CargarListProdAgg();
            } else{
                JOptionPane.showMessageDialog(null, "Error al ingresar la informacion de datos.");
            }
            
        } else{
            JOptionPane.showMessageDialog(null, "Error al ingresar la informacion");
        }
    }//GEN-LAST:event_jBModificarProdActionPerformed

    private void jBEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarProdActionPerformed
        if(this.jTableProdOrd.getSelectedRow() > -1){
            int index = this.jTableProdOrd.getSelectedRow();
            
            this.lProdAgg.remove(index);
            this.lProdDetalle.remove(index);
            this.CargarListProdAgg();
        }
    }//GEN-LAST:event_jBEliminarProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTComentIn;
    private javax.swing.JButton jBActOrden;
    private javax.swing.JButton jBAgregarOrden;
    private javax.swing.JButton jBAgregarProd;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelarOrden;
    private javax.swing.JButton jBEliminarProd;
    private javax.swing.JButton jBModificarOrdan;
    private javax.swing.JButton jBModificarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTBuscarNombre;
    private javax.swing.JTextField jTCantidad;
    private javax.swing.JTextField jTColaCromada;
    private javax.swing.JTextField jTNombreOrdenIN;
    private javax.swing.JTable jTableOrdenes;
    private javax.swing.JTable jTableProdOrd;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}

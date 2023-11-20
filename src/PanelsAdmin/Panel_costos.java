/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelsAdmin;

import classes.OrderCost;
import classes.ProductOrder;
import classes.ProductionOrderDetail;
import classes.Taxe;
import classes.TaxeUse;
import classesDAO.OrderCostDAO;
import classesDAO.ProductOrderDAO;
import classesDAO.TaxeDAO;
import classesDAO.TaxeUseDAO;
import classesDAO.production_order_detailDAO;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mario
 */
public class Panel_costos extends javax.swing.JPanel {

    Taxe taxe;
    TaxeDAO taxeDAO;
    
    //listas
    List<Taxe> lTaxe;
    
    boolean bandporcentaje;
    double porcentaje;
    DefaultTableModel model;
    
    DefaultTableModel modelImp;
    List<Taxe> lImpAg;
    
    DefaultTableModel modelOrder;
    List<ProductOrder> lOrdenes;
    ProductOrderDAO orderDAO;
    
    DefaultTableModel modelDetalle;
    List<ProductionOrderDetail> lDetalle;
    production_order_detailDAO detalleDAO;
    
    List<TaxeUse> lTaxeUse;
    TaxeUseDAO taxUseDao;
    
    int id;
    
    
    int id_user;
    String nombre_user, pass_user;
    
    public Panel_costos(int id, String nombre, String pass) {
        initComponents();
        bandporcentaje = false;
        porcentaje = 0;
        model = new DefaultTableModel();
        taxeDAO = new TaxeDAO();
        modelImp = new DefaultTableModel();
        modelOrder = new DefaultTableModel();
        orderDAO = new ProductOrderDAO();
        
        modelDetalle = new DefaultTableModel();
        lDetalle = new ArrayList<>();
        detalleDAO = new production_order_detailDAO();
        
        lImpAg = new ArrayList<>();
        lOrdenes = new ArrayList<>();
        
        lTaxeUse = new ArrayList<>();
        taxUseDao = new TaxeUseDAO();
        
        
        this.cargar_table();
        this.cargarTablaImpAgg();
        this.cargarTablaOrdenes();
        this.cargarTablaDetalles();
        
        
        //variable para el update o delete
        id = 0;
        
        id_user = id;
        nombre_user = nombre;
        pass_user = pass;
        
    }
    
    void cargar_table(){
        model.setRowCount(0);
        String[] nombreColum = {"Impuesto", "Porcentaje", "Valor en decimal"};
        model.setColumnIdentifiers(nombreColum);
        
        try {
            lTaxe = taxeDAO.listarTaxe();
            
            if (lTaxe.size()>-1) {
                for (int i = 0; i < lTaxe.size(); i++) {
                    model.addRow(new Object[]{lTaxe.get(i).getNAME(), lTaxe.get(i).getPercentage(), lTaxe.get(i).getVALUE()});
                }
                this.jTableImpuestos.setModel(model);
                this.jTableImpuestos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableImpuestos.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void cargar_tableNombre(String pNombre){
        model.setRowCount(0);
        String[] nombreColum = {"Impuesto", "Porcentaje", "Valor en decimal"};
        model.setColumnIdentifiers(nombreColum);
        
        try {
            lTaxe = taxeDAO.listarTaxeNombre(pNombre);
            
            if (lTaxe.size()>-1) {
                for (int i = 0; i < lTaxe.size(); i++) {
                    model.addRow(new Object[]{lTaxe.get(i).getNAME(), lTaxe.get(i).getPercentage(), lTaxe.get(i).getVALUE()});
                }
                this.jTableImpuestos.setModel(model);
                this.jTableImpuestos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableImpuestos.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void cargarTablaImpAgg(){
        modelImp.setRowCount(0);
        String[] nombreColum = {"Impuesto", "Valor en decimal"};
        modelImp.setColumnIdentifiers(nombreColum);
        
        try {
            
            if (lImpAg.size()>-1) {
                for (int i = 0; i < lImpAg.size(); i++) {
                    modelImp.addRow(new Object[]{lImpAg.get(i).getNAME(), lTaxe.get(i).getVALUE()});
                }
                this.jTableImpuiestosAgg.setModel(modelImp);
                this.jTableImpuiestosAgg.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableImpuiestosAgg.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void cargarTablaOrdenes(){
        modelOrder.setRowCount(0);
        String[] nombreColum = {"Nombre", "Fecha"};
        modelOrder.setColumnIdentifiers(nombreColum);
        
        try {
            lOrdenes = orderDAO.ListarOrdenes();
            
            if (lOrdenes.size()>-1) {
                for (int i = 0; i < lOrdenes.size(); i++) {
                    modelOrder.addRow(new Object[]{ lOrdenes.get(i).getNombre(), lOrdenes.get(i).getOrder_date()});
                }
                this.jTableOrden.setModel(modelOrder);
                this.jTableOrden.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableOrden.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void cargarTablaDetalles(){
        modelDetalle.setRowCount(0);
        String[] nombreColum = {"Producto", "Cantidad", "Costos de materia", "Costo de cola cromada"};
        modelDetalle.setColumnIdentifiers(nombreColum);
        
        try {
            
            if (lDetalle.size()>-1) {
                for (int i = 0; i < lDetalle.size(); i++) {
                    if(lDetalle.get(i).getState().equals("a")){
                        modelDetalle.addRow(new Object[]{ lDetalle.get(i).getNombre_prod(), lDetalle.get(i).getQuantity(),
                        lDetalle.get(i).getSub_total(), lDetalle.get(i).getCosto_cola_cromada()});
                    }
                }
                this.jTableDetalle.setModel(modelDetalle);
                this.jTableDetalle.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableDetalle.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void cargarTableOrdenesNombre(String nombreBuscar) {
        modelOrder.setRowCount(0);
        String[] nombreColum = {"Nombre", "Fecha"};
        modelOrder.setColumnIdentifiers(nombreColum);
        
        try {
            lOrdenes = orderDAO.ListarOrdenesPorNombre(nombreBuscar);
            
            if (lOrdenes.size()>-1) {
                for (int i = 0; i < lOrdenes.size(); i++) {
                    modelOrder.addRow(new Object[]{ lOrdenes.get(i).getNombre(), lOrdenes.get(i).getOrder_date()});
                }
                this.jTableOrden.setModel(modelOrder);
                this.jTableOrden.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                this.jTableOrden.setFillsViewportHeight(true);
            }
        } catch (Exception e) {
            this.jBIngresar.setEnabled(false);
            this.jBBuscar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Error al cargar el panel de costos");
        }
    }
    
    void limpiar(){
        this.jBIngresar.setEnabled(true);
        //desactivar botones
        this.jBModificar.setEnabled(false);

        this.jTNombreIN.setText("");
        this.JTPorcentajeIN.setText("");
        this.jTDecimalIN.setText("");
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
        jTNombreBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableImpuestos = new javax.swing.JTable();
        jBAggImpuesto = new javax.swing.JButton();
        jTNombreIN = new javax.swing.JTextField();
        JTPorcentajeIN = new javax.swing.JTextField();
        jTDecimalIN = new javax.swing.JTextField();
        jBIngresar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jTNombreBuscarOrden = new javax.swing.JTextField();
        jBBuscarOrden = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrden = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableImpuiestosAgg = new javax.swing.JTable();
        jBCalcularCostoProd = new javax.swing.JButton();
        jBCalcularCostoProdAll = new javax.swing.JButton();
        jBEliminarImpuesto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 190, 186));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setText("Costos");

        jTNombreBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreBuscarMouseClicked(evt);
            }
        });

        jBBuscar.setBackground(new java.awt.Color(255, 255, 106));
        jBBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTableImpuestos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableImpuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableImpuestos.setRowHeight(35);
        jTableImpuestos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableImpuestosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableImpuestos);

        jBAggImpuesto.setBackground(new java.awt.Color(255, 117, 117));
        jBAggImpuesto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAggImpuesto.setText("Agregar impuesto a detalle");
        jBAggImpuesto.setEnabled(false);
        jBAggImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAggImpuestoActionPerformed(evt);
            }
        });

        jTNombreIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreINMouseClicked(evt);
            }
        });

        JTPorcentajeIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTPorcentajeIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTPorcentajeINMouseClicked(evt);
            }
        });
        JTPorcentajeIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTPorcentajeINActionPerformed(evt);
            }
        });
        JTPorcentajeIN.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JTPorcentajeINPropertyChange(evt);
            }
        });
        JTPorcentajeIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTPorcentajeINKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTPorcentajeINKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTPorcentajeINKeyTyped(evt);
            }
        });

        jTDecimalIN.setEditable(false);
        jTDecimalIN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jBIngresar.setBackground(new java.awt.Color(95, 207, 95));
        jBIngresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBIngresar.setText("Ingresar");
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });

        jBModificar.setBackground(new java.awt.Color(101, 150, 247));
        jBModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });

        jTNombreBuscarOrden.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNombreBuscarOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNombreBuscarOrdenMouseClicked(evt);
            }
        });

        jBBuscarOrden.setBackground(new java.awt.Color(255, 255, 106));
        jBBuscarOrden.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBBuscarOrden.setText("Buscar");
        jBBuscarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarOrdenActionPerformed(evt);
            }
        });

        jTableOrden.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableOrden.setRowHeight(35);
        jTableOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrdenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableOrden);

        jTableDetalle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDetalle.setRowHeight(35);
        jTableDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDetalleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDetalle);

        jTableImpuiestosAgg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTableImpuiestosAgg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableImpuiestosAgg.setRowHeight(35);
        jTableImpuiestosAgg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableImpuiestosAggMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableImpuiestosAgg);

        jBCalcularCostoProd.setBackground(new java.awt.Color(255, 117, 117));
        jBCalcularCostoProd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBCalcularCostoProd.setText("Calcular costo por producto");
        jBCalcularCostoProd.setEnabled(false);
        jBCalcularCostoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularCostoProdActionPerformed(evt);
            }
        });

        jBCalcularCostoProdAll.setBackground(new java.awt.Color(255, 117, 117));
        jBCalcularCostoProdAll.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBCalcularCostoProdAll.setText("Calcular costo por todos los productos");
        jBCalcularCostoProdAll.setEnabled(false);
        jBCalcularCostoProdAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularCostoProdAllActionPerformed(evt);
            }
        });

        jBEliminarImpuesto.setBackground(new java.awt.Color(228, 4, 52));
        jBEliminarImpuesto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBEliminarImpuesto.setText("Eliminar Impuesto");
        jBEliminarImpuesto.setEnabled(false);
        jBEliminarImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarImpuestoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Impact", 0, 25)); // NOI18N
        jLabel2.setText("Detalle de ordenes");

        jButton1.setBackground(new java.awt.Color(239, 151, 85));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Ingrese el porcentaje:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Ingrese el nombre del impuesto:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Valor en decimal:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ingrese el nombre del impuesto a buscar");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Buscar orden:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNombreBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTNombreIN, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                        .addComponent(JTPorcentajeIN))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jBIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBModificar)
                                            .addGap(25, 25, 25)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTDecimalIN, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBAggImpuesto)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBBuscar))
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCalcularCostoProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jBCalcularCostoProdAll)
                        .addGap(65, 65, 65)
                        .addComponent(jBEliminarImpuesto)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNombreIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTPorcentajeIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(jTDecimalIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBModificar)
                            .addComponent(jButton1)
                            .addComponent(jBAggImpuesto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNombreBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarOrden)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCalcularCostoProd)
                    .addComponent(jBCalcularCostoProdAll)
                    .addComponent(jBEliminarImpuesto))
                .addGap(97, 97, 97))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreINMouseClicked
        if (this.jTNombreIN.getText().equals("Ingrese el nombre del impuesto")) {
            this.jTNombreIN.setText("");
        }
    }//GEN-LAST:event_jTNombreINMouseClicked

    private void JTPorcentajeINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTPorcentajeINMouseClicked
        if (this.JTPorcentajeIN.getText().equals("Ingrese el porcentaje")) {
            this.JTPorcentajeIN.setText("");
        }
    }//GEN-LAST:event_JTPorcentajeINMouseClicked

    private void JTPorcentajeINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeINKeyTyped
        
    }//GEN-LAST:event_JTPorcentajeINKeyTyped

    private void JTPorcentajeINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeINKeyPressed
        
    }//GEN-LAST:event_JTPorcentajeINKeyPressed

    private void JTPorcentajeINPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JTPorcentajeINPropertyChange
        
    }//GEN-LAST:event_JTPorcentajeINPropertyChange

    private void JTPorcentajeINKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTPorcentajeINKeyReleased
        double conversion = 0;
        try {
            porcentaje = Double.parseDouble(this.JTPorcentajeIN.getText().trim());
            if (porcentaje > 0 && porcentaje <101) {
                bandporcentaje = true;
                conversion = porcentaje / 100;
            }
        } catch (Exception e) {
            bandporcentaje = false;
        }
        this.jTDecimalIN.setText(String.valueOf(conversion));
    }//GEN-LAST:event_JTPorcentajeINKeyReleased

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
        boolean bandExiste = false;
        
        String nombreImpuesto = this.jTNombreIN.getText();
        String porcen = this.JTPorcentajeIN.getText()+"%";
        porcentaje /= 100;
        
        
        
        if (bandporcentaje) {
            if (lTaxe.size() > 0) {
                for (int i = 0; i < lTaxe.size(); i++) {
                    if (nombreImpuesto.toLowerCase().equals(lTaxe.get(i).getNAME().toLowerCase())) {
                        bandExiste = true;
                    }
                }
            }
            
            if (!bandExiste) {
                if (!nombreImpuesto.equals("Ingrese el nombre del impuesto") && nombreImpuesto.trim().length() > 0) {
                    
                    taxe = new Taxe(nombreImpuesto, porcen, porcentaje);
                
                    if (taxeDAO.insert(taxe)) {
                        JOptionPane.showMessageDialog(null, "Se ingresó el impuesto");
                        this.cargar_table();
                        this.limpiar();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al ingresar el impuesto");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No puede dejar el campo de nombre de impuesto vacio");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "El impuesto existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error! El porcentaje debe estar entre 1% y 100%\n"
                                                           + "El campo de porcentaje deber ser valor numerico");
        }
    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jTableImpuestosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableImpuestosMouseClicked
    try {
        if(this.jTableImpuestos.getSelectedRow() > -1){
            //activar los botones de actualizar y eliminar
            this.jBIngresar.setEnabled(false);
            this.jBModificar.setEnabled(true);
            this.jBAggImpuesto.setEnabled(true);

            int index = this.jTableImpuestos.getSelectedRow();
            String porc = ((DefaultTableModel)this.jTableImpuestos.getModel()).getValueAt(index, 1).toString().replace("%", "");
            
            id = this.lTaxe.get(index).getTaxe_id();
            this.jTNombreIN.setText(((DefaultTableModel)this.jTableImpuestos.getModel()).getValueAt(index, 0).toString());
            
            this.JTPorcentajeIN.setText(porc);
            this.jTDecimalIN.setText(((DefaultTableModel)this.jTableImpuestos.getModel()).getValueAt(index, 2).toString());                
            
            porcentaje  = Double.parseDouble(porc.trim());
            bandporcentaje = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla");
        }
    } 
    catch (Exception e) {
    }        
    }//GEN-LAST:event_jTableImpuestosMouseClicked

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        String nombreImpuesto = this.jTNombreIN.getText();
        String porcen = this.JTPorcentajeIN.getText()+"%";
        porcentaje /= 100;
        
        
        
        if (bandporcentaje) {
            if (!nombreImpuesto.equals("Ingrese el nombre del impuesto") && nombreImpuesto.trim().length() > 0) {

                taxe = new Taxe(id, nombreImpuesto, porcen, porcentaje);

                int response = JOptionPane.showConfirmDialog(null, "¿Desea modificar el impuesto?", "Confirmar", JOptionPane.YES_NO_OPTION);
                
                if (response == JOptionPane.YES_OPTION) {
                    if (taxeDAO.update(taxe)) {
                        JOptionPane.showMessageDialog(null, "Se modificó el impuesto");
                        this.cargar_table();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al modificar el impuesto");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Se canceló la accción modificar el impuesto");
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No puede dejar el campo de nombre de impuesto vacio");
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "Error! El porcentaje debe estar entre 1% y 100%\n"
                                                           + "El campo de porcentaje deber ser valor numerico");
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void JTPorcentajeINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTPorcentajeINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTPorcentajeINActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String nombre = this.jTNombreBuscar.getText();
        
        if (!nombre.equals("") && nombre.trim().length() > 0) {
            this.cargar_tableNombre(nombre);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puede dejar el campo de buscar vacio");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTNombreBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreBuscarMouseClicked
        if (this.jTNombreBuscar.getText().equals("Ingrese el nombre del impuesto a buscar")) {
            this.jTNombreBuscar.setText("");
        }
    }//GEN-LAST:event_jTNombreBuscarMouseClicked

    private void jTNombreBuscarOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNombreBuscarOrdenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreBuscarOrdenMouseClicked

    private void jBBuscarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarOrdenActionPerformed
        String nombreBuscar = this.jTNombreBuscarOrden.getText();
        
        if (!nombreBuscar.equals("Ingrese el nombre") && nombreBuscar.trim().length() > 0) {
            this.cargarTableOrdenesNombre(nombreBuscar);
        }
        else{
            JOptionPane.showMessageDialog(null, "No ha ingresado nombre en el campo");
        }        
    }//GEN-LAST:event_jBBuscarOrdenActionPerformed

    private void jTableOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdenMouseClicked
        if(this.jTableOrden.getSelectedRow() > -1){
            int index = this.jTableOrden.getSelectedRow();
            int idOrder = lOrdenes.get(index).getProduction_order_id();
            lDetalle = detalleDAO.ListarOrderDetailsById(idOrder);
            this.cargarTablaDetalles();
        }
    }//GEN-LAST:event_jTableOrdenMouseClicked

    private void jTableDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDetalleMouseClicked
        if(this.jTableDetalle.getSelectedRow()>-1){
            this.jBCalcularCostoProd.setEnabled(true);
             this.jBCalcularCostoProdAll.setEnabled(true);
        }
    }//GEN-LAST:event_jTableDetalleMouseClicked

    private void jTableImpuiestosAggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableImpuiestosAggMouseClicked
        if(this.jTableImpuiestosAgg.getSelectedRow()>-1){
            this.jBEliminarImpuesto.setEnabled(true);
        }
    }//GEN-LAST:event_jTableImpuiestosAggMouseClicked

    private void jBAggImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAggImpuestoActionPerformed
        if(this.jTableImpuestos.getSelectedRow() > -1){
            int index = this.jTableImpuestos.getSelectedRow();
            Taxe impuestoAGG = new Taxe();
            impuestoAGG.setTaxe_id(this.lTaxe.get(index).getTaxe_id());
            impuestoAGG.setNAME(this.lTaxe.get(index).getNAME());
            impuestoAGG.setPercentage(this.lTaxe.get(index).getPercentage());
            impuestoAGG.setVALUE(this.lTaxe.get(index).getVALUE());
            
            lImpAg.add(impuestoAGG);
            this.cargarTablaImpAgg();
            this.jBIngresar.setEnabled(true);
            this.jBModificar.setEnabled(false);
            this.jBAggImpuesto.setEnabled(true);
        }
    }//GEN-LAST:event_jBAggImpuestoActionPerformed

    private void jBEliminarImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarImpuestoActionPerformed
        if(this.jTableImpuiestosAgg.getSelectedRow()>-1){
            int index = this.jTableImpuiestosAgg.getSelectedRow();
            
            lImpAg.remove(index);
            this.cargarTablaImpAgg();
        }
    }//GEN-LAST:event_jBEliminarImpuestoActionPerformed

    private void jBCalcularCostoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularCostoProdActionPerformed
       boolean continuar = true;
       
        if(this.jTableDetalle.getSelectedRow()>-1){
           double suma_impuestos = 0.0;
           double costoacumluado = 0.0;
           int index = this.jTableDetalle.getSelectedRow();
           
           int idprod= this.lDetalle.get(index).getProduct_id();
            int idorden = this.lDetalle.get(index).getProduction_order_id();
            int iddetalle = this.lDetalle.get(index).getProduction_order_detail_id();
            
            int response = JOptionPane.showConfirmDialog(null, "¿Desea el costo del producto "+this.lDetalle.get(index).getNombre_prod()+"? Se utilizaran los impuestos a;adidos al detella.", 
                   "Confirmar", JOptionPane.YES_NO_OPTION);

            if(response == JOptionPane.YES_OPTION){
                
                production_order_detailDAO detalleDAO = new production_order_detailDAO();
                    
                if(detalleDAO.VerificarCostos(idprod, iddetalle) == 0){
                    double costomodelo = detalleDAO.getCostoModelo(idprod, idorden);
                    double costoprimo = detalleDAO.getCostoPrimo(costomodelo, idprod, idorden);
                    costoacumluado = costoprimo;
                    TaxeUse taxeUsados;

                    for (int j = 0; j < this.lImpAg.size(); j++) {
                        suma_impuestos = (costoacumluado*this.lImpAg.get(j).getVALUE())+costoacumluado;
                        costoacumluado = suma_impuestos;
                    }

                    if(continuar){
                        OrderCostDAO costDao = new OrderCostDAO();
                        OrderCost costo = new OrderCost( iddetalle, costomodelo, costoprimo, suma_impuestos);
                        if(costDao.insert(costo)){
                            continuar = true;
                            int idcostos = costDao.getLastOrderId();
                                for (int j = 0; j < this.lImpAg.size(); j++) {
                                    taxeUsados = new TaxeUse(idcostos, this.lImpAg.get(j).getTaxe_id());
                                    taxUseDao.insert(taxeUsados);

                                    if(taxUseDao.insert(taxeUsados)){
                                        continue;
                                    } else{
                                        JOptionPane.showMessageDialog(null, "Error en impuestos");
                                        continuar = false;
                                        break;
                                    }
                                }
                        } else{
                            JOptionPane.showMessageDialog(null, "Ha surgido un error."); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Error en impuestos");
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "Ya se ha calculado el costo de este producto.");
                }
                
                
                if(continuar){
                    JOptionPane.showMessageDialog(null, "Se han calculado los costos para los productos."); 
                    this.lImpAg.clear();
                    this.lDetalle.clear();
                    this.cargarTablaOrdenes();
                    this.cargarTablaImpAgg();
                    this.cargarTablaDetalles();
                    this.jBCalcularCostoProd.setEnabled(false);
                    this.jBCalcularCostoProdAll.setEnabled(false);
                    this.jBEliminarImpuesto.setEnabled(false);
                    this.jBIngresar.setEnabled(true);
                    this.jBModificar.setEnabled(false);
                    this.jBAggImpuesto.setEnabled(false);
                }
                
                
            }else{
                JOptionPane.showConfirmDialog(null, "Se ha cancelado la operacion.");
            }

           
       }
    }//GEN-LAST:event_jBCalcularCostoProdActionPerformed

    private void jBCalcularCostoProdAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularCostoProdAllActionPerformed
        double suma_impuestos = 0.0;
        double costoacumluado = 0.0;
        boolean continuar = true;
        
        int response = JOptionPane.showConfirmDialog(null, "¿Desea el costo de todos los productos del detalle? Se utilizaran los impuestos a;adidos al detalle.", 
                   "Confirmar", JOptionPane.YES_NO_OPTION);

        if(response == JOptionPane.YES_OPTION){
            try{
                for (int i = 0; i < lDetalle.size(); i++) {
                    int idprod= this.lDetalle.get(i).getProduct_id();
                    int idorden = this.lDetalle.get(i).getProduction_order_id();
                    int iddetalle = this.lDetalle.get(i).getProduction_order_detail_id();
                    
                    production_order_detailDAO detalleDAO = new production_order_detailDAO();
                    
                    if(detalleDAO.VerificarCostos(idprod, iddetalle) == 0){
                        double costomodelo = detalleDAO.getCostoModelo(idprod, idorden);
                        double costoprimo = detalleDAO.getCostoPrimo(costomodelo, idprod, idorden);
                        costoacumluado = costoprimo;
                        TaxeUse taxeUsados;

                        for (int j = 0; j < this.lImpAg.size(); j++) {
                            suma_impuestos = (costoacumluado*this.lImpAg.get(j).getVALUE())+costoacumluado;
                            costoacumluado = suma_impuestos;
                        }

                        if(continuar){
                            OrderCostDAO costDao = new OrderCostDAO();
                            OrderCost costo = new OrderCost( iddetalle, costomodelo, costoprimo, suma_impuestos);
                            if(costDao.insert(costo)){
                                continuar = true;
                                int idcostos = costDao.getLastOrderId();
                                for (int j = 0; j < this.lImpAg.size(); j++) {
                                    taxeUsados = new TaxeUse(idcostos, this.lImpAg.get(j).getTaxe_id());
                                    taxUseDao.insert(taxeUsados);

                                    if(taxUseDao.insert(taxeUsados)){
                                        continue;
                                    } else{
                                        JOptionPane.showMessageDialog(null, "Error en impuestos");
                                        continuar = false;
                                        break;
                                    }
                                }
                            } else{
                                JOptionPane.showMessageDialog(null, "Ha surgido un error."); 
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al generar costos.");
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Los costos ya han sido calculados."); 
                    }

                    
                }
                
                if(continuar){
                    JOptionPane.showMessageDialog(null, "Se han calculado los costos para los productos."); 
                    this.lImpAg.clear();
                    this.lDetalle.clear();
                    this.cargarTablaOrdenes();
                    this.cargarTablaImpAgg();
                    this.cargarTablaDetalles();
                    this.jBCalcularCostoProd.setEnabled(false);
                    this.jBCalcularCostoProdAll.setEnabled(false);
                    this.jBEliminarImpuesto.setEnabled(false);
                    this.jBIngresar.setEnabled(true);
                    this.jBModificar.setEnabled(false);
                    this.jBAggImpuesto.setEnabled(false);
                }
                
                
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha surgido un error.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se ha cancelado la acción.");
        }
        
        
    }//GEN-LAST:event_jBCalcularCostoProdAllActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTPorcentajeIN;
    private javax.swing.JButton jBAggImpuesto;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarOrden;
    private javax.swing.JButton jBCalcularCostoProd;
    private javax.swing.JButton jBCalcularCostoProdAll;
    private javax.swing.JButton jBEliminarImpuesto;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTDecimalIN;
    private javax.swing.JTextField jTNombreBuscar;
    private javax.swing.JTextField jTNombreBuscarOrden;
    private javax.swing.JTextField jTNombreIN;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTable jTableImpuestos;
    private javax.swing.JTable jTableImpuiestosAgg;
    private javax.swing.JTable jTableOrden;
    // End of variables declaration//GEN-END:variables

    
}

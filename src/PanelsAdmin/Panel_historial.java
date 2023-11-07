package PanelsAdmin;

import classes.JasperClase;
import javax.swing.table.DefaultTableModel;
import classes.ProductOrder;
import classes.ProductionOrderDetail;
import classesDAO.ProductOrderDAO;
import classesDAO.production_order_detailDAO;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Panel_historial extends javax.swing.JPanel {

    //variables ordenes 
    int id_orden, id_user, cantidad, order_cost_id, production_order_detail_Id;

    String nombre_user, pass_user, nombre, comentario, producto, hecho_por;
    Date fecha;

    double sub_total, cola_cromada, total_modelo, costo_primo, precio_venta, costo_venta_agregado, ganancia;

    //clases
    ProductOrder ordenes;
    ProductionOrderDetail ordenesDetail;
    //clases DAO
    ProductOrderDAO ordenesDAO;
    production_order_detailDAO Det_ordenDAO;

    //list 
    List<ProductOrder> List_ordenes;
    List<ProductionOrderDetail> List_DetOrden;

    //Modelos
    DefaultTableModel Model_Ordenes;
    DefaultTableModel Model_Det_Ordenes;

    public Panel_historial(int id, String nombre, String pass) {
        initComponents();

        id_orden = 0;
        nombre_user = nombre;
        pass_user = pass;

        this.jLUser.setText("Bienevenido: " + nombre_user);
        //iniciar objetos y DAO
        ordenes = new ProductOrder();
        ordenesDetail = new ProductionOrderDetail();
        ordenesDAO = new ProductOrderDAO();
        Det_ordenDAO = new production_order_detailDAO();

        //inicar modelo JT
        Model_Ordenes = new DefaultTableModel();
        Model_Det_Ordenes = new DefaultTableModel();

        //this.cargarTablaDetalleOrder();
        this.JBVolver.setEnabled(false);
        this.JBReportes.setEnabled(false);
        this.JBaddPorcentaje.setEnabled(false);
        this.cargarTablaOrdenes();
        this.JTAsignaPorsentaje.setText("");
    }

    void limpiar() {
        this.JTBuscarOrden.setText("");

        id_orden = 0;
    }

    void cargarTablaOrdenes() {
        Model_Ordenes.setRowCount(0);
        String[] nombreColum = {"Creada Por", "Nombre ", "Fecha", "Comentario"};
        Model_Ordenes.setColumnIdentifiers(nombreColum);
        try {
            List_ordenes = ordenesDAO.ListarOrdenesCombinadoUser();
            if (List_ordenes.size() > -1) {
                for (int i = 0; i < List_ordenes.size(); i++) {
                    if (List_ordenes.get(i).getState().equals("a")) {
                        Model_Ordenes.addRow(new Object[]{
                            List_ordenes.get(i).getNombre_user(),
                            List_ordenes.get(i).getNombre(),
                            List_ordenes.get(i).getOrder_date(),
                            List_ordenes.get(i).getComent()});
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error en tabla 1" + e);
        }
        this.jTableOrdenes.setModel(Model_Ordenes);
        this.jTableOrdenes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTableOrdenes.setFillsViewportHeight(true);
        this.JBVolver.setEnabled(false);
    }

    //Cragar tabla de busqueda
    void cargarTablaOrdenEspecifica(String nombreOrden) {
        Model_Ordenes.setRowCount(0);
        String[] nombreColum = {"Creada Por", "Nombre ", "Fecha", "Comentario"};
        Model_Ordenes.setColumnIdentifiers(nombreColum);

        List_ordenes = ordenesDAO.ListarOrdenesNombre(nombreOrden);

        if (List_ordenes.size() > -1) {
            for (int i = 0; i < List_ordenes.size(); i++) {
                //si es A lo mostrara ?
                if (List_ordenes.get(i).getState().equals("a")) {
                    Model_Ordenes.addRow(new Object[]{
                        List_ordenes.get(i).getNombre_user(),
                        List_ordenes.get(i).getNombre(),
                        List_ordenes.get(i).getOrder_date(),
                        List_ordenes.get(i).getComent()});
                }
            }
        }
        this.jTableOrdenes.setModel(Model_Ordenes);
        this.jTableOrdenes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.jTableOrdenes.setFillsViewportHeight(true);
        this.JBVolver.setEnabled(false);
    }

    void cargarTablaDetalleOrder() {
        Model_Det_Ordenes.setRowCount(0);
        String[] nombreColum = {"Producto ", "Cantidad", "Costo cola comada", "Costo Primo", "Sub Total", "Total modelo", "Precio Venta", "Ganancia"};
        Model_Det_Ordenes.setColumnIdentifiers(nombreColum);

        List_DetOrden = Det_ordenDAO.ListarOrderDetailsCombinado(id_orden);
        try {
            if (List_DetOrden.size() > -1) {
                for (int i = 0; i < List_DetOrden.size(); i++) {
                    if (List_DetOrden.get(i).getState().equals("a")) {
                        Model_Det_Ordenes.addRow(new Object[]{
                            List_DetOrden.get(i).getNombre_prod(),
                            List_DetOrden.get(i).getQuantity(),
                            List_DetOrden.get(i).getCosto_cola_cromada(),
                            List_DetOrden.get(i).getCosto_primo(),
                            List_DetOrden.get(i).getSub_total(),
                            List_DetOrden.get(i).getCosto_total_modelo(),
                            List_DetOrden.get(i).getPrecio_venta(),                            
                            List_DetOrden.get(i).getPrecio_ganancia(),});
                    }
                }
                this.JBReportes.setEnabled(true);
            }
            if (Model_Det_Ordenes.getRowCount() < 1) {
                JOptionPane.showMessageDialog(null, "Orden incompleta, No se puede mostrar.");
                this.JBReportes.setEnabled(false);
            }

            //this.jTableOrdenes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            this.jTableOrdenes.setFillsViewportHeight(true);
            this.jTableDetalleOrden.setModel(Model_Det_Ordenes);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hay un error al cargar el detalle.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrdenes = new javax.swing.JTable();
        JTBuscarOrden = new javax.swing.JTextField();
        JBBuscarOrden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDetalleOrden = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        JBReportes = new javax.swing.JButton();
        JBVolver = new javax.swing.JButton();
        JTOrdenSelect = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTAsignaPorsentaje = new javax.swing.JTextField();
        JBaddPorcentaje = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTDetalle_seleccionado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(192, 190, 186));
        setPreferredSize(new java.awt.Dimension(1005, 699));

        jLUser.setBackground(new java.awt.Color(0, 0, 0));
        jLUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLUser.setText("Bienvenido: User");

        jTableOrdenes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        JTBuscarOrden.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JBBuscarOrden.setBackground(new java.awt.Color(255, 255, 106));
        JBBuscarOrden.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JBBuscarOrden.setText("Buscar");
        JBBuscarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarOrdenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Buscar por nombre:");

        jLabel2.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel2.setText("Historial de Ordenes");

        jTableDetalleOrden.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDetalleOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDetalleOrdenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableDetalleOrden);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        jLabel4.setText("Detalle de Orden");

        JBReportes.setBackground(new java.awt.Color(255, 117, 117));
        JBReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JBReportes.setText("Imprimir Reporte");
        JBReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReportesActionPerformed(evt);
            }
        });

        JBVolver.setBackground(new java.awt.Color(239, 151, 85));
        JBVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JBVolver.setText("Volver");
        JBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVolverActionPerformed(evt);
            }
        });

        JTOrdenSelect.setEditable(false);
        JTOrdenSelect.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTOrdenSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTOrdenSelectActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Orden seleccionada:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Agregar % de ganancias");

        JTAsignaPorsentaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JBaddPorcentaje.setBackground(new java.awt.Color(95, 207, 95));
        JBaddPorcentaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JBaddPorcentaje.setText("Ingresar");
        JBaddPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaddPorcentajeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Asignar nuevo %");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Producto seleccionado");

        JTDetalle_seleccionado.setEditable(false);
        JTDetalle_seleccionado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel6.setText("Historial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(JTBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(JBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBReportes)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTAsignaPorsentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBaddPorcentaje))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTOrdenSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(JTDetalle_seleccionado))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLUser, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JTBuscarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBBuscarOrden)
                            .addComponent(JBVolver))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTOrdenSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTDetalle_seleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTAsignaPorsentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBaddPorcentaje))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBReportes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBBuscarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarOrdenActionPerformed
        //BTN BUSCAR La orden
        String NombreOrden = this.JTBuscarOrden.getText();
        if (!NombreOrden.isEmpty()) {
            this.cargarTablaOrdenEspecifica(NombreOrden);
            Model_Det_Ordenes.setRowCount(0);
            this.JBReportes.setEnabled(false);
            //NUEVO
            this.JTOrdenSelect.setText("");
            this.JBaddPorcentaje.setEnabled(false);
            //
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de una orden");
        }
        limpiar();
        this.JBVolver.setEnabled(true);
        this.JTAsignaPorsentaje.setText("");
        this.JBaddPorcentaje.setEnabled(false);
    }//GEN-LAST:event_JBBuscarOrdenActionPerformed

    private void JBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVolverActionPerformed

        cargarTablaOrdenes();
        this.Model_Det_Ordenes.setRowCount(0);
        this.JTOrdenSelect.setText("");
        this.JTAsignaPorsentaje.setText("");
        this.JBReportes.setEnabled(false);
        this.JBaddPorcentaje.setEnabled(false);
    }//GEN-LAST:event_JBVolverActionPerformed

    private void jTableOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdenesMouseClicked
        try {
            if (this.jTableOrdenes.getSelectedRow() > -1) {
                int index = this.jTableOrdenes.getSelectedRow();

                //SE EXTRAE ID,NOMBRE,FECHA,COMENTARIO SELECCIONADO.                
                id_orden = this.List_ordenes.get(index).getProduction_order_id(); //no va en jasper
                nombre = this.List_ordenes.get(index).getNombre();
                fecha = this.List_ordenes.get(index).getOrder_date();
                comentario = this.List_ordenes.get(index).getComent();
                hecho_por = this.List_ordenes.get(index).getNombre_user();
                //////////////////////////////////////////////////////////////////////////////
                this.JTOrdenSelect.setText(this.List_ordenes.get(index).getNombre());
                this.cargarTablaDetalleOrder();

                this.JBaddPorcentaje.setEnabled(true);
                this.JBaddPorcentaje.setEnabled(true);
                this.JTAsignaPorsentaje.setText("");
                JTDetalle_seleccionado.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento de la tabla" + e);
        }
    }//GEN-LAST:event_jTableOrdenesMouseClicked

    private void jTableDetalleOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDetalleOrdenMouseClicked
        try {
            if (this.jTableDetalleOrden.getSelectedRow() > -1) {
                int index = this.jTableDetalleOrden.getSelectedRow();
                this.JTDetalle_seleccionado.setText(List_DetOrden.get(index).getNombre_prod());

                total_modelo = this.List_DetOrden.get(index).getCosto_total_modelo();
                order_cost_id = this.List_DetOrden.get(index).getOrder_cost_id();
                costo_venta_agregado = this.List_DetOrden.get(index).getPrecio_ganancia();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableDetalleOrdenMouseClicked

    private void JBReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReportesActionPerformed
        List lista = new ArrayList();
        try {
            for (int i = 0; i < jTableDetalleOrden.getRowCount(); i++) {
                JasperClase listaOrden = new JasperClase(
                        jTableDetalleOrden.getValueAt(i, 0).toString(), //nombre
                        jTableDetalleOrden.getValueAt(i, 1).toString(), //cantidad
                        jTableDetalleOrden.getValueAt(i, 2).toString(),//cola cromada
                        jTableDetalleOrden.getValueAt(i, 3).toString(),//costo primo
                        jTableDetalleOrden.getValueAt(i, 4).toString(), //sub total
                        jTableDetalleOrden.getValueAt(i, 5).toString(),//precio venta
                        jTableDetalleOrden.getValueAt(i, 6).toString(),//tot modelo
                        jTableDetalleOrden.getValueAt(i, 7).toString() // ganancia
                );
                lista.add(listaOrden);
            }
            File archivo = new File("src/Reporte/reportesproducto.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(archivo);

            Map parametros = new HashMap();
            parametros.put("nombre", nombre);
            parametros.put("user_name", hecho_por);
            parametros.put("fecha", String.valueOf(fecha));
            parametros.put("comentario", comentario);

            JasperPrint jPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(lista));
            // Obtener la ruta del escritorio del usuario
            String rutaEscritorio = System.getProperty("user.home") + "//Desktop";
            // Crear la carpeta "Reportes" si no existe
            File carpetaReportes = new File(rutaEscritorio, "Reportes_Macroa");
            if (!carpetaReportes.exists()) {
                carpetaReportes.mkdirs();
            }
            // Genera un nombre de archivo PDF basado en el número de orden y la fecha
            String nombreArchivo = "Orden_" + nombre + "_Fecha_" + fecha + ".pdf";
            // Guardar el informe en formato PDF en la carpeta "Reportes" en el escritorio
            String rutaCompleta = new File(carpetaReportes, nombreArchivo).getPath();
            JasperExportManager.exportReportToPdfFile(jPrint, rutaCompleta);
            JasperViewer.viewReport(jPrint, false);
            JOptionPane.showMessageDialog(null, "Se guardó el archivo en la carpeta: Reportes Macroa. En su escritorio.");
        } catch (JRException ex) {
            System.out.println("error: " + ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al general el reporte.");
            JOptionPane.showMessageDialog(null, "La orden existe, pero no contiene ningún detalle.");
        }
    }//GEN-LAST:event_JBReportesActionPerformed

    private void JBaddPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBaddPorcentajeActionPerformed
        try {
            double Porcentaje = Double.parseDouble(this.JTAsignaPorsentaje.getText());

            if (Porcentaje >= 0) {
                ganancia = 0;

                if (!JTOrdenSelect.getText().trim().isEmpty() && JTDetalle_seleccionado.getText().trim().isEmpty()) {
                    for (int i = 0; i < List_DetOrden.size(); i++) {
                        order_cost_id = this.List_DetOrden.get(i).getOrder_cost_id();
                        total_modelo = this.List_DetOrden.get(i).getCosto_total_modelo();

                        ganancia = ((total_modelo - costo_venta_agregado)) * (Porcentaje / 100);
                        // Redondear ganancia al entero siguiente
                        ganancia = Math.ceil(ganancia);
                        this.ordenesDetail.setPrecio_ganancia(ganancia);
                        this.ordenesDetail.setOrder_cost_id(order_cost_id);//El ID al que pertenece la orden 
                        Det_ordenDAO.insert_valor_agregado(ordenesDetail);
                    }
                } else {
                    ganancia = ((total_modelo - costo_venta_agregado)) * (Porcentaje / 100);
                    // Redondear ganancia al entero siguiente
                    ganancia = Math.ceil(ganancia);
                    this.ordenesDetail.setPrecio_ganancia(ganancia);
                    this.ordenesDetail.setOrder_cost_id(order_cost_id);//El ID al que pertenece la orden                         
                    Det_ordenDAO.insert_valor_agregado(ordenesDetail);
                }
                cargarTablaDetalleOrder();
                cargarTablaOrdenes();
                this.JTAsignaPorsentaje.setText("");
                JTDetalle_seleccionado.setText("");
            }
            JOptionPane.showMessageDialog(null, "Se actualizo el porcentaje.");
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El porcentaje solo admite números.");
        }
    }//GEN-LAST:event_JBaddPorcentajeActionPerformed

    private void JTOrdenSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTOrdenSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTOrdenSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBuscarOrden;
    private javax.swing.JButton JBReportes;
    private javax.swing.JButton JBVolver;
    private javax.swing.JButton JBaddPorcentaje;
    private javax.swing.JTextField JTAsignaPorsentaje;
    private javax.swing.JTextField JTBuscarOrden;
    private javax.swing.JTextField JTDetalle_seleccionado;
    private javax.swing.JTextField JTOrdenSelect;
    private javax.swing.JLabel jLUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDetalleOrden;
    private javax.swing.JTable jTableOrdenes;
    // End of variables declaration//GEN-END:variables
}

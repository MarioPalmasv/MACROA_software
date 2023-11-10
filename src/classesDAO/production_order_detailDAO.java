package classesDAO;

import db.DbConexion;
import classes.ProductionOrderDetail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gergo
 */
public class production_order_detailDAO implements DML<ProductionOrderDetail> {

    private Connection con;

    public production_order_detailDAO() {
        con = new DbConexion().getCon();
    }

    // Método para obtener todos las combinaciones
    public List<ProductionOrderDetail> ListarOrderDetails() {

        List<ProductionOrderDetail> OrderD_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM production_order_detail";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int production_order_detail_id = resultSet.getInt("production_order_detail_Id");
                int product_id = resultSet.getInt("product_id");
                int production_order_id = resultSet.getInt("production_order_Id");
                int quantity = resultSet.getInt("quantity");
                double sub_total = resultSet.getDouble("sub_total");
                double costo_cola_cromada = resultSet.getDouble("costo_cola_cromada");
                String state = resultSet.getString("state");

                ProductionOrderDetail listaOD = new ProductionOrderDetail(production_order_detail_id, product_id,
                        production_order_id, quantity, sub_total, costo_cola_cromada, state);

                OrderD_lista.add(listaOD);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return OrderD_lista;
    }

    //nuevo metodo mela
    public List<ProductionOrderDetail> ListarOrderDetailsById(int id) {

        List<ProductionOrderDetail> OrderD_lista = new ArrayList<>();
        try {
            String sql = "SELECT pod.*, p.nombre FROM production_order_detail pod INNER JOIN product p ON pod.product_id = p.product_id WHERE pod.production_order_Id =?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int production_order_detail_id = resultSet.getInt("production_order_detail_Id");
                int product_id = resultSet.getInt("product_id");
                int production_order_id = resultSet.getInt("production_order_Id");
                int quantity = resultSet.getInt("quantity");
                double sub_total = resultSet.getDouble("sub_total");
                double costo_cola_cromada = resultSet.getDouble("costo_cola_cromada");
                String state = resultSet.getString("state");
                String producto = resultSet.getString("nombre");

                ProductionOrderDetail listaOD = new ProductionOrderDetail(production_order_detail_id, product_id, producto,
                        production_order_id, quantity, sub_total, costo_cola_cromada, state);

                OrderD_lista.add(listaOD);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return OrderD_lista;
    }

    @Override
    public boolean insert(ProductionOrderDetail objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertProductionOrderDetail(?,?,?,?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, objeto.getProduct_id());
                valores.setInt(2, objeto.getProduction_order_id());
                valores.setInt(3, objeto.getQuantity());
                valores.setDouble(4, objeto.getSub_total());
                valores.setDouble(5, objeto.getCosto_cola_cromada());
                valores.setString(6, objeto.getState());

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateProductionOrderDetailCancelado(?)}";
            CallableStatement callableStatement = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            callableStatement.setInt(1, id);

            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ProductionOrderDetail objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activate(int id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateProductionOrderDetail(?)}";
            CallableStatement callableStatement = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            callableStatement.setInt(1, id);

            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //g nuevos 
    public List<ProductionOrderDetail> ListarOrderDetailsCombinado(int idOrdenn) {
        List<ProductionOrderDetail> OrderD_lista = new ArrayList<>();
        //sumar el precio venta + ganancia y cambiar el modelo tamb
        try {
            String sql = "SELECT  CONCAT(u.first_name, ' ', u.last_name) AS creada_por, po.nombre AS nombre_orden, po.order_date AS fecha, " +
                    "p.nombre AS producto, " +
                    "pod.quantity AS cantidad, " +
                    "pod.sub_total, " +
                    "pod.costo_cola_cromada AS cola_cromada, " +
                    "oc.costo_total_modelo, " +
                    "oc.costo_primo, " +
                    "oc.precio_venta, " +
                    "((oc.precio_venta * pod.quantity)+ oc.precio_ganancia) AS tot_detalle, " +
                    "oc.precio_ganancia, " +
                    "po.state, oc.order_id,  pod.production_order_detail_Id " +
                    "FROM product_order po " +
                    "JOIN production_order_detail pod ON po.production_order_Id = pod.production_order_Id " +
                    "JOIN order_cost oc ON pod.production_order_detail_Id = oc.production_order_detail_Id " +
                    "JOIN product p ON pod.product_id = p.product_id " +
                    "JOIN user u ON po.user_id = u.user_id " +
                    "WHERE po.production_order_Id = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, idOrdenn);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductionOrderDetail orderDetail = new ProductionOrderDetail();
                orderDetail.setNombre_user(resultSet.getString("creada_por"));
                orderDetail.setNombre(resultSet.getString("nombre_orden"));
                orderDetail.setFecha(resultSet.getDate("fecha"));
                orderDetail.setNombre_prod(resultSet.getString("producto"));
                orderDetail.setQuantity(resultSet.getInt("cantidad"));
                orderDetail.setCosto_cola_cromada(resultSet.getDouble("cola_cromada"));
                orderDetail.setCosto_primo(resultSet.getDouble("costo_primo"));
                orderDetail.setSub_total(resultSet.getDouble("sub_total"));
                orderDetail.setCosto_total_modelo(resultSet.getDouble("costo_total_modelo"));
                orderDetail.setPrecio_venta(resultSet.getDouble("precio_venta"));
                orderDetail.setTot_detalle(resultSet.getDouble("tot_detalle"));
                orderDetail.setPrecio_ganancia(resultSet.getDouble("precio_ganancia"));
                
                orderDetail.setState(resultSet.getString("state"));
                orderDetail.setOrder_cost_id(resultSet.getInt("order_id"));//id individual de cada detalle
                orderDetail.setProduction_order_detail_id(resultSet.getInt("production_order_detail_Id"));//id general de cada orden 
                OrderD_lista.add(orderDetail);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
              System.out.println("Error: " + e);
        }
        return OrderD_lista;
    }

    public boolean insert_valor_agregado(ProductionOrderDetail objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdatePrecioGanancia(?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                                
                valores.setInt(1, objeto.getOrder_cost_id());
                valores.setDouble(2, objeto.getPrecio_ganancia())
                        ;
                valores.execute();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }
    /////
//      public boolean insert_valor_agregadoTODAORDEN(ProductionOrderDetail objeto) {
//        try {
//            // Llamar al procedimiento almacenado
//            String sql = "{CALL UpdatePrecioGananciaTODOS(?,?)}";
//            // Establecer los parámetros del procedimiento almacenado
//            try (CallableStatement valores = con.prepareCall(sql)) {
//                // Establecer los parámetros del procedimiento almacenado                                
//                valores.setInt(1, objeto.getProduction_order_detail_id() );//production_order_detail_Id
//                valores.setDouble(2, objeto.getPrecio_ganancia());
//                valores.execute();
//            }
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//            return false;
//        }
//        return true;
//    }
   

    //estos nuevos 4 metodos mela
    public double getProductPriceById(int productId) {
        double productPrice = 0.0;

        try {
            String sql = "SELECT P.product_id, SUM((M.precio*M.cms) + M.pintura_empaque) AS product_price "
                    + "FROM Product AS P "
                    + "JOIN combination AS C ON P.product_id = C.product_id "
                    + "JOIN material AS M ON C.material_id = M.material_id "
                    + "WHERE P.product_id = ? "
                    + "GROUP BY P.product_id";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                productPrice = resultSet.getDouble("product_price");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return productPrice;
    }

    public int getDetailIdByOrder(int OrderId) {
        int DetailId = -1;

        try {
            String sql = "SELECT production_order_detail_Id FROM production_order_detail WHERE production_order_Id=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, OrderId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                DetailId = resultSet.getInt("production_order_detail_Id");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return DetailId;
    }

    public double getCostoModelo(int productId, int detalleId) {
        double costo_modelo = 0.0;

        try {
            String sql = "SELECT pod.sub_total+pod.costo_cola_cromada as costo_modelo FROM production_order_detail"
                    + " pod INNER JOIN product p ON pod.product_id = p.product_id WHERE pod.production_order_Id =? AND pod.product_id=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, detalleId);
            preparedStatement.setInt(2, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                costo_modelo = resultSet.getDouble("costo_modelo");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return costo_modelo;
    }

    public double getCostoPrimo(double costo_modelo, int productId, int detalleId) {
        double costo_primo = 0.0;

        try {
            String sql = "SELECT ?+p.constante_mod as costoprimo FROM production_order_detail"
                    + " pod INNER JOIN product p ON pod.product_id = p.product_id WHERE pod.production_order_Id =? AND pod.product_id=?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDouble(1, costo_modelo);
            preparedStatement.setInt(2, detalleId);
            preparedStatement.setInt(3, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                costo_primo = resultSet.getDouble("costoprimo");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return costo_primo;
    }

}

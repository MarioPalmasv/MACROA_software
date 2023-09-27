/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import classes.ProductOrder;
import db.DbConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melan
 */
public class ProductOrderDAO {
    private Connection con;
    
    public ProductOrderDAO(){
        con = new DbConexion().getCon();
    }
    
    public List<ProductOrder> ListarOrdenes() {
        List<ProductOrder> lista_ordenProd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product_order";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductOrder order = new ProductOrder();
                order.setProduction_order_id(resultSet.getInt("production_order_Id"));
                order.setUser_id(resultSet.getInt("user_id"));
                order.setNombre(resultSet.getString("nombre"));
                order.setOrder_date(resultSet.getDate("order_date"));
                order.setComent(resultSet.getString("coment"));
                order.setState(resultSet.getString("state"));
                lista_ordenProd.add(order);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
        }

        return lista_ordenProd;
    }
    
    public void AgregarProductOrder(int userId, String nombre, String comentario) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertProductOrder(?, ?, ?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, userId);
                valores.setString(2, nombre);
                valores.setString(3, comentario);

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    
    public void ActualizarProductOrder(ProductOrder order, int id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateProductOrder(?, ?, ?, ?, ?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);
                valores.setInt(2, order.getUser_id());
                valores.setString(3, order.getNombre());
                valores.setString(4, order.getComent());
                valores.setString(5, order.getState());

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarOrderCancelada(int productionOrderId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateOrderCancelada(?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, productionOrderId);

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void ActivarOrder(int productionOrderId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateOrder(?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, productionOrderId);

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

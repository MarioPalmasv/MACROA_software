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
import javax.swing.JOptionPane;

/**
 *
 * @author melan
 */
public class ProductOrderDAO implements DML<ProductOrder> {

    private Connection con;

    public ProductOrderDAO() {
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

    //este nuevo metodo (mela)
    public List<ProductOrder> ListarOrdenesPorNombre(String nOrden) {
        List<ProductOrder> lista_ordenProd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product_order WHERE nombre LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nOrden + "%");
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

    //g nuevo
    public List<ProductOrder> ListarOrdenesCombinadoUser() {
        List<ProductOrder> lista_ordenProd = new ArrayList<>();
        try {
            String sql = "SELECT p.production_order_Id, CONCAT(u.first_name, ' ', u.last_name) AS creada_por, p.nombre, p.order_date, p.coment, p.state"
                    + " FROM product_order p "
                    + "JOIN USER u ON p.user_id = u.user_id;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductOrder order = new ProductOrder();
                
                order.setProduction_order_id(resultSet.getInt("production_order_Id"));
                order.setNombre_user(resultSet.getString("creada_por"));
                order.setNombre(resultSet.getString("nombre"));
                order.setOrder_date(resultSet.getDate("order_date"));
                order.setComent(resultSet.getString("coment"));
                order.setState(resultSet.getString("state"));
                lista_ordenProd.add(order);
            }            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
              System.out.println("Error: " + e);
        }

        return lista_ordenProd;
    }
    
    public List<ProductOrder> ListarOrdenesNombre(String HNombre) {
        List<ProductOrder> lista_ordenProd = new ArrayList<>();
        try {
            String sql = "SELECT p.production_order_Id, CONCAT(u.first_name, ' ', u.last_name) AS creada_por, p.nombre, p.order_date, p.coment, p.state"
                    + " FROM product_order p "
                    + "JOIN USER u ON p.user_id = u.user_id "
                    + "WHERE p.nombre like ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,"%"+HNombre+"%" );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductOrder order = new ProductOrder();
                
                order.setProduction_order_id(resultSet.getInt("production_order_Id"));
                order.setNombre_user(resultSet.getString("creada_por"));
                order.setNombre(resultSet.getString("nombre"));
                order.setOrder_date(resultSet.getDate("order_date"));
                order.setComent(resultSet.getString("coment"));
                order.setState(resultSet.getString("state"));
                lista_ordenProd.add(order);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Conectar con la Base de datos. \nRevise la conexion");
        }

        return lista_ordenProd;
    }

    @Override
    public boolean insert(ProductOrder objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertProductOrder(?, ?, ?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, objeto.getUser_id());
                valores.setString(2, objeto.getNombre());
                valores.setString(3, objeto.getComent());

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
            String sql = "{CALL UpdateOrderCancelada(?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ProductOrder objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateProductOrder(?, ?, ?, ?, ?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, objeto.getProduction_order_id());
                valores.setInt(2, objeto.getUser_id());
                valores.setString(3, objeto.getNombre());
                valores.setString(4, objeto.getComent());
                valores.setString(5, objeto.getState());

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean activate(int id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateOrder(?)}";

            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    // para obtener el id
    public int getProductOrderId() {
        int productOrderId = -1;

        try {
            String sql = "SELECT production_order_Id FROM product_order ORDER BY production_order_Id DESC LIMIT 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                productOrderId = resultSet.getInt("production_order_Id");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return productOrderId;
    }

}

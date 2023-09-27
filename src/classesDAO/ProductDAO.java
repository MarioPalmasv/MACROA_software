package classesDAO;

import classes.Product;
import db.DbConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gergo
 */
public class ProductDAO {
    private Connection con;
    
    public ProductDAO(){
        con = new DbConexion().getCon();
    }
    
     // Método para obtener todos los materiales
    public List<Product> ListarProdcut() {
        List<Product> products_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("product_id");
                String nombre = resultSet.getString("nombre");
                String modelo = resultSet.getString("modelo");
                String state = resultSet.getString("state");
                double time_in = resultSet.getDouble("time_in");
                double constante_mod = resultSet.getDouble("constante_mod");
                

                Product productos = new Product(product_id, nombre, modelo, state, time_in, constante_mod);
                products_lista.add(productos);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return products_lista;
    }
    
     // Método para agregar un nuevo material
    public void AgregarProductos (Product productos) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertProduct(?, ?, ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado
                valores.setString(1, productos.getNombre() );
                valores.setString(2, productos.getModelo() );
                valores.setDouble(3, productos.getTime_in() );
                valores.setDouble(4, productos.getConstante_mod() );
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
      //Metodo para editar un producto
    public void EditProductos(Product productos) {
        
         try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateProduct( ?,?,?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, productos.getProduct_id() );
               valores.setString(2, productos.getNombre() );
               valores.setString(3,productos.getModelo());
                valores.setDouble(4, productos.getTime_in() );
                valores.setDouble(5, productos.getConstante_mod() );
                
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para Eliminar (desactivar) un Prodcuto
    public void EliminarProducto(int product_id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL DeleteProduct(?)}";
            CallableStatement callableStatement = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            callableStatement.setInt(1, product_id);

            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para Activar  un Prodcuto
    public void ActivarProducto(int product_id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateProduct(?)}";
            CallableStatement callableStatement = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            callableStatement.setInt(1, product_id);

            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

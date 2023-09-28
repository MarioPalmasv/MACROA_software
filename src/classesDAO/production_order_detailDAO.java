package classesDAO;
import db.DbConexion;
import classes.ProductionOrderDetail;
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
public class production_order_detailDAO implements DML<ProductionOrderDetail>{
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
                int production_order_detail_id = resultSet.getInt("production_order_detail_id");
                int product_id = resultSet.getInt("product_id");
                int production_order_id = resultSet.getInt("production_order_id");
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

}

package classesDAO;

import classes.OrderCost;
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
public class OrderCostDAO {

    private Connection con;

    public OrderCostDAO() {
        con = new DbConexion().getCon();
    }

    // Método para obtener todos las ordenes
    public List<OrderCost> ListarOrderCosts() {

        List<OrderCost> OrderC_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM order_cost";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int order_id = resultSet.getInt("order_id");
                int production_order_detail_id = resultSet.getInt("production_order_detail_id");
                int costo_total_modelo = resultSet.getInt("costo_total_modelo");
                int costo_primo = resultSet.getInt("costo_primo");
                int precio_venta = resultSet.getInt("precio_venta");

                OrderCost listaOrdenCost = new OrderCost(order_id, production_order_detail_id, costo_total_modelo, costo_primo, precio_venta);

                OrderC_lista.add(listaOrdenCost);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return OrderC_lista;
    }

    // Método para agregar una combinacion
    public void AddOrderCost(OrderCost OrderC) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertOrderCost( ?,?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, OrderC.getProduction_order_detail_id());                
                valores.setDouble(2, OrderC.getCosto_total_modelo());
                valores.setDouble(3, OrderC.getCosto_primo());
                valores.setDouble(4, OrderC.getPrecio_venta());
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

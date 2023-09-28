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
public class OrderCostDAO implements DML<OrderCost>{

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

    @Override
    public boolean insert(OrderCost objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertOrderCost( ?,?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, objeto.getProduction_order_detail_id());                
                valores.setDouble(2, objeto.getCosto_total_modelo());
                valores.setDouble(3, objeto.getCosto_primo());
                valores.setDouble(4, objeto.getPrecio_venta());
                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(OrderCost objeto) {
        return false;
    }

    @Override
    public boolean activate(int id) {
        return false;
    }

}

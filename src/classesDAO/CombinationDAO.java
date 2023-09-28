package classesDAO;

import classes.Combination;
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
public class CombinationDAO implements DML<Combination>{

    private Connection con;

    public CombinationDAO() {
        con = new DbConexion().getCon();
    }

    // Método para obtener todos las combinaciones
    public List<Combination> ListarCombinacion() {
        List<Combination> Combination_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM combination";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int use_id = resultSet.getInt("use_id");
                int product_id = resultSet.getInt("product_id");
                int material_id = resultSet.getInt("material_id");
                Combination listaCombination = new Combination(use_id, product_id, material_id);

                Combination_lista.add(listaCombination);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }
        
        return Combination_lista;
    }
    //metodo de insert
    @Override
    public boolean insert(Combination objeto) {
    try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertCombination( ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, objeto.getProduct_id());
                valores.setInt(2, objeto.getMaterial_id());
                
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

    //metodo de update
    @Override
    public boolean update(Combination objeto) {
             try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateCombination( ?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, objeto.getUse_id());
                valores.setInt(2, objeto.getProduct_id());
                valores.setInt(3, objeto.getMaterial_id());
                
                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean activate(int id) {
        return false;
    }
    
}

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
public class CombinationDAO {

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
    
    // Método para agregar una combinacion
    public void AddCombination(Combination Combi) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertCombination( ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, Combi.getProduct_id());
                valores.setInt(2, Combi.getMaterial_id());
                
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para editar una combinación
    public void EditCombination(Combination Combi) {
        
         try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateCombination( ?,?,?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado                
                valores.setInt(1, Combi.getUse_id());
                valores.setInt(2, Combi.getProduct_id());
                valores.setInt(3, Combi.getMaterial_id());
                
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

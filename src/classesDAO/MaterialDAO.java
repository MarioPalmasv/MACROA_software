package classesDAO;
import classes.Material;
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
public class MaterialDAO {
     private Connection con;

    public MaterialDAO() {
        con = new DbConexion().getCon();
    }
    
     // Método para obtener todos los materiales
    public List<Material> ListarMateriales() {
        List<Material> materiales_lista = new ArrayList<>();
        try {
            String sql = "SELECT material_id, nombre, pulgada, cms, precio, pintura_empaque, estado FROM material";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int material_id = resultSet.getInt("material_id");
                String nombre = resultSet.getString("nombre");
                double pulgada = resultSet.getDouble("pulgada");
                double cms = resultSet.getDouble("cms");
                double precio = resultSet.getDouble("precio");
                double pintura_empaque = resultSet.getDouble("pintura_empaque");
                String estado = resultSet.getString("estado");

                Material material = new Material(material_id, nombre, pulgada, cms, precio, pintura_empaque, estado);
                materiales_lista.add(material);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
        }

        return materiales_lista;
    }
    
    // Método para agregar un nuevo material
    public void AgregarMateriales(Material material) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertMaterial(?, ?, ?, ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado
                valores.setString(1, material.getNombre());
                valores.setDouble(2, material.getPulgada());
                valores.setDouble(3, material.getCms());
                valores.setDouble(4, material.getPrecio());
                valores.setDouble(5, material.getPintura_empaque());
                
                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para eliminar un material
    public void EliminarMaterial(int materialId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL DeleteMaterial(?)}";
            CallableStatement valores = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            valores.setInt(1, materialId);

            valores.execute();
            valores.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Método para reactivar un material utilizando un ID
    public void EstadoMaterial(int materialId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateUseMaterial(?)}";
            CallableStatement callableStatement = con.prepareCall(sql);

            // Establecer el parámetro del procedimiento almacenado
            callableStatement.setInt(1, materialId);

            callableStatement.execute();
            callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

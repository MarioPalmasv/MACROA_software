package classesDAO;

import classes.Material;
import classes.Encode;
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

    private final Connection con;

    public MaterialDAO() {
        con = new DbConexion().getCon();
    }
    //instancia del objeto de encriptado
    Encode encrip = new Encode();

    // Método para obtener todos los materiales
    public List<Material> ListarMateriales() {

        List<Material> materiales_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM material";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql); 
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int material_id = resultSet.getInt("material_id");
                    //se envia el parametro recuperado de DB para desencriptar
                    String nombre = encrip.Desencriptar(resultSet.getString("nombre"));
                    double pulgada = resultSet.getDouble("pulgada");
                    double cms = resultSet.getDouble("cms");
                    double precio = resultSet.getDouble("precio");
                    double pintura_empaque = resultSet.getDouble("pintura_empaque");
                    String estado = resultSet.getString("estado");

                    Material material = new Material(material_id, nombre, pulgada, cms, precio, pintura_empaque, estado);
                    materiales_lista.add(material);
                }
            }
        } catch (SQLException e) {
        }

        return materiales_lista;
    }

    // Método para agregar un nuevo material
    public void AgregarMateriales(Material material) {
        //Se envia el valor insertado a la clase Encode para encriptar antes de insertar en DB
        String Cadena_Encriptar = encrip.Encriptar(material.getNombre());
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertMaterial(?, ?, ?, ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado
                valores.setString(1, Cadena_Encriptar);
                valores.setDouble(2, material.getPulgada());
                valores.setDouble(3, material.getCms());
                valores.setDouble(4, material.getPrecio());
                valores.setDouble(5, material.getPintura_empaque());

                valores.execute();
            }
        } catch (SQLException e) {
        }
    }

    // Método para eliminar un material
    public void EliminarMaterial(int materialId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL DeleteMaterial(?)}";
            // Establecer el parámetro del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer el parámetro del procedimiento almacenado
                valores.setInt(1, materialId);

                valores.execute();
            }
        } catch (SQLException e) {
        }
    }

    // Método para reactivar un material utilizando un ID
    public void EstadoMaterial(int materialId) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateUseMaterial(?)}";
            // Establecer el parámetro del procedimiento almacenado
            try (CallableStatement callableStatement = con.prepareCall(sql)) {
                // Establecer el parámetro del procedimiento almacenado
                callableStatement.setInt(1, materialId);

                callableStatement.execute();
            }
        } catch (SQLException e) {
        }
    }
}

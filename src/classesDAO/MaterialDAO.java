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
public class MaterialDAO  implements DML<Material>{

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
                    String nombre = (resultSet.getString("nombre"));
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

    //lista de materiales en base al nombre
    public List<Material> ListarMaterialesNombre(String pNombre) {

        List<Material> materiales_lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM material WHERE nombre LIKE ?";
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             preparedStatement.setString(1, "%"+pNombre+"%");
             
             ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int material_id = resultSet.getInt("material_id");
                    String nombre = (resultSet.getString("nombre"));
                    double pulgada = resultSet.getDouble("pulgada");
                    double cms = resultSet.getDouble("cms");
                    double precio = resultSet.getDouble("precio");
                    double pintura_empaque = resultSet.getDouble("pintura_empaque");
                    String estado = resultSet.getString("estado");

                    Material material = new Material(material_id, nombre, pulgada, cms, precio, pintura_empaque, estado);
                    materiales_lista.add(material);
                }
            
        } catch (SQLException e) {
        }

        return materiales_lista;
    }
    
    public List<Material> ListarMaterialesCombination(int PIdProduct) {

        List<Material> materiales_lista = new ArrayList<>();
        try {
            String sql = "SELECT c.use_id, m.material_id, m.nombre, m.pulgada, m.cms, m.precio, m.pintura_empaque, m.estado FROM material m " +
                        "JOIN combination c ON m.material_id = c.material_id " +
                        "JOIN product p ON c.product_id = p.product_id " +
                        "WHERE p.product_id = ?";
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             preparedStatement.setInt(1, PIdProduct);
             ResultSet resultSet = preparedStatement.executeQuery();
             
                while (resultSet.next()) {
                    int idCombination = resultSet.getInt("use_id");
                    int material_id = resultSet.getInt("material_id");
                    String nombre = (resultSet.getString("nombre"));
                    double pulgada = resultSet.getDouble("pulgada");
                    double cms = resultSet.getDouble("cms");
                    double precio = resultSet.getDouble("precio");
                    double pintura_empaque = resultSet.getDouble("pintura_empaque");
                    String estado = resultSet.getString("estado");
                    
                    Material material = new Material(material_id, nombre, pulgada, cms, precio, pintura_empaque, estado,idCombination);
                    materiales_lista.add(material);
                }
            
        } catch (SQLException e) {
        }

        return materiales_lista;
    }
    
    
    @Override
    public boolean insert(Material objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL InsertMaterial(?, ?, ?, ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado
                valores.setString(1, objeto.getNombre());
                valores.setDouble(2, objeto.getPulgada());
                valores.setDouble(3, objeto.getCms());
                valores.setDouble(4, objeto.getPrecio());
                valores.setDouble(5, objeto.getPintura_empaque());

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
            String sql = "{CALL DeleteMaterial(?)}";
            // Establecer el parámetro del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer el parámetro del procedimiento almacenado
                valores.setInt(1, id);

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Material objeto) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL UpdateMaterial(?, ?, ?, ?, ?, ?)}";
            // Establecer los parámetros del procedimiento almacenado
            try (CallableStatement valores = con.prepareCall(sql)) {
                // Establecer los parámetros del procedimiento almacenado
                valores.setInt(1, objeto.getMaterial_id());
                valores.setString(2, objeto.getNombre());
                valores.setDouble(3, objeto.getPulgada());
                valores.setDouble(4, objeto.getCms());
                valores.setDouble(5, objeto.getPrecio());
                valores.setDouble(6, objeto.getPintura_empaque());
                

                valores.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
        
    }

    //activar el material
    @Override
    public boolean activate(int id) {
        try {
            // Llamar al procedimiento almacenado
            String sql = "{CALL ActivateUseMaterial(?)}";
            // Establecer el parámetro del procedimiento almacenado
            try (CallableStatement callableStatement = con.prepareCall(sql)) {
                // Establecer el parámetro del procedimiento almacenado
                callableStatement.setInt(1, id);

                callableStatement.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}

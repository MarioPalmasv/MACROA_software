/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCon {
    
        public static void main(String[] args) {
        DbConexion dbConexion = new DbConexion();

        try {
            Connection con = dbConexion.getCon();

            if (con != null) {
                // Consulta SQL para obtener los datos de la tabla "material" con campos específicos
                String sql = "SELECT material_id, nombre, pulgada, cms, precio, pintura_empaque, estado FROM material";

                // Preparar la consulta
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                // Ejecutar la consulta
                ResultSet resultSet = preparedStatement.executeQuery();

                // Mostrar los datos en la consola
                while (resultSet.next()) {
                    int materialId = resultSet.getInt("material_id");
                    String nombre = resultSet.getString("nombre");
                    double pulgada = resultSet.getDouble("pulgada");
                    double cms = resultSet.getDouble("cms");
                    double precio = resultSet.getDouble("precio");
                    double pinturaEmpaque = resultSet.getDouble("pintura_empaque");
                    String estado = resultSet.getString("estado");

                    System.out.println("Material ID: " + materialId);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Pulgada: " + pulgada);
                    System.out.println("Cms: " + cms);
                    System.out.println("Precio: " + precio);
                    System.out.println("Pintura_Empaque: " + pinturaEmpaque);
                    System.out.println("Estado: " + estado);
                    System.out.println();
                }

                // Cerrar recursos
                resultSet.close();
                preparedStatement.close();
                con.close();
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

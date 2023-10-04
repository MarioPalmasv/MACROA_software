package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author gergo
 */
public class DbConexion {
    private Connection con;
    
    public DbConexion (){
        try{           
            // Cargar el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");            
            
            //Class.forName("com.mysql.jdbc.Driver");
            con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/macroa", "root", "");
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error al establecer la conexión con el server");
        }
    }

    public Connection getCon() {
        return con;
    }
}

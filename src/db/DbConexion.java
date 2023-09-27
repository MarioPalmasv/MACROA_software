package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            System.err.println("Error " + e);
        }
    }

    public Connection getCon() {
        return con;
    }
}

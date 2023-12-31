/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;
import classes.ProductOrder;
import classes.User;
import db.DbConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author melan
 */
public class UserDAO implements DML<User>{
    private Connection con;
    
    public UserDAO(){
        con = new DbConexion().getCon();
    }
    
    
    
    public User IngresarSistema(String usuario, String contrasenia) {
        User user = null; // Inicializamos user como nulo (indicando que el usuario no existe)

        try {
            String sql = "SELECT * FROM user WHERE user_name=? AND Password_user=?";

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, usuario); 
                statement.setString(2, contrasenia); 
                ResultSet resultSet = statement.executeQuery(); 

                if (resultSet.next()) {
                    user = new User();
                    user.setUser_id(resultSet.getInt("user_id"));
                    user.setFirst_name(resultSet.getString("first_name"));
                    user.setLast_name(resultSet.getString("last_name"));
                    user.setUser_name(resultSet.getString("user_name"));
                    user.setPassword_user(resultSet.getString("password_user"));
                    user.setEmail(resultSet.getString("email"));
                    user.setSalary_employee(resultSet.getDouble("salary_employee"));
                    user.setAddress(resultSet.getString("address"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setState(resultSet.getString("state"));
                    user.setType_user(resultSet.getString("user_type"));
                }
            }
        } catch (SQLException e) {

        }

        return user; 
    }
    public List<User> ListarUsuarios() {
        List<User> listaUser = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USER";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setPassword_user(resultSet.getString("password_user"));
                user.setEmail(resultSet.getString("email"));
                user.setSalary_employee(resultSet.getDouble("salary_employee"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setState(resultSet.getString("state"));
                user.setType_user(resultSet.getString("user_type"));
                listaUser.add(user);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
        }

        return listaUser;
    }
    public List<User> ListarUserName() {
        List<User> listaUserName = new ArrayList<>();
        try {
            String sql = "SELECT user_name,password_user FROM USER";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();                
                user.setUser_name(resultSet.getString("user_name"));
                user.setPassword_user(resultSet.getString("password_user"));
                listaUserName.add(user);
            }            
            resultSet.close();
            preparedStatement.close();           
        } catch (SQLException e) {
        }
        return listaUserName;
    }
    
      public List<User> ListarUsuariosNombre(String pNombre) {
        List<User> listaUser = new ArrayList<>();
        try {
            String sql = "SELECT * FROM USER WHERE CONCAT(first_name, ' ', last_name) LIKE ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "%"+pNombre+"%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setUser_name(resultSet.getString("user_name"));
                user.setPassword_user(resultSet.getString("password_user"));
                user.setEmail(resultSet.getString("email"));
                user.setSalary_employee(resultSet.getDouble("salary_employee"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setState(resultSet.getString("state"));
                user.setType_user(resultSet.getString("user_type"));
                listaUser.add(user);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
        }

        return listaUser;
    }

    @Override
    public boolean insert(User objeto) {
        try {
            String sql = "{CALL InsertUser(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

          
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setString(1, objeto.getFirst_name());
                valores.setString(2,objeto.getLast_name());
                valores.setString(3, objeto.getUser_name());
                valores.setString(4, objeto.getPassword_user());
                valores.setString(5, objeto.getEmail());
                valores.setDouble(6, objeto.getSalary_employee());
                valores.setString(7, objeto.getAddress());
                valores.setString(8, objeto.getPhone());
                valores.setString(9, objeto.getType_user());

                valores.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            String sql = "{CALL DeleteUser(?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User objeto) {
        try {
            String sql = "{CALL UpdateUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            
            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, objeto.getUser_id());
                valores.setString(2, objeto.getFirst_name());
                valores.setString(3, objeto.getLast_name());
                valores.setString(4, objeto.getUser_name());
                valores.setString(5, objeto.getEmail());
                valores.setDouble(6, objeto.getSalary_employee());
                valores.setString(7, objeto.getAddress());
                valores.setString(8, objeto.getPhone());
                valores.setString(9, objeto.getPassword_user());
                valores.setString(10, objeto.getType_user());

                valores.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean activate(int id) {
        try {
            String sql = "{CALL ActivateUser(?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setInt(1, id);

                valores.execute();
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


}

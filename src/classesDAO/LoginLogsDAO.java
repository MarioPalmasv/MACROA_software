/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAO;

import classes.LoginLogs;
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
 * @author melan
 */
public class LoginLogsDAO {
    private Connection con;
    
    public LoginLogsDAO(){
        con = new DbConexion().getCon();
    }
    
    public List<LoginLogs> ListarLogins() {
        List<LoginLogs> lista_login = new ArrayList<>();
        try {
            String sql = "SELECT * FROM login_logs";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                LoginLogs login = new LoginLogs();
                login.setLogin_id(resultSet.getInt("login_id"));
                login.setIp_address(resultSet.getString("ip_address"));
                login.setLogin_time(resultSet.getTimestamp("login_time"));
                login.setUser_id(resultSet.getInt("user_id"));
                lista_login.add(login);
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
        }
        
        return lista_login;
    }
    
    public void InsertarLoginLog(String ipAddress, int userId) {
        try {
            String sql = "{CALL InsertLoginLog(?, ?)}";

            try (CallableStatement valores = con.prepareCall(sql)) {
                valores.setString(1, ipAddress);
                valores.setInt(2, userId);

                valores.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

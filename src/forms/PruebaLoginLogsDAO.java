/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author melan
 */
import classes.LoginLogs;
import classesDAO.LoginLogsDAO;
import java.util.Date;
import java.util.List;
import classes.ObtenerIP;

public class PruebaLoginLogsDAO {
    public static void main(String[] args) {
        // Crear una instancia de LoginLogsDAO para realizar operaciones en la base de datos
        LoginLogsDAO loginLogsDAO = new LoginLogsDAO();
        ObtenerIP ip = new ObtenerIP();

        // Insertar un nuevo registro de inicio de sesión
        LoginLogs nuevoLogin = new LoginLogs(ip.obtenerIP(), 1); // Asegúrate de proporcionar una IP válida y un ID de usuario existente
        loginLogsDAO.InsertarLoginLog(nuevoLogin.getIp_address(), nuevoLogin.getUser_id());
        System.out.println("Registro de inicio de sesión insertado con éxito.");

        // Listar todos los registros de inicio de sesión
        List<LoginLogs> registrosDeLogin = loginLogsDAO.ListarLogins();
        System.out.println("Lista de registros de inicio de sesión:");
        for (LoginLogs login : registrosDeLogin) {
            System.out.println("ID de inicio de sesión: " + login.getLogin_id());
            System.out.println("IP Address: " + login.getIp_address());
            System.out.println("Fecha y hora de inicio de sesión: " + login.getLogin_time());
            System.out.println("ID de usuario: " + login.getUser_id());
            System.out.println("-------------------");
        }
    }
}


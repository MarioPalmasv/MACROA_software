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
import classes.User;
import classesDAO.UserDAO;
import java.util.List;

public class PruebaUserDAO {
    public static void main(String[] args) {
        // Crear una instancia de UserDAO para realizar operaciones en la base de datos
        UserDAO userDAO = new UserDAO();

        // Insertar un nuevo usuario
//        User nuevoUsuario = new User("Nombre", "Apellido", "memem", "melmel@example.com", 5000.0, "Dirección", "123456789", "a");
//        userDAO.InsertarUsuario(nuevoUsuario);

        // Listar todos los usuarios
        List<User> usuarios = userDAO.ListarUsuarios();
        System.out.println("Lista de usuarios:");
        for (User usuario : usuarios) {
            System.out.println("ID: " + usuario.getUser_id());
            System.out.println("Nombre: " + usuario.getFirst_name() + " " + usuario.getLast_name());
            System.out.println("Usuario: " + usuario.getUser_name());
            System.out.println("Usuario: " + usuario.getPassword_user());
            System.out.println("Correo: " + usuario.getEmail());
            System.out.println("Salario: " + usuario.getSalary_employee());
            System.out.println("Dirección: " + usuario.getAddress());
            System.out.println("Teléfono: " + usuario.getPhone());
            System.out.println("Estado: " + usuario.getState());
            System.out.println("-------------------");
        }

         //Actualizar un usuario existente
        if (!usuarios.isEmpty()) {
            User usuarioActualizar = usuarios.get(0); // Obtener el primer usuario de la lista (puedes cambiar el índice según tus necesidades)
            usuarioActualizar.setFirst_name("NuevoNombre");
            usuarioActualizar.setLast_name("NuevoApellido");
            usuarioActualizar.setEmail("nuevo2@example.com");
            userDAO.ActualizarUsuario(usuarioActualizar, usuarioActualizar.getUser_id());
            System.out.println("Usuario actualizado con éxito.");
        }
//
//         Activar o eliminar un usuario existente
//        if (!usuarios.isEmpty()) {
//            User usuarioActualizar = usuarios.get(0); // Obtener el primer usuario de la lista (puedes cambiar el índice según tus necesidades)
//
//             Eliminar el usuario
//            userDAO.EliminarUsuario(usuarioActualizar.getUser_id());
//            System.out.println("Usuario eliminado con éxito.");
//
//             Activar el usuario (cambiar el estado de 'd' a 'a')
//            userDAO.ActivarUsuario(usuarioActualizar.getUser_id());
//            System.out.println("Usuario activado con éxito.");
//        }
    }
}


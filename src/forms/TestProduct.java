package forms;

import java.util.List;
import classes.Product;
import classesDAO.ProductDAO;

/**
 *
 * @author gergo
 */
public class TestProduct {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductDAO P_DAO = new ProductDAO();

        List<Product> List_productos = P_DAO.ListarProdcut();
        System.out.println("Lista de productos:");
        
        for (Product producto : List_productos) {
            System.out.println("ID: " + producto.getProduct_id());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("modelo: " + producto.getModelo());
            System.out.println("state: " + producto.getState());
            System.out.println("time in: " + producto.getTime_in());
            System.out.println("constante: " + producto.getConstante_mod());
        }

        //Agregar un nuevo producto
        Product nuevoProducto = new Product(0, "gerson  Producto", "Bueno", "", 10.0, 51.0);
        P_DAO.AgregarProductos(nuevoProducto);

        System.out.println(" material agregado: " + nuevoProducto.getNombre());
        System.out.println("===================================================");

        //Editar un nuevo producto
        //Recordar enviar el ID a editar
        Product EditarProducto = new Product(2, "GOMEZ Producto", "Editado", "", 1.0, 1.0);
        P_DAO.EditProductos(EditarProducto);
        System.out.println(" Editado:  " + EditarProducto.getNombre());
        System.out.println("===================================================");

        //Eliminar         
        int EliminarProductol_id = 2; // Reemplazar con el ID del material a eliminar
        P_DAO.EliminarProducto(EliminarProductol_id);
        System.out.println("Producto eliminado ID:  " + EliminarProductol_id);
        System.out.println("===================================================");

        //ActivarP
        int ActivarProductol_id = 2; // Reemplazar con el ID del material a eliminar
        P_DAO.ActivarProducto(ActivarProductol_id);
        System.out.println("Producto eliminado ID:  " + ActivarProductol_id);
        System.out.println("===================================================");

    }
}

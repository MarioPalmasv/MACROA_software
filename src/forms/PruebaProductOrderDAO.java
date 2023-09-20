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
import classes.ProductOrder;
import classesDAO.ProductOrderDAO;
import java.util.Date;
import java.util.List;

public class PruebaProductOrderDAO {
    public static void main(String[] args) {
        // Crear una instancia de ProductOrderDAO para realizar operaciones en la base de datos
        ProductOrderDAO productOrderDAO = new ProductOrderDAO();

        // Agregar una nueva orden de producción
        int userId = 1; // ID del usuario
        String nombre = "Orden de Prueba";
        String comentario = "Esta es una orden de prueba";
        productOrderDAO.AgregarProductOrder(userId, nombre, comentario);

        // Listar todas las órdenes de producción
        List<ProductOrder> ordenes = productOrderDAO.ListarOrdenes();
        System.out.println("Lista de órdenes de producción:");
        for (ProductOrder order : ordenes) {
            System.out.println("ID: " + order.getProduction_order_id());
            System.out.println("Nombre: " + order.getNombre());
            System.out.println("Fecha de orden: " + order.getOrder_date());
            System.out.println("Comentario: " + order.getComent());
            System.out.println("Estado: " + order.getState());
            System.out.println("-------------------");
        }

        // Actualizar una orden de producción existente
        if (!ordenes.isEmpty()) {
            ProductOrder orderActualizar = ordenes.get(0); // Obtener la primera orden de la lista (puedes cambiar el índice según tus necesidades)
            orderActualizar.setNombre("Nueva Orden Actualizada");
            orderActualizar.setComent("Este es un comentario actualizado");
            productOrderDAO.ActualizarProductOrder(orderActualizar, orderActualizar.getProduction_order_id());
            System.out.println("Orden actualizada con éxito.");
        }

        // Activar o cancelar una orden de producción existente
        if (!ordenes.isEmpty()) {
            ProductOrder orderActualizar = ordenes.get(0); // Obtener la primera orden de la lista (puedes cambiar el índice según tus necesidades)

            // Cancelar la orden
            productOrderDAO.ActualizarOrderCancelada(orderActualizar.getProduction_order_id());
            System.out.println("Orden cancelada con éxito.");

            // Activar la orden (cambiar el estado de 'c' a 'a')
            productOrderDAO.ActivarOrder(orderActualizar.getProduction_order_id());
            System.out.println("Orden activada con éxito.");
        }
    }
}

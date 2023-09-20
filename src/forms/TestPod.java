package forms;

import classes.ProductionOrderDetail;
import classesDAO.production_order_detailDAO;
import java.util.List;

/**
 *
 * @author gergo
 */
public class TestPod {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        production_order_detailDAO pod = new production_order_detailDAO();

        List<ProductionOrderDetail> List_pod = pod.ListarOrderDetails();

//        System.out.println("lista de ordenes");
//        for (ProductionOrderDetail Order : List_pod) {
//            System.out.println("production_order_detail_id:  " + Order.getProuction_order_detail_id());
//            System.out.println("product_id: " + Order.getProduct_id());
//            System.out.println("production_order_id: " + Order.getProduction_order_id());
//            System.out.println("quantity: " + Order.getQuantity());
//            System.out.println("sub_total: " + Order.getSub_total());
//            System.out.println("costo_cola_cromada: " + Order.getCosto_cola_cromada());
//            System.out.println("state: " + Order.getState());
//        }
//        
               
         //Agregar un nuevo producto
//        ProductionOrderDetail nuevaorderDetail = new ProductionOrderDetail(0,1,1,50,200,25,"A");
//        pod.AddOrderC(nuevaorderDetail);
//
//        System.out.println(" nueva orden agregado: ");
//        System.out.println("===================================================");
//
//        
//        
//                //Eliminar         
//        int EliminarOrderD_id = 2; // Reemplazar con el ID del material a eliminar
//        pod.CancelarOrderC(EliminarOrderD_id);
//        System.out.println("Producto eliminado ID:  " + EliminarOrderD_id);
//        System.out.println("===================================================");
//        
//        
        
                    //Eliminar         
        int ActivarOrderD_id = 2; // Reemplazar con el ID del material a eliminar
        pod.ActivarOrderC(ActivarOrderD_id);
        System.out.println("Producto Activado ID:  " + ActivarOrderD_id);
        System.out.println("===================================================");
    }
 }


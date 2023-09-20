package forms;

import java.util.List;
import classes.Combination;
import classesDAO.CombinationDAO;

/**
 *
 * @author gergo
 */
public class TestCombination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CombinationDAO combination_DAO = new CombinationDAO();

        List<Combination> List_combi = combination_DAO.ListarCombinacion();
        System.out.println("Lista de combinaciones:");
        
        for (Combination combinacion : List_combi) {
            System.out.println("ID: " + combinacion.getUse_id());
            System.out.println("Producto ID: " + combinacion.getProduct_id() );
            System.out.println("Material ID: " + combinacion.getMaterial_id());            
        }
          //Agregar una nueva combinacion
        Combination NuevaCombination = new Combination(0,1,1);
        combination_DAO.AddCombination(NuevaCombination);

        System.out.println("Se registró la combinacion de:");
        System.out.println("Producto ID: "+NuevaCombination.getProduct_id());
        System.out.println("Material ID: "+NuevaCombination.getMaterial_id());
        System.out.println("===================================================");
  
        //Editar una  combinacion
        Combination EditarCombination = new Combination(2, 1, 1);
        combination_DAO.EditCombination(EditarCombination);
        System.out.println("Se edito la combinacion con id " + EditarCombination.getUse_id());

    }
}

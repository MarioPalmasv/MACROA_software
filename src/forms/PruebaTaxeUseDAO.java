/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.TaxeUse;
import classesDAO.TaxeUseDAO;
import java.util.List;

/**
 *
 * @author melan
 */
public class PruebaTaxeUseDAO {
    public static void main(String[] args) {
        // Crear una instancia de TaxeUseDAO para interactuar con la base de datos
        TaxeUseDAO taxeUseDAO = new TaxeUseDAO();

        // Listar todos los registros de taxe_use
//        List<TaxeUse> listaTaxeUse = taxeUseDAO.listarTaxeUse();
//        for (TaxeUse taxe : listaTaxeUse) {
//            System.out.println("Order Cost ID: " + taxe.getOrder_cost_id());
//            System.out.println("Taxe Use: " + taxe.getTaxe_use());
//            System.out.println("--------------------");
//        }

        // Insertar un nuevo registro en taxe_use
        TaxeUse nuevoTaxeUse = new TaxeUse(123, 456); // Ejemplo de datos
        taxeUseDAO.InsertarTaxeUse(nuevoTaxeUse);

        // Actualizar un registro existente en taxe_use
//        TaxeUse taxeExistente = new TaxeUse(789, 101); // Ejemplo de datos
//        int idActualizar = 1; // ID del registro que deseas actualizar
//        taxeUseDAO.ActualizarTaxeUse(taxeExistente, idActualizar);
    }





    
}

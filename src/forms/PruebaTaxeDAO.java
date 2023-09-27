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
import classes.Taxe;
import classesDAO.TaxeDAO;
import java.util.List;

public class PruebaTaxeDAO {
    public static void main(String[] args) {
        // Crear una instancia de TaxeDAO para realizar operaciones en la base de datos
        TaxeDAO taxeDAO = new TaxeDAO();

        // Insertar un nuevo impuesto
        Taxe nuevoImpuesto = new Taxe("Impuesto 1", "10%", 100.0); // Asegúrate de proporcionar valores válidos
        taxeDAO.InsertarImpuesto(nuevoImpuesto);
        System.out.println("Impuesto insertado con éxito.");

        // Listar todos los impuestos
        List<Taxe> impuestos = taxeDAO.listarTaxe();
        System.out.println("Lista de impuestos:");
        for (Taxe impuesto : impuestos) {
            System.out.println("ID de impuesto: " + impuesto.getTaxe_id());
            System.out.println("Nombre: " + impuesto.getNAME());
            System.out.println("Porcentaje: " + impuesto.getPercentage());
            System.out.println("Valor: " + impuesto.getVALUE());
            System.out.println("-------------------");
        }

        // Actualizar un impuesto existente (debes proporcionar un ID de impuesto válido)
        int idImpuestoAActualizar = 1; // Reemplaza con un ID válido de impuesto
        Taxe impuestoActualizado = new Taxe("Impuesto Actualizado", "15%", 150.0);
        taxeDAO.ActualizarImpuesto(impuestoActualizado, idImpuestoAActualizar);
        System.out.println("Impuesto actualizado con éxito.");
    }
}

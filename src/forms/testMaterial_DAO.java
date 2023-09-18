/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package forms;

import classesDAO.MaterialDAO;
import classes.Material;
import java.util.List;

/**
 *
 * @author gergo
 */
public class testMaterial_DAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancas del obj dao 
        MaterialDAO materialDAO = new MaterialDAO();
        listar();
        System.out.println("===================================================");

        //Agregar un nuevo material 
        ////// EL ESTADO SIEMPRE LO ENVIA COMO A
        
        Material nuevoMaterial = new Material(0, "Daniel Material", 11.0, 21.0, 51.0, 51.0, "");
        materialDAO.AgregarMateriales(nuevoMaterial);
        System.out.println(" material agregado: " + nuevoMaterial.getNombre());        
        listar();
        System.out.println("===================================================");

        //Eliminar un material (cambia el estado a 'd')
        
        int EliminarMaterial_id = 1; // Reemplazar con el ID del material a eliminar
        materialDAO.EliminarMaterial(EliminarMaterial_id);
        System.out.println("\nMaterial eliminado con ID " + EliminarMaterial_id);
        listar();
        System.out.println("===================================================");
        
        
        //Reactivar un material (cambia el estado a 'a')
        int ActivarMaterial_id = 1; // Reemplaza con el ID del material que deseas reactivar
        materialDAO.EstadoMaterial(ActivarMaterial_id);
        System.out.println("\nMaterial reactivado con ID " + ActivarMaterial_id);
        listar();
        System.out.println("===================================================");

    }

    public static void listar() {
        MaterialDAO materialDAO = new MaterialDAO();
        //Listar materiales
        List<Material> materiales = materialDAO.ListarMateriales();
        System.out.println("Lista de materiales:");
        for (Material material : materiales) {
            System.out.println("Material ID: " + material.getMaterial_id());
            System.out.println("Nombre: " + material.getNombre());
            System.out.println("Pulgada: " + material.getPulgada());
            System.out.println("Cms: " + material.getCms());
            System.out.println("Precio: " + material.getPrecio());
            System.out.println("Pintura/Empaque: " + material.getPintura_empaque());
            System.out.println("Estado: " + material.getEstado());
            System.out.println();
        }
    }
}

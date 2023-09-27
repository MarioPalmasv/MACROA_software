/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gergo
 */
public class Material {
    private int material_id;
    private String nombre;
    private double pulgada;
    private double cms;
    private double precio;
    private double pintura_empaque;
    private String estado;

    public Material(int material_id, String nombre, double pulgada, double cms, double precio, double pintura_empaque, String estado) {
        this.material_id = material_id;
        this.nombre = nombre;
        this.pulgada = pulgada;
        this.cms = cms;
        this.precio = precio;
        this.pintura_empaque = pintura_empaque;
        this.estado = estado;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPulgada() {
        return pulgada;
    }

    public void setPulgada(double pulgada) {
        this.pulgada = pulgada;
    }

    public double getCms() {
        return cms;
    }

    public void setCms(double cms) {
        this.cms = cms;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPintura_empaque() {
        return pintura_empaque;
    }

    public void setPintura_empaque(double pintura_empaque) {
        this.pintura_empaque = pintura_empaque;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author gergo
 */
public class Product {
    private int product_id;
    private String nombre;
    private String modelo;
    private String state;
    private double time_in;
    private double constante_mod;

    public Product(int product_id, String nombre, String modelo, String state, double time_in, double constante_mod) {
        this.product_id = product_id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.state = state;
        this.time_in = time_in;
        this.constante_mod = constante_mod;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTime_in() {
        return time_in;
    }

    public void setTime_in(double time_in) {
        this.time_in = time_in;
    }

    public double getConstante_mod() {
        return constante_mod;
    }

    public void setConstante_mod(double constante_mod) {
        this.constante_mod = constante_mod;
    }
   
}

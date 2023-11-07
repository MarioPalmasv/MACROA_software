/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author melan
 */
public class OrderCost {
    private int order_id;
    private int production_order_detail_id;
    private double costo_total_modelo;
    private double costo_primo;
    private double precio_venta;

    // Constructor
    public OrderCost(int order_id, int production_order_detail_id, double costo_total_modelo, double costo_primo, double precio_venta) {
        this.order_id = order_id;
        this.production_order_detail_id = production_order_detail_id;
        this.costo_total_modelo = costo_total_modelo;
        this.costo_primo = costo_primo;
        this.precio_venta = precio_venta;
    }
    
    //este constructor es nuevo je
    public OrderCost( int production_order_detail_id, double costo_total_modelo, double costo_primo, double precio_venta) {
        this.production_order_detail_id = production_order_detail_id;
        this.costo_total_modelo = costo_total_modelo;
        this.costo_primo = costo_primo;
        this.precio_venta = precio_venta;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduction_order_detail_id() {
        return production_order_detail_id;
    }

    public void setProduction_order_detail_id(int production_order_detail_id) {
        this.production_order_detail_id = production_order_detail_id;
    }

    public double getCosto_total_modelo() {
        return costo_total_modelo;
    }

    public void setCosto_total_modelo(double costo_total_modelo) {
        this.costo_total_modelo = costo_total_modelo;
    }

    public double getCosto_primo() {
        return costo_primo;
    }

    public void setCosto_primo(double costo_primo) {
        this.costo_primo = costo_primo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author melan
 */
public class ProductionOrderDetail {
    private int production_order_detail_id;
    private int product_id;
    private int production_order_id;
    private int quantity;
    private double sub_total;
    private double costo_cola_cromada;
    private String state;

    // Constructor
    public ProductionOrderDetail(int production_order_detail_id, int product_id, int production_order_id, int quantity, double sub_total, double costo_cola_cromada, String state) {
        this.production_order_detail_id = production_order_detail_id;
        this.product_id = product_id;
        this.production_order_id = production_order_id;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.costo_cola_cromada = costo_cola_cromada;
        this.state = state;
    }

    public int getProuction_order_detail_id() {
        return production_order_detail_id;
    }

    public void setProuction_order_detail_id(int production_order_detail_id) {
        this.production_order_detail_id = production_order_detail_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduction_order_id() {
        return production_order_id;
    }

    public void setProduction_order_id(int production_order_id) {
        this.production_order_id = production_order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public double getCosto_cola_cromada() {
        return costo_cola_cromada;
    }

    public void setCosto_cola_cromada(double costo_cola_cromada) {
        this.costo_cola_cromada = costo_cola_cromada;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

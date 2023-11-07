/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Date;

/**
 *
 * @author melan
 */
public class ProductionOrderDetail {

    private int production_order_detail_id;
    private int product_id;
    //agregue este campo con los get y set
    private String nombre_prod;
    private int production_order_id;
    private int quantity;
    private double sub_total;
    private double costo_cola_cromada;
    private String state;
    //g
    private String nombre;//nombre de la orden
    private String nombre_user;//g nuevo //nombre de quine hizo la orden
    //private String producto;
    private Date fecha;
    private double costo_primo, costo_total_modelo, precio_venta, precio_ganancia;
    private int order_cost_id;

    public ProductionOrderDetail() {
    }

    
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

    //este constructor es nuevo (mela)
    public ProductionOrderDetail(int production_order_detail_id, int product_id, String nombre_prod, int production_order_id, int quantity, double sub_total, double costo_cola_cromada, String state) {
        this.production_order_detail_id = production_order_detail_id;
        this.product_id = product_id;
        this.nombre_prod = nombre_prod;
        this.production_order_id = production_order_id;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.costo_cola_cromada = costo_cola_cromada;
        this.state = state;
    }

//    //g recibe lo de ambas tablas
      public ProductionOrderDetail(String nombre_user, String nombre, Date fecha,int production_order_detail_id, int product_id, int production_order_id, 
            int quantity, double sub_total, double costo_cola_cromada, String state, String nombre_prod, double costo_primo, double costo_total_modelo, double precio_venta, double  precio_ganancia,
            int order_cost_id) {        
        this.nombre_user = nombre_user;
        this.nombre = nombre;
        this.fecha = fecha;
        this.production_order_detail_id = production_order_detail_id;
        this.product_id = product_id;
        this.order_cost_id=order_cost_id;
        this.production_order_id = production_order_id;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.costo_cola_cromada = costo_cola_cromada;
        this.state = state;
        this.nombre_prod = nombre_prod;
        this.costo_primo = costo_primo;
        this.costo_total_modelo = costo_total_modelo;
        this.precio_venta = precio_venta;
        this.precio_ganancia = precio_ganancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto_primo() {
        return costo_primo;
    }

    public void setCosto_primo(double costo_primo) {
        this.costo_primo = costo_primo;
    }

    public double getCosto_total_modelo() {
        return costo_total_modelo;
    }

    public void setCosto_total_modelo(double costo_total_modelo) {
        this.costo_total_modelo = costo_total_modelo;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_ganancia() {
        return precio_ganancia;
    }

    public void setPrecio_ganancia(double precio_ganancia) {
        this.precio_ganancia = precio_ganancia;
    }

    public int getOrder_cost_id() {
        return order_cost_id;
    }

    public void setOrder_cost_id(int order_cost_id) {
        this.order_cost_id = order_cost_id;
    }
    
    
    //

    public ProductionOrderDetail(int product_id, int production_order_id, int quantity, double sub_total, double costo_cola_cromada, String state) {
        this.product_id = product_id;
        this.production_order_id = production_order_id;
        this.quantity = quantity;
        this.sub_total = sub_total;
        this.costo_cola_cromada = costo_cola_cromada;
        this.state = state;
    }

    public int getProduction_order_detail_id() {
        return production_order_detail_id;
    }

    public void setProduction_order_detail_id(int production_order_detail_id) {
        this.production_order_detail_id = production_order_detail_id;
    }

    //los get y set
    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
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

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
public class ProductOrder {
    private int id;
    private int production_order_id;
    private int user_id;
    private String nombre;
    private Date order_date;
    private String coment;
    private String state;

    public ProductOrder(){}
    
// Constructor
    public ProductOrder(int user_id, String nombre, Date order_date, String coment, String state) {
        this.user_id = user_id;
        this.nombre = nombre;
        this.order_date = order_date;
        this.coment = coment;
        this.state = state;
    }

    public ProductOrder(int id, int production_order_id, int user_id, String nombre, Date order_date, String coment, String state) {
        this.id = id;
        this.production_order_id = production_order_id;
        this.user_id = user_id;
        this.nombre = nombre;
        this.order_date = order_date;
        this.coment = coment;
        this.state = state;
    }
    

    public ProductOrder(int user_id, String nombre, String coment) {
        this.user_id = user_id;
        this.nombre = nombre;
        this.coment = coment;
    }

    
    public int getProduction_order_id() {
        return production_order_id;
    }

    public void setProduction_order_id(int production_order_id) {
        this.production_order_id = production_order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

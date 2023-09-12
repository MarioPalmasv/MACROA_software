/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author melan
 */
public class TaxeUse {
    private int taxe_id;
    private int order_cost_id;
    private int taxe_use;

    // Constructor
    public TaxeUse(int taxe_id, int order_cost_id, int taxe_use) {
        this.taxe_id = taxe_id;
        this.order_cost_id = order_cost_id;
        this.taxe_use = taxe_use;
    }

    public int getTaxe_id() {
        return taxe_id;
    }

    public void setTaxe_id(int taxe_id) {
        this.taxe_id = taxe_id;
    }

    public int getOrder_cost_id() {
        return order_cost_id;
    }

    public void setOrder_cost_id(int order_cost_id) {
        this.order_cost_id = order_cost_id;
    }

    public int getTaxe_use() {
        return taxe_use;
    }

    public void setTaxe_use(int taxe_use) {
        this.taxe_use = taxe_use;
    }
}

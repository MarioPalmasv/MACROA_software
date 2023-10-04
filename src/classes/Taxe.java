/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author melan
 */
public class Taxe {
    private int taxe_id;
    private String NAME;
    private String percentage;
    private double VALUE;
    
    public Taxe(){}

    public Taxe(int taxe_id, String NAME, String percentage, double VALUE) {
        this.taxe_id = taxe_id;
        this.NAME = NAME;
        this.percentage = percentage;
        this.VALUE = VALUE;
    }
    
    
    // Constructor
    public Taxe(String NAME, String percentage, double VALUE) {
        this.NAME = NAME;
        this.percentage = percentage;
        this.VALUE = VALUE;
    }

    public int getTaxe_id() {
        return taxe_id;
    }

    public void setTaxe_id(int taxe_id) {
        this.taxe_id = taxe_id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public double getVALUE() {
        return VALUE;
    }

    public void setVALUE(double VALUE) {
        this.VALUE = VALUE;
    }
}

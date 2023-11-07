
package classes;

/**
 *
 * @author gergo
 */
public class JasperClase {
    private String producto;
    private String cantidad;
    private String cola_cromada;
    private String costo_primo;
    private String sub_total;
    private String precio_venta;
    private String total_modelo;
    private String ganancia;

    public JasperClase(String producto, String cantidad, String cola_cromada, String costo_primo, String sub_total, String precio_venta, String total_modelo, String ganancia) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cola_cromada = cola_cromada;
        this.costo_primo = costo_primo;
        this.sub_total = sub_total;
        this.precio_venta = precio_venta;
        this.total_modelo = total_modelo;
        this.ganancia = ganancia;
        
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCola_cromada() {
        return cola_cromada;
    }

    public void setCola_cromada(String cola_cromada) {
        this.cola_cromada = cola_cromada;
    }

    public String getCosto_primo() {
        return costo_primo;
    }

    public void setCosto_primo(String costo_primo) {
        this.costo_primo = costo_primo;
    }

    public String getSub_total() {
        return sub_total;
    }

    public void setSub_total(String sub_total) {
        this.sub_total = sub_total;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getTotal_modelo() {
        return total_modelo;
    }

    public void setTotal_modelo(String total_modelo) {
        this.total_modelo = total_modelo;
    }

    public String getGanancia() {
        return ganancia;
    }

    public void setGanancia(String ganancia) {
        this.ganancia = ganancia;
    }

    

    
}

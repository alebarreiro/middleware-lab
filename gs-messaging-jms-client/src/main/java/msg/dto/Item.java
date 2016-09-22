package msg.dto;

/**
 * Created by alejandrobarreiro on 21/9/16.
 */
public class Item {

    private long id;
    private int categoria;
    private int catnidad;
    private double precio;
    private String descripcion;


    public Item() {}


    public Item(long id, int categoria, int catnidad, double precio, String descripcion) {
        this.id = id;
        this.categoria = categoria;
        this.catnidad = catnidad;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCatnidad() {
        return catnidad;
    }

    public void setCatnidad(int catnidad) {
        this.catnidad = catnidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

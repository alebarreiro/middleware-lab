package ticketinco.model;

public class Ticket {

    private long id;
    private String sector;
    private double precio;
    private int cantidad;

    private Funcion funcion;

    public Ticket(long id, String sector, Funcion funcion, int cantidad, double precio) {
        this.id = id;
        this.sector = sector;
        this.funcion = funcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

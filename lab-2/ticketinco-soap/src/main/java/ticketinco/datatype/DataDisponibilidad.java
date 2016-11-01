package ticketinco.datatype;

import ticketinco.model.Disponibilidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataDisponibilidad implements Serializable {
    private String sector;
    private double precio;
    private int cantidadDisponible;

    public DataDisponibilidad() {}

    public DataDisponibilidad(String sector, double precio, int cantidadDisponible) {
        this.sector = sector;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getSector() {
        return sector;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return "DataDisponibilidad{" +
                "sector='" + sector + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidadDisponible +
                '}';
    }

    public static List<DataDisponibilidad> getDataDisponibilidades(List<Disponibilidad> disponibilidades) {
        List<DataDisponibilidad> dataDisponibilidades = new ArrayList<>();

        for(Disponibilidad disponibilidad: disponibilidades) {
            DataDisponibilidad dataDisponibilidad = new DataDisponibilidad(
                    disponibilidad.getSector(),
                    disponibilidad.getPrecio(),
                    disponibilidad.getCantidadDisponible()
            );

            dataDisponibilidades.add(dataDisponibilidad);
        }

        return dataDisponibilidades;
    }
}

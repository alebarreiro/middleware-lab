package msg.dto;

import java.util.List;
import java.util.Date;

public class Order {

    //Orden
    private long numero;
    private Date fecha;
    private long clientId;
    private String formaPago; //E = Efectivo, C = Cheque, D = Debito, X = Crédito

    //Facturacion
    private int moneda; //858 = pesos, 840 = dolares
    private int cuotas; //1 efectivo, cheque o debito, N para credito

    //Items*
    private List<Item> Items;

    public void Order () {}


    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    public void printOrder() {
        System.out.println("Moneda: " + this.moneda);
        System.out.println("Forma de pago: " + this.formaPago);
        System.out.println("Cuotas: " + this.cuotas);
        System.out.println("Client ID: " + this.clientId);
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Numero de orden: " + this.numero);

        System.out.println("Items: ");


        for (int i = 0; i < this.Items.size(); i++) {
            Item item = this.Items.get(i);
            item.printItem();
        }
    }
}

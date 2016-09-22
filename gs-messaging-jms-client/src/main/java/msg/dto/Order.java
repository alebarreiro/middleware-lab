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

}

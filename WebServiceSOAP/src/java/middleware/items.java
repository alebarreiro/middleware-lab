/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author fabian
 */
public class items implements Serializable{
  
        private int id_producto;
        private Date fecha_hora;
        private String id_transaccion;
        private int cantidad;
        
        public int getid_Producto() {
            return id_producto;
        }
        public void setid_Producto(int id_producto) {
            this.id_producto = id_producto;
        }
        public int getcantidad() {
            return cantidad;
        }
        public void setcantidad(int longg) {
            this.cantidad = longg;
        }
        public String getid_Transaccion() {
            return id_transaccion;
        }
        public void setid_Transaccion(String id_transaccion) {
            this.id_transaccion = id_transaccion;
        }        
        public Date getfecha_hora() {
            return fecha_hora;
        }
        public void setfecha_hora(Date date) {
            this.fecha_hora = date;
        }         
}

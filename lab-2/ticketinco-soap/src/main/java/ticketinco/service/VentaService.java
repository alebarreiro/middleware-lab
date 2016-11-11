package ticketinco.service;

import org.apache.log4j.Logger;
import ticketinco.datatype.DataReservaConfirmada;
import ticketinco.datatype.DataReservaPendiente;
import ws.com.ticketinco.esb.DataVenta;
import ticketinco.controller.ReservaController;
import ticketinco.controller.VentaController;
import ticketinco.datatype.DataHorario;
import ticketinco.exception.BusinessException;
import ws.com.ticketinco.esb.WsPagosLocalService;
import ws.com.ticketinco.esb.WsPagosYaService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Date;
import java.util.List;


@WebService
public class VentaService {
    final static Logger logger = Logger.getLogger(VentaService.class);

    @WebMethod(action = "obtenerDisponibilidad")
    public List<DataHorario> obtenerDisponibilidad(int id, Date fecha) {
        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id, fecha);
    }

    @WebMethod(action = "estadoReserva")
    public int estadoReserva(long idReserva) throws BusinessException {
        VentaController vc = new VentaController();
        int estado = vc.getEstadoReserva(idReserva);
        if (estado == -1) {
           throw new BusinessException("NOT_FOUND", 404, "No existe reserva con dicho id");
        }
        return estado;
    }

    @WebMethod(action = "reservarEntrada")
    public long reservarEntrada(@WebParam(name = "confirmacion") DataReservaPendiente dataReservaPendiente) throws Exception {
        ReservaController vc = new ReservaController();

        return vc.reservarEntrada(dataReservaPendiente);
    }

    @WebMethod
    public long confirmarReserva(@WebParam(name = "reserva") DataReservaConfirmada dataReservaConfirmada) throws BusinessException {
        ReservaController vc = new ReservaController();

        return vc.confirmarReserva(dataReservaConfirmada);
    }

    @WebMethod(action = "testConfirmacionLocal")
    public long testConfirmacionLocal() {
        DataVenta dv = new DataVenta();
        dv.setMonto(12);
        dv.setDigitoVerificador(7);
        dv.setNroTarjeta(213123);
        dv.setFechaVencimiento("2016-11-19T23:00:00");

        WsPagosLocalService wsPagosLocal = new WsPagosLocalService();
        return wsPagosLocal.getWsPagosLocalPort().confirmarPago(dv).getIdConfirmacion();
    }

    @WebMethod(action = "testAnulacionLocal")
    public long testAnulacionLocal() {
        WsPagosLocalService wsPagosLocal = new WsPagosLocalService();

        return wsPagosLocal.getWsPagosLocalPort().anularPago(1).getIdAnulacion();
    }

    @WebMethod(action = "testConfirmacionExterno")
    public long testConfirmacionExterno() {
        DataVenta dv = new DataVenta();
        dv.setMonto(12);
        dv.setDigitoVerificador(7);
        dv.setNroTarjeta(213123);
        dv.setFechaVencimiento("2016-11-19T23:00:00");

        WsPagosYaService wsPagosYa = new WsPagosYaService();

        return wsPagosYa.getWsPagosYaPort().confirmarPago(dv).getIdConfirmacion();
    }

    @WebMethod(action = "testAnulacionExterno")
    public long testAnulacionExterno() {
        WsPagosYaService wsPagosYa = new WsPagosYaService();

        return wsPagosYa.getWsPagosYaPort().anularPago(1).getIdAnulacion();
    }
}

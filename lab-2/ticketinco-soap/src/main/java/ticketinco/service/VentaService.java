package ticketinco.service;

import org.apache.log4j.Logger;
import ws.com.ticketinco.esb.DataVenta;
import ticketinco.controller.PagoLocalController;
import ticketinco.controller.ReservaController;
import ticketinco.controller.VentaController;
import ticketinco.datatype.DataConfirmacionReserva;
import ticketinco.datatype.DataHorario;
import ticketinco.datatype.DataPagoLocal;
import ticketinco.exception.BusinessException;
import ws.com.ticketinco.esb.WsPagosYaService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.Date;
import java.util.List;


@WebService
public class VentaService {
    final static Logger logger = Logger.getLogger(PagoService.class);

    @WebMethod
    public List<DataHorario> obtenerDisponibilidad(int id, Date fecha) {
        VentaController vc = new VentaController();
        return vc.getDisponibilidadParaEvento(id, fecha);
    }

    @WebMethod
    public int estadoReserva(long idReserva) throws BusinessException {
        VentaController vc = new VentaController();
        int estado = vc.getEstadoReserva(idReserva);
        if (estado == -1) {
           throw new BusinessException("NOT_FOUND", 404, "No existe reserva con dicho id");
        }
        return estado;
    }

    @WebMethod
    public long reservarEntrada(@WebParam(name = "confirmacion") DataConfirmacionReserva dataConfirmacionReserva) throws Exception {
        ReservaController vc = new ReservaController();

        return vc.reservarEntrada(dataConfirmacionReserva);
    }

    @WebMethod
    public void testPagoLocal() {
        PagoLocalController plc = new PagoLocalController();
        DataPagoLocal dpl = new DataPagoLocal("1242-1231-1231-1231", "OCA", "1", "123");
        String xml = plc.parsePagoDataToXmlString(dpl);
        plc.enviarPagoLocal(xml);
    }

    @WebMethod
    public long testConfirmacionExterno() {
        DataVenta dv = new DataVenta();
        dv.setMonto(12);
        dv.setDigitoVerificador(7);
        dv.setNroTarjeta(213123);
        dv.setFechaVencimiento("2016-11-19T23:00:00");

        WsPagosYaService wsPagosYa = new WsPagosYaService();

        return wsPagosYa.getWsPagosYaPort().confirmarPago(dv).getIdConfirmacion();
    }

    @WebMethod
    public long testAnulacionExterno() {

        WsPagosYaService wsPagosYa = new WsPagosYaService();

        return wsPagosYa.getWsPagosYaPort().anularPago(1).getIdAnulacion();
    }
}

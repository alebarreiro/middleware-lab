package ticketinco.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.utils.URIBuilder;
import ticketinco.datatype.pagosYa.DataAnulacion;
import ticketinco.datatype.pagosYa.DataConfirmacion;
import ticketinco.datatype.pagosYa.DataVenta;
import java.util.logging.Logger;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import java.util.Base64;
import java.util.Date;

public class PagosYaClientRest {
    private String BASE_URL = "http://localhost:8081/pagosya-rest-0.1.0/api";
    private Logger logger;

    public PagosYaClientRest() {
        this.logger = Logger.getLogger(PagosYaClientRest.class.getName());
    }

    public long confirmarPago(DataVenta dataVenta) throws Exception {
        String endpointUrl = BASE_URL + "/pago";

        if (dataVenta == null) {
            dataVenta = new DataVenta(3, new Date(), 45656, 8);
        }

        ClientRequest request = new ClientRequest(endpointUrl);
        request.accept(MediaType.APPLICATION_JSON);

        basicAuthorization(request);

        request.body(MediaType.APPLICATION_JSON, dataVenta);

        ClientResponse<DataConfirmacion> response = request.post(DataConfirmacion.class);

        Response.Status responseStatus = response.getResponseStatus();

        if (responseStatus == Response.Status.OK) {
            DataConfirmacion dataConfirmacion = response.getEntity();

            return dataConfirmacion.getIdConfirmacion();
        } else {
            throw new Exception("Error");
        }
    }

    private void basicAuthorization(ClientRequest request) {
        String username = "ticket_inco_user";
        String password = "ticket_inco_user";
        String credentials = username + ":" + password;

        String auth = Base64.getEncoder().encodeToString(credentials.getBytes());

        request.header("Authorization", "Basic " + auth);
    }

    public long anularPago(Long idPago) throws Exception {
        String endpointUrl = BASE_URL + "/pago/" + idPago.toString();

        ClientRequest request = new ClientRequest(endpointUrl);
        request.accept(MediaType.APPLICATION_JSON);

        basicAuthorization(request);

        ClientResponse<DataAnulacion> response = request.delete(DataAnulacion.class);
        Response.Status responseStatus = response.getResponseStatus();

        if (responseStatus == Response.Status.OK) {
            DataAnulacion dataAnulacion = response.getEntity();

            return dataAnulacion.getIdAnulacion();
        } else {
            throw new Exception("Error");
        }
    }
}

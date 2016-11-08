package com.ticketinco.esb;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WsPagosYa {

	@WebMethod 
	public DataConfirmacion confirmarPago(DataVenta dataVenta);
	
	@WebMethod
	public DataAnulacion anularPago(long idPago);
}

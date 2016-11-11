package com.ticketinco.esb.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ticketinco.esb.datatype.DataAnulacion;
import com.ticketinco.esb.datatype.DataConfirmacion;
import com.ticketinco.esb.datatype.DataVenta;

@WebService
public interface WsPagosLocal {

	@WebMethod 
	public DataConfirmacion confirmarPago(DataVenta dataVenta);
	
	@WebMethod
	public DataAnulacion anularPago(long idPago);
}

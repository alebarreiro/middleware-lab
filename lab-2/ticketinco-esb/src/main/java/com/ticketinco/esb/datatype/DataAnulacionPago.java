package com.ticketinco.esb.datatype;

public class DataAnulacionPago {
	private long idAnulacion;
	private long idConfirmacion;

    public DataAnulacionPago() {}
    
    public DataAnulacionPago(long idAnulacion, long idConfirmacion) {
    	this.idAnulacion = idAnulacion;
    	this.idConfirmacion = idConfirmacion;
    }

	public long getIdAnulacion() {
		return idAnulacion;
	}

	public void setIdAnulacion(long idAnulacion) {
		this.idAnulacion = idAnulacion;
	}

	public long getIdConfirmacion() {
		return idConfirmacion;
	}

	public void setIdConfirmacion(long idConfirmacion) {
		this.idConfirmacion = idConfirmacion;
	}
	
	
}

package com.ticketinco.esb.datatype;

public class DataAnulacion {
	private long idAnulacion;

    public DataAnulacion() {}

	public long getIdAnulacion() {
		return idAnulacion;
	}

	public void setIdAnulacion(long idAnulacion) {
		this.idAnulacion = idAnulacion;
	}

	@Override
	public String toString() {
		return "DataAnulacion [idAnulacion=" + idAnulacion + "]";
	}
}

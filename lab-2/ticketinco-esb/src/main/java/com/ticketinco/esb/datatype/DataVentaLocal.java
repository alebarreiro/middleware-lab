package com.ticketinco.esb.datatype;

import javax.xml.bind.annotation.XmlRootElement;

public class DataVentaLocal {
	private Long idConfirmacion;
	private long nroTarjeta;
	
    private String fechaVencimiento;
	
    private double monto;
    private int digitoVerificador;
    
    DataVentaLocal() {}

    public DataVentaLocal(Long idConfirmacion, long nroTarjeta, String fechaVencimiento, double monto,
			int digitoVerificador) {
		super();
		this.idConfirmacion = idConfirmacion;
		this.nroTarjeta = nroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.digitoVerificador = digitoVerificador;
	}

	public long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(int digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }
   

	public Long getIdConfirmacion() {
		return idConfirmacion;
	}

	public void setIdConfirmacion(Long idConfirmacion) {
		this.idConfirmacion = idConfirmacion;
	}

	@Override
	public String toString() {
		return "DataVentaLocal [idConfirmacion=" + idConfirmacion + ", nroTarjeta=" + nroTarjeta + ", fechaVencimiento="
				+ fechaVencimiento + ", monto=" + monto + ", digitoVerificador=" + digitoVerificador + "]";
	}
}

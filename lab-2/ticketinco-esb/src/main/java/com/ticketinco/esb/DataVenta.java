package com.ticketinco.esb;

public class DataVenta {
	private long nroTarjeta;
	
    private String fechaVencimiento;
	
    private double monto;
    private int digitoVerificador;
    
    DataVenta() {}

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

	@Override
	public String toString() {
		return "DataVenta [nroTarjeta=" + nroTarjeta + ", fechaVencimiento=" + fechaVencimiento + ", monto=" + monto
				+ ", digitoVerificador=" + digitoVerificador + "]";
	}
}

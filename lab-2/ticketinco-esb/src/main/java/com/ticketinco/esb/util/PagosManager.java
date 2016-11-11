package com.ticketinco.esb.util;

public class PagosManager {
	private static PagosManager instance = new PagosManager();
	private long idConfirmacion = 0;
	private long idAnulacion = 0;
	
	private PagosManager() {
		
	}
	
	public static PagosManager getInstance() {
		return PagosManager.instance;
	}
	
	public long getIdConfirmacion() {
		return ++idConfirmacion;
	}
	
	public long getIdAnulacion() {
		return ++idAnulacion;
	}
}

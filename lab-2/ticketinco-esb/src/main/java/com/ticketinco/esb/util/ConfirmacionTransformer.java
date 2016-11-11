package com.ticketinco.esb.util;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import com.ticketinco.esb.datatype.DataVenta;
import com.ticketinco.esb.datatype.DataVentaLocal;
 
public class ConfirmacionTransformer extends AbstractTransformer {
	public ConfirmacionTransformer() {
		super();
        this.registerSourceType(DataTypeFactory.create(DataVenta.class));
        this.setReturnDataType(DataTypeFactory.create(DataVentaLocal.class));
	}
	
	@Override
    public Object doTransform(Object src, String encoding) throws TransformerException {
		DataVenta dataVenta = (DataVenta) src;
		
		long idConfirmacion = PagosManager.getInstance().getIdConfirmacion();
		DataVentaLocal dataVentaLocal = new DataVentaLocal(
				idConfirmacion,
				dataVenta.getNroTarjeta(),
				dataVenta.getFechaVencimiento(),
				dataVenta.getMonto(),
				dataVenta.getDigitoVerificador()
		);
		
        return dataVentaLocal;
    }
 
}
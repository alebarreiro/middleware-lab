package com.ticketinco.esb.util;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import com.ticketinco.esb.datatype.DataAnulacionPago;
 
public class AnulacionTransformer extends AbstractTransformer {
	public AnulacionTransformer() {
		super();
        this.registerSourceType(DataTypeFactory.create(Long.class));
        this.setReturnDataType(DataTypeFactory.create(DataAnulacionPago.class));
	}
	
	@Override
    public Object doTransform(Object src, String encoding) throws TransformerException {
		long idConfirmacion = (Long) src;
		long idAnulacion = PagosManager.getInstance().getIdAnulacion();
				
        return new DataAnulacionPago(idConfirmacion, idAnulacion);
    }
 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
/**
 *
 * @author fabian
 */
@WebService(serviceName = "SolicitudCompra")
public class SolicitudCompra {

    @Resource
    WebServiceContext webServiceContext;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "NotificarCompra")
    public String NotificarCompra(@WebParam(name = "items") items[] items) throws UnsupportedEncodingException, IOException {
        //TODO write your implementation code here:
		MessageContext messageContext = webServiceContext.getMessageContext();

		// get request headers
		Map<?,?> requestHeaders = (Map<?,?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<?> usernameList = (List<?>) requestHeaders.get("username");
		List<?> passwordList = (List<?>) requestHeaders.get("password");

		String username = "";
		String password = "";

		if (usernameList != null) {
			username = usernameList.get(0).toString();
		}

		if (passwordList != null) {
			password = passwordList.get(0).toString();
		}
                String msg = "OK";
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
                String time = sdf.format(cal.getTime());
                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("C:\\Users\\fabian\\Documents\\NetBeansProjects\\middleware-lab1\\WebServiceSOAP\\log"+time), "utf-8"))
                ) 
                {    
                    if (items.length == 999) {    
                        for (int i = 0; i < items.length; i++) {
                            writer.write("--------------\n");
                            SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
                            String fecha = fromUser.format(items[i].getfecha_hora());
                            writer.write(String.format("Cantidad: %d\n",items[i].getcantidad()));
                            writer.write(String.format("Producto: %d\n",items[i].getid_Producto()));
                            writer.write(String.format("Transaccion: %s\n",items[i].getid_Transaccion()));
                            writer.write(String.format("Fecha: %s\n",fecha));
                            writer.write("--------------\n");
                        }
                    }else {
                        msg = "Error: La coleccion no tiene 1000 elementos";
                    }
                    
                }
        return msg;
    }
}

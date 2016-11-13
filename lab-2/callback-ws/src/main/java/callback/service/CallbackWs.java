package callback.service;

import javax.imageio.ImageIO;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.MTOM;

import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

@MTOM(enabled = true)
@WebService(name = "ConfirmarReserva", targetNamespace = "http://service.ticketinco/")
public class CallbackWs {

    final static Logger logger = Logger.getLogger(CallbackWs.class);

    @WebResult(name="reserva")
    @WebMethod(action = "confirmarReserva")
    public DataNotificacionReserva confirmarReserva(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        logger.info("CALLBACK LLAMADO SAY!!!");
        return reserva;
    }

    @WebMethod(action = "confirmarReservaResponse")
    public void confirmarReservaResponse(@WebParam(name="reserva") DataNotificacionReserva reserva) {
        logger.info("CALLBACK INVOCADO: DATOS DE LA RESERVA >>" + reserva.toString());

        if (reserva.isError()) {
            logger.info("Callback.error: " + reserva.getMsgError());
        } else {
            try {
                int index = 0;
                for (Image source : reserva.getImagenes()) {
                    index++;
                    String fileName = "img-reserva-" + reserva.getIdConfirmacionReserva() + "-nro-" + index + ".png";
                    logger.info("GUARDANDO IMAGEN " + fileName);
                    File outputfile = new File(fileName);
                    ImageIO.write(toBufferedImage(source), "png", outputfile);
                }
            } catch (Exception e) {
                logger.info("ERROR GUARDANDO IMAGEN " + e.getMessage());
            }
        }
    }

    public BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}

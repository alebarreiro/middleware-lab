package com.middleware.integracion;

import com.middleware.clases.ItemMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by acabrera on 9/19/16.
 */
public class LoggerEndpoint {
    private static final Logger logger = LogManager.getLogger("LoggerEndpoint");

    public void logMessage(Object object) {
        logger.debug(object);
    }
}


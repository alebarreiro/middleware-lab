package com.mobilesys.io;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by alejandrobarreiro on 24/9/16.
 */
public class DeadLetterMessageListener {

    private static final Logger LOG = Logger.getLogger(DeadLetterMessageListener.class);

    public void onMessage(String message) {

        LOG.info("xxxxx DEAD LETTER LISTENER xxxxx" + message);

    }
}

package com.mobilesys.io;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by alejandrobarreiro on 24/9/16.
 */
public class MobileSysMessageListener implements MessageListener {

    private static final Logger LOG = Logger.getLogger(MobileSysMsgListener.class);

    public void test(Object o) {
        LOG.debug(o);
    }

    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            LOG.info("Consumed message: " + msg.getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

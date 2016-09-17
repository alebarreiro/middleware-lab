package com.middleware;

/**
 * Created by acabrera on 9/17/16.
 */
public class SimpleMessageListener {
    public String onMessage(String message) {
        System.out.println("message processado " + message);

        return "transformer:" + message;
    }
}

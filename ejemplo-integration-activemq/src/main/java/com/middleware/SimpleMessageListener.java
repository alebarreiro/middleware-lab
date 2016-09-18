package com.middleware;

public class SimpleMessageListener {
    public String onMessage(String message) {
        System.out.println("message processado " + message);

        return "transformer:" + message;
    }
}

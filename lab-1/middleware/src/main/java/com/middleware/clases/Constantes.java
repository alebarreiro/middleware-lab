package com.middleware.clases;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acabrera on 9/19/16.
 */
public class Constantes {

    public static Map<Integer, String> tipoMoneda = new HashMap<>();

    static {
        tipoMoneda.put(858, "pesos");
        tipoMoneda.put(840, "dolares");
    }
}

package com.pagosya.service.app;

import com.pagosya.service.PagoService;
import com.pagosya.service.config.JacksonContextResolver;

import javax.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;


public class ResourceServiceApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public ResourceServiceApplication() {

        /**
         * Config
         */
        singletons.add(new JacksonContextResolver());

        /**
         * Servicios api
         */
        singletons.add(new PagoService());
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

package com.pagosya.service.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
    @Override
    public ObjectMapper getContext(Class<?> type) {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.setSerializationConfig(mapper.getSerializationConfig()
                .withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));
    }
}

package com.trubin.citystore.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trubin.citystore.entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonJacksonConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    // thread-safe
    private ObjectMapper objectMapper = new ObjectMapper();

    public City parseCity(String json) {
        log.info("Start parsing city from json {}", json);
        long startTime = System.currentTimeMillis();
        City city = parseValue(json, City.class);
        long time = System.currentTimeMillis() - startTime;
        log.info("City {} is received. It took {} ms", city, time);
        return city;
    }

    private <T> T parseValue(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

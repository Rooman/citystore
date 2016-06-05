package com.trubin.citystore.util;

import com.trubin.citystore.entity.City;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonJacksonConverterTest {
    @Test
    public void testParseAddCityRequest() {
        String json = "{\"name\":\"City Name\",\"district\":\"City District\",\"population\":\"1000\"}";
        JsonJacksonConverter converter = new JsonJacksonConverter();
        City city= converter.parseCity(json);

        assertEquals("City Name", city.getName());
        assertEquals("City District", city.getDistrict());
        assertEquals(1000, city.getPopulation());
    }
}
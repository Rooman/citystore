package com.trubin.citystore.util;

import com.trubin.citystore.entity.City;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonManualConverterTest {

    @Test
    public void testCityToJson() {
        String expectedJson = "{\"id\":\"1\",\"name\":\"City Name\",\"district\":\"City District\",\"population\":\"1000\"}";
        JsonManualConverter jsonManualConverter = new JsonManualConverter();
        City city = new City();
        city.setId(1);
        city.setName("City Name");
        city.setDistrict("City District");
        city.setPopulation(1000);

        String actualJson = jsonManualConverter.toJson(city);
        assertEquals(expectedJson, actualJson);
    }
}
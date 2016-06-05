package com.trubin.citystore.controller;

import com.trubin.citystore.entity.City;
import com.trubin.citystore.service.CityService;
import com.trubin.citystore.util.JsonJacksonConverter;
import com.trubin.citystore.util.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/city")
public class CityController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CityService cityService;

    @Autowired
    private JsonManualConverter jsonConverter;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping("/{cityId}")
    @ResponseBody
    public String getCityById(@PathVariable int cityId) {
        log.info("Sending request to get city with id = {}", cityId);
        long startTime = System.currentTimeMillis();
        City city = cityService.getById(cityId);
        String cityJson = jsonConverter.toJson(city);
        log.info("City {} is received. It took {} ms", cityJson, System.currentTimeMillis() - startTime);
        return cityJson;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addCity(@RequestBody String json) {
        log.info("Sending request to add new city {}", json);
        long startTime = System.currentTimeMillis();
        try {
            City city = jsonJacksonConverter.parseCity(json);
            cityService.add(city);
        } catch (Exception e) {
            log.error("Exception occurred during adding the city", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        log.info("City {} is added. It took {} ms", json, System.currentTimeMillis() - startTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

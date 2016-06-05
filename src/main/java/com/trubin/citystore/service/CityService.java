package com.trubin.citystore.service;

import com.trubin.citystore.entity.City;

public interface CityService {
    City getById(int id);

    void add(City city);
}

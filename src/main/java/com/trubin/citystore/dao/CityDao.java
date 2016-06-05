package com.trubin.citystore.dao;

import com.trubin.citystore.entity.City;

public interface CityDao {
    City getById(int id);

    void add(City city);
}

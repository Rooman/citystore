package com.trubin.citystore.service.impl;

import com.trubin.citystore.dao.CityDao;
import com.trubin.citystore.entity.City;
import com.trubin.citystore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public City getById(int id) {
        return cityDao.getById(id);
    }

    @Override
    public void add(City city) {
        cityDao.add(city);
    }
}

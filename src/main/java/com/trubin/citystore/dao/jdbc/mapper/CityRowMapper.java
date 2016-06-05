package com.trubin.citystore.dao.jdbc.mapper;

import com.trubin.citystore.entity.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setName(resultSet.getString("name"));
        city.setDistrict(resultSet.getString("district"));
        city.setPopulation(resultSet.getInt("population"));
        return city;
    }
}

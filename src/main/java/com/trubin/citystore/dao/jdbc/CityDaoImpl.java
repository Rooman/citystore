package com.trubin.citystore.dao.jdbc;

import com.trubin.citystore.dao.CityDao;
import com.trubin.citystore.dao.jdbc.mapper.CityRowMapper;
import com.trubin.citystore.entity.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CityDaoImpl implements CityDao {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getCityByIdSQL;

    @Autowired
    private String addCitySQL;

    @Override
    public City getById(int id) {
        log.info("Start query to get city with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        City city = jdbcTemplate.queryForObject(getCityByIdSQL, new Object[]{id}, new CityRowMapper());
        log.info("Finish query to get city with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return city;
    }

    @Override
    public void add(City city) {
        log.info("Start query to add city {} to DB", city);
        long startTime = System.currentTimeMillis();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", city.getName());
        parameterSource.addValue("district", city.getDistrict());
        parameterSource.addValue("population", city.getPopulation());
        namedJdbcTemplate.update(addCitySQL, parameterSource);
        log.info("Finish query to add city {} to DB. It took {} ms", city, System.currentTimeMillis() - startTime);
    }
}

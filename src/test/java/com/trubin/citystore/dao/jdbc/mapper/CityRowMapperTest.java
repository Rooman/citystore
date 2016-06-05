package com.trubin.citystore.dao.jdbc.mapper;

import com.trubin.citystore.entity.City;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CityRowMapperTest {

    @Test
    public void testMapRowWithProperCity() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt(any())).thenReturn(1).thenReturn(1000);
        when(resultSet.getString(any())).thenReturn("Test name").thenReturn("Test district");

        CityRowMapper cityMapper = new CityRowMapper();
        City actualCity = cityMapper.mapRow(resultSet, 0);
        assertEquals(actualCity.getId(), 1);
        assertEquals(actualCity.getName(), "Test name");
        assertEquals(actualCity.getDistrict(), "Test district");
        assertEquals(actualCity.getPopulation(), 1000);
    }
}
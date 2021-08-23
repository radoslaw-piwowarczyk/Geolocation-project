package pl.spring.geo_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import pl.spring.geo_project.dto.DeviceDtoResponse;
import pl.spring.geo_project.entity.DeviceEntity;

//@SpringBootTest
abstract class DeviceServiceUtil {

    @Autowired
    NamedParameterJdbcOperations jdbc;

    DeviceDtoResponse initDevice(Long id, Double latitude, Double longitude) {
        var sql = "INSERT INTO devices(id, latitude, longitude) " +
                "VALUES(:id, :latitude, :longitude)";
        var mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        mapSqlParameterSource.addValue("latitude", latitude);
        mapSqlParameterSource.addValue("longitude", longitude);
        jdbc.update(sql, mapSqlParameterSource);
        return new DeviceDtoResponse(new DeviceEntity());
    }
}

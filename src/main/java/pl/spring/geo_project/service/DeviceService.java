package pl.spring.geo_project.service;

import pl.spring.geo_project.dto.DeviceDtoRequest;
import pl.spring.geo_project.dto.DeviceDtoResponse;
import pl.spring.geo_project.logger.AbstractLogger;

public interface DeviceService extends AbstractLogger {

    DeviceDtoResponse get(Long id);

    DeviceDtoResponse create(DeviceDtoRequest deviceDtoRequest);

}

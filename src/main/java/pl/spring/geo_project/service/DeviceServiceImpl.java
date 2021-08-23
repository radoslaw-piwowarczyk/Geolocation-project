package pl.spring.geo_project.service;

import org.springframework.stereotype.Service;
import pl.spring.geo_project.dto.DeviceDtoRequest;
import pl.spring.geo_project.dto.DeviceDtoResponse;
import pl.spring.geo_project.entity.DeviceEntity;
import pl.spring.geo_project.repository.DeviceRepository;

import javax.transaction.Transactional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public DeviceDtoResponse get(Long id) {
        var deviceEntity = deviceRepository.getOrThrow(id);
        return new DeviceDtoResponse(deviceEntity);
    }

    @Override
    public DeviceDtoResponse create(DeviceDtoRequest deviceDtoRequest) {
        var deviceEntity = new DeviceEntity();
        copyProperties(deviceDtoRequest, deviceEntity);
        var saved = deviceRepository.save(deviceEntity);
        return new DeviceDtoResponse(saved);
    }
}
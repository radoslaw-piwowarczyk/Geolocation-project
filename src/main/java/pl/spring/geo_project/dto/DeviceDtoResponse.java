package pl.spring.geo_project.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.ToString;
import pl.spring.geo_project.entity.DeviceEntity;

@Getter
@ToString
public class DeviceDtoResponse {

    private final Long id;

    @JsonUnwrapped
    private final DeviceDtoRequest deviceDtoRequest;

    public DeviceDtoResponse(DeviceEntity deviceEntity) {
        this.id = deviceEntity.getId();
        this.deviceDtoRequest = new DeviceDtoRequest(deviceEntity);
    }
}
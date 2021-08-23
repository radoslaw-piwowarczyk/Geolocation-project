package pl.spring.geo_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.spring.geo_project.entity.DeviceEntity;

import javax.validation.constraints.Min;


@Getter
@Setter
@ToString
public class DeviceDtoRequest {

    @Min(1)
    private Double latitude;

    @Min(1)
    private Double longitude;

    public DeviceDtoRequest(DeviceEntity deviceEntity) {
        this.latitude = deviceEntity.getLatitude();
        this.longitude = deviceEntity.getLongitude();
    }

    public DeviceDtoRequest() {
    }
}
package pl.spring.geo_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "devices")
public class DeviceEntity extends AbstractEntity {

    private Long id;
    private Double latitude;
    private Double longitude;

    public DeviceEntity(Long id, Double latitude, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

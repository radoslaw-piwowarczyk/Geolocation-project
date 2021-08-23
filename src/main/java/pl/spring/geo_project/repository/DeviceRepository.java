package pl.spring.geo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.spring.geo_project.entity.DeviceEntity;

import javax.persistence.EntityNotFoundException;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

    default DeviceEntity getOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity by id: " + id + " does not exist."));
    }
}


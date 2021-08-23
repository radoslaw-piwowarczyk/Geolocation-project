package pl.spring.geo_project.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.spring.geo_project.entity.DeviceEntity;
import pl.spring.geo_project.repository.DeviceRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DeviceServiceTest {

    @InjectMocks
    DeviceServiceImpl deviceService;
    @Mock
    DeviceRepository deviceRepository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldGetDeviceById() {
        //given
        var id = 1L;
        var latitude = 45.1;
        var longitude = 56.24;

        //when
        when(deviceRepository.getOrThrow(id)).thenReturn(new DeviceEntity(id, latitude, longitude));
        var device = deviceService.get(id);

        //then
        assertEquals(latitude, device.getDeviceDtoRequest().getLatitude());
        assertEquals(longitude, device.getDeviceDtoRequest().getLongitude());
        assertEquals(id, device.getId());
    }

}

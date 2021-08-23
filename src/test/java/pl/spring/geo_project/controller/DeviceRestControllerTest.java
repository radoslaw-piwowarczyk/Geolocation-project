package pl.spring.geo_project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.spring.geo_project.repository.DeviceRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DeviceRestControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    DeviceRepository deviceRepository;

    @Test
    void shouldReturnDeviceById() throws Exception {
        //given
        var deviceId = 10001L;
        var url = "/device/{id}";
        var latitude = 45.1;
        var longitude = 56.24;

        //when
        mockMvc.perform(get(url, deviceId))

                //then
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.latitude").value(latitude))
                .andExpect(jsonPath("$.longitude").value(longitude));
    }
}
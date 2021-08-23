package pl.spring.geo_project.controller;

import org.springframework.web.bind.annotation.*;
import pl.spring.geo_project.dto.DeviceDtoRequest;
import pl.spring.geo_project.dto.DeviceDtoResponse;
import pl.spring.geo_project.service.DeviceService;

import javax.validation.Valid;

@RestController
@RequestMapping("/device")
public class DeviceRestController {

    private final DeviceService deviceService;

    public DeviceRestController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public DeviceDtoResponse get(@PathVariable Long id) {
        return deviceService.get(id);
    }

    @PostMapping
    public DeviceDtoResponse create(@RequestBody @Valid DeviceDtoRequest deviceDtoRequest) {
        return deviceService.create(deviceDtoRequest);
    }
}

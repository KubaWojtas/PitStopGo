package com.swc.vroomvroom.controller;

import com.swc.vroomvroom.dto.DriverDto;
import com.swc.vroomvroom.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/{id}")
    public DriverDto findById(@PathVariable("id") UUID id) {
        return service.getDriverById(id);
    }

    @GetMapping()
    public Set<DriverDto> findAll() {
        return service.getAllDrivers();
    }

    @PostMapping("/add")
    public void addDriver(@RequestBody DriverDto driver) {
        service.createDriver(driver);
    }

//    @PutMapping("/update")
//    public Driver updateDriver(@RequestBody Driver driver) {
//        return service.updateDriver(driver);
//    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteDriverById(id);
    }
}

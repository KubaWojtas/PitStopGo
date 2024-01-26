package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping("/drivers/add")
    public Driver addDriver(@RequestBody Driver driver) {
        return service.createDriver(driver);
    }

    @GetMapping("/drivers/{id}")
    public Driver findById(@PathVariable("id") int id) {
        return service.getDriverById(id);
    }

    @GetMapping("/drivers")
    public List<Driver> findAll() {
        return service.getAllDrivers();
    }

    @DeleteMapping("/drivers/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteDriverById(id);
    }
}

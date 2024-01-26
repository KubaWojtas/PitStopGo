package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/{id}")
    public Driver findById(@PathVariable("id") int id) {
        return service.getDriverById(id);
    }

    @GetMapping()
    public List<Driver> findAll() {
        return service.getAllDrivers();
    }

    @PostMapping("/add")
    public Driver addDriver(@RequestBody Driver driver) {
        return service.createDriver(driver);
    }

    @PutMapping("/update")
    public Driver updateDriver(@RequestBody Driver driver) {
        return service.updateDriver(driver);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteDriverById(id);
    }
}

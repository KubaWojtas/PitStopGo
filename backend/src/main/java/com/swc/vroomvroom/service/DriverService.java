package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> createDrivers(List<Driver> drivers) {
        return (List<Driver>) driverRepository.saveAll(drivers);
    }

    public Driver getDriverById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> getAllDrivers() {
        return (List<Driver>) driverRepository.findAll();
    }

    public Driver updateDriver(Driver driver) {
        Driver old = getDriverById(driver.getDriverId());
        if (old != null) {
            old.setName(driver.getName());
            old.setTeam(driver.getTeam());
            driverRepository.save(old);
        }
        else {
            return new Driver();
        }
        return old;
    }

    public String deleteDriverById(int id) {
        driverRepository.deleteById(id);
        return "Driver got deleted";
    }
}

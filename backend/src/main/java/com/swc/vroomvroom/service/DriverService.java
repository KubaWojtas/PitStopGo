package com.swc.vroomvroom.service;

import com.swc.vroomvroom.entity.Driver;
import com.swc.vroomvroom.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver getDriverById(UUID id) {
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> getAllDrivers() {
        return (List<Driver>) driverRepository.findAll();
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

//    public List<Driver> createDrivers(List<Driver> drivers) {
//        return (List<Driver>) driverRepository.saveAll(drivers);
//    }

//    public Driver updateDriver(Driver driver) {
//        Driver old = getDriverById(driver.getDriverId());
//        if (old != null) {
//            old.setFirstName(driver.getFirstName());
//            driverRepository.save(old);
//        }
//        else {
//            return new Driver();
//        }
//        return old;
//    }

    public void deleteDriverById(UUID id) {
        driverRepository.deleteById(id);
    }
}

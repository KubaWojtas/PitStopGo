package com.swc.vroomvroom.service.driver;

import com.swc.vroomvroom.dto.DriverDto;
import com.swc.vroomvroom.entity.DriverEntity;
import com.swc.vroomvroom.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.swc.vroomvroom.service.driver.DriverMapper.mapToDriverDto;
import static com.swc.vroomvroom.service.driver.DriverMapper.mapToDriverEntity;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public DriverDto getDriverById(UUID id) {
        DriverEntity driver = driverRepository.findById(id).orElseThrow();
        return mapToDriverDto(driver);
    }

    public Set<DriverDto> getAllDrivers() {
        List<DriverEntity> drivers = (List<DriverEntity>) driverRepository.findAll();
        return drivers.stream()
                .map(DriverMapper::mapToDriverDto)
                .collect(Collectors.toSet());
    }

    public void createDriver(DriverDto driver) {
        driverRepository.save(mapToDriverEntity(driver));
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

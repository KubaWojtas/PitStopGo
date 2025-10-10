package com.swc.vroomvroom.service.driver;

import com.swc.vroomvroom.dto.DriverDto;
import com.swc.vroomvroom.entity.DriverEntity;
import org.springframework.stereotype.Component;

@Component
public final class DriverMapper {

    public static DriverEntity mapToDriverEntity(DriverDto driver) {
        return new DriverEntity.Builder()
                .withDriverId(driver.getDriverId())
                .withFirstName(driver.getFirstName())
                .withLastName(driver.getLastName())
                .withBirthdate(driver.getBirthdate())
                .withCountry(driver.getCountry())
                .withNumber(driver.getNumber())
                .withTeamId(driver.getTeamId())
                .build();
    }

    public static DriverDto mapToDriverDto(DriverEntity driver) {
        return new DriverDto.Builder()
                .withDriverId(driver.getDriverId())
                .withFirstName(driver.getFirstName())
                .withLastName(driver.getLastName())
                .withBirthdate(driver.getBirthdate())
                .withCountry(driver.getCountry())
                .withNumber(driver.getNumber())
                .withTeamId(driver.getTeamId())
                .build();
    }
}

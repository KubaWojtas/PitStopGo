package com.swc.vroomvroom.service;

import com.swc.vroomvroom.dto.DriverStandingDto;
import com.swc.vroomvroom.dto.RaceStandingDto;
import com.swc.vroomvroom.entity.RaceStandingEntity;
import com.swc.vroomvroom.repository.RaceStandingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RaceStandingService {

    @Autowired
    private RaceStandingRepository raceStandingRepository;

    public RaceStandingDto getRaceStandingById(UUID id) {
        List<RaceStandingEntity> raceStandings = (List<RaceStandingEntity>) raceStandingRepository.findAll();
        RaceStandingDto result = new RaceStandingDto();
        List<DriverStandingDto> resultaten = result.getResultaten();
        for (RaceStandingEntity r : raceStandings) {
            if (r.getRace().getRaceId() == id) {
                DriverStandingDto driverStandingDto = new DriverStandingDto();
                driverStandingDto.setPosition(Integer.parseInt(r.getPosition()));
                driverStandingDto.setDriverName(r.getDriver().getLastName());
                driverStandingDto.setPoints(r.getPoints());
                driverStandingDto.setTime(r.getTime());
                resultaten.add(driverStandingDto);
            }
        }
        result.sortStanding();
        return result;
    }

    public void createRaceStanding(RaceStandingEntity raceStanding) {
        raceStandingRepository.save(raceStanding);
    }
}

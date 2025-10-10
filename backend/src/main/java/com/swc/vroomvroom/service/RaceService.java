package com.swc.vroomvroom.service;

import com.swc.vroomvroom.dto.RaceStandingDto;
import com.swc.vroomvroom.entity.DriverEntity;
import com.swc.vroomvroom.entity.RaceEntity;
import com.swc.vroomvroom.entity.RaceStandingEntity;
import com.swc.vroomvroom.entity.TrackEntity;
import com.swc.vroomvroom.repository.DriverRepository;
import com.swc.vroomvroom.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.valueOf;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    private final DriverRepository driverRepository;
    @Autowired
    private RaceStandingService raceStandingService;
    @Autowired
    private TrackService trackService;

    private int randomTimeOffset;

    public RaceService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public RaceEntity getRaceById(UUID id) {
        return raceRepository.findById(id).orElse(null);
    }

    public List<RaceEntity> getAllRaces() {
        return (List<RaceEntity>) raceRepository.findAll();
    }

    public RaceStandingDto simulateRace(UUID raceId) {
        RaceEntity race = getRaceById(raceId);
        List<DriverEntity> drivers = (List<DriverEntity>) driverRepository.findAll();
        Map<UUID, Integer> standings = race.simulateRace(new HashSet<>(drivers));
        int[] pointsArray = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        int position = 1;
        int pointsIndex = 0;
        for (Map.Entry<UUID, Integer> standing : standings.entrySet()) {
            DriverEntity driver = driverRepository.findById(standing.getKey()).orElseThrow();
            RaceStandingEntity raceStanding = new RaceStandingEntity(driver, race);
            if (pointsIndex > 9) {
                raceStanding.setPoints(0);
            } else {
                raceStanding.setPoints(pointsArray[pointsIndex]);
            }
            raceStanding.setPosition(valueOf(position));
            TrackEntity track = trackService.getTrackById(race.getTrackId());
            raceStanding.setTime(generateRaceTime(track, position));
            raceStandingService.createRaceStanding(raceStanding);
            position++;
            pointsIndex++;
        }

        return raceStandingService.getRaceStandingById(raceId);
    }

    private String generateRaceTime(TrackEntity track, int offset) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        float time = track.getLapRecord() * (100 + offset + random.nextInt(1, 4)) / 100;
        return calcTime(time * track.getLaps());
    }

    private String calcTime(float time) {
        int hours = (int) (time / 3600);
        int minutes = (int) ((time % 3600) / 60);
        int seconds = (int) (time % 60);
        int millis = (int) ((time - (int)time) * 1000);

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }

    public RaceEntity createRace(RaceEntity race) {
        return raceRepository.save(race);
    }

}

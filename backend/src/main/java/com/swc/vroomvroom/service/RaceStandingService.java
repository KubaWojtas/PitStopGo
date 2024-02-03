package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.RaceStanding;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.RaceStandingRepository;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceStandingService {

    @Autowired
    private RaceStandingRepository raceStandingRepository;

    public RaceStanding createRaceStanding(RaceStanding raceStanding) {
        return raceStandingRepository.save(raceStanding);
    }
}

package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Driver;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.Team;
import main.java.com.swc.vroomvroom.repository.RaceRepository;
import main.java.com.swc.vroomvroom.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    private RaceRepository raceRepository;

    public Race getRaceById(int id) {
        return raceRepository.findById(id).orElse(null);
    }

    public List<Race> getAllRaces() {
        return (List<Race>) raceRepository.findAll();
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

}

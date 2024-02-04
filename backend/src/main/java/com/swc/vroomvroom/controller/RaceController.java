package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.dto.RaceStandingDto;
import main.java.com.swc.vroomvroom.dto.SeasonResultsDto;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceService service;

    @GetMapping("/{id}")
    public Race findById(@PathVariable("id") int id) {
        return service.getRaceById(id);
    }

    @GetMapping()
    public List<Race> findAll() {
        return service.getAllRaces();
    }

    @GetMapping("/{id}/simulate")
    public RaceStandingDto simulateRace(@PathVariable("id") int id) {
        return service.simulateRace(id);
    }

    @GetMapping("/simulateAllRaces")
    public SeasonResultsDto simulateAllRaces() {
        return service.simulateAllRaces();
    }


    @PostMapping("/add")
    public Race addRace(@RequestBody Race race) {
        return service.createRace(race);
    }
}

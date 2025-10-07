package com.swc.vroomvroom.controller;

import com.swc.vroomvroom.dto.RaceStandingDto;
import com.swc.vroomvroom.entity.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.swc.vroomvroom.service.RaceService;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/races")
public class RaceController {

    @Autowired
    private RaceService service;

    @GetMapping("/{id}")
    public Race findById(@PathVariable("id") UUID id) {
        return service.getRaceById(id);
    }

    @GetMapping()
    public List<Race> findAll() {
        return service.getAllRaces();
    }

    @PostMapping("/add")
    public Race addRace(@RequestBody Race race) {
        return service.createRace(race);
    }

    @GetMapping("/{id}/simulate")
    public RaceStandingDto simulateRace(@PathVariable("id") UUID id) {
        return service.simulateRace(id);
    }
//
//    @GetMapping("/simulateAllRaces")
//    public SeasonResultsDto simulateAllRaces() {
//        return service.simulateAllRaces();
//    }
}

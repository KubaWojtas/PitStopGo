package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.service.RaceService;
import main.java.com.swc.vroomvroom.service.TrackService;
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

    @PostMapping("/add")
    public Race addRace(@RequestBody Race race) {
        return service.createRace(race);
    }
}

package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Track;
import main.java.com.swc.vroomvroom.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService service;

    @GetMapping("/{id}")
    public Track findById(@PathVariable("id") int id) {
        return service.getTrackById(id);
    }

    @GetMapping()
    public List<Track> findAll() {
        return service.getAllTracks();
    }

    @PostMapping("/add")
    public Track addTrack(@RequestBody Track track) {
        return service.createTrack(track);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteTrackById(id);
    }
}

package com.swc.vroomvroom.controller;

import com.swc.vroomvroom.entity.TrackEntity;
import com.swc.vroomvroom.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService service;

    @GetMapping("/{id}")
    public TrackEntity findById(@PathVariable("id") UUID id) {
        return service.getTrackById(id);
    }

    @GetMapping()
    public List<TrackEntity> findAll() {
        return service.getAllTracks();
    }

    @PostMapping("/add")
    public TrackEntity addTrack(@RequestBody TrackEntity track) {
        return service.createTrack(track);
    }
//
//    @PutMapping("/update")
//    public Track updateTrack(@RequestBody Track track) {
//        return service.updateTrack(track);
//    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteTrackById(id);
    }
}

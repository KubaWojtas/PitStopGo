package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Calender;
import main.java.com.swc.vroomvroom.model.Track;
import main.java.com.swc.vroomvroom.service.CalenderService;
import main.java.com.swc.vroomvroom.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class CalenderController {

    @Autowired
    private CalenderService service;
    @Autowired
    private TrackService trackService;

    @PostMapping("/calenders/add")
    public Calender addCalender(@RequestBody Calender calender) {
        return service.createCalender(calender);
    }

    @PostMapping("/calenders/{id}/{trackId}")
    public Calender addTrackToCalender(@PathVariable("id") int id, @PathVariable("trackId") int trackId) {
        Track track = trackService.getTrackById(trackId);
        Calender calender = findById(id);
        service.addTrackToCalender(calender, track);
        return calender;
    }

    @GetMapping("/calenders/{id}")
    public Calender findById(@PathVariable("id") int id) {
        return service.getCalenderById(id);
    }

    @GetMapping("/calenders")
    public Set<Calender> findAll() {
        return service.getAllCalenders();
    }

    @DeleteMapping("/calenders/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteCalenderById(id);
    }
}

package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Calendar;
import main.java.com.swc.vroomvroom.model.Track;
import main.java.com.swc.vroomvroom.service.CalendarService;
import main.java.com.swc.vroomvroom.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/calendars")
public class CalendarController {

    @Autowired
    private CalendarService service;

    @GetMapping("/{id}")
    public Calendar findById(@PathVariable("id") int id) {
        return service.getCalendarById(id);
    }

    @GetMapping("")
    public List<Calendar> findAll() {
        return service.getAllCalendars();
    }

    @PostMapping("/add")
    public Calendar addCalender(@RequestBody Calendar calendar) {
        return service.createCalender(calendar);
    }

    @PostMapping("/{id}/addTrack/{trackId}")
    public Calendar addTrackToCalendar(@PathVariable("id") int id, @PathVariable("trackId") int trackId) {
        return service.addTrackToCalendar(id, trackId);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteCalendarById(id);
    }
}

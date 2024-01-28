package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.service.CalendarService;
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

//    @GetMapping("/{id}/generate")
//    public Calendar generateRaceCalendar(@PathVariable("id") int id) {
//        return service.generateRaceCalendar(id);
//    }

    @PostMapping("/add")
    public Calendar addCalender(@RequestBody Calendar calendar) {
        return service.createCalender(calendar);
    }

    @PostMapping("/{id}/addRace/{raceId}")
    public Calendar addRace(@PathVariable("id") int id, @PathVariable("raceId") int raceId) {
        return service.addRace(id, raceId);
    }

    @PostMapping("/{id}/removeRace/{raceId}")
    public Calendar removeRace(@PathVariable("id") int id, @PathVariable("raceId") int raceId) {
        return service.removeRace(id, raceId);
    }

    @PutMapping("/update")
    public Calendar updateCalendar(@RequestBody Calendar calendar) {
        return service.updateCalendar(calendar);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteCalendarById(id);
    }
}

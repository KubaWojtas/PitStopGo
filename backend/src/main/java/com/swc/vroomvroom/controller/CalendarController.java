package com.swc.vroomvroom.controller;

import com.swc.vroomvroom.dto.SeasonResultsDto;
import com.swc.vroomvroom.entity.CalendarEntity;
import com.swc.vroomvroom.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/calendars")
public class CalendarController {

    @Autowired
    private CalendarService service;

    @GetMapping("/{id}")
    public CalendarEntity findById(@PathVariable("id") UUID id) {
        return service.getCalendarById(id);
    }

    @GetMapping("")
    public List<CalendarEntity> findAll() {
        return service.getAllCalendars();
    }

//    @GetMapping("/{id}/generate")
//    public Calendar generateRaceCalendar(@PathVariable("id") UUID id) {
//        return service.generateRaceCalendar(id);
//    }

    @GetMapping("/{id}/simulate")
    public SeasonResultsDto simulateRaceCalendar(@PathVariable("id") UUID id) {
        return service.simulateCalendar(id);
    }

    @PostMapping("/add")
    public CalendarEntity addCalender(@RequestBody CalendarEntity calendar) {
        return service.createCalender(calendar);
    }

    @PostMapping("/{id}/addRace/{trackId}")
    public CalendarEntity addRace(@PathVariable("id") UUID id, @PathVariable("trackId") UUID trackId) {
        return service.addRace(id, trackId);
    }

    @PostMapping("/{id}/removeRace/{raceId}")
    public CalendarEntity removeRace(@PathVariable("id") UUID id, @PathVariable("raceId") UUID raceId) {
        return service.removeRace(id, raceId);
    }

//    @PutMapping("/update")
//    public Calendar updateCalendar(@RequestBody Calendar calendar) {
//        return service.updateCalendar(calendar);
//    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteCalendarById(id);
    }
}

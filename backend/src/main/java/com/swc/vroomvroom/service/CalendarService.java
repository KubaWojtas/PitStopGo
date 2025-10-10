package com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import com.swc.vroomvroom.dto.RaceStandingDto;
import com.swc.vroomvroom.dto.SeasonResultsDto;
import com.swc.vroomvroom.entity.CalendarEntity;
import com.swc.vroomvroom.entity.RaceEntity;
import com.swc.vroomvroom.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;
//    @Autowired
//    private TrackService trackService;
    @Autowired
    private RaceService raceService;

    public CalendarEntity getCalendarById(UUID id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public List<CalendarEntity> getAllCalendars() {
        return (List<CalendarEntity>) calendarRepository.findAll();
    }

    public CalendarEntity createCalender(CalendarEntity calendar) {
        return calendarRepository.save(calendar);
    }

//    public Calendar generateRaceCalendar(UUID id) {
//        Calendar calendar = getCalendarById(id);
//        if (calendar.getRaces().isEmpty()) {
//            List<Track> tracks = trackService.getAllTracks();
//            for (Track track : tracks) {
//                Race race = new Race();
//                race.setTrackId(track.getTrackId());
//                calendar.addRace(race);
//            }
//        }
//        calendar.generateRaceCalendar();
//        return calendarRepository.save(calendar);
//    }

    public SeasonResultsDto simulateCalendar(UUID id) {
        CalendarEntity calendar = getCalendarById(id);
        List<RaceStandingDto> standings= new ArrayList<>();
        for (RaceEntity race: calendar.getRaces()) {
            RaceStandingDto raceStanding = raceService.simulateRace(race.getRaceId());
            standings.add(raceStanding);
        }
        SeasonResultsDto seasonResultsDto = new SeasonResultsDto();
        seasonResultsDto.createSeasonResults(standings);
        return seasonResultsDto;
    }

    @Transactional
    public CalendarEntity addRace(UUID calenderId, UUID trackId) {
        CalendarEntity calendar = getCalendarById(calenderId);
//        Track track = trackService.getTrackById(trackId);
//        Race race = new Race();
//        race.setCalendarId(calenderId);
//        race.setTrackId(trackId);
//        raceService.createRace(race);
//        calendar.addRace(race);
//        track.addRace(race);
        return calendar;
    }

    @Transactional
    public CalendarEntity removeRace(UUID calenderId, UUID raceId) {
        CalendarEntity calendar = getCalendarById(calenderId);
        RaceEntity race = raceService.getRaceById(raceId);
        calendar.removeRace(race);
        race.setTrackId(null);
        race.setCalendarId(null);
        return calendar;
    }

//    public Calendar updateCalendar(Calendar calendar) {
//        Calendar old = getCalendarById(calendar.getCalendarId());
//        if (old != null) {
//            old.setName(calendar.getName());
//            calendarRepository.save(old);
//        }
//        else {
//            return new Calendar();
//        }
//        return old;
//    }

    public void deleteCalendarById(UUID id) {
        calendarRepository.deleteById(id);
    }

//    private RaceStanding mapToRaceStanding(RaceStandingDto raceStandingDto) {
//        return new RaceStanding.Builder()
//                .withId(raceStandingDto.get)
//                .build();
//    }
}

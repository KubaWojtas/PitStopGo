package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.dto.RaceStandingDto;
import main.java.com.swc.vroomvroom.dto.SeasonResultsDto;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.RaceStanding;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private TrackService trackService;
    @Autowired
    private RaceService raceService;

    public Calendar getCalendarById(UUID id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public List<Calendar> getAllCalendars() {
        return (List<Calendar>) calendarRepository.findAll();
    }

    public Calendar createCalender(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Calendar generateRaceCalendar(UUID id) {
        Calendar calendar = getCalendarById(id);
        if (calendar.getRaces().isEmpty()) {
            List<Track> tracks = trackService.getAllTracks();
            for (Track track : tracks) {
                Race race = new Race();
                race.setTrackId(track.getTrackId());
                calendar.addRace(race);
            }
        }
        calendar.generateRaceCalendar();
        return calendarRepository.save(calendar);
    }

    public SeasonResultsDto simulateCalendar(UUID id) {
        Calendar calendar = getCalendarById(id);
        List<RaceStandingDto> standings= new ArrayList<>();
        for (Race race: calendar.getRaces()) {
            RaceStandingDto raceStanding = raceService.simulateRace(race.getRaceId());
            standings.add(raceStanding);
        }
        SeasonResultsDto seasonResultsDto = new SeasonResultsDto();
        seasonResultsDto.createSeasonResults(standings);
        return seasonResultsDto;
    }

    @Transactional
    public Calendar addRace(UUID calenderId, UUID trackId) {
        Calendar calendar = getCalendarById(calenderId);
        Track track = trackService.getTrackById(trackId);
        Race race = new Race();
        race.setCalendarId(calenderId);
        race.setTrackId(trackId);
        raceService.createRace(race);
        calendar.addRace(race);
        track.addRace(race);
        return calendar;
    }

    @Transactional
    public Calendar removeRace(UUID calenderId, UUID raceId) {
        Calendar calendar = getCalendarById(calenderId);
        Race race = raceService.getRaceById(raceId);
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
}

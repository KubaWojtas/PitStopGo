package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private TrackService trackService;
    @Autowired
    private RaceService raceService;

    public Calendar getCalendarById(int id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public List<Calendar> getAllCalendars() {
        return (List<Calendar>) calendarRepository.findAll();
    }

    public Calendar generateRaceCalendar(int id) {
        Calendar calendar = getCalendarById(id);
        if (calendar.getRaces().isEmpty()) {
            List<Track> tracks = trackService.getAllTracks();
            for (Track track: tracks) {
                Race race = new Race();
                race.setTrackId(track.getTrackId());
                calendar.addRace(race);
            }
        }
        calendar.generateRaceCalendar();
        return calendarRepository.save(calendar);
    }

    public Calendar createCalender(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Transactional
    public Calendar addRace(int calenderId, int trackId) {
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

//    @Transactional
//    public Calendar removeRace(int calenderId, int trackId) {
//        Calendar calendar = getCalendarById(calenderId);
//        Race race = raceService.getRaceById(raceId);
//        calendar.removeRace(race);
//        return calendar;
//    }

    public Calendar updateCalendar(Calendar calendar) {
        Calendar old = getCalendarById(calendar.getCalendarId());
        if (old != null) {
            old.setName(calendar.getName());
            calendarRepository.save(old);
        }
        else {
            return new Calendar();
        }
        return old;
    }

    public void deleteCalendarById(int id) {
        calendarRepository.deleteById(id);
    }
}

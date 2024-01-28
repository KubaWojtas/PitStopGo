package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private TrackService trackService;

    public Calendar getCalendarById(int id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public List<Calendar> getAllCalendars() {
        return (List<Calendar>) calendarRepository.findAll();
    }

//    public Calendar generateRaceCalendar(int id) {
//        Calendar calendar = getCalendarById(id);
//        calendar.generateRaceCalendar();
//        return calendar;
//    }

    public Calendar createCalender(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Transactional
    public Calendar addTrack(int calenderId, int trackId) {
        Calendar calendar = getCalendarById(calenderId);
        Track track = trackService.getTrackById(trackId);
        calendar.addTrack(track);
        return calendar;
    }

    public Calendar updateCalendar(Calendar calendar) {
        Calendar old = getCalendarById(calendar.getCalendarId());
        if (old != null) {
            old.setName(calendar.getName());
            old.setTracks(calendar.getTracks());
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

    @Transactional
    public Calendar removeTrack(int calenderId, int trackId) {
        Calendar calendar = getCalendarById(calenderId);
        Track track = trackService.getTrackById(trackId);
        calendar.removeTrack(track);
        return calendar;
    }
}

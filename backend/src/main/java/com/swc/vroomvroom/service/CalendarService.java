package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.model.Calendar;
import main.java.com.swc.vroomvroom.model.Track;
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

    public Calendar createCalender(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Transactional
    public Calendar addTrackToCalendar(int calenderId, int trackId) {
        Calendar calendar = getCalendarById(calenderId);
        Track track = trackService.getTrackById(trackId);
        calendar.addTrack(track);
        return calendar;
    }

    @Transactional
    public Calendar removeTrackOfCalendar(int calenderId, int trackId) {
        Calendar calendar = getCalendarById(calenderId);
        Track track = trackService.getTrackById(trackId);
        calendar.removeTrack(track);
        return calendar;
    }

    public String deleteCalendarById(int id) {
        calendarRepository.deleteById(id);
        return "Calender got deleted";
    }
}

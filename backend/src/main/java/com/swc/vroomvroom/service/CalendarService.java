package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Race;
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
    private RaceService raceService;

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
    public Calendar addRace(int calenderId, int raceId) {
        Calendar calendar = getCalendarById(calenderId);
        Race race = raceService.getRaceById(raceId);
        calendar.addRace(race);
        return calendar;
    }

    @Transactional
    public Calendar removeRace(int calenderId, int raceId) {
        Calendar calendar = getCalendarById(calenderId);
        Race race = raceService.getRaceById(raceId);
        calendar.removeRace(race);
        return calendar;
    }

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

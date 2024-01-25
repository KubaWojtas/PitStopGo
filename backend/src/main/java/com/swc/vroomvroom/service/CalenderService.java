package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.model.Calender;
import main.java.com.swc.vroomvroom.model.Track;
import main.java.com.swc.vroomvroom.repository.CalenderRepository;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CalenderService {

    @Autowired
    private CalenderRepository calenderRepository;

    public Calender createCalender(Calender calender) {
        return calenderRepository.save(calender);
    }

    public List<Calender> createCalenders(List<Calender> calenders) {
        return (List<Calender>) calenderRepository.saveAll(calenders);
    }

    public void addTrackToCalender(Calender calender, Track track) {
        calender.getTracks().add(track);
    }

    public Calender getCalenderById(int id) {
        return calenderRepository.findById(id).orElse(null);
    }

    public Set<Calender> getAllCalenders() {
        return (Set<Calender>) calenderRepository.findAll();
    }

    public String deleteCalenderById(int id) {
        calenderRepository.deleteById(id);
        return "Calender got deleted";
    }
}

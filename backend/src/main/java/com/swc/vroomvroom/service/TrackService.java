package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.model.Track;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    public List<Track> createTracks(List<Track> tracks) {
        return (List<Track>) trackRepository.saveAll(tracks);
    }

    public Track getTrackById(int id) {
        return trackRepository.findById(id).orElse(null);
    }

    public Set<Track> getAllTracks() {
        return (Set<Track>) trackRepository.findAll();
    }

    public String deleteTrackById(int id) {
        trackRepository.deleteById(id);
        return "Track got deleted";
    }
}

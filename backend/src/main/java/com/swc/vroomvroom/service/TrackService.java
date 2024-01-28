package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public Track getTrackById(int id) {
        return trackRepository.findById(id).orElse(null);
    }

    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    public List<Track> createTracks(List<Track> tracks) {
        return (List<Track>) trackRepository.saveAll(tracks);
    }

    public Track updateTrack(Track track) {
        Track old = getTrackById(track.getTrackId());
        if (old != null) {
            old.setName(track.getName());
            trackRepository.save(old);
        }
        else {
            return new Track();
        }
        return old;
    }

    public void deleteTrackById(int id) {
        trackRepository.deleteById(id);
    }
}

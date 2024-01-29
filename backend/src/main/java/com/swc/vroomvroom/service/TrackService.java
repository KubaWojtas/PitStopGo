package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private RaceService raceService;

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

    @Transactional
    public void addRace(int trackId, int raceId) {
        Track track = getTrackById(trackId);
        Race race = raceService.getRaceById(raceId);
        track.addRace(race);
    }

    @Transactional
    public void removeRace(int trackId, int raceId) {
        Track track = getTrackById(trackId);
        Race race = raceService.getRaceById(raceId);
        track.removeRace(race);
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

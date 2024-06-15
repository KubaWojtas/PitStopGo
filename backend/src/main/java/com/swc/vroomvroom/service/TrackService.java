package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Race;
import main.java.com.swc.vroomvroom.entity.Track;
import main.java.com.swc.vroomvroom.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private RaceService raceService;

    public Track getTrackById(UUID id) {
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
    public void addRace(UUID trackId, UUID raceId) {
        Track track = getTrackById(trackId);
        Race race = raceService.getRaceById(raceId);
        track.addRace(race);
    }

    @Transactional
    public void removeRace(UUID trackId, UUID raceId) {
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

    public void deleteTrackById(UUID id) {
        trackRepository.deleteById(id);
    }
}

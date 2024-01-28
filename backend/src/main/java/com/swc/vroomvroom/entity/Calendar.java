package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Data
@Entity
@Table(name = "CALENDER")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int calendarId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Track> tracks = new HashSet<>();

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

//    public Set<raceCalendar> generateRaceCalendar() {
//        Set<raceCalendar> raceCalendar = new HashSet<>();
//        LocalDate dateOfStart = LocalDate.of(2024, 3, 2);
//        LocalDate dateOfRace = dateOfStart;
//
//        for (Track track: tracks) {
//            int random = new Random().nextInt(3) + 1;
//            dateOfRace = dateOfRace.plusWeeks(random);
//            raceCalendar.add(mapCalendarTrack(track, dateOfStart));
//        }
//
//        return raceCalendar;
//    }
//
//    private raceCalendar mapCalendarTrack(Track track, LocalDate dateOfRace) {
//        raceCalendar calendarTrack = new raceCalendar();
//
//        calendarTrack.setCalendarId(this.getCalendarId());
//        calendarTrack.setTrackId(track.getTrackId());
//        calendarTrack.setDateOfRace(dateOfRace);
//
//        return calendarTrack;
//    }


}

package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Entity
@Table(name = "CALENDER")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "calendarId")
    private Set<Race> races = new HashSet<>();

    public void addRace(Race race) {
        races.add(race);
    }

    public void removeRace(Race race) {
        races.remove(race);
    }

    public void generateRaceCalendar() {
        LocalDate dateOfStart = LocalDate.of(2024, 3, 2);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (Race race : races) {
            race.setDateOfRace(dateOfStart);
            int randomWeeks = random.nextInt(1, 4);
            dateOfStart = dateOfStart.plusWeeks(randomWeeks);
        }
    }
}

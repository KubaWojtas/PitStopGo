package com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Data
@Table(name = "calendar")
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID calendarId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "calendarId")
    private Set<RaceEntity> races = new HashSet<>();

    public void addRace(RaceEntity race) {
        races.add(race);
    }

    public void removeRace(RaceEntity race) {
        races.remove(race);
    }

    public void generateRaceCalendar() {
        LocalDate dateOfStart = LocalDate.of(2024, 3, 2);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (RaceEntity race : races) {
            race.setDateOfRace(dateOfStart);
            int randomWeeks = random.nextInt(1, 4);
            dateOfStart = dateOfStart.plusWeeks(randomWeeks);
        }
    }
}

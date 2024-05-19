package main.java.com.swc.vroomvroom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "CALENDER")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "calendarId")
    private Set<Race> races = new HashSet<>();

    private Calendar(Builder builder) {
        calendarId = builder.calendarId;
        name = builder.name;
        races = builder.races;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public String getName() {
        return name;
    }

    public Set<Race> getRaces() {
        return races;
    }

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

    public static final class Builder {
        private int calendarId;
        private String name;
        private Set<Race> races;

        public Builder() {
        }

        public Builder withCalendarId(int calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withRaces(Set<Race> races) {
            this.races = races;
            return this;
        }

        public Calendar build() {
            return new Calendar(this);
        }
    }
}

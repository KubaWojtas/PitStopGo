package main.java.com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import main.java.com.swc.vroomvroom.entity.Driver;
import main.java.com.swc.vroomvroom.entity.Team;
import main.java.com.swc.vroomvroom.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DriverService driverService;

    public Team getTeamById(int id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> createsTeam(List<Team> teams) {
        return (List<Team>) teamRepository.saveAll(teams);
    }

    @Transactional
    public Team addDriver(int teamId, int driverId) {
        Team team = getTeamById(teamId);
        Driver driver = driverService.getDriverById(driverId);

        team.addDriver(driver);
        return team;
    }

    @Transactional
    public Team removeDriver(int teamId, int driverId) {
        Team team = getTeamById(teamId);
        Driver driver = driverService.getDriverById(driverId);

        team.removeDriver(driver);
        return team;
    }

    public Team updateTeam(Team team) {
        Team old = getTeamById(team.getTeamId());
        if (old != null) {
            old.setName(team.getName());
            teamRepository.save(old);
        }
        else {
            return new Team();
        }
        return old;
    }

    public void deleteTeamById(int id) {
        teamRepository.deleteById(id);
    }
}

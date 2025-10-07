package com.swc.vroomvroom.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swc.vroomvroom.entity.Driver;
import com.swc.vroomvroom.entity.Team;
import com.swc.vroomvroom.repository.TeamRepository;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DriverService driverService;

    public Team getTeamById(UUID id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

//    public List<Team> createsTeam(List<Team> teams) {
//        return (List<Team>) teamRepository.saveAll(teams);
//    }

    @Transactional
    public Team addDriver(UUID teamId, UUID driverId) {
        Team team = getTeamById(teamId);
        Driver driver = driverService.getDriverById(driverId);
//        driver.setTeamId(teamId);

        team.addDriver(driver);
        return team;
    }

    @Transactional
    public Team removeDriver(UUID teamId, UUID driverId) {
        Team team = getTeamById(teamId);
        Driver driver = driverService.getDriverById(driverId);
//        driver.setTeamId(null);

        team.removeDriver(driver);
        return team;
    }

//    public Team updateTeam(Team team) {
//        Team old = getTeamById(team.getTeamId());
//        if (old != null) {
//            old.setName(team.getName());
//            teamRepository.save(old);
//        }
//        else {
//            return new Team();
//        }
//        return old;
//    }

    public void deleteTeamById(UUID id) {
        teamRepository.deleteById(id);
    }
}

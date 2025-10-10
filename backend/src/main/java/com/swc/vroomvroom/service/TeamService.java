package com.swc.vroomvroom.service;

import com.swc.vroomvroom.service.driver.DriverMapper;
import com.swc.vroomvroom.service.driver.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swc.vroomvroom.entity.DriverEntity;
import com.swc.vroomvroom.entity.TeamEntity;
import com.swc.vroomvroom.repository.TeamRepository;
import java.util.List;
import java.util.UUID;

import static com.swc.vroomvroom.service.driver.DriverMapper.mapToDriverEntity;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DriverService driverService;

    public TeamEntity getTeamById(UUID id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<TeamEntity> getAllTeams() {
        return (List<TeamEntity>) teamRepository.findAll();
    }

    public TeamEntity createTeam(TeamEntity team) {
        return teamRepository.save(team);
    }

//    public List<Team> createsTeam(List<Team> teams) {
//        return (List<Team>) teamRepository.saveAll(teams);
//    }

    @Transactional
    public TeamEntity addDriver(UUID teamId, UUID driverId) {
        TeamEntity team = getTeamById(teamId);
        DriverEntity driver = mapToDriverEntity(driverService.getDriverById(driverId));
//        driver.setTeamId(teamId);

        team.addDriver(driver);
        return team;
    }

    @Transactional
    public TeamEntity removeDriver(UUID teamId, UUID driverId) {
        TeamEntity team = getTeamById(teamId);
        DriverEntity driver =  mapToDriverEntity(driverService.getDriverById(driverId));
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

package main.java.com.swc.vroomvroom.service;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.model.Team;
import main.java.com.swc.vroomvroom.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

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

    public String deleteTeamById(int id) {
        teamRepository.deleteById(id);
        return "Team got deleted";
    }
}

package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.model.Team;
import main.java.com.swc.vroomvroom.service.DriverService;
import main.java.com.swc.vroomvroom.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private TeamService service;

    @PostMapping("/teams/add")
    public Team addTeam(@RequestBody Team team) {
        return service.createTeam(team);
    }

    @GetMapping("/teams/{id}")
    public Team findById(@PathVariable("id") int id) {
        return service.getTeamById(id);
    }

    @GetMapping("/teams")
    public Set<Team> findAll() {
        return service.getAllTeams();
    }

    @DeleteMapping("/teams/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteTeamById(id);
    }
}

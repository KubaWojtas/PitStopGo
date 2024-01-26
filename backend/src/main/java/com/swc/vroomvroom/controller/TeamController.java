package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.model.Driver;
import main.java.com.swc.vroomvroom.model.Team;
import main.java.com.swc.vroomvroom.service.DriverService;
import main.java.com.swc.vroomvroom.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin()
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping("/{id}")
    public Team findById(@PathVariable("id") int id) {
        return service.getTeamById(id);
    }

    @GetMapping()
    public List<Team> findAll() {
        return service.getAllTeams();
    }

    @PostMapping("/add")
    public Team addTeam(@RequestBody Team team) {
        return service.createTeam(team);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteTeamById(id);
    }
}

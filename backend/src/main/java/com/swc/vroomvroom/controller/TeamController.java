package main.java.com.swc.vroomvroom.controller;

import main.java.com.swc.vroomvroom.entity.Calendar;
import main.java.com.swc.vroomvroom.entity.Team;
import main.java.com.swc.vroomvroom.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping("/{id}")
    public Team findById(@PathVariable("id") UUID id) {
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

    @PostMapping("/{id}/addDriver/{driverId}")
    public Team addDriver(@PathVariable("id") UUID id, @PathVariable("driverId") UUID driverId) {
        return service.addDriver(id, driverId);
    }

    @PostMapping("/{id}/removeDriver/{driverId}")
    public Team removeDriver(@PathVariable("id") UUID id, @PathVariable("driverId") UUID driverId) {
        return service.removeDriver(id, driverId);
    }
//
//    @PutMapping("/update")
//    public Team updateTeam(@RequestBody Team team) {
//        return service.updateTeam(team);
//    }

    @DeleteMapping("/{id}/delete")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteTeamById(id);
    }
}

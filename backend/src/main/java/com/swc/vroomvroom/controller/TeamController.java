package com.swc.vroomvroom.controller;

import com.swc.vroomvroom.entity.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.swc.vroomvroom.service.TeamService;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin()
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping("/{id}")
    public TeamEntity findById(@PathVariable("id") UUID id) {
        return service.getTeamById(id);
    }

    @GetMapping()
    public List<TeamEntity> findAll() {
        return service.getAllTeams();
    }

    @PostMapping("/add")
    public TeamEntity addTeam(@RequestBody TeamEntity team) {
        return service.createTeam(team);
    }

    @PostMapping("/{id}/addDriver/{driverId}")
    public TeamEntity addDriver(@PathVariable("id") UUID id, @PathVariable("driverId") UUID driverId) {
        return service.addDriver(id, driverId);
    }

    @PostMapping("/{id}/removeDriver/{driverId}")
    public TeamEntity removeDriver(@PathVariable("id") UUID id, @PathVariable("driverId") UUID driverId) {
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

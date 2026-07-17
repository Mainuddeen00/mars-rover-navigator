package com.github.mainuddeen00.mars_rover_navigator.controller;


import com.github.mainuddeen00.mars_rover_navigator.model.Rover;
import com.github.mainuddeen00.mars_rover_navigator.service.RoverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoverController {

    private final RoverService roverService;

    public RoverController(RoverService roverService){

        this.roverService = roverService;
    }


    @GetMapping("/status")
    public Rover getStatus(){

        return roverService.getRoverStatus();
    }


    @PostMapping("/move")
    public Rover moveRover(@RequestParam String commands){

        return roverService.processCommands(commands);
    }

    @PostMapping("/reset")
    public Rover resetRover(){

        return roverService.resetRover();
    }
}

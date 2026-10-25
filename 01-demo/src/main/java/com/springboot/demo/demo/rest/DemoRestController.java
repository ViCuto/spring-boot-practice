package com.springboot.demo.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private static final String GREETING = "Hello world!";
    private static final String WORKOUT = "Swam 5 km today!";

    // Inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/" endpoint that return "Hello world!"
    @GetMapping("/")
    public String sayHello() {
        return GREETING;
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return WORKOUT;
    }

    // expose a new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return String.format("Coach: %s, Team name: %s", coachName, teamName);
    }

}

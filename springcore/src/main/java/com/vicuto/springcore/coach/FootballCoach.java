package com.vicuto.springcore.coach;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public static final String DAILY_WORKOUT = "Practice penalty shots for 30 minutes!";

    public FootballCoach() {
        IO.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return DAILY_WORKOUT;
    }

}

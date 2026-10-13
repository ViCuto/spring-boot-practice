package com.vicuto.springcore.coach;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public static final String DAILY_WORKOUT = "Practice your backhand volley for 15 minutes.";

    public TennisCoach() {
        IO.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return DAILY_WORKOUT;
    }

}

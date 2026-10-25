package com.vicuto.springcore.coach;

public class BoxingCoach implements Coach {

    public static final String DAILY_WORKOUT = "Do 5 rounds of shadow boxing!";

    public BoxingCoach() {
        IO.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return DAILY_WORKOUT;
    }

}

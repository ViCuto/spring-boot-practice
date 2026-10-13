package com.vicuto.springcore.coach;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
// Lazy initialization(disabled by default).
// Bean only will be initialized if needed(dependency injection or explicitly requested).
public class BasketballCoach implements Coach {

    public static final String DAILY_WORKOUT = "Shoot 100 free throws as a warm-up.";

    public BasketballCoach() {
        IO.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return DAILY_WORKOUT;
    }

}

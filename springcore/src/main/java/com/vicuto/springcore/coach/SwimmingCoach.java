package com.vicuto.springcore.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//  @Qualifier has higher priority than @Primary.
//  Only one @Primary for multiple implementations.

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// by default: Singleton.
// New bean instance for each container request, so new object instance for each injection.
// After dependency injection spring container "forgets" prototype beans.
public class SwimmingCoach implements  Coach {

    public static final String DAILY_WORKOUT = "Set 5x200 fly. Good luck!";

    public SwimmingCoach() {
        IO.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return DAILY_WORKOUT;
    }

    // init method (custom code during bean initialization)
    @PostConstruct
    public void doStartupStuff() {
        IO.println("Preparating some stuff for " + getClass().getSimpleName());
    }

    // destroy method (custom code during bean destruction)
    // Special Note for Prototype Scope:
    // Spring does NOT call the @PreDestroy method for prototype beans!
    // After dependency injection, the Spring container "forgets" the bean.
    // The "client code" (meaning the class that injected and uses this bean,
    // for example our CoachController) must clean up prototype-scoped objects manually.
    @PreDestroy
    public void doCleanupStuff() {
        IO.println("Cleaning some stuff for " + getClass().getSimpleName());
    }

}

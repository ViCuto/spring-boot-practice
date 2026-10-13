package com.vicuto.springcore.rest;

import com.vicuto.springcore.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    /*
    Field Injection, not recommended; Can see it in legacy code.
    @Autowired
    */
    private Coach headCoach;
    private Coach secondaryCoach;
    private Coach guestCoach;

    // --- CONSTRUCTOR INJECTION --- (required dependencies)
    // Note: If there is only one constructor, @Autowired is optional.
    // @Qualifier("bean id")
    @Autowired
    public CoachController(Coach headCoach,
                           @Qualifier("swimmingCoach")Coach secondaryCoach,
                           @Qualifier("boxingCoach")Coach guestCoach) {
        IO.println("In constructor: " + getClass().getSimpleName());

        this.headCoach = headCoach;
        this.secondaryCoach = secondaryCoach;
        this.guestCoach = guestCoach;
    }

    /*
    --- SETTER INJECTION ---
    (optional dependencies)
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return headCoach.getDailyWorkout();
    }

    @GetMapping("/secondworkout")
    public String getSecondWorkout() {
        return guestCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: headCoach == secondaryCoach, " + (headCoach == secondaryCoach);
        // Output result based on Bean Scopes:
        // Singleton -> true
        // Prototype -> false
    }

}

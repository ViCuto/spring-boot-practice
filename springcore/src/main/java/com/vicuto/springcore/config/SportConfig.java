package com.vicuto.springcore.config;

import com.vicuto.springcore.coach.BoxingCoach;
import com.vicuto.springcore.coach.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Use @Bean to take an existing third-party class, wrap it,
    // and expose it as a Spring bean so we can use it in our application.
    // @Bean("MikeTyson") assign a custom bean ID
    @Bean
    public Coach boxingCoach() {
        return new BoxingCoach();
    }

}

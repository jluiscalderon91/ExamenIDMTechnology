package com.bci.apicliente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class WebConfig {
    @Bean
    public WebConfig WebConfig() {
        return new WebConfig();
    }
}
package com.demo.StudentRegistration.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = "com.demo.StudentRegistration.repository")
@EntityScan("com.demo.StudentRegistration.entity")
public class JpaConfiguration {
}
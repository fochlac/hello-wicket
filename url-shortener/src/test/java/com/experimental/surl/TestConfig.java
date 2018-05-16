package com.experimental.surl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.example.surl"})
@EnableJpaRepositories(basePackages = "com.example.surl")
@EnableTransactionManagement
@ActiveProfiles("test")
public class TestConfig {
}

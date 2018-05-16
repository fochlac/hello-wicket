package com.experimental.surl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Start
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder().sources(Start.class).run(args);
    }
}
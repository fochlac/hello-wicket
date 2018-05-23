package com.experimental.surl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UrlShortenerApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder().sources(UrlShortenerApplication.class).run(args);
    }
}
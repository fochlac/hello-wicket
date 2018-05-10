package com.experimental.surl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Start
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder().sources(Start.class).run(args);
    }
}
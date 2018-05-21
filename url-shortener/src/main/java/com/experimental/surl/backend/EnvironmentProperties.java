package com.experimental.surl.backend;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class EnvironmentProperties
{
    private String protocol = "http";
    private String domain = "localhost";
    private int portNumber = 8080;
}

package com.experimental.surl.services;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.UUID;

//@Entity
@Builder
@Getter
@Setter
public class Url {

    @Id
    private UUID id;

    private String longUrl;

    private String shortUrl;

    private int numberOfAccesses;
}

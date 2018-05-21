package com.experimental.surl.backend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class Url
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String longUrl;

    private String shortUrl;

    private int numberOfAccesses;
}

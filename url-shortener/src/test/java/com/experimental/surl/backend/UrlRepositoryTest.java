package com.experimental.surl.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UrlRepositoryTest
{
    @Autowired
    private UrlRepository urlRepository;

    @Test
    public void should_create_url_entry()
    {
        Url url = Url.builder()
                .shortUrl("/289347934")
                .longUrl("http://www.google.de")
                .build();
        urlRepository.save(url);

        assertEquals(1, urlRepository.count());
    }

    @Test
    public void should_retrieve_url_entry()
    {
        Url url = Url.builder()
                .shortUrl("/289347934")
                .longUrl("http://www.google.de")
                .build();
        urlRepository.save(url);

        Optional<Url> retrievedUrl = urlRepository.findByShortUrl("/289347934");

        assertTrue(retrievedUrl.isPresent());
        assertEquals("http://www.google.de", retrievedUrl.get().getLongUrl());
    }
}

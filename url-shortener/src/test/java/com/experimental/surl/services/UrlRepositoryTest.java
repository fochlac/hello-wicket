package com.experimental.surl.services;

import com.experimental.surl.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class UrlRepositoryTest {

//    @Autowired
//    private UrlRepository urlRepository;

    @Test
    public void should_create_url_entry()
    {
//        Url url = Url.builder()
//                .id(UUID.randomUUID())
//                .shortUrl("/289347934")
//                .longUrl("http://www.google.de")
//                .build();
//        urlRepository.save(url);
    }

    @Test
    public void should_update_url_entry()
    {

    }

    @Test
    public void should_retrieve_url_entry()
    {

    }

    @Test
    public void should_retrieve_empty_url_entry()
    {

    }
}

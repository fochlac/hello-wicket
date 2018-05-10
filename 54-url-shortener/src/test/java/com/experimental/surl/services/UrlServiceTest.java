package com.experimental.surl.services;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest
{
    @InjectMocks
    private UrlService urlService;

    @Test
    public void should_create_short_url()
    {
        String originalUrl = "http://www.experimental-software.com";

        String shortUrl = urlService.generateRandomShortUrl();

        assertEquals(7, shortUrl.length());
    }

    @Test
    public void should_retrieve_long_url()
    {

    }
}

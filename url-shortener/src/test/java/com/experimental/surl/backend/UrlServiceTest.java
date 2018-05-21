package com.experimental.surl.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest
{
    @InjectMocks
    private UrlServiceImpl urlService;

    @Mock
    private UrlRepository urlRepository;

    @Mock
    private EnvironmentProperties environmentProperties;

    @Captor
    private ArgumentCaptor<Url> urlArgumentCaptor;

    @Test
    public void should_create_short_url()
    {
        String shortUrl = urlService.generateRandomShortUrl();

        assertEquals(7, shortUrl.length());
    }

    @Test
    public void should_retrieve_long_url()
    {
        given(urlRepository.findByShortUrl("abcde"))
                .willReturn(buildUrl("http://www.experimental-software.com", ("abcde")));

        Optional<String> longUrl = urlService.retrieveLongUrl("abcde");

        assertTrue(longUrl.isPresent());
        assertEquals("http://www.experimental-software.com", longUrl.get());
    }

    @Test
    public void should_prepend_http_if_no_protocol_specified()
    {
        String longUrl = "experimental-software.com";

        urlService.createShortUrl(longUrl);

        verify(urlRepository).save(urlArgumentCaptor.capture());
        assertEquals("http://experimental-software.com", urlArgumentCaptor.getValue().getLongUrl());
    }

    @Test
    public void should_retrieve_full_url_for_short_url_key()
    {
        given(environmentProperties.getProtocol()).willReturn("http");
        given(environmentProperties.getDomain()).willReturn("localhost");
        given(environmentProperties.getPortNumber()).willReturn(8080);

        String shortUrl = urlService.toFullShortUrl("6lBolvo");

        assertFalse(shortUrl.isEmpty());
        assertEquals("http://localhost:8080/6lBolvo", shortUrl);
    }

    @Test
    public void should_increment_url_access()
    {
        given(urlRepository.getByShortUrl("6lBolvo")).willReturn(Url.builder()
                .numberOfAccesses(2)
                .build());

        urlService.registerAccess("6lBolvo");

        verify(urlRepository).save(urlArgumentCaptor.capture());
        assertEquals(3, urlArgumentCaptor.getValue().getNumberOfAccesses());
    }

    private Optional<Url> buildUrl(String longUrl, String shortUrl)
    {
        return Optional.of(Url.builder()
                .id(1L)
                .longUrl(longUrl)
                .shortUrl(shortUrl)
                .build());
    }
}

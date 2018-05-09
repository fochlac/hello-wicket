package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest
{
    @InjectMocks
    private UrlService urlService;

    @Mock
    private UrlRepository urlRepository;

    @Test
    public void should_create_short_url()
    {
        String originalUrl = "http://www.experimental-software.com";

        String shortUrl = urlService.generateRandomShortUrl(originalUrl);

        assertEquals(7, shortUrl.length());
    }

    @Test
    public void should_retrieve_long_url()
    {

    }
}

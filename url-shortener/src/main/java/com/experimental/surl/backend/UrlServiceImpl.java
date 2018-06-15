package com.experimental.surl.backend;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
class UrlServiceImpl implements UrlService
{
    private final UrlRepository urlRepository;

    private final EnvironmentProperties environmentProperties;

    @Override
    @Transactional
    public String createShortUrl(String originalUrl)
    {
        String shortUrl;
        do {
            shortUrl = generateRandomShortUrl();
        } while (doesShortUrlAlreadyExist(shortUrl));

        urlRepository.save(buildUrl(originalUrl, shortUrl));

        return shortUrl;
    }

    @Override
    @Transactional
    public Optional<String> retrieveLongUrl(String shortUrl)
    {
        Optional<Url> url = urlRepository.findByShortUrl(shortUrl);
        return url.isPresent() ? Optional.of(url.get().getLongUrl()) : Optional.empty();
    }

    @Override
    public String toFullShortUrl(String shortUrlKey)
    {
        if (environmentProperties.getPortNumber() == 80) {
            return String.format("%s://%s/%s",
                    environmentProperties.getProtocol(),
                    environmentProperties.getDomain(),
                    shortUrlKey);
        } else {
            return String.format("%s://%s:%d/%s",
                    environmentProperties.getProtocol(),
                    environmentProperties.getDomain(),
                    environmentProperties.getPortNumber(),
                    shortUrlKey);
        }
    }

    @Override
    @Transactional
    public int getNumberOfAccesses(String shortUrlKey)
    {
        Url url = urlRepository.getByShortUrl(shortUrlKey);
        return url.getNumberOfAccesses();
    }

    @Override
    @Transactional
    synchronized public void registerAccess(String shortUrlKey)
    {
        Url url = urlRepository.getByShortUrl(shortUrlKey);
        url.setNumberOfAccesses(url.getNumberOfAccesses() + 1);
        urlRepository.save(url);
    }

    protected static String generateRandomShortUrl()
    {
        final int SHORT_URL_LENTH = 7;
        final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        final Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENTH; i++) {
            sb.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return sb.toString();
    }

    private static Url buildUrl(String originalUrl, String shortUrl)
    {
        String longUrl = originalUrl.startsWith("http") ? originalUrl : "http://" + originalUrl;
        return Url.builder().longUrl(longUrl).shortUrl(shortUrl).numberOfAccesses(0).build();
    }

    private boolean doesShortUrlAlreadyExist(String shortUrl)
    {
        return urlRepository.findByShortUrl(shortUrl).isPresent();
    }
}

package com.experimental.surl.backend;

import java.util.Optional;

public interface UrlService
{
    String createShortUrl(String originalUrl);

    Optional<String> retrieveLongUrl(String shortUrlKey);

    /**
     * @param shortUrlKey the key of the short url, e.g. 6lBolvo
     * @return the short URL inclusive protocol, domain, and port number
     */
    String toFullShortUrl(String shortUrlKey);

    int getNumberOfAccesses(String shortUrlKey);

    void registerAccess(String shortUrlKey);
}

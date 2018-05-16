package com.experimental.surl.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlService {

    public static final int SHORT_URL_LENTH = 7;

    private static String CHAR_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private static Random random = new Random();

    public String createShortUrl(String originalUrl)
    {
        String shortUrl;
        do {
            shortUrl = generateRandomShortUrl();
        } while (doesShortUrlAlreadyExist(shortUrl));

        return shortUrl;
    }

    protected static String generateRandomShortUrl()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENTH; i++) {
            sb.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return sb.toString();
    }

    private boolean doesShortUrlAlreadyExist(String shortUrl)
    {
        return false;
    }
}

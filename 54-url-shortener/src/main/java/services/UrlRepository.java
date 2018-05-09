package services;

import java.util.Optional;

public interface UrlRepository {

    Optional<Url> findByShortUrl(String shortUrl);

    Url save(Url url);
}

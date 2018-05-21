package com.experimental.surl.backend;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlRepository extends CrudRepository<Url, Long>
{
    Optional<Url> findByShortUrl(String shortUrl);

    Url getByShortUrl(String shortUrl);
}

package services;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Url {

    private String longUrl;

    private String shortUrl;

    private int numberOfAccesses;
}

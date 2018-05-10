package com.experimental.surl.frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.experimental.surl.services.UrlService;

public class UrlStats extends WebPage
{
    @SpringBean
    private UrlService urlService;

    public UrlStats()
    {
        add(new Label("longUrl", "https://www.google.com"));
        add(new Label("shortUrl", urlService.createShortUrl("https://www.google.com")));
    }
}

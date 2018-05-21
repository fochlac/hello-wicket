package com.experimental.surl.frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import com.experimental.surl.backend.UrlService;

import java.util.Optional;

public class UrlStats extends WebPage
{
    @SpringBean
    private UrlService urlService;

    public UrlStats(final PageParameters pageParameters)
    {
        String shortUrl = pageParameters.get("shortUrl").toString();

        Optional<String> longUrl = urlService.retrieveLongUrl(shortUrl);

        if(longUrl.isPresent()) {
            add(new Label("longUrl", longUrl.get()));
            add(new Label("shortUrl", urlService.toFullShortUrl(shortUrl)));
            add(new Label("numberOfAccesses", urlService.getNumberOfAccesses(shortUrl)));
        } else {
            redirectToNotFoundPage(shortUrl);
        }
    }

    private void redirectToNotFoundPage(String shortUrl)
    {
        PageParameters parameters = new PageParameters();
        parameters.add("shortUrl", shortUrl);
        getRequestCycle().setResponsePage(ShortUrlNotFound.class, parameters);
    }
}

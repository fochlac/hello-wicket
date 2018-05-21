package com.experimental.surl.frontend;

import com.experimental.surl.backend.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Optional;

@Slf4j
public class ShortUrlRedirect extends WebPage
{
    @SpringBean
    private UrlService urlService;

    public ShortUrlRedirect(final PageParameters parameters)
    {
        super(parameters);
        String shortUrl = parameters.get("shortUrl").toString();

        Optional<String> longUrl = urlService.retrieveLongUrl(shortUrl);

        if (longUrl.isPresent()) {
            urlService.registerAccess(shortUrl);
            redirectTo(longUrl.get());
        } else {
            redirectToNotFoundPage(shortUrl);
        }
    }

    private void redirectTo(String longUrl)
    {
        throw new RedirectToUrlException(longUrl);
    }

    private void redirectToNotFoundPage(String shortUrl)
    {
        PageParameters parameters = new PageParameters();
        parameters.add("shortUrl", shortUrl);
        getRequestCycle().setResponsePage(ShortUrlNotFound.class, parameters);
    }
}

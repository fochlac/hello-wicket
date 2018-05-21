package com.experimental.surl.frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ShortUrlNotFound extends WebPage
{
    public ShortUrlNotFound(final PageParameters pageParameters)
    {
        add(new Label("shortUrl", pageParameters.get("shortUrl")));
    }
}

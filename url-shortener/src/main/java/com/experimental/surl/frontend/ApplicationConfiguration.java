package com.experimental.surl.frontend;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import org.apache.wicket.protocol.http.WebApplication;

@ApplicationInitExtension
public class ApplicationConfiguration implements WicketApplicationInitConfiguration
{
    @Override
    public void init(WebApplication webApplication)
    {
        webApplication.mountPage("/${shortUrl}", ShortUrlRedirect.class);
        webApplication.mountPage("/${shortUrl}/stats", UrlStats.class);
    }
}

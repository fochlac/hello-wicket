package com.experimental.surl.frontend;

import com.experimental.surl.backend.UrlService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

@WicketHomePage
public class HomePage extends WebPage
{
    private static final long serialVersionUID = 1L;

    private String shortUrl = null;

    private String longUrl = null;

    @SpringBean
    private UrlService urlService;

    public HomePage(final PageParameters parameters)
    {
        final PropertyModel<String> shortUrlModel = new PropertyModel<>(this, "shortUrl");
        final PropertyModel<String> longUrlModel = new PropertyModel<>(this, "longUrl");

        add(new Label("shortUrl", shortUrlModel));

        Form<?> form = new Form("form")
        {
            @Override
            public void onSubmit()
            {
                String generatedShortUrl = urlService.createShortUrl(longUrlModel.getObject());
                HomePage.this.shortUrl = urlService.toFullShortUrl(generatedShortUrl);
                longUrlModel.setObject(null);
            }
        };
        form.add(new TextField<>("urlInput", longUrlModel));
        add(form);
    }
}

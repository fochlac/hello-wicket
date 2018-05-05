package frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ShortUrlRedirect extends WebPage {

    public ShortUrlRedirect(final PageParameters parameters) {
        super(parameters);

        String shortUrl = parameters.get(0).toString();

        redirectTo("https://www.google.de");
    }

    private void redirectTo(String url) {
        throw new RedirectToUrlException(url);
    }

    private void redirectTo(Class <? extends IRequestablePage> pageClass) {
        getRequestCycle().setResponsePage(pageClass);
    }
}

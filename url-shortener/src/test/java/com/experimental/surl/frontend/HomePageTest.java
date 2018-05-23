package com.experimental.surl.frontend;

import com.experimental.surl.WebPageTest;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Test;

public class HomePageTest extends WebPageTest
{
    @Test
    public void should_generate_short_url()
    {
        tester.startPage(HomePage.class);

        FormTester newFormTester = tester.newFormTester("form");
        newFormTester.setValue("urlInput", "http://www.experimental-software.com");
        newFormTester.submit();

        tester.assertContains("http://localhost:8080");
    }
}

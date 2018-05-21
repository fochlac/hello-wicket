package com.experimental.surl.frontend;

import com.experimental.surl.Start;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Start.class)
public class HomePageTest
{
    private WicketTester tester;

    @Autowired
    private WebApplication wicketApplication;

    @Autowired
    private ApplicationContext applicationContextMock;

    @Before
    public void setUp()
    {
        ReflectionTestUtils.setField(wicketApplication, "applicationContext", applicationContextMock);
        tester = new WicketTester(wicketApplication);
    }

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

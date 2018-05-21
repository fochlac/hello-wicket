package com.experimental.surl.frontend;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@WicketSignInPage
public class LoginPage extends WebPage
{
	public LoginPage(PageParameters parameters) {
		super(parameters);

		add(new SignInPanel("signInPanel"));
	}
}

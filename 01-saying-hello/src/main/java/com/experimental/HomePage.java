package com.experimental;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage
{
    private static final long serialVersionUID = 1L;
    private final TextField userNameInput;
    private Label greeting;

    public HomePage(final PageParameters parameters)
    {
        super(parameters);

        Form myForm = new Form("myForm") {
            @Override
            protected void onSubmit() {
                String enteredName = (String) userNameInput.getDefaultModelObject();
                greeting.setDefaultModelObject("Hello, " + enteredName);
                userNameInput.setDefaultModelObject("");
            }
        };

        greeting = new Label("greeting", Model.of(""));
        userNameInput = new TextField("userNameInput", new Model(""));

        myForm.add(userNameInput);

        add(myForm);
        add(greeting);
    }
}

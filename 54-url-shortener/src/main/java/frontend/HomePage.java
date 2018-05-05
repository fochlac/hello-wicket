package frontend;

import lombok.Getter;
import lombok.Setter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String shortUrl = null;

	public HomePage()
	{
		// This model references the page's shortUrl property and is
		// shared by the label and form component
		PropertyModel<String> messageModel = new PropertyModel<>(this, "shortUrl");

		// The label displays the currently set shortUrl
		add(new Label("shortUrl", messageModel));

		// Add a form to change the shortUrl. We don't need to do anything
		// else with this form as the shared model is automatically updated
		// on form submits
		Form<?> form = new Form("form");
		form.add(new TextField<>("urlInput", messageModel));
		add(form);
	}
}

package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage {
    public Locator topMenuButton;

    public LandingPage(Page page) {
        super(page);
        topMenuButton = page.getByTestId("category-link");
    }

    public void selectMenuButton(String buttonText) {
        topMenuButton.getByText(buttonText).hover();

    }

    public void open() {
        page.navigate("/");
    }
}

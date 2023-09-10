package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage {
    public Locator topMenuButton;
    public Locator subMenuButton;

    public LandingPage(Page page) {
        super(page);
        topMenuButton = page.getByTestId("category-link");
        subMenuButton = topMenuButton.locator("[class*='submenu'] a");
    }

    public void selectFromMenu(String buttonText) {
        topMenuButton.getByText(buttonText).hover();
    }

    public void selectFromMenu(String buttonText, String submenuButtonText) {
        topMenuButton.getByText(buttonText).hover();
        subMenuButton.getByText(submenuButtonText).locator("visible=true").click();
    }

    public void open() {
        page.navigate("/pl/pl");
    }
}

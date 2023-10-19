package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasketPage extends BasePage {
    public Locator headline;
    public Locator button;
    public Locator link;

    public BasketPage(Page page) {
        super(page);
        headline = page.locator("[class^=\"headline\"]");
        button = page.locator("[class^=\"primary__PrimaryButtonComponent\"]");
        link = page.locator("a[href]");

    }
}

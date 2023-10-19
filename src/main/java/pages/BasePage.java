package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import modules.BaseModule;

public class BasePage extends BaseModule {
    public Locator basket;

    public BasePage(Page page) {
        super(page);
        basket = page.getByTestId("cart-button");
    }

    public void open() {
        page.navigate(".");
    }
}

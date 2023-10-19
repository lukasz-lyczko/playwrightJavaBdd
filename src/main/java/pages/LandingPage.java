package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage {
    public Locator topMenuButton;
    public Locator subMenuButton;
    public Locator productNameLink;
    public Locator sizeNameButton;
    public Locator addToCartButton;
    public Locator cartConfirmationTitle;
    public Locator confirmationDialogProductName;
    public Locator confirmationDialogProductSize;
    public Locator searchButton;
    public Locator searchInput;
    public Locator searchResultProductName;
    public Locator accountButton;
    public Locator accountSubButtons;

    public LandingPage(Page page) {
        super(page);
        topMenuButton = page.getByTestId("category-link");
        subMenuButton = topMenuButton.locator("[class*='submenu'] a");
        productNameLink = page.locator(".es-product-name a");
        sizeNameButton = page.getByTestId("size-name");
        addToCartButton = page.getByTestId("add-to-cart");
        cartConfirmationTitle = page.getByTestId("cart-confirmation-title");
        confirmationDialogProductName = page.locator(".add-to-cart-confirmation-modal [class*='ProductName']");
        confirmationDialogProductSize = page.getByTestId("cart-confirmation-product-size");
        searchButton = page.getByTestId("search-open-button");
        searchInput = page.getByTestId("search-input").locator("input");
        searchResultProductName = page.getByTestId("products-results").locator("[class*=Title]");
        accountButton = page.getByTestId("account-info-logged-false");
        accountSubButtons = page.locator("[data-testid-group='login-dropdown'] a");
    }

    public void selectFromMenu(String buttonText) {
        topMenuButton.getByText(buttonText).hover();
    }

    public void selectFromMenu(String buttonText, String submenuButtonText) {
        topMenuButton.getByText(buttonText).hover();
        subMenuButton.getByText(submenuButtonText).locator("visible=true").click();
    }

    public void openProductPage(String url) {
        page.navigate("." + url);
    }
}



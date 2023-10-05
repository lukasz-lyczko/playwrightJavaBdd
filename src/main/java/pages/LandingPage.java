package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

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
    public Locator kontoButton;

    public Locator kontoSubButtons;

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
        kontoButton = page.getByTestId("account-info-logged-false");
        kontoSubButtons = page.locator("[data-testid-group=\"login-dropdown\"] a");
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

    public void openProductPage(String url) {
        page.navigate("pl/pl" + url);
    }

//    // ta metoda lokalizuje na stronie naglowek z napisem Nowosci dla kobiet ktory jest oznaczony klasą: .es-category-title i pobiera ten napis z niego
//    public void testPrint() {
//        page.locator(".es-category-title").innerText();
//        String textZnaglowka = page.locator(".es-category-title").innerText();
//        System.out.println(textZnaglowka);
//// ta metoda klika w to
//        page.locator(".es-product-photo").first().click();
//    }
//
//    // ta metoda bedzie sprawdzala jaka cena jest dla bluzki w ktora klikalismy
//    public void jakaCenabluzki() {
//        page.locator("[class^='priceview']").locator("[data-selen='product-price']").innerText();
//        String cenaBluzki = page.locator("[class^='priceview']  [data-selen='product-price']").innerText();
//        System.out.println("Cena bluzki to: " + cenaBluzki);
//    }
//
//    //ta metoda zamyka X na okienku nowym popup
//    public void zamykaczOkna() {
//        page.locator(".outline-close").click();
//    }
//
//    public void czujnik() {
//        page.locator(".outline-close").getAttribute("class");
//        String atrybut = page.locator(".outline-close").getAttribute("class");
//        System.out.println("tak X jest na stronie i ma atrybut: " + atrybut);
//    }


}


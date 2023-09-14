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

    // ta metoda lokalizuje na stronie naglowek z napisem Nowosci dla kobiet ktory jest oznaczony klasą: .es-category-title i pobiera ten napis z niego
    public void testPrint() {
        page.locator(".es-category-title").innerText();
        String textZnaglowka = page.locator(".es-category-title").innerText();
        System.out.println(textZnaglowka);
// ta metoda klika w to
        page.locator(".es-product-photo").first().click();
    }

    // ta metoda bedzie sprawdzala jaka cena jest dla bluzki w ktora klikalismy
    public void jakaCenabluzki() {
        page.locator("[class^='priceview']  [data-selen='product-price']").innerText();
        String cenaBluzki = page.locator("[class^='priceview']  [data-selen='product-price']").innerText();
        System.out.println("Cena bluzki to: " + cenaBluzki);
    }

    //ta metoda zamyka X na okienku nowym popup
    public void zamykaczOkna() {
        page.locator(".outline-close").click();
    }

    public void czujnik() {
        page.locator(".outline-close").getAttribute(".outline-close");
        String atrybut = page.locator(".outline-close").getAttribute(".outline-close");
        System.out.println("tak X jest na stronie i ma atrybut: " + atrybut);
    }


}


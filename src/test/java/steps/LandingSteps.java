package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingSteps extends BaseSteps {
    private final LandingPage landingPage;

    public LandingSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        landingPage = new LandingPage(page);
    }

    @When("I select {string} from top menu")
    public void iSelectFromTopMenu(String buttonText) {
        landingPage.selectFromMenu(buttonText);
    }

    @When("I select {string} and {string} from top menu")
    public void iSelectFromTopMenu(String buttonText, String submenuButtonText) {

        landingPage.selectFromMenu(buttonText, submenuButtonText);
        // tu wywoluje metode wypisujaca text z naglowka i klikajacą potem w obrazek
//        landingPage.testPrint();
//
//        // tu wywoluje metode ktora ma pobrac i wyswietlic cene bluzki
//        landingPage.jakaCenabluzki();
////        page.pause();
//        landingPage.czujnik();
//        landingPage.zamykaczOkna();
    }

    @Given("I'm on product page {string}")
    public void iMOnProductPage(String url) {
        landingPage.openProductPage(url);


    }

    @When("I click on {string}")
    public void iClickOn(String productName) {
        landingPage.productNameLink.getByText(productName).first().click();

//        page.pause();


    }

    @When("I choose size {string}")
    public void iChooseSize(String size) {
        landingPage.sizeNameButton.getByText(size).click();

    }

    @When("I add to cart")
    public void iAddToCart() {
        landingPage.addToCartButton.click();
        System.out.println("sfdgadg");
    }

    @Then("I should see confirmation dialog with following heading {string}")
    public void iShouldSeeConfirmationDialogWithFollowingHeading(String expectedHeadingText) {
        assertThat(landingPage.cartConfirmationTitle).hasText(expectedHeadingText);
    }

    @Then("I should see that {string} was added to cart")
    public void iShouldSeeThatWasAddedToCart(String expectedProductName) {
        assertThat(landingPage.confirmationDialogProductName).hasText(expectedProductName);
    }

    @Then("I should see size of product {string} was added to cart")
    public void iShouldSeeSizeOfProductWasAddedToCart(String expectedProductSize) {
        assertThat(landingPage.confirmationDialogProductSize).containsText(expectedProductSize);
    }

    @When("I search for {string}")
    public void iSearchFor(String searchQuery) {
        landingPage.searchButton.click();
        landingPage.searchInput.fill(searchQuery);
        page.keyboard().press("Enter");
//        page.pause();
    }

    @Then("I should see product containing phrase {string}")
    public void iShouldSeeProductContainingPhrase(String expectedResults) {
        int productCount = landingPage.searchResultProductName.count();
        for (int i = 0; i < productCount; i++) {
            assertThat(landingPage.searchResultProductName.nth(i)).containsText(expectedResults);
        }
    }

    @Then("I should see following buttons")
    public void iShouldSeeFollowingButtons(List<String> expectedButtons) {
//        for (int i = 0; i < expectedButtons.size(); i++) {
//            assertThat(landingPage.kontoSubButtons.nth(i)).hasText(expectedButtons.get(i));
//        }
        assertThat(landingPage.kontoSubButtons).hasText(expectedButtons.toArray(new String[0]));

    }

    @When("I hover on the Konto link")
    public void iHoverOnTheLink() {
        landingPage.kontoButton.hover();

    }
}

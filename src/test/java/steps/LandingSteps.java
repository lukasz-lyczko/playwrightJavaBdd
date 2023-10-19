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
    }

    @Given("I am on product page {string}")
    public void iAmOnProductPage(String url) {
        landingPage.openProductPage(url);
    }

    @When("I click on {string}")
    public void iClickOn(String productName) {
        landingPage.productNameLink.getByText(productName).first().click();
    }

    @When("I choose size {string}")
    public void iChooseSize(String size) {
        landingPage.sizeNameButton.getByText(size).click();
    }

    @When("I add to cart")
    public void iAddToCart() {
        landingPage.addToCartButton.click();
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
    }

    @Then("I should see product containing phrase {string}")
    public void iShouldSeeProductContainingPhrase(String expectedResults) {
        int productCount = landingPage.searchResultProductName.count();
        for (int i = 0; i < productCount; i++) {
            assertThat(landingPage.searchResultProductName.nth(i)).containsText(expectedResults);
        }
    }

    @Then("I should see following buttons")
    public void iShouldSeeFollowingButtons(List<String> expectedButtonTexts) {
//        for (int i = 0; i < expectedButtonTexts.size(); i++) {
//            assertThat(landingPage.accountSubButtons.nth(i)).hasText(expectedButtonTexts.get(i));
//        }
        assertThat(landingPage.accountSubButtons).hasText(expectedButtonTexts.toArray(new String[0]));
    }

    @When("I hover on the Konto link")
    public void iHoverOnTheLink() {
        landingPage.accountButton.hover();
    }

    @When("I check shopping basket")
    public void iCheckShoppingBasket() {
        landingPage.basket.click();
    }
}

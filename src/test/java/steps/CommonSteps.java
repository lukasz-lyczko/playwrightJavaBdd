package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.LandingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps extends BaseSteps {
    private final BasePage lumaPage;

    private final LandingPage landingPage;

    public CommonSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.lumaPage = new BasePage(page);
        this.landingPage = new LandingPage(page);
    }

    @Then("I should see {string} notification")
    public void iShouldSeeNotification(String expectedAlertText) {
        assertThat(lumaPage.alert).hasText(expectedAlertText);
    }

    @Then("I should see {string} in my shopping cart")
    public void iShouldSeeInMyShoppingCart(String productName) {
        lumaPage.shoppingCartButton.click();
    }

    @Then("I should see {string} button")
    public void iShouldSeeButton(String buttonText) {
        assertThat(lumaPage.button.getByText(buttonText)).isVisible();

    }

    @Given("I am on the landing page")
    public void iAmOnTheLandingPage() {

    }
}

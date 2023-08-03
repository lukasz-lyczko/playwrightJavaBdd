package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CommonSteps extends BaseSteps {
    private final BasePage lumaPage;

    public CommonSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.lumaPage = new BasePage(page);
    }

    @Then("I should see {string} notification")
    public void iShouldSeeNotification(String expectedAlertText) {
        page.pause();
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

    @Given("I am on the Landing Page")
    public void iAmOnTheLandingPage() {
        landingPage.open();

    }
}

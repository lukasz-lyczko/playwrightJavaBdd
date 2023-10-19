package steps;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Then;
import pages.BasketPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasketSteps extends BaseSteps {
    private final BasketPage basketPage;

    public BasketSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        basketPage = new BasketPage(page);
    }

    @Then("I should see {string} headline")
    public void iShouldSeeHeadline(String expectedHeadline) {
        assertThat(basketPage.headline).hasText(expectedHeadline);
    }
    @Then("I should see {string} button")
    public void iShouldSeeButton(String expectedButtonName) {
        assertThat(basketPage.button).hasText(expectedButtonName);
    }

    @Then("I should see {string} link")
    public void iShouldSeeLink(String expectedLinkText) {
        assertThat(
                basketPage.link.filter(new Locator.FilterOptions().setHasText(expectedLinkText))
        ).isVisible();
    }
}

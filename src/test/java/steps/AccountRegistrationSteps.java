package steps;

import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountRegistrationPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountRegistrationSteps extends BaseSteps {
    private final AccountRegistrationPage accountRegistrationPage;
    private Locator checkboxLocator;

    public AccountRegistrationSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.accountRegistrationPage = new AccountRegistrationPage(page);
    }

    @Given("I am on account registration page")
    public void iAmOnAccountRegistrationPage() {
        page.navigate("./customer/account/login/#register");
    }

    @When("I enter email address {string}")
    public void iEnterEmailAddress(String email) {
        accountRegistrationPage.emailInput.fill(email);
    }

    @Then("I should see email field validation error {string}")
    public void iShouldSeeEmailFieldValidationErrorValidationError(String expectedErrorMessage) {
        assertThat(accountRegistrationPage.emailInputError).hasText(expectedErrorMessage);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String buttonText) {
        accountRegistrationPage.button
                .filter(new Locator.FilterOptions().setHasText(buttonText))
                .click();
    }

    @Then("I should see {int} field validation error(s)")
    public void iShouldSeeFieldValidationErrors(int expectedErrorCount) {
        assertThat(accountRegistrationPage.inputError).hasCount(expectedErrorCount);
    }

    @When("I click on checkbox with label {string}")
    public void iClickOnNewsletterCheckbox(String checkboxText) {
        checkboxLocator = accountRegistrationPage.checkbox.filter(
                new Locator.FilterOptions().setHasText(checkboxText)
        ).locator("input");
        checkboxLocator.click();
    }

    @Then("I should see the checkbox is checked")
    public void iShouldSeeTheCheckboxIsChecked() {
        assertThat(checkboxLocator).isChecked();
    }
}

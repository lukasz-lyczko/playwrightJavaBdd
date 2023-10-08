package steps;

import io.cucumber.java.en.Given;
import pages.AccountRegistrationPage;

public class AccountRegistrationSteps extends BaseSteps {
    private final AccountRegistrationPage accountRegistrationPage;
    public AccountRegistrationSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.accountRegistrationPage = new AccountRegistrationPage(page);
    }

    @Given("I'm on account registration page")
    public void iMOnAccountRegistrationPage() {
        page.navigate("./customer/account/login/#register");
    }
}

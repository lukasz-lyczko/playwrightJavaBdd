package steps;

import io.cucumber.java.en.When;
import pages.LandingPage;

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
}

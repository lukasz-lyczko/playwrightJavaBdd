package steps;

import io.cucumber.java.en.When;
import pages.LandingPage;

public class LandingSteps extends BaseSteps {
    private LandingPage landingPage;

    public LandingSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        landingPage = new LandingPage(page);
    }

    @When("I select {string} from top menu")
    public void iSelectFromTopMenu(String buttonText) {
        landingPage.selectMenuButton(buttonText);
    }
}

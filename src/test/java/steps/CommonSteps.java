package steps;

import io.cucumber.java.en.Given;

import pages.LandingPage;

public class CommonSteps extends BaseSteps {
    private final LandingPage landingPage;

    public CommonSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        this.landingPage = new LandingPage(page);
    }

    @Given("I am on the landing page")
    public void iAmOnTheLandingPage() {
        landingPage.open();
    }
}

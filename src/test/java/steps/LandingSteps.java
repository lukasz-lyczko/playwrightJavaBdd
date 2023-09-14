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
        // tu wywoluje metode wypisujaca text z naglowka i klikajacą potem w obrazek
        landingPage.testPrint();

        // tu wywoluje metode ktora ma pobrac i wyswietlic cene bluzki
        landingPage.jakaCenabluzki();
//        page.pause();
        landingPage.czujnik();
        landingPage.zamykaczOkna();
    }
}

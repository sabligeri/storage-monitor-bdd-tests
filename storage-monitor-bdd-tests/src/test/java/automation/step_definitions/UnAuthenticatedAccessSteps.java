package automation.step_definitions;

import automation.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UnAuthenticatedAccessSteps extends BaseTest {

    private String path;

    @After
    public void clean() {
        tearDown();
    }

    @When("Navigating to path {string}")
    public void navigateToPath(String path) {
        this.path = path;
        setUp(path);
    }

    @Then("Should be redirected to login page if should be redirected {string}")
    public void shouldBeRedirectedToLoginPage(String shouldRedirected) {
        boolean redirect = Boolean.parseBoolean(shouldRedirected);
        String currentURL = wait.until(WebDriver::getCurrentUrl);
        if (redirect) {
            Assert.assertTrue(currentURL.endsWith("/login"));
        } else {
            Assert.assertTrue(currentURL.endsWith("/" + path));
        }
    }
}

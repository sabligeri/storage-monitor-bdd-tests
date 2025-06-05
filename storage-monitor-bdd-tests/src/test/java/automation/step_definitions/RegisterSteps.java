package automation.step_definitions;

import automation.base.BaseTest;
import automation.page.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;

public class RegisterSteps extends BaseTest {

    private RegisterPage registerPage;
    private boolean actualResult;

    @After
    public void afterScenario() {
        tearDown();
    }

    @Given("I open the register page")
    public void iOpenTheRegisterPage() {
        setUp("register");
        registerPage = new RegisterPage(driver);
    }

    @When("I register with username {string} and password {string}")
    public void iRegisterWithUsernameAndPassword(String username, String password) {
        String finalUsername = username.isEmpty()
                ? ""
                : username + "_" + Instant.now().toEpochMilli();

        registerPage.register(finalUsername, password);
        actualResult = registerPage.isOnLoginPage();
    }

    @Then("registration result should be {string}")
    public void registrationResultShouldBe(String expectedResult) {
        boolean expected = Boolean.parseBoolean(expectedResult);
        Assertions.assertEquals(expected, actualResult, "Expected result should be " + expected + "but we got: " + actualResult);
    }

    @Then("I should see a password validation message containing {string}")
    public void iShouldSeeAPasswordValidationMessageContaining(String expectedMessagePart) {
        Assertions.assertFalse(registerPage.isOnLoginPage(),
                "In this scenario we waited for a Error Message but we were directed to the login page.");

        String actualText = registerPage.getPasswordValidationText();
        Assertions.assertTrue(actualText.contains(expectedMessagePart),
                "Expected: " + expectedMessagePart + " but the actual: " + actualText);
    }

    @When("I click the login-here link")
    public void iClickTheLoginHereLink() {
        registerPage.clickLoginHere();
    }

    @Then("I should be redirected to login page")
    public void iShouldBeRedirectedToLoginPage() {
        boolean onLogin = registerPage.isOnLoginPage();
        Assertions.assertTrue(onLogin,
                "Expected: navigate to the login page. The current URL is: " + driver.getCurrentUrl());
    }
}

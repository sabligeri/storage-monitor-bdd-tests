package automation.step_definitions;

import io.cucumber.java.After;
import automation.base.BaseTest;
import automation.page.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps extends BaseTest {

    private LoginPage loginPage;

    @After
    public void clean() {
        tearDown();
    }

    @Given("User is registered")
    public void userIsRegistered() {
        registerUser();
    }

    @When("Login page is opened")
    public void openLoginPage() {
        setUp("login");
        loginPage = new LoginPage(driver);
    }

    @And("Login with valid credentials")
    public void loginWithValidCredentials() {
        loginPage.login(username, PASSWORD);
    }

    @Then("Should be navigated on the home page")
    public void shouldBeNavigatedOnHomePage() {
        Assert.assertTrue(loginPage.isOnPage("home"));
    }

    @And("Login with username {string} and password {string}")
    public void loginWithInvalidUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("An error message should appear containing {string}")
    public void errorMessageShouldAppearContaining(String message) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(message));
    }

    @And("Click on Register here link")
    public void clickRegisterHereLink() {
        loginPage.clickRegisterHereLink();
    }

    @Then("Should be redirected on the register page")
    public void redirectOnRegisterPage() {
        Assert.assertTrue(loginPage.isOnPage("register"));
    }
}

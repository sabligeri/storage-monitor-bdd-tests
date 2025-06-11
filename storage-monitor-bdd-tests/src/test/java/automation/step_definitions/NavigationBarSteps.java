package automation.step_definitions;

import automation.base.BaseTest;
import automation.page.NavBarComponent;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class NavigationBarSteps extends BaseTest {

    private NavBarComponent navBar;

    @After
    public void clean() {
        tearDown();
    }

    @Given("We are on the home page")
    public void weAreOnTheHomePage() {
        registerUser();
        login();
        navBar = new NavBarComponent(driver);
    }

    @When("I click on the {string} link")
    public void iClickOnNavigationLink(String link) {
        switch (link) {
            case "Storage":
                navBar.clickStorageLink();
                break;
            case "Products":
                navBar.clickProductsLink();
                break;
            case "Production":
                navBar.clickProductionLink();
                break;
            case "Home":
                navBar.clickHomeLink();
                break;
            default:
                throw new IllegalArgumentException("Unknown link: " + link);
        }
    }

    @Then("I should be on the {string} page")
    public void iShouldBeOnThePage(String page) {
        Assert.assertTrue(navBar.isOnPage(page));
    }

    @When("I click on the Toggle Theme button")
    public void iClickOnToggleThemeButton() {
        navBar.clickThemeToggleButton();
    }

    @Then("The theme should be {string}")
    public void theThemeShouldBe(String theme) {
        Assert.assertEquals(navBar.getCurrentTheme(), theme);
    }

    @Then("The Icon should be {string}")
    public void theIconShouldBe(String icon) {
        Assert.assertEquals(navBar.getCurrentThemeIcon(), icon);
    }

    @When("I click on the Logout button")
    public void iClickOnLogoutButton() {
        navBar.clickLogoutButton();
    }

    @Then("We should be directed back to the login page")
    public void weShouldBeDirectedBackToLoginPage() {
        Assert.assertTrue(navBar.isOnPage("login"));
    }


    @And("We should not be able to access {string} path")
    public void weShouldNotBeAbleToAccessPath(String path) {
            driver.get(SUT + path);
            Assert.assertTrue(navBar.isOnPage("login"));
    }
}

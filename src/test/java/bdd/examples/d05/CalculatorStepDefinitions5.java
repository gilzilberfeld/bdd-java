package bdd.examples.d05;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CalculatorStepDefinitions5 {
    final String url = "http://localhost:8000/calculator";
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @Before("@browser")
    public void setup() throws IOException {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
    }

    @After("@browser")
    public void cleanup() {
        page.close();
        browser.close();
        playwright.close();
    }

    @Given("calculator page is loaded")
    public void calculator_page_is_loaded() throws IOException {
        page.navigate(url);
    }

    @When("press button {string}")
    public void press_button(String key) {
        Locator button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(key));
        button.click();
    }

    @Then("The result should be {string}")
    public void the_result_should_be(String expectedResult) {
        Locator textbox = page.getByRole(AriaRole.TEXTBOX);
        assertThat(textbox).hasValue(expectedResult);
    }


}

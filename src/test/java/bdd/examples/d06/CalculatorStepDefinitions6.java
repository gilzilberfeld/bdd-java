package bdd.examples.d06;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions6 {
    private CalculatorPOM calcPage;

    @Given("calculator page is loaded ")
    public void calculator_page_is_loaded() throws IOException {
        calcPage = new CalculatorPOM("http://localhost:8000/");
        calcPage.navigate();
    }

    @When("press button {string} ")
    public void press_button(String key) {
        calcPage.press(key);
    }

    @Then("The result should be {string} ")
    public void the_result_should_be(String expectedResult) {
        String result = calcPage.getResult();
        assertThat(result).isEqualTo(expectedResult);
        calcPage.close();
    }
}

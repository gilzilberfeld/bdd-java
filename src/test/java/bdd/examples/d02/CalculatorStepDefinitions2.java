package bdd.examples.d02;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions2 {
    Calculator calc;

    @Given("calculator is on")
    public void calculatr_is_on() {
        calc = new Calculator();
    }

    @When("pressing {string}")
    public void pressing(String key) {
        calc.press(key);
    }

    @Then("It displays {string}")
    public void it_displays(String expected) {
        assertThat(calc.getDisplay()).isEqualTo(expected);
    }
}

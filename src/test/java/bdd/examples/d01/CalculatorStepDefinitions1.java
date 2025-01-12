package bdd.examples.d01;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions1 {
    Calculator calc;

    @Given("calculator was just turned on")
    public void calculator_was_just_turned_on() {
         calc = new Calculator();
    }
    @Then("It shows zero")
    public void it_shows_zero() {
        assertThat(calc.getDisplay()).isEqualTo("0");
    }

    @Then("It shows {string}")
    public void it_shows(String expected) {
        assertThat(calc.getDisplay()).isEqualTo(expected);
    }
}

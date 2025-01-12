package bdd.examples.d03;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions3 {
    Calculator calc;

    @Given("a calculator")
    public void a_calculator() {
        calc = new Calculator();
    }

    @When("pressing a sequence {string}")
    public void pressingASequence(String sequence) {
        Stream.of(sequence.split("")) .forEach(calc::press);
    }

    @Then("it displays {string}")
    public void it_displays(String expected) {
        assertThat(calc.getDisplay()).isEqualTo(expected);
    }



}

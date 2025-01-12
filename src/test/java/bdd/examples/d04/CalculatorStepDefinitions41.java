package bdd.examples.d04;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CalculatorStepDefinitions41 {
    final  String theURL = "http://localhost:8000";
    String sequence = "";

    @Given("another calculator is ready")
    public void another_calculator_is_ready() {
    }

    @When("again send press {string}")
    public void again_send_press(String key) {
        sequence += key;
    }

    @Then("it returns another {string}")
    public void it_returns_another(String expected) {
        // Skip ping, we'll know anyway
        // Send multiple posts
        RequestSender request = when();
        Stream.of(sequence.split("")) .forEach((key)->{
            Response response = request.post(theURL + "/calculator/press?key=" + key);
            response.then().statusCode(200);
        });

        // Get the display
        when().
                get(theURL+"/calculator/display").
        then().
                statusCode(200).
                body("result", equalTo(expected));
    }
}

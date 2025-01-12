package bdd.examples.d04;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class CalculatorStepDefinitions4 {
    final  String theURL = "http://localhost:8000";

    @Given("calculator is ready")
    public void calculatr_is_ready() {
        given().
                get(theURL+"/calculator/ping").
        then().
                statusCode(200);
    }

    @When("send press {string}")
    public void send_press(String key) {
        when().
                post(theURL+"/calculator/press?key="+key).
        then().
                statusCode(200);
    }

    @Then("it returns {string}")
    public void it_returns(String expected) {
        when().
                get(theURL+"/calculator/display").
        then().
                statusCode(200).
                body("result", equalTo(expected));
    }
}

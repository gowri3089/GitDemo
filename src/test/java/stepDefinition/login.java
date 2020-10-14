package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
public class login {

    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
        System.out.println("Given");

    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_something_and_something(String strArg1, String strArg2) throws Throwable {
        System.out.println(strArg1);
        System.out.println(strArg2);
    }

    @Then("^User is displayed with Home page$")
    public void user_is_displayed_with_home_page() throws Throwable {
        System.out.println("Then");
    }

    @And("^account list displayed are \"([^\"]*)\"$")
    public void account_list_displayed_are_something(String strArg1) throws Throwable {
        System.out.println(strArg1);
    }

}

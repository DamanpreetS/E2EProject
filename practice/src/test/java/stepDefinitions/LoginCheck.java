package stepDefinitions;






import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Then;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;


@RunWith(Cucumber.class)
public class LoginCheck {

    @Given("^I want to Login into sign in page$")
    public void i_want_to_login_into_sign_in_page() throws Throwable {
        System.out.println("given scenario");
    }

    @When("^I try to login$")
    public void i_try_to_login() throws Throwable {
    	System.out.println("when scenario");
    }

    @Then("^Login should be Tested$")
    public void login_should_be_tested() throws Throwable {
    	System.out.println("then scenario");
    }

   
	@And("^Test my crdentials$")
    public void test_my_crdentials() throws Throwable {
		System.out.println("and for given scenario");
    }

    @And("^Card details be available$")
    public void card_details_be_available() throws Throwable {
    	System.out.println("and of then scenario");
    }

}
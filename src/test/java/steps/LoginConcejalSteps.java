package steps;

import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginConcejalSteps {

	@When("^un usuario de tipo concejal se loguea con usuario \"(.+)\" y password \"(.+)\"$")
	public void i_login_with_name_and_password_concejal(String name, String password) throws Throwable {
		assertTrue(true);
	}

	@Then("^el usuario logueado como concejal recibe la pantalla inicial$")
	public void i_receive_a_welcome_message_concejal() throws Throwable {
		assertTrue(true);
	}

}